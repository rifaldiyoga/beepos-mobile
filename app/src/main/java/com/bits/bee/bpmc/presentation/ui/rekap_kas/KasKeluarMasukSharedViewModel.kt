package com.bits.bee.bpmc.presentation.ui.rekap_kas

import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.model.Kas
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.rekap_kas.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.*
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class KasKeluarMasukSharedViewModel @Inject constructor(
    private val addKasKeluarMasukUseCase: AddKasKeluarMasukUseCase,
    private val loadKasMasukSortUseCase: LoadKasMasukSortUseCase,
    private val getCadjInByDateUseCase: GetCadjInByDateUseCase,
    private val loadKasKeluarSortUseCase: LoadKasKeluarSortUseCase,
    private val getCadjOutByDateUseCase: GetCadjOutByDateUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase
): BaseViewModel<KasKeluarMasukState, KasKeluarMasukSharedViewModel.UIEvent>() {

    init {
        state = KasKeluarMasukState()
    }

    fun checkPosses() = viewModelScope.launch {
        getActivePossesUseCase.invoke().collect {
            updateState(
                state.copy(
                    acrivePosses = it
                )
            )
        }
    }

    fun onSaveKasMasuk(
        isStatus: Boolean,
        nominal: String,
        deskripsi: String,
        posses: Posses?,
        cash: Cash?
    ) = viewModelScope.launch {
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
            val status = if (isStatus) "i" else "o"
            val longStartBal = nominal.replace("[.,]".toRegex(), "").toLong()
            val balance = BigDecimal.valueOf(longStartBal)
            val note = deskripsi.replace(BPMConstants.REGEX_INPUT.toRegex(), "")
            val reftype = BPMConstants.BPM_DEFAULT_TYPE_CASH_POSSES
            val autogen = false

            if (isStatus){
                addKasKeluarMasukUseCase.invoke(note, reftype, balance, mPosses, status, autogen)
            }else{
                if (mPosses?.totIn!!.add(mPosses.startBal) < (mPosses.totOut?.add(balance)
                        ?: BigDecimal.ZERO.add(balance))
                ){
                    // blocking
                    msgChannel.send("Kas keluar tidak boleh melebihi saldo kasir !")
                }else{
                    addKasKeluarMasukUseCase.invoke(note, reftype, balance, mPosses, status, autogen)
                }
            }
//            eventChannel.send(UIEvent.SuccesAddkasMasuk)
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
            val balance = BigDecimal.valueOf(longStartBal)
            val note = deskripsi.replace(BPMConstants.REGEX_INPUT.toRegex(), "")
            val reftype = BPMConstants.BPM_DEFAULT_TYPE_CASH_POSSES
            val autogen = false

            if (mPosses?.totIn!!.add(mPosses.startBal) < (mPosses.totOut?.add(balance)
                    ?: BigDecimal.ZERO.add(balance))
            ){
                // blocking
                msgChannel.send("Kas keluar tidak boleh melebihi saldo kasir !")
            }else{
                addKasKeluarMasukUseCase.invoke(note, reftype, balance, mPosses, status, autogen)
            }
        }

    }

    fun loadKasMasuk(desc: Boolean, query: String) = viewModelScope.launch {
        updateState(
            state.copy(
                isDesc = desc
            )
        )
        loadKasMasukSortUseCase.invoke(desc, query).collect{
            updateState(
                state.copy(
                    cadjListIn = it
                )
            )
        }
    }

    fun loadKasKeluar(desc: Boolean, query: String) = viewModelScope.launch {
        updateState(
            state.copy(
                isDesc = desc
            )
        )
        loadKasKeluarSortUseCase.invoke(desc, query).collect{
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
        val resultSorted: SortedMap<Long, MutableList<Cadj>>
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

        if (state.isDesc){
            resultSorted = cadjMap.toSortedMap(compareByDescending { it })
        }else{
            resultSorted = cadjMap.toSortedMap(compareBy { it })
        }

        parseMapCadjIn(resultSorted)
    }

    private fun parseMapCadjIn(cadjMap: SortedMap<Long, MutableList<Cadj>>) = viewModelScope.launch {
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
        val resultSorted: SortedMap<Long, MutableList<Cadj>>
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

        if (state.isDesc){
            resultSorted = cadjMap.toSortedMap(compareByDescending { it })
        }else{
            resultSorted = cadjMap.toSortedMap(compareBy { it })
        }


        parseMapCadjOut(resultSorted)
    }

    private fun parseMapCadjOut(cadjMap: SortedMap<Long, MutableList<Cadj>>) = viewModelScope.launch {
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
        object SuccesAddkasMasuk: UIEvent()
        object SuccesAddKasKeluar: UIEvent()
    }
}