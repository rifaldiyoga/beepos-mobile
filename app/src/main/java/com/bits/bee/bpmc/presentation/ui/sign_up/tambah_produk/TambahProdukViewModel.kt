package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.usecase.signup.AddEditProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
@HiltViewModel
class TambahProdukViewModel @Inject constructor(
    private val addEditProdukUseCase : AddEditProdukUseCase
): BaseViewModel<TambahProdukState, TambahProdukViewModel.UIEvent>() {

    init {
        state = TambahProdukState()
    }

    fun onSubmit() = viewModelScope.launch {
        val itemDummy = ItemDummy(
            id = state.itemDummy?.id,
            name = state.nama,
            itemTypeCode = state.tipeProduk,
            itemGroup = state.kategoriProduk,
            price = state.harga,
            picPath = "",
            unit = state.satuan
        )
        addEditProdukUseCase(itemDummy)
        eventChannel.send(UIEvent.FinsihSubmit)
    }

    sealed class UIEvent {
        object FinsihSubmit : UIEvent()
    }
}