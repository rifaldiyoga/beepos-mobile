package com.bits.bee.bpmc.presentation.dialog.info_akun

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.common.GetActiveOperatorUseCase
import com.bits.bee.bpmc.domain.usecase.download.GetLatestCmpUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetCmpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoAkunViewModel @Inject constructor(
    private val getCmpUseCase: GetCmpUseCase,
    private val getActiveOperatorUseCase: GetActiveOperatorUseCase
): BaseViewModel<InfoAkunState, InfoAkunViewModel.UIEvent>() {

    init {
        state = InfoAkunState()
    }

    fun getCmp() = viewModelScope.launch {
        getCmpUseCase.invoke().collect {
            it.data?.let {
                updateState(
                    state.copy(
                        perusahaan = it.name
                    )
                )
            }
        }

        val data = getActiveOperatorUseCase.invoke().first()
        data?.let {
            updateState(
                state.copy(
                    email = it.username
                )
            )
        }
    }

    sealed class UIEvent {
        object RequestInfoTax : UIEvent()
    }
}