package com.bits.bee.bpmc.presentation.dialog.tambah_kas

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_kas.GetActiveCashUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TambahKasSharedViewModel @Inject constructor(
    private val getActiveUserUseCase: GetActiveUserUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getActiveCashUseCase: GetActiveCashUseCase
): BaseViewModel<TambahKasState, TambahKasSharedViewModel.UIEvent>() {

    init {
        state = TambahKasState()
    }

    fun getValue() = viewModelScope.launch {
        val user = getActiveUserUseCase().first()
        user.let {
            updateState(
                state.copy(
                    user = it!!.name
                )
            )
        }
    }

    fun posses() = viewModelScope.launch {
        getActivePossesUseCase.invoke().collect {
            updateState(
                state.copy(
                    posses = it
                )
            )
        }
    }

    fun initCash(possesId: Int) = viewModelScope.launch {
        val cashh = getActiveCashUseCase.invoke(possesId.toLong()).first()
        updateState(
            state.copy(
                cash = cashh
            )
        )
    }

    sealed class UIEvent{
        object RequestSaveKasMasuk: UIEvent()
    }
}