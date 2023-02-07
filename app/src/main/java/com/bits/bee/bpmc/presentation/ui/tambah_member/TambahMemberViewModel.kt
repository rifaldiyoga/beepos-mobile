package com.bits.bee.bpmc.presentation.ui.tambah_member

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.domain.usecase.member.AddBpUseCase
import com.bits.bee.bpmc.domain.usecase.member.GetActivePriceLvlUseCase
import com.bits.bee.bpmc.domain.usecase.member.GetRegencyByCodeUseCase
import com.bits.bee.bpmc.domain.usecase.upload_manual.GetBpByIdUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
@HiltViewModel
class TambahMemberViewModel @Inject constructor(
    private val getActivePriceLvlUseCase: GetActivePriceLvlUseCase,
    private val addBpUseCase: AddBpUseCase,
    private val getBpByIdUseCase: GetBpByIdUseCase,
    private val getRegencyByCodeUseCase: GetRegencyByCodeUseCase,
    private val getRegUseCase: GetRegUseCase
): BaseViewModel<TambahMemberState, TambahMemberViewModel.UIEvent >() {

    init {
        state = TambahMemberState()
    }

    var priceLvlList = getActivePriceLvlUseCase()

    val regSaleTaxed = getRegUseCase(BPMConstants.REG_SALE_TAXED)
    val regSaleTaxInc = getRegUseCase(BPMConstants.REG_SALE_TAXINC)
    val regDefPriceLvl = getRegUseCase(BPMConstants.REG_PRCLVL_DEFAULT)

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
        if (state.priceLvl == -1){
            updateState(
                state.copy(
                    priceLvl = 1
                )
            )
        }

        updateState(state.copy(
            errorNamaMember = errorNamaMember,
            errorNoTelp = errorNoTelp,
            errorAlamat = errorAlamat,
            errorEmail = errorEmail
        ))

        if(isValid) {
            val bp = Bp(
                code = state.noTelp,
                name = state.namaMember,
                alamat = state.alamat,
                isTaxedOnSale = state.isTaxed,
                isTaxIncOnSale = state.isTaxInc,
                priceLvlId = state.priceLvl,
                createdBy = -1,
                createdAt = Date()
            )
            val id = addBpUseCase(state.kota, bp, state.noTelp, state.email, bp.alamat)
            val bpLast = getBpByIdUseCase(id.toInt()).first()
            eventChannel.send(UIEvent.SuccessAddMember(bpLast))
        }
    }

    fun getRegency() = viewModelScope.launch{
        getRegencyByCodeUseCase.invoke(state.district!!.regencyCode).collect {

            updateState(
                state.copy(
                    regency = it
                )
            )
        }

    }

    fun onClickInfoLainnya() = viewModelScope.launch {
        updateState(
            state.copy(
                isInfoLainnya = !state.isInfoLainnya
            )
        )
    }

    fun onClickKota() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestKota)
    }

    fun onClickIcon() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestTaxInfo)
    }

    sealed class UIEvent {
        data class SuccessAddMember(val bp : Bp?) : UIEvent()
        object RequestKota : UIEvent()
        object RequestTaxInfo: UIEvent()
    }
}