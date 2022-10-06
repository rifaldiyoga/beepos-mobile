package com.bits.bee.bpmc.presentation.ui.upload_manual

import android.text.format.DateFormat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.domain.usecase.download.GetLatestItemUseCase
import com.bits.bee.bpmc.domain.usecase.manual_upload.GetDataSyncUseCase
import com.bits.bee.bpmc.domain.usecase.member.AddUpdateMemberUseCase
import com.bits.bee.bpmc.domain.usecase.upload_manual.*
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.String
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.Int
import kotlin.Long
import kotlin.let

@HiltViewModel
class UploadManualViewModel @Inject constructor(
    private val GetDataSyncUseCase: GetDataSyncUseCase,
    private val getLatestItemUseCase: GetLatestItemUseCase,
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
    private val getSaledDeletedItemUseCase: GetSaledDeletedItemUseCase,
    private val getSaleHaventUploadedUseCase: GetSaleHaventUploadedUseCase,
    private val getPossesHaventUploadUseCase: GetPossesHaventUploadUseCase,
    private val updatePossesUseCase: UpdatePossesUseCase,
    private val getCadjByReftypeInOutHaventUploadUseCase: GetCadjByReftypeInOutHaventUploadUseCase,
    private val getCstrByReftypeHaventUpload: GetCstrByReftypeHaventUpload,
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val getItemByIdUseCase: GetItemByIdUseCase,
    private val getSalecrcvBySaleUseCase: GetSalecrcvBySaleUseCase,
    private val postAllUseCase: PostAllUseCase,
    private val getSaleByIdUseCase: GetSaleByIdUseCase,
    private val updateSaleUseCase: UpdateSaleUseCase,
    private val getCashAByRefidUseCase: GetCashAByRefidUseCase,
    private val updateCashAUseCase: UpdateCashAUseCase,
    private val updateCadjUseCase: UpdateCadjUseCase,
    private val updateCstrUseCase: UpdateCstrUseCase,
    private val getSaleAddOnBySaleUseCase: GetSaleAddOnBySaleUseCase,
    private val getSaleAddonDByAddonUseCase: GetSaleAddonDByAddonUseCase,
    private val getSalePromoBySaleUseCase: GetSalePromoBySaleUseCase,
    private val getPromoByIdUseCase: GetPromoByIdUseCase

): BaseViewModel<UploadManualState, UploadManualViewModel.UIEvent>() {

    private var userId: Int = 0
    private var whId: Long = 0
    private var cashId: Long = 0
    private var cashierId: Int = 0
    private var branchId = 0
    //    private var bpPost = BpPost()
    private var mBp: Bp? = null
    private var saledlist: List<Saled>? = null
    private var listSaleHaventUpload: List<Sale>? = null
    private var listPosses: List<Posses>? = null
    private var listCadj: List<Cadj>? = null
    private var listCstr: List<Cstr>? = null
    private var listBp: List<Bp>? = null
    //    private var postBody: PostAll? = null
    private var errorMsg = ""

    init {
        state = UploadManualState()
    }

    private var bpReturn: MediatorLiveData<Resource<BpReturn>> = MediatorLiveData()
    fun observeBpReturn() = bpReturn as LiveData<Resource<BpReturn>>

    private var postAllReturn: MediatorLiveData<Resource<PostAllReturn>> = MediatorLiveData()
    fun observePostallReturn() = postAllReturn as LiveData<Resource<PostAllReturn>>

    fun checkData() = viewModelScope.launch {
        getLatestItemUseCase.invoke(1).collect {
            it.data?.let {
                updateState(
                    state.copy(
                        listItem = it
                    )
                )
            }
        }
    }

    private fun initUpload() = viewModelScope.launch {
        var bpList: List<Bp>? = null
        var bpPost = BpPost()

        getActiveUserUseCase.invoke().collect {
            it?.let {
                if (it != null){
                    userId = it.id
                }
            }
        }
        getActiveCashierUseCase.invoke().collect {
            it?.let {
                if (it != null){
                    whId = it.whId
                    cashId = it.cashId
                    cashierId = it.id
                }
            }
        }

        getBpNotUploadedUseCase.invoke().collect {
            it.data?.let {
                bpList = it
            }
        }
        if (bpList!!.isNotEmpty()){
            for (bp in bpList!!){
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

        if (bpPost.bpArray.isNotEmpty()){
            uploadBp(bpPost)
        }else{
            collectData()
//            saleUploaded()
        }

    }

    fun collectData() = viewModelScope.launch {
        var saleIdList: MutableList<Int> = mutableListOf()
        var postBody: PostAll? = null

        getSaledDeletedItemUseCase.invoke().collect {
            saledlist = it
        }
        for (saled in saledlist!!){
            saleIdList.add(saled.saleId)
        }
        getSaleHaventUploadedUseCase.invoke(50, saleIdList).collect {
            listSaleHaventUpload = it
        }
        getPossesHaventUploadUseCase.invoke().collect {
            listPosses = it
        }

        var newPosses = ""
        var possesList: MutableList<Posses> = mutableListOf()
        for (checkPosses in listPosses!!){
            if (checkPosses.trxNo.equals(newPosses)){
                val newTrxnoPosses = newPosses.substring(0, newPosses.length - 1)
                val newLastTrxno = newPosses.substring(newPosses.length - 1)
                val trxno = Integer.valueOf(newLastTrxno) + 1
                checkPosses.trxNo = newTrxnoPosses + trxno
            }
            possesList.add(checkPosses)
            updatePossesUseCase.invoke(checkPosses)
            newPosses = checkPosses.trxNo
        }

        getCadjByReftypeInOutHaventUploadUseCase.invoke().collect {
            listCadj = it
        }
        getCstrByReftypeHaventUpload.invoke().collect {
            it.data?.let {
                listCstr = it
            }
        }

        getBpNotUploadedUseCase.invoke().collect {
            it.data?.let {
                listBp = it
            }
        }
        if (listBp!!.isEmpty()){
            if (listSaleHaventUpload!!.isNotEmpty() || listPosses!!.isNotEmpty()
                || listCadj!!.isNotEmpty() || listCstr!!.isNotEmpty()){
                var bpSale: Bp? = null
                var saledListsale: List<Saled>? = null
                var salecrcvListSale: List<SaleCrcv>? = null
                var itemSale: Item? = null
                var saleAddOn: SaleAddOn? = null
                var promo: Promo? = null
                var saleAddOnDList: List<SaleAddOnD>? = null
                var salePromoList: List<SalePromo>? = null
                var saledPostList: MutableList<PostAll.SaledPost> = mutableListOf()
                var salecrcvPostList: MutableList<PostAll.SalecrcvsPost> = mutableListOf()
                var saleAddonPostList: MutableList<PostAll.SaleAddOnPost> = mutableListOf()
                var salePromoPostList: MutableList<PostAll.SalePromoPost> = mutableListOf()
                var saleBnsPostList: MutableList<PostAll.SaleBns> = mutableListOf()


                var salePostList: MutableList<PostAll.SalePost> = mutableListOf()
                var possesPostList: MutableList<PostAll.PossesPost> = mutableListOf()
                var cstrPostList: MutableList<PostAll.CstrPost> = mutableListOf()
                var cadjPostList: MutableList<PostAll.CadjsPost> = mutableListOf()

                for (sale in listSaleHaventUpload!!){
                    getBpByIdUseCase.invoke(sale.bpId).collect {
                        it?.let {
                            bpSale = it
                        }
                    }
                    getSaledBySaleUseCase.invoke(sale.id!!).collect {
                        saledListsale = it
                    }

                    for ((index, value) in saledListsale!!.withIndex()){
                        val saled = saledListsale!![index]
                        getItemByIdUseCase.invoke(saled.itemId).collect {
                            it?.let {
                                itemSale = it
                            }
                        }
                        val saledPost = PostAll.SaledPost(
                            dno = ""+saled.dno,
                            whId = whId.toString(),
                            itemId = String.valueOf(saled.itemId),
                            itemname = saled.name,
                            qty = saled.qty.toPlainString(),
                            unit = String.valueOf(itemSale!!.saleUnit),
                            conv = "1",
                            baseprice = String.valueOf(saled.basePrice),
                            listprice = String.valueOf(saled.listPrice),
                            discexp = if (!saled.discExp.contains("%")) DecimalFormat("0").format(saled.disc)
                            else DecimalFormat("0").format(saled.disc) + "%",
                            discamt = String.valueOf(saled.discAmt),
                            totaldiscamt = String.valueOf(saled.totalDiscAmt),
                            disc2amt = String.valueOf(saled.disc2Amt),
                            totaldisc2amt = String.valueOf(saled.totalDisc2Amt),
                            tax_code = "PPN",
                            taxableamt = String.valueOf(saled.taxableAmt),
                            taxamt = String.valueOf(saled.taxAmt),
                            totaltaxamt = String.valueOf(saled.totalTaxAmt),
                            basetotaltaxamt = saled.totalTaxAmt,
                            basefistotaltaxamt = saled.totalTaxAmt,
                            subtotal = String.valueOf(saled.subtotal),
                            basesubtotal = String.valueOf(saled.subtotal)
                        )
                        saledPostList.add(saledPost)
                    }

                    getSalecrcvBySaleUseCase.invoke(sale.id!!).collect {
                        it.data?.let {
                            salecrcvListSale = it
                        }
                    }
                    if (salecrcvListSale!!.size > 0){
                        for ((index, value) in salecrcvListSale!!.withIndex()){
                            val salecrcv = salecrcvListSale!!.get(index)
                            val saleCrcvPost = PostAll.SalecrcvsPost(
                                rcvtype_code = salecrcv.rcvTypeCode,
                                ref_id = salecrcv.refId,
                                rcvamt = salecrcv.rcvAmt,
                                note = salecrcv.note,
                                edc_id = String.valueOf(salecrcv.edcId),
                                cash_id = String.valueOf(salecrcv.cashId),
                                card_no = salecrcv.cardNo,
                                cctype_code = salecrcv.cctypeCode,
                                mdrexp = salecrcv.mdrExp,
                                mdramt = salecrcv.mdrAmt,
                                surcexp = salecrcv.surcExp,
                                surcamt = salecrcv.surcAmt,
                                mdracc_id = salecrcv.mdrAccId,
                                surcacc_id = salecrcv.surAccId,
                                trackno = salecrcv.trackNo
                            )
                            salecrcvPostList.add(saleCrcvPost)
                        }
                    }

                    getSaleAddOnBySaleUseCase.invoke(sale.id!!).collect {
                        saleAddOn = it
                    }
                    if (saleAddOn != null){
                        getSaleAddonDByAddonUseCase.invoke(saleAddOn!!.id!!).collect {

                            saleAddOnDList = it

                        }
                        for ((index, value) in saleAddOnDList!!.withIndex()) {
                            val saleAddonD = saleAddOnDList!!.get(index)
                            val saleAddon = PostAll.SaleAddOnPost(
                                up_saled_dno = saleAddonD.upSaled!!.dno,
                                saled_dno = saleAddonD.saled!!.dno
                            )
                            saleAddonPostList.add(saleAddon)

                        }
                    }

                    getSalePromoBySaleUseCase.invoke(sale.id!!).collect {
                        salePromoList = it
                    }
                    if (salePromoList!!.isNotEmpty()){
                        for (salepromo in salePromoList!!){
                            val salePromoPost = PostAll.SalePromoPost(
                                promo_id = salepromo.promo!!.id,
                                promo_qty = salepromo.promoQty,
                                promo_role = salepromo.promoRule,
                                saledno = -1,
                                bp_id = -1
                            )
                            salePromoPostList.add(salePromoPost)
                            getPromoByIdUseCase.invoke(salepromo.promo!!.id).collect {
                                it.data?.let {
                                    promo = it
                                }
                            }
                            if (promo!!.promoCat.equals("BONUS", ignoreCase = true) && salepromo.promoRule.equals("D", ignoreCase = true)){
                                val saleBns = PostAll.SaleBns(
                                    dno = -1,
                                    promoId = salepromo.promo!!.id,
                                    whId = whId,
                                    itemId = -1,
                                    unit = "",
                                    qty = BigDecimal.ZERO
                                )
                                saleBnsPostList.add(saleBns)
                            }
                        }
                    }

                    val salepost = PostAll.SalePost(
                        trxno = sale.trxNo,
                        trxdate = BPMConstants.DEFAULT_DATE_FORMAT.format(sale.trxDate),
                        termtype = "C",
                        cashId = cashId,
                        branchId = 1,
                        cashier_id = sale.cashierId,
                        bpId = sale.bpId,
                        trxtype = "S",
                        isvoid = sale.isVoid,
                        createdBy = sale.operatorId,
                        updatedBy = sale.operatorId,
                        reserverd_var1 = sale.trxNo,
                        createdAt = BPMConstants.DEFAULT_DATE_FORMAT.format(sale.trxDate),
                        updatedAt = BPMConstants.DEFAULT_DATE_FORMAT.format(sale.trxDate),
                        crcId = 1,
                        excrate = 1,
                        fisrate = 1,
                        billaddr = sale.bpName,
                        shipaddr = sale.bpName,
                        subtotal = sale.subtotal.toDouble(),
                        basesubtotal = sale.subtotal.toDouble(),
                        discamt = if (!sale.discAmt.equals(BigDecimal.ZERO)) sale.discAmt else BigDecimal.ZERO,
                        basediscamt = if (!sale.discAmt.equals(BigDecimal.ZERO)) sale.discAmt else BigDecimal.ZERO,
                        discexp = if (!sale.discAmt.equals(BigDecimal.ZERO)) sale.discExp else "",
                        rounding = if (sale.rounding != null) sale.rounding else BigDecimal.ZERO,
                        taxamt = sale.taxAmt,
                        basetaxamt = sale.taxAmt,
                        basefistaxamt = sale.taxAmt,
                        total = sale.total.toDouble(),
                        basetotal = sale.total.toDouble(),
                        paystatus = "N",
                        channel_id = if (sale.channelId != 0) sale.channelId else 0,
                        note = sale.voidNote,
                        taxed = if (bpSale!!.isTaxedOnSale) true else if (bpSale!!.isTaxIncOnSale) true else if (bpSale!!.isTaxedOnSale && bpSale!!.isTaxIncOnSale) true else false,
                        taxinc = if (bpSale!!.isTaxedOnSale) false else if (bpSale!!.isTaxIncOnSale) true else if (bpSale!!.isTaxedOnSale && bpSale!!.isTaxIncOnSale) true else false,
                        saleds = saledPostList,
                        salecrcvs = salecrcvPostList,
                        saleaddonList = saleAddonPostList,
                        salePromoList = salePromoPostList,
                        saleBnsList = saleBnsPostList
                    )
                    salePostList.add(salepost)
                }

                for (posses in possesList){
                    val possesPost = PostAll.PossesPost(
                        trxno = posses.trxNo,
                        trxdate = DateFormat.format("yyyyMMdd", posses.trxDate).toString(),
                        cashierId = posses.cashierId,
                        posses_kode = posses.trxNo,
                        shift = String.valueOf(posses.shift),
                        starttime = posses.trxDate,
                        endtime = posses.endTime,
                        startbal = posses.startBal.toDouble(),
                        totin = if (posses.totIn == null) 0.toDouble() else posses.totIn!!.toDouble(),
                        totout = if (posses.totOut == null) 0.toDouble() else posses.totOut!!.toDouble(),
                        endbal = posses.endBal?.toDouble(),
                        iscollected = if (posses.endTime == null) false else true,
                        usrId = userId,
                        totalActualCash = posses.totalActualCash,
                        totDiffCash = posses.totalDiffCash
                    )
                    possesPostList.add(possesPost)
                }

                for (cstr in listCstr!!){
                    val cstrPost = PostAll.CstrPost(
                        trxno = cstr.kodeCstr,
                        trxdate = SimpleDateFormat(BPMConstants.DEFAULT_DATE_FORMAT).format(cstr.trxDate),
                        branch_id = branchId,
                        reftype = cstr.refType,
                        refno = cstr.refNo,
                        note = "cstr.note",//not yet fix
                        cash_id1 = cstr.cashId1,
                        cash_id2 = cstr.cashId2,
                        excrate1 = BigDecimal.ONE,
                        excrate2 = BigDecimal.ONE,
                        amount1 = cstr.amount1,
                        amount2 = cstr.amount2
                    )
                    cstrPostList.add(cstrPost)
                }

                for (cadj in listCadj!!){
                    val cadjPost = PostAll.CadjsPost(
                        trxno = cadj.kodeCadj,
                        trxdate = SimpleDateFormat(BPMConstants.DEFAULT_DATE_FORMAT).format(cadj.trxDate),
                        branchId = branchId,
                        reftype = cadj.refType,
                        note = cadj.note,
                        cashid = cashId,
                        crcId = 1,
                        amount = cadj.amount,
                        excrate = 1,
                        fisrate = 1,
                        reserved_var1 = cadj.refNo,
                        trxitype = BPMConstants.BPM_DEFAULT_TYPE_CADJ
                    )
                    cadjPostList.add(cadjPost)
                }

                val meta = PostAll.Meta(
                    branchId = branchId,
                    cashierId = cashierId.toLong(),
                    syncAt = SimpleDateFormat(BPMConstants.DEFAULT_DATE_FORMAT).format(Date())
                )

                postBody = PostAll(meta, salePostList, cadjPostList, cstrPostList, possesPostList)
            }
        }

        val source = postAllUseCase.invoke(postBody!!).asLiveData()
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

    fun saleUploaded(){
//        collectData()
//        val source = postAllUseCase.invoke(postBody!!).asLiveData()
//        postAllReturn.addSource(source){
//            if (it != null) {
//                postAllReturn.value = it
//                if (it.status !== Resource.Status.LOADING) {
//                    postAllReturn.removeSource(source)
//                }
//            } else {
//                postAllReturn.removeSource(source)
//            }
//        }
    }

    fun prosesResponse() = viewModelScope.launch{
        var sales: Sale? = null
        var cashaPossesList: List<CashA> = mutableListOf()
        var cadjList: List<Cadj> = mutableListOf()
        var cstrList: List<Cstr> = mutableListOf()

        for (sale in listSaleHaventUpload!!){
            getSaleByIdUseCase.invoke(sale.id!!).collect {
                sales = it
            }
            sales!!.isUploaded = true
            updateSaleUseCase.invoke(sales!!)
        }

//        for (posses in listPosses!!){
//            getCashAByRefidUseCase.invoke(posses.possesId!!.toLong(), BPMConstants.BPM_DEFAULT_TYPE_POSSES).collect {
//                it.data?.let {
//                    cashaPossesList = it
//                }
//            }
//            for (casha in cashaPossesList){
//                casha.isUploaded = true
//                updateCashAUseCase.invoke(casha)
//            }
//        }

        getCadjByReftypeInOutHaventUploadUseCase.invoke().collect {
            cadjList = it
        }
        for (cadj in cadjList){
            cadj.isUploaded = true
            updateCadjUseCase.invoke(cadj)
        }

        getCstrByReftypeHaventUpload.invoke().collect {
            it.data?.let {
                cstrList = it
            }
        }
        for (cstr in cstrList){
            cstr.isUploaded = true
            updateCstrUseCase.invoke(cstr)
        }


    }

    fun collectBp() = viewModelScope.launch {
//        var bpList: List<Bp>? = null
//        getBpNotUploadedUseCase.invoke().collect {
//            it.data?.let {
//                bpList = it
//            }
//        }
//        if (bpList!!.isNotEmpty()){
//            for (bp in bpList!!){
//                val bparray = BpPost.BpArray(
//                    code = bp.code,
//                    businessname = bp.name,
//                    ownname = bp.name,
//                    hp = "123",
//                    address = "",
//                    cityCode = "",
//                    coordinate = "",
//                    pricelvl_id = "",
//                    email = "",
//                    saleistaxed = bp.isTaxedOnSale,
//                    saletaxinc = bp.isTaxIncOnSale
//                )
//                bpPost.bpArray.add(bparray)
//            }
//        }
    }

    fun uploadBp(bpPost: BpPost) = viewModelScope.launch {
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
            getBpByCodeUseCase.invoke(dataBpCode.code!!).collect {
                it.data?.let {
                    mBp = it
                }
            }
            if (mBp != null){
                val newBp = Bp(
                    id = Integer.valueOf(dataBpCode.id),
                    code = dataBpCode.code!!,
                    name = mBp!!.name,
                    alamat = mBp!!.alamat,
                    priceLvlId = mBp!!.priceLvlId,
                    isActive = true,
                    isTaxedOnSale = mBp!!.isTaxedOnSale,
                    isTaxIncOnSale = mBp!!.isTaxIncOnSale,
                    createdAt = Date(),
                    isFavorit = mBp!!.isFavorit
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
        collectData()
//        saleUploaded()
    }

    fun loadDataSync(limit: Long, offer: Long) = viewModelScope.launch{
        GetDataSyncUseCase.invoke(limit, offer).collect {
            it.data?.let {
                updateState(
                    state.copy(
                        listSync = it
                    )
                )
            }
        }
    }

    fun manualUpload(){
        initUpload()
//        collectBp()
//        if (bpPost.bpArray.isNotEmpty()){
//            uploadBp()
//        }else{
//            saleUploaded()
//        }
    }

    fun aftePostAll(){

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