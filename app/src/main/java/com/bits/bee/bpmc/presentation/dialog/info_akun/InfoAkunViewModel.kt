package com.bits.bee.bpmc.presentation.dialog.info_akun

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.domain.usecase.download.GetLatestCmpUseCase
import com.bits.bee.bpmc.domain.usecase.login.operator.GetCmpUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoAkunViewModel @Inject constructor(
    private val getCmpUseCase: GetCmpUseCase,
    private val getActiveUserUseCase: GetActiveUserUseCase
): BaseViewModel<InfoAkunState, InfoAkunViewModel.UIEvent>() {

    init {
        state = InfoAkunState()
    }

    fun getCmp(context: Context) = viewModelScope.launch {
        updateState(
            state.copy(
                perusahaan = getCmpUseCase.invoke().first().name,
                email = getActiveUserUseCase().first()?.username
                    ?: BeePreferenceManager.getDataFromPreferences(context, context.getString(R.string.pref_email), "") as String
            )
        )
    }

    sealed class UIEvent {
    }

}