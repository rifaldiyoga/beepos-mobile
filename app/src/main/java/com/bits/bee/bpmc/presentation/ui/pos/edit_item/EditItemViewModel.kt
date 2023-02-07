package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.helper.PrivilegeHelper
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetPriceUnitUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetUnitItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CalcUtils
import com.bits.bee.bpmc.utils.removeSymbol
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 25/05/22.
 */
@HiltViewModel
class EditItemViewModel @Inject constructor(
    private val getUnitItemUseCase: GetUnitItemUseCase,
    private val privilegeHelper: PrivilegeHelper,
    private val getPriceUnitUseCase: GetPriceUnitUseCase
): BaseViewModel<EditItemState, EditItemViewModel.UIEvent>() {

    init {
        state = EditItemState()
    }

    fun loadData() = viewModelScope.launch {
        state.isEditPrice = privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, BPMConstants.ACS_PRICE_EDIT)
        state.isEditDisc =  privilegeHelper.hasAccess(BPMConstants.BPM_PRIVILEGE_OBJ, BPMConstants.ACS_DISC)
    }

    fun loadUnit(id : Int, unit : Int? = -1) = viewModelScope.launch {
        getUnitItemUseCase(id).collect {
            updateState(
                state.copy(
                    unitList = it,
                    unit = if(it.isNotEmpty()) if(unit != null && unit > 0) it[it.indexOfFirst { it.id == unit }] else it[0] else null
                )
            )
        }
    }

    fun onPriceFocus() = viewModelScope.launch {
        if(!state.isEditPrice){
            eventChannel.send(UIEvent.NavigateToHakAkses(BPMConstants.ACS_PRICE_EDIT))
        }
    }

    fun onDiscFocus() = viewModelScope.launch {
        if(!state.isEditDisc){
            eventChannel.send(UIEvent.NavigateToHakAkses(BPMConstants.ACS_DISC))
        }
    }

    fun onPriceChange(price : String) = viewModelScope.launch {
        if(price.isEmpty()){
            updateState(
                state.copy(
                    listPrice = BigDecimal.ZERO
                )
            )
            msgChannel.send("Harga tidak boleh kosong!")
        } else {
            updateState(
                state.copy(
                    listPrice = BigDecimal(price.removeSymbol())
                )
            )
        }
    }

    fun onDiscChange(disc :String) = viewModelScope.launch {
        try {
            val discAmt = CalcUtils.getDiscAmt(disc, state.listPrice)
            updateState(
                state.copy(
                    diskon = disc,
                    discAmt = discAmt,
                    diskonMsg = ""
                )
            )
        } catch (e : Exception){
            msgChannel.send(e.message ?: "")
            updateState(
                state.copy(
                    diskonMsg = e.message ?: ""
                )
            )
        }
    }

    fun onQtyChange(qtyInput : String) = viewModelScope.launch {
        if(qtyInput.isEmpty()) {
            msgChannel.send("Qty tidak boleh kosong!")
        } else {
            val qty = BigDecimal(qtyInput.removeSymbol())
            reloadQtyAddOn(state.qty, qty)
            updateState(
                state.copy(
                    qty = qty
                )
            )
        }
    }

    fun onUnitChange(pos : Int) = viewModelScope.launch {
        updateState(
            state.copy(
                unit = state.unitList[pos],
                listPrice = getPriceUnitUseCase(state.item?.id ?: state.saled?.itemId ?: 1,  state.bp?.priceLvlId ?: 1, state.bp!!, pos)
            )
        )
    }


    fun onClickPlus() = viewModelScope.launch {
        val qty = state.qty + BigDecimal.ONE
        reloadQtyAddOn(state.qty, qty)
        updateState(
            state.copy(
                qty = qty
            )
        )
    }

    fun onClickMinus() = viewModelScope.launch {
        if(state.qty == BigDecimal.ONE){
            state.saled?.let {
                eventChannel.send(UIEvent.ValidateDelete)
            }
        } else if(state.qty > BigDecimal.ONE) {
            val qty = state.qty - BigDecimal.ONE
            reloadQtyAddOn(state.qty, qty)
            updateState(
                state.copy(
                    qty = qty
                )
            )
        }
    }

    fun onClickSubmit() = viewModelScope.launch {
        var isValid = true
        if(state.discAmt > state.listPrice) {
            isValid = false
            msgChannel.send("Diskon tidak boleh melebihi harga produk!")
        }
        if(state.diskonMsg.isNotEmpty()) {
            isValid = false
            msgChannel.send("Format diskon yang anda masukkan salah!")
        }

        if(isValid) {
            state.saled?.let { saled ->
                saled.qty = state.qty
                saled.discExp = state.diskon
                saled.listPrice = state.listPrice
                saled.discExp = state.diskon
                saled.discAmt = state.discAmt
                saled.dNotes = state.note
                saled.stock = state.pid
                eventChannel.send(UIEvent.RequestSubmit(saled, state.addOnList))
            } ?: state.item?.let {
                it.qty = state.qty
                it.price = state.listPrice
                val item = ItemWithUnit(
                    item = it,
                    unit = state.unit!!,
                    pid = state.pid?.pid,
                    discAmt = state.discAmt,
                    discExp = state.diskon,
                    note = state.note,
                    stock = state.pid
                )
                eventChannel.send(UIEvent.RequestAdd(item))
            }
        }
    }

    fun onClickAddOn() = viewModelScope.launch {
        state.saled?.let {
            eventChannel.send(UIEvent.NavigateToAddOn(it.item!!, it))
        }
    }

    fun reloadQtyAddOn(lastQty : BigDecimal, currentQty : BigDecimal) {
        state.addOnList.forEach {
            val qty = it.qty / lastQty
            it.qty = qty * currentQty
        }
    }

    sealed class UIEvent {
        data class RequestSubmit(val saled: Saled, val selectedAddOnList : List<Item> = mutableListOf()) : UIEvent()
        data class RequestAdd(val itemWithUnit: ItemWithUnit) : UIEvent()
        data class NavigateToAddOn(val item: Item, val saled : Saled) : UIEvent()
        data class NavigateToHakAkses(val accType : String) : UIEvent()
        object ValidateDelete : UIEvent()
    }

}