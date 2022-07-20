package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import android.provider.Contacts
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */

class DetailTutupKasirViewModel (
): BaseViewModel<DetailTutupKasirState, DetailTutupKasirViewModel.UIEvent>() {

    init {
        state = DetailTutupKasirState()
    }

    fun onTutupKasir() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestSave)
    }

      fun onCLickMenu() = viewModelScope.launch{
          eventChannel.send(UIEvent.RequestRekapSesi)
      }

    sealed class UIEvent {
        object RequestSave : UIEvent()
        object RequestRekapSesi : UIEvent()
    }
}
