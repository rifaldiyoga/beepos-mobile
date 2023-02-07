package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity
import com.bits.bee.bpmc.data.list.ListItemBonusAddon.ItemBonusAddOn
import com.bits.bee.bpmc.data.list.ListPromoBonus
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.PromoMultiRepository
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject


/**
 * Created by aldi on 09/09/22
 */
@HiltViewModel
class KlaimPromoViewModel @Inject constructor(
    private val promoMultiRepository: PromoMultiRepository,
    private val itemRepository: ItemRepository,
    private val getPriceItemUseCase: GetPriceItemUseCase
) : BaseViewModel<KlaimPromoState, KlaimPromoViewModel.UIEvent>() {

    init {
        state = KlaimPromoState()
    }


    fun onClickNext() = viewModelScope.launch{
        if(state.index < state.maxIndex){
            var next = true
            if(state.promoBonus!!.getPromo().promoCat == PromoEntity.BONUS)
                next = checkBonusClaimed()

            if(next){
                state.index = state.index + 1
                loadData()
            } else {
                eventChannel.send(UIEvent.ShowSnackBar("Jumlah item belum terpenuhi!"))
            }
        } else {
            if(checkBonusClaimed()){
                if(!state.finishBonus){
                    state.finishBonus = true
                    addBonusToSale()
                    doBack()
                }
            } else {
                eventChannel.send(UIEvent.ShowSnackBar("Jumlah item belum terpenuhi!"))
            }
        }
    }

    fun onClickCancel() = viewModelScope.launch {
        for (itemBonusAddOn in state.listItemBonusAddon){
            if(itemBonusAddOn != null && state.promoBonus != null) {
                val promo = itemBonusAddOn.promoBonus.getPromo()
                if(promo.code == state.promoBonus!!.getPromo().code)
                    itemBonusAddOn.getItem().qty = BigDecimal.ZERO
            }
        }
        if(state.index < state.maxIndex){
            state.index = state.index + 1
            loadData()
        } else {
            if(state.listPromoBonus!!.totalQtyBonus > BigDecimal.ZERO){
                addBonusToSale()
            }
            doBack()
        }
    }

    fun onAddItem(item : Item) = viewModelScope.launch {
        if(validateQty()){
            addItem(item.qty, item)
        } else {
            eventChannel.send(UIEvent.ShowSnackBar("Total qty promo melebihi batas!"))
        }
    }

    fun onMinItem(item : Item) {
        minItem(item)
    }

    fun doBack() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateBack)
    }

    fun loadData() = viewModelScope.launch {
        val itemBonusList : MutableList<Item> = mutableListOf()
        state.promoBonus = state.listPromoBonus?.get(state.index)
        state.promoBonus?.let { promoBonus ->

            state.qtyItem = BigDecimal.ZERO
            state.qtyPerPromo = state.listQtyPerPromo[state.index]
            state.totalQtyPromo = promoBonus.qty
            state.qtyPromo = promoBonus.qty

            val promo = promoBonus.getPromo()
            val promoMultiList = if(!promo.isDealSameItem)
                promoMultiRepository.getOfferPromoMultiByPromo(promo.id).first()
            else
                promoMultiRepository.getSyaratPromoMultiByPromo(promo.id).first()

            for (promoMulti in promoMultiList){
                if (promo.isDealSameItem){
                    if(promoMulti.value == "ITEMGRP1"){
                        val itemList = itemRepository.getActiveItemListByItemGrp(promoMulti.value.toInt()).first()
                        for(item in itemList){
                            for (saled in state.saledList){
                                if(saled.itemId == item.id && saled.qty >= promo.minQty){
                                    itemBonusList.add(item)
                                }
                            }
                        }
                    }
                    if(promoMulti.value == "ITEM") {
                        val item = itemRepository.getItemById(promoMulti.value.toInt()).first()
                        item?.let {
                            for (saled in state.saledList){
                                if(saled.itemId == item.id && saled.qty >= promo.minQty){
                                    itemBonusList.add(item)
                                }
                            }
                        }
                    }
                } else {
                    val item = itemRepository.getItemById(promoMulti.value.toInt()).first()
                    item?.let {
                        if(promo.isPriceOveride)
                            item.price = promo.itemPrice ?: BigDecimal.ZERO
                        itemBonusList.add(item)
                    }
                }
            }
        }
        updateState(
            state.copy(
                itemListBonus = itemBonusList
            )
        )
    }

    fun addItem(finalQtyPcs: BigDecimal, item: Item) {
        addItem(finalQtyPcs, item, null, null, null)
    }

    fun addItem(finalQtyPcs: BigDecimal, item: Item, itemTemp: Item?, qtyNew: BigDecimal?, itemAddon: List<Item>?) {
        val qtyN = qtyNew ?: BigDecimal.ONE
        val itemList = itemAddon ?: ArrayList()
        val itemN = itemTemp ?: item
        val qty = finalQtyPcs.add(qtyN)
        val list = state.listQtyPerPromo
        list[state.index] = state.qtyPromo

        state.listItemBonusAddon.addItemBonusAddon(ItemBonusAddOn(itemN, itemList, state.promoBonus!!))
        val itemBonusList : MutableList<Item> = mutableListOf()
        itemBonusList.addAll(state.itemListBonus)
        itemBonusList.onEach { if(it.id == item.id) it.qty = qty }
        updateState(
            state.copy(
                qtyItem = state.qtyItem.add(BigDecimal.ONE),
                qtyPerPromo = state.qtyPerPromo.add(BigDecimal.ONE),
                listQtyPerPromo = list,
                itemListBonus = itemBonusList
            )
        )
    }

    fun minItem(item: Item) {
        var qtyItem = BigDecimal.ZERO
        var qtyPerPromo = BigDecimal.ZERO

        if (item.qty > BigDecimal.ZERO && state.qtyItem > BigDecimal.ZERO)
            qtyItem = state.qtyItem.subtract(BigDecimal.ONE)
        if (item.qty > BigDecimal.ZERO && state.qtyPromo > BigDecimal.ZERO)
            qtyPerPromo = state.qtyPerPromo.subtract(BigDecimal.ONE)

        state.listItemBonusAddon.minItem(item)

        val qty = state.listItemBonusAddon.firstOrNull { it!!.getItem().id == item.id }?.getItem()?.qty ?: BigDecimal.ZERO

        val itemBonusList : MutableList<Item> = mutableListOf()
        itemBonusList.addAll(state.itemListBonus)
        itemBonusList.onEach { if(it.id == item.id) it.qty = qty }
        updateState(
            state.copy(
                qtyItem = qtyItem,
                qtyPerPromo = qtyPerPromo,
                itemListBonus = itemBonusList
            )
        )

    }

    suspend fun addBonusToSale() {
        for (itemBonusAddOn in state.listItemBonusAddon){
            itemBonusAddOn?.let { itemBonusAddOn ->
                val promo = itemBonusAddOn.promoBonus.getPromo()
                var item = itemBonusAddOn.getItem()
                val itemAddonList = itemBonusAddOn.getItemAddonList()
                val isPromoBonus = promo.promoCat == "BONUS" || promo.itemDiscExp != null && promo.itemDiscExp.equals("100%")

                if(!isPromoBonus) {
                   item = getPriceItemUseCase(item, state.priceLvlId, state.bp!!)
                }

                repeat(item.qty.toInt()){
                    eventChannel.send(UIEvent.RequestAdd(item, isPromoBonus, true, itemBonusAddOn.promoBonus))
                }
            }
        }
    }

    private fun validateQty(): Boolean = state.qtyPerPromo < state.qtyPromo

    private fun checkBonusClaimed(): Boolean = state.qtyItem >= state.totalQtyPromo


    sealed class UIEvent {
        data class ShowSnackBar(val msg : String) : UIEvent()
        data class RequestAdd(val item: Item, val isPromoBonus : Boolean, val isUseQty : Boolean, val promoBonus: ListPromoBonus.PromoBonus) : UIEvent()
        object NavigateBack : UIEvent()
    }

}