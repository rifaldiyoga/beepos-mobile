package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.Unit
import com.bits.bee.bpmc.domain.usecase.common.GetUnitItemUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.CalcUtils
import com.bits.bee.bpmc.utils.extension.removeSymbol
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 25/05/22.
 */
@HiltViewModel
class EditItemViewModel @Inject constructor(
    private val getUnitItemUseCase: GetUnitItemUseCase
): BaseViewModel<EditItemState, EditItemViewModel.UIEvent>() {

    init {
        state = EditItemState()
    }

    fun loadUnit(id : Int) = viewModelScope.launch {
        getUnitItemUseCase(id).collect {
            updateState(
                state.copy(
                    unitList = it,
                    unit = if(it.isNotEmpty()) it[0] else null
                )
            )
        }
    }

    fun onPriceChange(price : String) = viewModelScope.launch {
        if(price.isEmpty()){
            errorChannel.send("Qty tidak boleh kosong!")
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
            errorChannel.send(e.message ?: "")
            updateState(
                state.copy(
                    diskonMsg = e.message ?: ""
                )
            )
        }

    }

    fun onQtyChange(qty : String) = viewModelScope.launch {
        if(qty.isEmpty()) {
            errorChannel.send("Qty tidak boleh kosong!")
        } else {
            updateState(
                state.copy(
                    qty = BigDecimal(qty.removeSymbol())
                )
            )
        }
    }


    fun onClickPlus() = viewModelScope.launch {
        val qty = state.qty + BigDecimal.ONE
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
        }else if(state.qty > BigDecimal.ONE) {
            val qty = state.qty - BigDecimal.ONE
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
            errorChannel.send("Diskon tidak boleh melebihi harga produk!")
        }
        if(state.diskonMsg.isNotEmpty()) {
            isValid = false
            errorChannel.send("Format diskon yang anda masukkan salah!")
        }

        if(isValid) {
            state.saled?.let { saled ->
                saled.qty = state.qty
                saled.discExp = state.diskon
                saled.listPrice = state.listPrice
                saled.discExp = state.diskon
                saled.discAmt = state.discAmt
                saled.dNotes = state.note
                eventChannel.send(UIEvent.RequestSubmit(saled))
            } ?: state.item?.let {
                it.qty = state.qty
                it.price = state.listPrice
                val item = ItemWithUnit(
                    item = it,
                    unit = state.unit!!,
                    pid = state.pid?.pid,
                    discAmt = state.discAmt,
                    discExp = state.diskon,
                    note = state.note
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

    sealed class UIEvent {
        data class RequestSubmit(val saled: Saled) : UIEvent()
        data class RequestAdd(val itemWithUnit: ItemWithUnit) : UIEvent()
        data class NavigateToAddOn(val item: Item, val saled : Saled) : UIEvent()
        object ValidateDelete : UIEvent()
    }

}