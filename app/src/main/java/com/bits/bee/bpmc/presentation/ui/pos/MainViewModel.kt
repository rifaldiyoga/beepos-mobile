package com.bits.bee.bpmc.presentation.ui.pos

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.calc.SaleCalc
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
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
    getActiveChannelUseCase: GetActiveChannelUseCase,
    getDefaultBpUseCase: GetDefaultBpUseCase,
//    private val addDetailUseCase: AddDetailUseCase
) : BaseViewModel<MainState, MainViewModel.UIEvent>(){

    private val roundVal = 0

    init {
        state = MainState()

        viewModelScope.launch {
            channelList.collect {
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
        viewModelScope.launch {
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
    }

    private val channelList = getActiveChannelUseCase.invoke()

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
            for (saled in state.saledList) {
                if (saled.itemId == item.id
//                    && !ItemAddOnDao.itemAddOnDao().checkAddon(item)
//                    && (grpAddon == null || grpAddon != null && item.itemGrpId !== grpAddon.id())
                    && saled.isBonus == isBonus
                ) {
                    saled.listPrice = item.price
                    saled.qty = saled.qty.add(if (useItemqty) item.qty else BigDecimal.ONE)
                    if (saled.disc != BigDecimal.ZERO) {
                        if (!saled.discExp.contains("%")) {
                            saled.disc = saled.disc
                            saled.discAmt = saled.disc.setScale(roundVal, RoundingMode.HALF_UP)
                            saled.discExp = saled.discExp
                        } else if (saled.discExp.contains("%")) {
                            saled.disc = saled.disc
                            saled.discAmt =
                                saled.listPrice.multiply(saled.disc, BPMConstants.MC_FOUR)
                                    .divide(BigDecimal(100), BPMConstants.MC_FOUR)
                                    .setScale(roundVal, RoundingMode.HALF_UP)

                            saled.discExp = saled.discExp
                        }
                    }
//                    currentSaled = saled
                    isNew = false
                    //                    PromoCalc.instance().generatePromoItem(saled);
//                    calculate()
                    break
                }
            }
            if (isNew) {
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
//                currentSaled = saledNew
            }
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

    fun addDetail(saled : Saled) {
        state.saledList.add(saled)
    }

    fun editDetail(saledEdit: Saled) {
        for (saled in state.saledList){
            if(saled == saledEdit){
                editSaled(saled, saledEdit)
                calculate()
                break
            }
        }
    }

    private fun editSaled(saled: Saled, newSaled: Saled) {
        saled.listPrice =  newSaled.listPrice
        saled.qty = newSaled.qty
        saled.disc = newSaled.disc
        saled.discAmt = newSaled.discAmt
        saled.tax = newSaled.tax
        saled.taxAmt = newSaled.taxAmt
        saled.disc2Amt = newSaled.disc2Amt
    }

    private fun deleteDetail(saledDel: Saled) {
        for (i in 0 until state.saledList.size){
            val saled = state.saledList[i]
            if(saledDel == saled){
                state.saledList.removeAt(i)
            }
        }
    }

    private fun calculate(){
        SaleCalc.calculate(state.sale, state.saledList, state.bp!!)
    }

    private fun deployData() {
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