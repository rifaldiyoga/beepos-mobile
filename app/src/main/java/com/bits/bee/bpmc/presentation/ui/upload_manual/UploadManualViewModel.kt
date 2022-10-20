package com.bits.bee.bpmc.presentation.ui.upload_manual

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.domain.repository.CstrRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.domain.usecase.manual_upload.GetDataSyncUseCase
import com.bits.bee.bpmc.domain.usecase.member.AddUpdateMemberUseCase
import com.bits.bee.bpmc.domain.usecase.upload_manual.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class UploadManualViewModel @Inject constructor(
    private val getDataSyncUseCase: GetDataSyncUseCase,
    private val getActiveUserUseCase: GetActiveUserUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getBpNotUploadedUseCase: GetBpNotUploadedUseCase,
    private val postBpClientUseCase: PostBpClientUseCase,
    private val getBpByCodeUseCase: GetBpByCodeUseCase,
    private val getBpByIdUseCase: GetBpByIdUseCase,
    private val addUpdateMemberUseCase: AddUpdateMemberUseCase,
    private val updateBpUseCase: UpdateBpUseCase,
    private val updateIDBpUseCase: UpdateIDBpUseCase,
    private val deleteBpUseCase: DeleteBpUseCase,
    private val postAllUseCase: PostAllUseCase,
    private val updateCadjUseCase: UpdateCadjUseCase,
    private val updateCstrUseCase: UpdateCstrUseCase,
    private val saleRepository: SaleRepository,
    private val possesRepository: PossesRepository,
    private val cadjRepository: CadjRepository,
    private val cstrRepository: CstrRepository,
    private val getSaledDeletedItemUseCase: GetSaledDeletedItemUseCase
): BaseViewModel<UploadManualState, UploadManualViewModel.UIEvent>() {

    init {
        state = UploadManualState()
    }

    val syncList = getDataSyncUseCase()

    private var bpReturn: MediatorLiveData<Resource<BpReturn>> = MediatorLiveData()
    fun observeBpReturn() = bpReturn as LiveData<Resource<BpReturn>>

    private var postAllReturn: MediatorLiveData<Resource<PostAllReturn>> = MediatorLiveData()
    fun observePostallReturn() = postAllReturn as LiveData<Resource<PostAllReturn>>

    fun loadData() = viewModelScope.launch {
        getActiveUserUseCase.invoke().collect {
            it?.let {
                state.userId = it.id
            }
        }
        getActiveCashierUseCase.invoke().collect {
            it?.let {
                updateState(
                    state.copy(
                        whId = it.whId.toInt(),
                        cashId = it.cashId.toInt(),
                        cashierId = it.id,
                        branchId = it.branchId.toInt()
                    )
                )
            }
        }
    }

    private fun initUpload() = viewModelScope.launch {
        val bpList: List<Bp> = getBpNotUploadedUseCase().first()

        if (bpList.isNotEmpty()){
            uploadBp()
        }else{
            uploadPostAll()
        }

    }

    fun prosesResponsePostAll() = viewModelScope.launch{

        for (sale in state.saleList){
            sale.isUploaded = true
            saleRepository.updateSale(sale)
        }

        for (posses in state.possesList){
            posses.isUploaded = true
            possesRepository.updatePosses(posses)
//            getCashAByRefidUseCase.invoke(posses.possesId!!.toLong(), BPMConstants.BPM_DEFAULT_TYPE_POSSES).collect {
//                it.data?.let {
//                    cashaPossesList = it
//                }
//            }
//            for (casha in cashaPossesList){
//                casha.isUploaded = true
//                updateCashAUseCase.invoke(casha)
//            }
        }

        for (cadj in state.cadjList){
            cadj.isUploaded = true
            updateCadjUseCase.invoke(cadj)
        }

        for (cstr in state.cstrList){
            cstr.isUploaded = true
            updateCstrUseCase.invoke(cstr)
        }

    }

    private fun uploadBp() = viewModelScope.launch {
        var bpPost = BpPost()
        var bpList: List<Bp>? = getBpNotUploadedUseCase().first()

        if (bpList!!.isNotEmpty()){
            for (bp in bpList){
                val bparray = BpPost.BpArray(
                    code = bp.code,
                    businessname = bp.name,
                    ownname = bp.name,
                    hp = "123",
                    address = "",
                    cityCode = "",
                    coordinate = "",
                    pricelvl_id = "",
                    email = "",
                    saleistaxed = bp.isTaxedOnSale,
                    saletaxinc = bp.isTaxIncOnSale
                )
                bpPost.bpArray.add(bparray)
            }
        }

        val source = postBpClientUseCase.invoke(bpPost).asLiveData()
        bpReturn.addSource(source){
            if (it != null) {
                bpReturn.value = it
                if (it.status !== Resource.Status.LOADING) {
                    bpReturn.removeSource(source)
                }
            } else {
                bpReturn.removeSource(source)
            }
        }
    }

    fun checkBpCode(bpReturn: BpReturn) = viewModelScope.launch {
        for (dataBpCode in bpReturn.data!!){
            val mBp = getBpByCodeUseCase(dataBpCode.code!!).first()
            mBp?.let {
                val newBp = Bp(
                    id = Integer.valueOf(dataBpCode.id),
                    code = dataBpCode.code!!,
                    name = mBp.name,
                    alamat = mBp.alamat,
                    priceLvlId = mBp.priceLvlId,
                    isActive = true,
                    isTaxedOnSale = mBp.isTaxedOnSale,
                    isTaxIncOnSale = mBp.isTaxIncOnSale,
                    createdAt = Date(),
                    isFavorit = mBp.isFavorit
                )
                var checkBp: Bp? = null
                getBpByIdUseCase.invoke(newBp.id!!).collect {
                    it?.let {
                        checkBp = it
                    }
                }
                if (checkBp != null){
                    updateBpUseCase.invoke(newBp)
                }else{
                    addUpdateMemberUseCase.invoke(newBp)
                }

                updateIDBpUseCase.invoke(mBp!!.id!!, Integer.valueOf(dataBpCode.id!!))

                deleteBpUseCase.invoke(mBp!!)
            }
        }
    }

    fun uploadPostAll() = viewModelScope.launch {
        val saledList = getSaledDeletedItemUseCase().first()

        state.saleList = saleRepository.getSaleHaventUploaded(50, saledList.map { it.saleId }).first()
        state.possesList = possesRepository.getPossesHaventUpload().first()
        state.cadjList = cadjRepository.getCadjByReftypeInOutHaventUpload().first()
        state.cstrList = cstrRepository.getCstrByReftypeHaventUpload().first()

        val source = postAllUseCase(state.whId!!, state.cashId!!,
            state.cashierId!!, state.branchId!!,
            state.saleList,
            state.possesList,
            state.cadjList,
            state.cstrList
        ).asLiveData()

        postAllReturn.addSource(source){
            if (it != null) {
                postAllReturn.value = it
                if (it.status !== Resource.Status.LOADING) {
                    postAllReturn.removeSource(source)
                }
            } else {
                postAllReturn.removeSource(source)
            }
        }
    }

    fun onClickUpload() = viewModelScope.launch {
        initUpload()
    }

    fun showDialogNoInternet() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequeatDialog)
    }

    fun confirmDialogUpload() = viewModelScope.launch {
        eventChannel.send(UIEvent.RequestUpload)
    }

    sealed class UIEvent {
        object RequestUpload : UIEvent()
        object RequeatDialog : UIEvent()
    }
}