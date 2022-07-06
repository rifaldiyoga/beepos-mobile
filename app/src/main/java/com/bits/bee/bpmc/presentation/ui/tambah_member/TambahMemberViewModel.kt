package com.bits.bee.bpmc.presentation.ui.tambah_member

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.member.AddUpdateMemberUseCase
import com.bits.bee.bpmc.domain.usecase.member.GetActivePriceLvlUseCase
import com.bits.bee.bpmc.domain.usecase.member.SaveBpAddrUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
@HiltViewModel
class TambahMemberViewModel @Inject constructor(
    private val addUpdateMemberUseCase: AddUpdateMemberUseCase,
    private val getActivePriceLvlUseCase: GetActivePriceLvlUseCase,
    private val saveBpAddrUseCase: SaveBpAddrUseCase
): BaseViewModel<TambahMemberState, TambahMemberViewModel.UIEvent >() {

    init {
        state = TambahMemberState()
    }

    var priceLvlList = getActivePriceLvlUseCase()

    fun onClickSimpan() = viewModelScope.launch {
        var errorNamaMember = ""
        var errorNoTelp = ""
        var errorAlamat = ""
        var errorEmail = ""
        var isValid = true

        if(state.namaMember.isEmpty()) {
            errorNamaMember = "Nama member tidak boleh kosong!"
            isValid = false
        }
        if(state.noTelp.isEmpty()) {
            errorNoTelp = "No. Telpon tidak boleh kosong!"
            isValid = false
        }
        if(state.isInfoLainnya && Utils.isValidEmail(state.email)) {
            errorEmail = "Format email salah!"
            isValid = false
        }

        _state.update {
            state.copy(
                errorNamaMember = errorNamaMember,
                errorNoTelp = errorNoTelp,
                errorAlamat = errorAlamat,
                errorEmail = errorEmail
            )
        }

        if(isValid) {
            var bp = Bp(
                code = "tes code",
                name = state.namaMember,
                alamat = state.alamat,
                isTaxedOnSale = state.isTaxed,
                isTaxIncOnSale = state.isTaxInc,
                priceLvlId = state.priceLvl
            )
//            addUpdateMemberUseCase(bp)
            saveBpAddrUseCase.invoke(state.kota, bp, state.noTelp, state.email, state.alamat)
//            state.city.
            eventChannel.send(UIEvent.SuccessAddMember)
        }
    }

    fun onClickInfoLainnya() = viewModelScope.launch {
        _state.update {
            state.copy(
                isInfoLainnya = !state.isInfoLainnya
            )
        }
    }

    fun onClickKota() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestKota)
    }

    fun onClickIcon() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestTaxInfo)
    }

    sealed class UIEvent {
        object SuccessAddMember : UIEvent()
        object RequestKota : UIEvent()
        object RequestTaxInfo: UIEvent()
    }
}