package com.bits.bee.bpmc.presentation.ui.pos

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.list.ListPromoBonus
import com.bits.bee.bpmc.domain.calc.PromoCalc
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.trans.SaleTrans
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase
import com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetItemGroupAddOnUseCase
import com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
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
    private val getItemGroupAddOnUseCase: GetItemGroupAddOnUseCase,
    private val addTransactionUseCase: AddTransactionUseCase,
    private val promoCalc: PromoCalc
) : BaseViewModel<MainState, MainViewModel.UIEvent>(){

    private val _posModeState: MutableStateFlow<PosModeState>
            = MutableStateFlow(PosModeState.RetailState)

    val posModeState : MutableStateFlow<PosModeState>
        get() = _posModeState

    private val _saleTrans: SaleTrans = SaleTrans(promoCalc)

    val saleTrans : SaleTrans
        get() = _saleTrans

    val listPromoBonus = promoCalc.listPromoBonus

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
                channel = if(channelList.isNotEmpty()) channelList[0] else null,
                bp = bp,
                itgrpAddOn = itgrpAddOn
            )
        }.collect {
//            saleTrans.newTrans()
            saleTrans.setBp(it.bp!!)
            it.bp?.let { bp ->
                saleTrans.getMaster().bpId = bp.id!!
                saleTrans.getMaster().bp = bp
                saleTrans.getMaster().bpName = bp.name
            }
            saleTrans.getMaster().channelId = it.channel?.id ?: -1
            saleTrans.setGrpAddOn(it.itgrpAddOn)
            updateState(it)
        }

        promoCalc.initPromo(saleTrans)
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

    fun onAddDetail(item : ItemWithUnit, useItemqty: Boolean = false, promoBonus: ListPromoBonus.PromoBonus? = null, isBonus : Boolean = false) = viewModelScope.launch {
        saleTrans.addDetail(
            itemWithUnit = item,
            useItemqty = useItemqty,
            promoBonus = promoBonus,
            isBonus = isBonus
        )
        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()
        promoCalc.generatePromo()
        deployData()
    }

    fun onAddAddOn(variant: ItemWithUnit?, addOnList : List<ItemWithUnit>) = viewModelScope.launch {
        variant?.let {
            saleTrans.addDetail(
                itemWithUnit = variant,
            )
            saleTrans.mergeAddon()
            saleTrans.mergeItemAddon()
            promoCalc.generatePromo()
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

    fun onItemAddOn(itemList : List<Item?>, upSaled: Saled?) = viewModelScope.launch {
        for (item in itemList){
            item?.let {
                if(upSaled == null){
                    saleTrans.addDetail(ItemWithUnit(item))
                } else {
                    saleTrans.addDetail(ItemWithUnit(item), saledParent = upSaled)
                }
            }
        }
        promoCalc.generatePromo()
        deployData()
    }

    fun onMinusClick(item : Item) = viewModelScope.launch {
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
                val saledAddOnList = it.getListDetail().filter { it.upSaled == saled }.map { it.saled }
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
        promoCalc.generatePromo()
        deployData()
    }

    fun onEditDetail(saled: Saled) = viewModelScope.launch {
        saleTrans.editDetail(saled)

        promoCalc.generatePromo()
        deployData()
    }

    fun onDeleteAddOnData(upSaled : Saled, saled : Saled) = viewModelScope.launch {
        saleTrans.deleteAddon(upSaled, saled)

        saleTrans.mergeAddon()
        saleTrans.mergeItemAddon()

        promoCalc.generatePromo()

        deployData()
    }

    fun updateTrxOrderNo(context : Context) = viewModelScope.launch {
        val trxOrderNum = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 0) as Int + 1
        BeePreferenceManager.saveToPreferences(context, context.getString(R.string.trx_ordernum), trxOrderNum)
        saleTrans.getMaster().trxOrderNum = trxOrderNum
    }

    fun resetState(){
        updateState(
            MainState()
        )
        saleTrans.newTrans()
        loadData()
    }

    suspend fun submitSale(
        context: Context,
        termType : String,
        paymentAmt : BigDecimal = BigDecimal.ZERO,
        pmtd : Pmtd? = null,
        trackNo : String = "",
        cardNo : String = "",
        note : String = "",
    )  {

        updateTrxOrderNo(context)

        val sale = saleTrans.getMaster()
        val saledList = saleTrans.getListDetail()
        val saleAddOn = saleTrans.addOnTrans?.getMaster()
        val saleAddOnDList = saleTrans.addOnTrans?.getListDetail() ?: mutableListOf()
        val salePromoList = saleTrans.salePromoList

        sale.termType = termType
        val saleNew = addTransactionUseCase(
            sale = sale,
            saledList = saledList,
            saleAddOn = saleAddOn,
            saleAddOnDList = saleAddOnDList,
            salePromoList = salePromoList,
            paymentAmt = paymentAmt,
            pmtd = pmtd,
            trackNo = trackNo,
            cardNo = cardNo,
            note = note,
            counter = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 1) as Int)

        state.sale = saleNew
    }

    fun submitDraft(context: Context) = viewModelScope.launch {
        updateTrxOrderNo(context)

        val sale = saleTrans.getMaster()
        val saledList = saleTrans.getListDetail()
        val saleAddOn = saleTrans.addOnTrans?.getMaster()
        val saleAddOnDList = saleTrans.addOnTrans?.getListDetail() ?: mutableListOf()
        val salePromoList = saleTrans.salePromoList
        sale.isDraft = true

        addTransactionUseCase(
            sale = sale,
            saledList = saledList,
            saleAddOn = saleAddOn,
            saleAddOnDList = saleAddOnDList,
            salePromoList = salePromoList,
            counter = BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.trx_ordernum), 1) as Int)
    }

    fun deployData() = viewModelScope.launch {
        val saledList = mutableListOf<Saled>()
        saledList.addAll(saleTrans.getListDetail())
        updateState(
            state.copy(
                sale = saleTrans.getMaster().copy(),
                saledList = saledList,
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