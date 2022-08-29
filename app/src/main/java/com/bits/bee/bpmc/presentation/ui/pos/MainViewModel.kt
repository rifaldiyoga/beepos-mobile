package com.bits.bee.bpmc.presentation.ui.pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.trans.SaleTrans
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetItemGroupAddOnUseCase
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject


/**
 * Created by aldi on 21/04/22.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getActiveChannelUseCase: GetActiveChannelUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getDefaultBpUseCase: GetDefaultBpUseCase,
    private val getDefaultCrcUseCase: GetDefaultCrcUseCase,
    private val getSaledListUseCase: GetSaledListUseCase,
    private val getItemGroupAddOnUseCase: GetItemGroupAddOnUseCase
) : BaseViewModel<MainState, MainViewModel.UIEvent>(){

    private val _posModeState: MutableStateFlow<PosModeState>
            = MutableStateFlow(PosModeState.RetailState)

    val posModeState : MutableStateFlow<PosModeState>
        get() = _posModeState

    private val _saleTrans: SaleTrans = SaleTrans()

    val saleTrans : SaleTrans = SaleTrans()

    init {
        state = MainState()
    }

    fun loadData() = viewModelScope.launch {
        combine(
            getDefaultCrcUseCase(),
            getActivePossesUseCase(),
            getActiveBranchUseCase(),
            getActiveCashierUseCase(),
            getActiveChannelUseCase(),
            getDefaultBpUseCase(),
            getItemGroupAddOnUseCase()
        ) { array ->
            val crc = array[0] as Crc?
            val posses = array[1] as Posses?
            val branch = array[2] as Branch
            val cashier = array[3] as Cashier
            val channelList = array[4] as List<Channel>
            val bp = array[5] as Bp
            val itgrpAddOn = array[6] as ItemGroup?

            state.copy(
                crc = crc,
                activePosses = posses,
                activeBranch = branch,
                activeCashier = cashier,
                channelList = channelList,
                bp = bp,
                itgrpAddOn = itgrpAddOn
            )
        }.collect {
//            saleTrans.newTrans()
            saleTrans.setBp(it.bp!!)
            saleTrans.setGrpAddOn(it.itgrpAddOn)
            updateState(it)
        }
    }

    fun loadDraft(sale : Sale) = viewModelScope.launch {
        getSaledListUseCase(sale.id!!).collect {
            updateState(
                state.copy(
                    sale = sale,
                    saledList = it.toMutableList()
                )
            )
            deployData()
        }
    }

    fun onClickDraft() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDraft)
    }

    fun onClickDiskonNota() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToDiskonNota)
    }

    fun onClickSearch() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToSearch)
    }

    fun onClickMember() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestMember)
    }

    fun onClickChannel() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestChannel)
    }

    fun onClickPromo() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPromo)
    }

    fun onAddDetail(item : ItemWithUnit, useItemqty: Boolean = false) {
        saleTrans.addDetail(
            itemWithUnit = item,
            useItemqty = useItemqty,
        )
        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        deployData()
    }

    fun onAddAddOn(variant: ItemWithUnit?, addOnList : List<ItemWithUnit>) {
        variant?.let {
            onAddDetail(it)
        }
        for(addOn in addOnList){
            saleTrans.addDetail(
                itemWithUnit = addOn
            )
        }
        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        deployData()
    }

    fun addAddOn(item : ItemWithUnit) {
        saleTrans.addDetail(
            itemWithUnit = item,
        )
        deployData()
    }

    fun onMinusClick(item : Item) {
        val saled = saleTrans.getListDetail().firstOrNull {
            item.id == it.itemId
        }
        saled?.let {
            if(it.qty > BigDecimal.ONE) {
                onEditDetail(it.copy(qty = it.qty.subtract(BigDecimal.ONE)))
            } else {
                onDeleteDetail(saled)
            }
        }
    }

    fun onDeleteDetail(saled: Saled) = viewModelScope.launch {
        if(saled.item?.isVariant == true) {
            saleTrans.addOnTrans?.let {
                var saledRemoveList = mutableListOf<Saled>()
                val saledAddOnList = it.getListDetail().filter { it.upSaledId == saled }.map { it.saledId }
                saledAddOnList.forEach { saled1 ->
                    saleTrans.getListDetail().forEach { saled ->
                        if(saled1 == saled)
                            saledRemoveList.add(saled)
                    }
                }
                for (saled in saledRemoveList){
                    saleTrans.deleteDetail(saled)
                }
            }
        }
        saleTrans.deleteDetail(saled)
        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        deployData()
    }

    fun onEditDetail(saled: Saled) = viewModelScope.launch {
        saleTrans.editDetail(saled)
        deployData()
    }

    fun resetState(){
        updateState(
            MainState()
        )
        loadData()
    }

     fun deployData() = viewModelScope.launch {
        val saledList = mutableListOf<Saled>()
        saledList.addAll(saleTrans.getListDetail())
        updateState(
            state.copy(
                sale = saleTrans.getMaster().copy(),
                saledList = saledList
            )
        )
    }

    sealed class UIEvent {
        object RequestMember : UIEvent()
        object RequestChannel: UIEvent()
        object NavigateToDraft : UIEvent()
        object NavigateToDiskonNota : UIEvent()
        object NavigateToPromo : UIEvent()
        object NavigateToSearch : UIEvent()
    }

}