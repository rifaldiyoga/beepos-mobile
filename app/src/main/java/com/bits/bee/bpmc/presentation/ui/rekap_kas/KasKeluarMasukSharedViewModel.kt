package com.bits.bee.bpmc.presentation.ui.rekap_kas

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_kas.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.HashMap
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class KasKeluarMasukSharedViewModel @Inject constructor(
    private val addKasKeluarMasukUseCase: AddKasKeluarMasukUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val loadKasMasukUseCase: LoadKasMasukUseCase,
    private val getCadjInByDateUseCase: GetCadjInByDateUseCase,
    private val loadKasKeluarUseCase: LoadKasKeluarUseCase,
    private val getCadjOutByDateUseCase: GetCadjOutByDateUseCase,
    private val updateTotalPossesUseCase: UpdateTotalPossesUseCase,
    private val addKasUseCase: AddKasUseCase
): BaseViewModel<KasKeluarMasukState, KasKeluarMasukSharedViewModel.UIEvent>() {

    private var mListCadj: List<Cadj> = mutableListOf()

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

            addKasKeluarMasukUseCase.invoke(cash!!, cashierId, user, note, reftype, balance, mPosses, status, autogen, state.activeBranch, state.activeCashier)

//            addKasUseCase.invoke(cash, balance)

//            loadKasMasukUseCase.invoke().collect{
//                mListCadj = it
//            }
//
//            updateTotalPossesUseCase.invoke(mPosses, balance, cash)
//            addKasUseCase.invoke(cash, balance)

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

            addKasKeluarMasukUseCase.invoke(cash!!, cashierId, user, note, reftype, balance, mPosses, status, autogen, state.activeBranch, state.activeCashier)

//            loadKasMasukUseCase.invoke().collect{
//                mListCadj = it
//            }
//
//            updateTotalPossesUseCase.invoke(mPosses, balance, cash)
//            addKasUseCase.invoke(cash, balance)

            eventChannel.send(UIEvent.SuccesAddkasMasuk)
        }

    }

    fun loadKasMasuk() = viewModelScope.launch {
        loadKasMasukUseCase.invoke().collect{
            updateState(
                state.copy(
                    cadjListIn = it
                )
            )
        }
    }

    fun loadKasKeluar() = viewModelScope.launch {
        loadKasKeluarUseCase.invoke().collect{
            updateState(
                state.copy(
                    cadjListOut = it
                )
            )
        }
    }

    fun setListKasIn(dataList: List<Cadj>) = viewModelScope.launch {
        val cadjMap : HashMap<Long, MutableList<Cadj>>
                = HashMap()
        cadjMap.clear()
        for (cadj in dataList){
            val key = DateFormatUtils.convertStartDate(cadj.trxDate)
            if (!cadjMap.containsKey(key)){
                val mutable: MutableList<Cadj> = mutableListOf()
                mutable.add(cadj)
                cadjMap.put(key, mutable)
            }else{
                cadjMap.get(key)!!.add(cadj)
            }
        }
        parseMapCadjIn(cadjMap)
    }

    private fun parseMapCadjIn(cadjMap: HashMap<Long, MutableList<Cadj>>) = viewModelScope.launch {
        var jmlTrans = 0
        val kasList = mutableListOf<Kas>()
        for (newMap in cadjMap.entries){
            getCadjInByDateUseCase.invoke(DateFormatUtils.convertStartDate(newMap.key), DateFormatUtils.convertEndDate(newMap.key)).collect{
                jmlTrans = it.size
            }
            kasList.add(Kas(newMap.key, newMap.value, jmlTrans))
        }

        updateState(
            state.copy(
                cashInList = kasList
            )
        )
    }

    fun setListKasOut(dataList: List<Cadj>) = viewModelScope.launch {
        val cadjMap : HashMap<Long, MutableList<Cadj>>
                = HashMap()
        cadjMap.clear()
        for (cadj in dataList){
            val key = DateFormatUtils.convertStartDate(cadj.trxDate)
            if (!cadjMap.containsKey(key)){
                val mutable: MutableList<Cadj> = mutableListOf()
                mutable.add(cadj)
                cadjMap.put(key, mutable)
            }else{
                cadjMap.get(key)!!.add(cadj)
            }
        }
        parseMapCadjOut(cadjMap)
    }

    private fun parseMapCadjOut(cadjMap: HashMap<Long, MutableList<Cadj>>) = viewModelScope.launch {
        var jmlTrans = 0
        val kasList = mutableListOf<Kas>()
        for (newMap in cadjMap.entries){
            getCadjOutByDateUseCase.invoke(DateFormatUtils.convertStartDate(newMap.key), DateFormatUtils.convertEndDate(newMap.key)).collect{
                jmlTrans = it.size
            }
            kasList.add(Kas(newMap.key, newMap.value, jmlTrans))
        }

        updateState(
            state.copy(
                cashOutList = kasList
            )
        )
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
        object SuccesAddKasKeluar: UIEvent()
    }
}