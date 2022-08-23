package com.bits.bee.bpmc.presentation.ui.pos.addon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.usecase.addon.GetItemVariantUseCase
import com.bits.bee.bpmc.domain.usecase.addon.GetSelectionAddOnUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 15/08/22.
 */
@HiltViewModel
class AddOnViewModel @Inject constructor(
    private val getSelectionAddOnUseCase: GetSelectionAddOnUseCase,
    private val getItemVariantUseCase: GetItemVariantUseCase
) : BaseViewModel<AddOnState, AddOnViewModel.UIEvent>() {

    private val _selectedAddOn = MutableLiveData<ArrayList<Item>>(arrayListOf())

    val selectedAddOn : LiveData<ArrayList<Item>>
        get() = _selectedAddOn

    init {
        state = AddOnState()
    }

    fun getSelectedAddOn() : ArrayList<Item> = _selectedAddOn.value?: arrayListOf()

    fun addItemSelectedList(item: Item){
        val list = _selectedAddOn.value ?: ArrayList()
        if (list.contains(item)){
            val exItem = list.findLast { it.id == item.id }
            exItem?.let { existedItem ->
                if(existedItem.qty != item.qty){
                    existedItem.qty = item.qty
                }
                if(item.qty <= BigDecimal.ZERO)
                    list.remove(item)
            }
        } else {
            if (item.qty > BigDecimal.ZERO)
                list.add(item)
        }
        _selectedAddOn.value = list
    }

    fun clearSelectedAddOn() {
        _selectedAddOn.value = arrayListOf()
    }

    fun loadData() = viewModelScope.launch {
        state.item?.let{ item ->
            if(item.isVariant)
                getVariant(item.id)
            else
                getSelection(item)
        }
    }

    fun getSelection(item: Item) = viewModelScope.launch {
        getSelectionAddOnUseCase(item, state.priceLvlId, state.bp!!).collect {
            updateState(
                state.copy(
                    selectionList = it
                )
            )
        }
    }

    fun getVariant(id : Int) = viewModelScope.launch {
        getItemVariantUseCase(id, state.priceLvlId, state.bp!!).collect {
            updateState(
                state.copy(
                    variantWithItem = it
                )
            )
        }
    }

    sealed class UIEvent {

    }

    data class VariantState(
        var item : Item?
    )
}