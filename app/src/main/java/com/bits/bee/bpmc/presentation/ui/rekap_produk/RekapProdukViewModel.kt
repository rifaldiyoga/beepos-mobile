package com.bits.bee.bpmc.presentation.ui.rekap_produk

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.rekap_produk.QueryRekapProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RekapProdukViewModel @Inject constructor(
    private val queryRekapProdukUseCase: QueryRekapProdukUseCase
): BaseViewModel<RekapProdukState, RekapProdukViewModel.UIEvent>() {

    init {
        state = RekapProdukState()
    }

    fun loadRekapProduk() = viewModelScope.launch {
        val listItem = queryRekapProdukUseCase.invoke()
        updateState(
            state.copy(
                itemList = listItem
            )
        )
    }

    sealed class UIEvent{
        object Request: UIEvent()
        object RequestAddKasKeluar: UIEvent()
    }
}