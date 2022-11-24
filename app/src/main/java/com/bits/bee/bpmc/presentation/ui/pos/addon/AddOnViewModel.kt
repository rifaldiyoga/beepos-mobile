package com.bits.bee.bpmc.presentation.ui.pos.addon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.usecase.addon.GetItemVariantUseCase
import com.bits.bee.bpmc.domain.usecase.addon.GetSelectionAddOnUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun setItemSelectedList(itemList: ArrayList<Item>) {
        _selectedAddOn.value = itemList
    }

    fun getSelectedAddOn() : ArrayList<Item> = _selectedAddOn.value ?: arrayListOf()

    fun addItemSelectedList(item: Item){
        val list = _selectedAddOn.value ?: ArrayList()

        val exItem = list.findLast { it.id == item.id }
        exItem?.let { existedItem ->
            if(existedItem.qty != item.qty){
                existedItem.qty = item.qty
            }
            if(item.qty <= BigDecimal.ZERO)
                list.remove(item)
        } ?: run {
            if (item.qty > BigDecimal.ZERO)
                list.add(item)
        }

        _selectedAddOn.value = list
    }

    fun minItemSelected(item : Item) {
        val list = _selectedAddOn.value ?: ArrayList()

        val index = list.indexOfFirst { it.id == item.id }

        if(index >= 0)
            list.removeAt(index)

        _selectedAddOn.value = list
    }

    fun clearSelectedAddOn() {
        _selectedAddOn.value = arrayListOf()
    }

    fun loadData() = viewModelScope.launch {
        state.item?.let{ item ->
            if(item.isVariant && state.saled == null)
                getVariant(item.id)
            else
                getSelection(item)
        }
    }

    fun getSelection(item: Item) = viewModelScope.launch {
        getSelectionAddOnUseCase(item, state.priceLvlId, state.bp!!).collect {
            when(it.status){
                Resource.Status.LOADING -> {
                    showLoading(true)
                }
                Resource.Status.SUCCESS -> {
                    showLoading(false)
                    it.data?.let {
                        it.forEach {
                            it.itemList.forEach { item ->
                                state.itemList.forEach { selectedItem ->
                                    if (item.id == selectedItem.id)
                                        item.qty = selectedItem.qty
                                }
                            }
                        }

                        updateState(
                            state.copy(
                                selectionList = it
                            )
                        )
                    }
                }
                Resource.Status.ERROR -> {
                    showLoading(false)
                }
                Resource.Status.NOINTERNET -> {

                }
            }

        }
    }

    fun showLoading(isLoading: Boolean) = viewModelScope.launch {
        eventChannel.send(UIEvent.ShowLoadingSelection(isLoading))
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
        data class ShowLoadingSelection(val isLoading : Boolean) : UIEvent()
    }

    data class VariantState(
        var item : Item?
    )
}