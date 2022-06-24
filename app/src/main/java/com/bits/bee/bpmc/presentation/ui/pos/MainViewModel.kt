package com.bits.bee.bpmc.presentation.ui.pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.calc.SaleCalc
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase
import com.bits.bee.bpmc.domain.usecase.pos.SubmitTransactionUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.mapButReplace
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.RoundingMode
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
    private val submitTransactionUseCase: SubmitTransactionUseCase,
) : BaseViewModel<MainState, MainViewModel.UIEvent>(){

    private val roundVal = 0

    init {
        state = MainState()
        getDefaultBp()
        getChannelList()
        getActivePosses()
        getActiveBranch()
        getActiveCashier()
    }

    fun getActivePosses() = viewModelScope.launch {
        getActivePossesUseCase().collect {
            updateState(
                state.copy(
                    activePosses = it
                )
            )
        }
    }

    fun getActiveBranch() = viewModelScope.launch {
        getActiveBranchUseCase().collect {
            updateState(
                state.copy(
                    activeBranch = it
                )
            )
        }
    }

    fun getActiveCashier() = viewModelScope.launch {
        getActiveCashierUseCase().collect {
            updateState(
                state.copy(
                    activeCashier = it
                )
            )
        }
    }

    fun getChannelList() = viewModelScope.launch {
        getActiveChannelUseCase().collect {
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        _state.update {
                            it!!.copy(
                                channelList = data,
                                channel = data[0]
                            )
                        }
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    fun getDefaultBp() = viewModelScope.launch {
        getDefaultBpUseCase.invoke().collect{
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        _state.update {
                            it!!.copy(
                                bp = data
                            )
                        }
                    }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
    }

    fun onClickMember() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestMember)
    }

    fun onClickChannel() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestChannel)
    }

    fun onAddDetail(item : Item) = viewModelScope.launch {
        addDetail(item)
        calculate()
        deployData()
    }

    fun onDeleteDetail(saled: Saled) = viewModelScope.launch {
        deleteDetail(saled)
        calculate()
        deployData()
    }

    fun onEditDetail(saled: Saled) = viewModelScope.launch {
        editDetail(saled)
        calculate()
        deployData()
    }

    fun submitTrans() = viewModelScope.launch {
        submitTransactionUseCase(state.sale, state.saledList)
    }

    fun resetState(){
        updateState(
            MainState()
        )
        getDefaultBp()
        getChannelList()
        getActivePosses()
        getActiveBranch()
        getActiveCashier()
    }

    private fun addDetail(item: Item, isBonus: Boolean = false, useItemqty: Boolean = false) {
        if (state.saledList.isEmpty()) {
            val saledNew = Saled(
                itemId = item.id,
                listPrice = item.price,
                qty = if(useItemqty) item.qty else BigDecimal.ONE,
                name = item.name1,
                discExp = "0",
                disc2Amt = BigDecimal.ZERO,
                isBonus = isBonus,
                isBonusUsed = isBonus,
                tax = if(item.tax.isEmpty()) BigDecimal.ZERO else BigDecimal(item.tax)
            )
            addDetail(saledNew)
//            currentSaled = saledNew
        } else {
            var isNew = true
//            for (saled in state.saledList) {
//                if (saled.itemId == item.id
////                    && !ItemAddOnDao.itemAddOnDao().checkAddon(item)
////                    && (grpAddon == null || grpAddon != null && item.itemGrpId !== grpAddon.id())
//                    && saled.isBonus == isBonus
//                ) {
//                    saled.listPrice = item.price
//                    saled.qty = saled.qty.add(if (useItemqty) item.qty else BigDecimal.ONE)
//                    if (saled.disc != BigDecimal.ZERO) {
//                        if (!saled.discExp.contains("%")) {
//                            saled.disc = saled.disc
//                            saled.discAmt = saled.disc.setScale(roundVal, RoundingMode.HALF_UP)
//                            saled.discExp = saled.discExp
//                        } else if (saled.discExp.contains("%")) {
//                            saled.disc = saled.disc
//                            saled.discAmt =
//                                saled.listPrice.multiply(saled.disc, BPMConstants.MC_FOUR)
//                                    .divide(BigDecimal(100), BPMConstants.MC_FOUR)
//                                    .setScale(roundVal, RoundingMode.HALF_UP)
//
//                            saled.discExp = saled.discExp
//                        }
//                    }
////                    currentSaled = saled
//                    isNew = false
//                    //                    PromoCalc.instance().generatePromoItem(saled);
////                    calculate()
//                    break
//                }
//            }


            val saledNew = Saled(
                itemId = item.id,
                listPrice = item.price,
                qty = if(useItemqty) item.qty else BigDecimal.ONE,
                name = item.name1,
                discExp = "0",
                disc2Amt = BigDecimal.ZERO,
                isBonus = isBonus,
                isBonusUsed = isBonus,
                tax = if(item.tax.isEmpty()) BigDecimal.ZERO else BigDecimal(item.tax)
            )
            var saledList = mutableListOf<Saled>()
            saledList.addAll(state.saledList)
            var saled  = saledList.filter { it.itemId == item.id }.firstOrNull()
            saled?.let {
                saledNew.listPrice = item.price
                saledNew.qty = saled.qty.add(if (useItemqty) item.qty else BigDecimal.ONE)
                if (saledNew.disc != BigDecimal.ZERO) {
                    if (!saledNew.discExp.contains("%")) {
                        saledNew.disc = saled.disc
                        saledNew.discAmt = saled.disc.setScale(roundVal, RoundingMode.HALF_UP)
                        saledNew.discExp = saled.discExp
                    } else if (saledNew.discExp.contains("%")) {
                        saledNew.disc = saled.disc
                        saledNew.discAmt =
                            saled.listPrice.multiply(saled.disc, BPMConstants.MC_FOUR)
                                .divide(BigDecimal(100), BPMConstants.MC_FOUR)
                                .setScale(roundVal, RoundingMode.HALF_UP)

                        saledNew.discExp = saled.discExp
                    }
                }
                val list = saledList.mapButReplace(
                    saled,
                    saledNew
                )
                updateState(
                    state.copy(
                        saledList = list.toMutableList()
                    )
                )
            } ?: run {
                addDetail(saledNew)
            }

//                currentSaled = saledNew

        }
//        if (grpAddon != null && item.itemGrpId === grpAddon.id()) {
//            if (addOnTrans == null) {
//                addOnTrans = AddOnTrans()
//                addOnTrans.New()
//                addOnTrans.getMaster().setSale(mTblMaster)
//            }
//            val saleAddOnD = SaleAddOnD()
//            saleAddOnD.setSaleAddOn(addOnTrans.getMaster())
//            saleAddOnD.setSaled(currentSaled)
//            saleAddOnD.setUp_saled(saledParent)
//            addOnTrans.addDetail(saleAddOnD)
//        } else {
//            saledParent = currentSaled
//        }
//        if (isBonus) {
        //Tambah salebonus apabila item bonus
//            PromoCalc.instance()
//                .addSalePromoItem(promoBonus.getPromo(), promoBonus.getSaled(), currentSaled)
//        }
    }

    private fun addDetail(saled : Saled) {
        var saledList = mutableListOf<Saled>()
        saledList.addAll(state.saledList)
        saledList.add(saled)
        updateState(
            state.copy(
                saledList = saledList
            )
        )
    }

    private fun editDetail(saledEdit: Saled) {
        val saledList = mutableListOf<Saled>()
        saledList.addAll(state.saledList)
        val saled  = saledList.filter { it.itemId == saledEdit.itemId }.firstOrNull()
        saled?.let {
            val list = saledList.map {
                if(it.itemId == saled.itemId) {
                    saledEdit
                } else {
                    it
                }
            }
            updateState(
                state.copy(
                    saledList = list.toMutableList()
                )
            )
        }
//        for (saled in state.saledList){
//            if(saled == saledEdit){
//                editSaled(saled, saledEdit)
//                calculate()
//                break
//            }
//        }
    }

    private fun editSaled(saled: Saled, newSaled: Saled) = viewModelScope.launch {
        saled.listPrice =  newSaled.listPrice
        saled.qty = newSaled.qty
        saled.disc = newSaled.disc
        saled.discAmt = newSaled.discAmt
        saled.tax = newSaled.tax
        saled.taxAmt = newSaled.taxAmt
        saled.disc2Amt = newSaled.disc2Amt
    }

    private fun deleteDetail(saledDel: Saled) {
        var indexDelete = -1
        val saledList = mutableListOf<Saled>()
        saledList.addAll(state.saledList)
        for (i in 0 until saledList.size){
            val saled = saledList[i]
            if(saledDel == saled){
                indexDelete = i
                break
            }
        }
        if(indexDelete > -1) {
            saledList.removeAt(indexDelete)
            updateState(
                state.copy(saledList = saledList)
            )
        }

    }

    private fun calculate() = viewModelScope.launch{
        SaleCalc.calculate(state.sale, state.saledList, state.bp!!)
    }

    private fun deployData() = viewModelScope.launch {
        val saledList = mutableListOf<Saled>()
        saledList.addAll(state.saledList)
        updateState(
            state.copy(
                sale = state.sale,
                saledList = saledList
            )
        )
    }

    sealed class UIEvent {
        object RequestMember : UIEvent()
        object RequestChannel: UIEvent()
    }

}