package com.bits.bee.bpmc.presentation.ui.rekap_kas

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_kas.AddKasMasukUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_kas.LoadKasMasukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.HashMap
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class KasKeluarMasukSharedViewModel @Inject constructor(
    private val addKasMasukUseCase: AddKasMasukUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val loadKasMasukUseCase: LoadKasMasukUseCase
): BaseViewModel<KasKeluarMasukState, KasKeluarMasukSharedViewModel.UIEvent>() {

    init {
        state = KasKeluarMasukState()
        getActiveBranch()
        getActiveCashier()
    }

    private fun getActiveBranch() = viewModelScope.launch {
        getActiveBranchUseCase.invoke().collect{
            updateState(
                state.copy(
                    activeBranch = it
                )
            )
        }
    }

    private fun getActiveCashier() = viewModelScope.launch {
        getActiveCashierUseCase.invoke().collect{
            updateState(
                state.copy(
                    activeCashier = it
                )
            )
        }
    }

    fun onSaveKasMasuk(nominal: String, deskripsi: String, posses: Posses?, cash: Cash?) = viewModelScope.launch {
        var isvalid = true
        var mPosses = posses.let { it }
        if (nominal.isEmpty()){
           isvalid = false
//            eventChannel.send(UIEvent.RequestDialogNominal)

        }else{
            val pattern = Pattern.compile(BPMConstants.REGEX_INPUT)
            val matcher = pattern.matcher(nominal.replace("[,.]".toRegex(), ""))
            if (matcher.find()){
                // pastikan tidak ada karakter
            }
        }

        if (deskripsi.isEmpty()){
            isvalid = false
            // pastikan deskripsi tidak kosong
        }

        if (isvalid){
            val user = mPosses?.userId
            val cashierId = mPosses?.cashierId
            val status = "i"
            val longStartBal = nominal.replace("[.,]".toRegex(), "").toLong()
            val balance = BigDecimal.valueOf(longStartBal)
            val note = nominal.replace(BPMConstants.REGEX_INPUT.toRegex(), "")
            val reftype = BPMConstants.BPM_DEFAULT_TYPE_CASH_POSSES
            val autogen = false

            addKasMasukUseCase.invoke(cash!!, cashierId, user, note, reftype, balance, mPosses, status, autogen, state.activeBranch, state.activeCashier)

            eventChannel.send(UIEvent.SuccesAddkasMasuk)
        }
    }

    fun onSaveKasKeluar(nominal: String, deskripsi: String, posses: Posses?, cash: Cash?) = viewModelScope.launch {
        var isvalid = true
        var mPosses = posses.let { it }
        if (nominal.isEmpty()){
            isvalid = false
//            eventChannel.send(UIEvent.RequestDialogNominal)

        }else{
            val pattern = Pattern.compile(BPMConstants.REGEX_INPUT)
            val matcher = pattern.matcher(nominal.replace("[,.]".toRegex(), ""))
            if (matcher.find()){
                // pastikan tidak ada karakter
            }
        }

        if (deskripsi.isEmpty()){
            isvalid = false
            // pastikan deskripsi tidak kosong
        }

        if (isvalid){
            val user = mPosses?.userId
            val cashierId = mPosses?.cashierId
            val status = "o"
            val longStartBal = nominal.replace("[.,]".toRegex(), "").toLong()
            val balance = BigDecimal.valueOf(longStartBal).negate()
            val note = nominal.replace(BPMConstants.REGEX_INPUT.toRegex(), "")
            val reftype = BPMConstants.BPM_DEFAULT_TYPE_CASH_POSSES
            val autogen = false

            addKasMasukUseCase.invoke(cash!!, cashierId, user, note, reftype, balance, mPosses, status, autogen, state.activeBranch, state.activeCashier)

            eventChannel.send(UIEvent.SuccesAddkasMasuk)
        }

    }

    fun loadKasMasuk() = viewModelScope.launch {
        loadKasMasukUseCase.invoke().collect{
            updateState(
                state.copy(
                    cadjList = it
                )
            )
        }
    }

    fun setListKas(data: List<Cadj>) = viewModelScope.launch {
        val possesMap : HashMap<Long, MutableList<Posses>>
                = HashMap()
        possesMap.clear()
    }

    fun onAddKasMasuk() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddKasMasuk)
    }

    fun onAddKasKeluar() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestAddKasKeluar)
    }

    sealed class UIEvent{
        object RequestAddKasMasuk: UIEvent()
        object RequestAddKasKeluar: UIEvent()
        object RequestDialogNominal: UIEvent()
        object SuccesAddkasMasuk: UIEvent()

    }
}