package com.bits.bee.bpmc.presentation.service

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.*
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.upload_manual.*
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.showNotifications
import com.google.gson.Gson
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import java.util.*

@HiltWorker
class UploadWorker @AssistedInject constructor(
    private val getBpNotUploadedUseCase: GetBpNotUploadedUseCase,
    private val postBpClientUseCase: PostBpClientUseCase,
    private val saleRepository: SaleRepository,
    private val possesRepository: PossesRepository,
    private val beePreferenceManager: BeePreferenceManager,
    private val cadjRepository: CadjRepository,
    private val cstrRepository: CstrRepository,
    private val updateCadjUseCase: UpdateCadjUseCase,
    private val updateCstrUseCase: UpdateCstrUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val postAllUseCase: PostAllUseCase,
    private val getBpByCodeUseCase: GetBpByCodeUseCase,
    private val getBpByIdUseCase: GetBpByIdUseCase,
    private val bpRepository: BpRepository,
    private val updateBpUseCase: UpdateBpUseCase,
    private val updateIDBpUseCase: UpdateIDBpUseCase,
    private val deleteBpUseCase: DeleteBpUseCase,
    @Assisted private val context : Context,
    @Assisted private val params : WorkerParameters
) : CoroutineWorker(context, params) {

    private var bpList : List<Bp> = mutableListOf()
    private var saleList : List<Sale> = mutableListOf()
    private var possesList : List<Posses> = mutableListOf()
    private var cadjList : List<Cadj> = mutableListOf()
    private var cstrList : List<Cstr> = mutableListOf()

    suspend fun init() {
        bpList = getBpNotUploadedUseCase().first()
        saleList = saleRepository.getSaleHaventUploaded(beePreferenceManager.sistemPreferences.first().batchUpload.toInt()).first()
        possesList = possesRepository.getPossesHaventUpload().first()
        cadjList = cadjRepository.getCadjByReftypeInOutHaventUpload().first()
        cstrList = cstrRepository.getCstrByReftypeHaventUpload().first()
    }

    override suspend fun doWork(): Result {
        return try {
            init()
            if(bpList .isNotEmpty() || saleList.isNotEmpty() || possesList.isNotEmpty() || cadjList.isNotEmpty() || cstrList.isNotEmpty()) {
                showNotifications(context, "STARTING UPLOADING DATA...")
                uploadBp()
                uploadPostAll()
                showNotifications(context, "UPLOADING DATA SUCCESS HURRAY!")
//            NotificationManagerCompat.from(context).cancelAll()
            }
            Result.success()
        } catch (e : Exception){
            showNotifications(context, "UPLOADING DATA FAILED!!")
//            NotificationManagerCompat.from(context).cancelAll()
            Result.failure(createData(e.message ?: ""))
        }
    }

    private suspend fun prosesResponsePostAll() {
        for (sale in saleList){
            sale.isUploaded = true
            saleRepository.updateSale(sale)
        }

        for (posses in possesList){
            posses.isUploaded = true
            possesRepository.updatePosses(posses)
        }

        for (cadj in cadjList){
            cadj.isUploaded = true
            updateCadjUseCase(cadj)
        }

        for (cstr in cstrList){
            cstr.isUploaded = true
            updateCstrUseCase(cstr)
        }

    }

    private suspend fun checkBpCode(bpReturn: BpReturn) {
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
                val checkBp = getBpByIdUseCase(newBp.id!!).first()
                if (checkBp != null){
                    updateBpUseCase.invoke(newBp)
                }else{
                    bpRepository.addUpdateBp(newBp)
                }

                updateIDBpUseCase.invoke(mBp.id!!, Integer.valueOf(dataBpCode.id!!))

                deleteBpUseCase.invoke(mBp)
            }
        }
    }

    private suspend fun uploadBp() {
        if (bpList.isNotEmpty()) {
            val bpPost = BpPost()
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

            postBpClientUseCase(bpPost).collect {
                when(it.status){
                    Resource.Status.LOADING -> {
                        showNotifications(context, "SYNCING DATA MEMBER (UPLOADING DATA...)")
                    }
                    Resource.Status.SUCCESS -> {
                        it.data?.let {
                            checkBpCode(it)
                        }
                    }
                    Resource.Status.ERROR -> {
                        throw Exception(it.message ?: "")
                    }
                    Resource.Status.NOINTERNET -> {
                        throw Exception("No Internet")
                    }
                }
            }
        }
    }

    private suspend fun uploadPostAll() {
        if(saleList.isNotEmpty() || possesList.isNotEmpty() || cadjList.isNotEmpty() || cstrList.isNotEmpty()) {
            val cashier = getActiveCashierUseCase().first()
                ?: throw IllegalArgumentException("No active cashier!")
            val whId = cashier.whId.toInt()
            val cashId = cashier.cashId.toInt()
            val cashierId = cashier.id
            val branchId = cashier.branchId.toInt()

            postAllUseCase(
                whId,
                cashId,
                cashierId,
                branchId,
                saleList,
                possesList,
                cadjList,
                cstrList
            ).collect {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        showNotifications(context, "SYNCING DATA TRANSACTION (UPLOADING DATA...)")
                    }
                    Resource.Status.SUCCESS -> {
                        it.data?.let {
                            val string = it.string()
                            try {
                                val postAllReturn = Gson().fromJson(string, PostAllReturn::class.java)
                                if (postAllReturn.status) {
                                    prosesResponsePostAll()
                                } else {

                                }
                            } catch (e : Exception) {
                                throw Exception(string)
                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        throw Exception(it.message ?: "")
                    }
                    Resource.Status.NOINTERNET -> {
                        throw Exception("No Internet")
                    }
                }
            }
        }
    }

    private fun createData(string : String) : Data = Data.Builder().putString("error", string).build()

}