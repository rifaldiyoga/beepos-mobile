package com.bits.bee.bpmc.domain.usecase.upload_manual

import android.text.format.DateFormat
import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.*
import com.bits.bee.bpmc.domain.usecase.common.GetSalePromoBySaleUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetSaledBySaleUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import okhttp3.ResponseBody
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*
import javax.inject.Inject

class PostAllUseCase @Inject constructor(
    private val syncRepository: SyncRepository,
    private val possesRepository: PossesRepository,
    private val bpRepository: BpRepository,
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val saleCrcvRepository: SaleCrcvRepository,
    private val saleAddOnRepository: SaleAddOnRepository,
    private val saleAddOnDRepository: SaleAddOnDRepository,
    private val getSalePromoBySaleUseCase: GetSalePromoBySaleUseCase,
) {
    suspend operator fun invoke(
        whId : Int, cashId : Int,
        cashierId : Int, branchId : Int,
        listSaleHaventUpload : List<Sale>,
        listPosses : List<Posses>,
        listCadj : List<Cadj>,
        listCstr : List<Cstr>) : Flow<Resource<ResponseBody>> {

        var postBody = PostAll()
        var newPosses = ""
        val possesList: MutableList<Posses> = mutableListOf()
        for (checkPosses in listPosses){
            if (checkPosses.trxNo == newPosses){
                val newTrxnoPosses = newPosses.substring(0, newPosses.length - 1)
                val newLastTrxno = newPosses.substring(newPosses.length - 1)
                val trxno = Integer.valueOf(newLastTrxno) + 1
                checkPosses.trxNo = newTrxnoPosses + trxno
            }
            possesList.add(checkPosses)
            possesRepository.updatePosses(checkPosses)
            newPosses = checkPosses.trxNo
        }

        val listBp = bpRepository.getBpHaventUploaded().first()

        if (listBp.isEmpty()) {
            if (listSaleHaventUpload.isNotEmpty() || listPosses.isNotEmpty() || listCadj.isNotEmpty() || listCstr.isNotEmpty()){
                val salePostList = mutableListOf<PostAll.SalePost>()
                val possesPostList = mutableListOf<PostAll.PossesPost>()
                val cadjPostList = mutableListOf<PostAll.CadjsPost>()
                val cstrPostList = mutableListOf<PostAll.CstrPost>()

                for (sale in listSaleHaventUpload){
                    val saledPostList = mutableListOf<PostAll.SaledPost>()
                    val salecrcvPostList = mutableListOf<PostAll.SalecrcvsPost>()
                    val saleAddonPostList = mutableListOf<PostAll.SaleAddOnPost>()
                    val salePromoPostList = mutableListOf<PostAll.SalePromoPost>()
                    val saleBnsPostList = mutableListOf<PostAll.SaleBns>()

                    val bpSale = bpRepository.getBpById(sale.bpId).first()
                    val saledListsale = getSaledBySaleUseCase(sale.id!!).first()

                    for (saled in saledListsale){
                        val saledPost = PostAll.SaledPost(
                            dno = saled.dno.toString(),
                            whId = whId.toString(),
                            itemId = saled.itemId.toString(),
                            itemname = saled.name,
                            qty = saled.qty.toString(),
                            unit = saled.unitId?.toString(),
                            conv = saled.conv?.toString(),
                            baseprice = saled.basePrice.toString(),
                            listprice = saled.listPrice.toString(),
                            discexp = if (!saled.discExp.contains("%")) DecimalFormat("0").format(saled.disc)
                            else DecimalFormat("0").format(saled.disc) + "%",
                            discamt = saled.discAmt.toString(),
                            totaldiscamt = saled.totalDiscAmt.toString(),
                            disc2amt = saled.disc2Amt.toString(),
                            totaldisc2amt = saled.totalDisc2Amt.toString(),
                            tax_code = if(!saled.taxCode.isNullOrEmpty()) saled.taxCode else "PPN",
                            taxableamt = saled.taxableAmt.toString(),
                            taxamt = saled.taxAmt.toString(),
                            totaltaxamt = saled.totalTaxAmt.toString(),
                            basetotaltaxamt = saled.totalTaxAmt,
                            basefistotaltaxamt = saled.totalTaxAmt,
                            subtotal = saled.subtotal.toString(),
                            basesubtotal = saled.subtotal.toString()
                        )
                        saledPostList.add(saledPost)
                    }

                    val salecrcvListSale = saleCrcvRepository.getSalecrcvBySale(sale.id!!).first()

                    if (salecrcvListSale.isNotEmpty()){
                        for (salecrcv in salecrcvListSale){

                            val saleCrcvPost = PostAll.SalecrcvsPost(
                                rcvtype_code = salecrcv.rcvTypeCode,
                                ref_id = salecrcv.refId,
                                rcvamt = salecrcv.rcvAmt,
                                note = salecrcv.note,
                                edc_id = salecrcv.edcId,
                                cash_id = salecrcv.cashId,
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

                    val saleAddOn = saleAddOnRepository.getSaleAddonBySale(sale.id!!).first()

                    if (saleAddOn != null){
                        val saleAddOnDList = saleAddOnDRepository.getSaleAddonDbyAddon(saleAddOn.id!!).first()
                        for (saleAddOnD in saleAddOnDList) {
                            val saleAddon = PostAll.SaleAddOnPost(
                                up_saled_dno = saleAddOnD.upSaled!!.dno,
                                saled_dno = saleAddOnD.saled!!.dno
                            )
                            saleAddonPostList.add(saleAddon)
                        }
                    }

                    val salePromoList = getSalePromoBySaleUseCase(sale.id!!).first()

                    if (salePromoList.isNotEmpty()){
                        for (salePromo in salePromoList){
                            val salePromoPost = PostAll.SalePromoPost(
                                promo_id = salePromo.promo!!.id,
                                promo_qty = salePromo.promoQty,
                                promo_role = salePromo.promoRule,
                                saledno = salePromo.saled?.dno ?: -1,
                                bp_id = salePromo.bp?.id ?: -1
                            )
                            salePromoPostList.add(salePromoPost)

                            if (salePromo.promo != null && salePromo.promo!!.promoCat.equals("BONUS", ignoreCase = true) && salePromo.promoRule.equals("D", ignoreCase = true)){
                                val saleBns = PostAll.SaleBns(
                                    dno = salePromo.saled?.dno ?: -1,
                                    promoId = salePromo.promo!!.id,
                                    whId = whId.toLong(),
                                    itemId = salePromo.saled?.itemId ?: -1,
                                    unit = salePromo.saled?.unitId.toString(),
                                    qty = salePromo.saled?.qty ?: BigDecimal.ZERO
                                )
                                saleBnsPostList.add(saleBns)
                            }
                        }
                    }

                    var taxed  = false
                    var taxInc = false

                    if(bpSale != null){
                        if(bpSale.isTaxedOnSale) {
                            taxed = true
                            taxInc = false
                        } else if(bpSale.isTaxIncOnSale) {
                            taxed = true
                            taxInc = true
                        } else if(bpSale.isTaxIncOnSale && bpSale.isTaxedOnSale){
                            taxed = true
                            taxInc = true
                        } else {
                            taxed = false
                            taxInc = false
                        }
                    }

                    val salepost = PostAll.SalePost(
                        trxno = sale.trxNo,
                        trxdate = DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, sale.trxDate),
                        termtype = "C",
                        cashId = cashId.toLong(),
                        branchId = branchId,
                        cashier_id = sale.cashierId,
                        bpId = sale.bpId,
                        trxtype = "S",
                        isvoid = sale.isVoid,
                        createdBy = sale.createdBy,
                        updatedBy = sale.updatedBy,
                        reserverd_var1 = sale.kodePosses,
                        createdAt = DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, sale.createdAt),
                        updatedAt = DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, sale.updatedAt),
                        crcId = sale.crcId,
                        excrate = sale.excrate.toInt(),
                        fisrate = sale.fisrate.toInt(),
                        billaddr = sale.bpName,
                        shipaddr = sale.bpName,
                        subtotal = sale.subtotal.toDouble(),
                        basesubtotal = sale.subtotal.toDouble(),
                        discamt = if (sale.discAmt != BigDecimal.ZERO) sale.discAmt else BigDecimal.ZERO,
                        basediscamt = if (sale.discAmt != BigDecimal.ZERO) sale.discAmt else BigDecimal.ZERO,
                        discexp = if (sale.discAmt != BigDecimal.ZERO) sale.discExp else "",
                        rounding = sale.rounding,
                        taxamt = sale.taxAmt,
                        basetaxamt = sale.taxAmt,
                        basefistaxamt = sale.taxAmt,
                        total = sale.total.toDouble(),
                        basetotal = sale.total.toDouble(),
                        paystatus = "N",
                        channel_id = if (sale.channelId != 0) sale.channelId else null,
                        note = sale.voidNote,
                        taxed = taxed,
                        taxinc = taxInc,
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
                        shift = posses.shift.toString(),
                        starttime = posses.trxDate,
                        endtime = posses.endTime,
                        startbal = posses.startBal.toDouble(),
                        totin = if (posses.totIn == null) 0.toDouble() else posses.totIn!!.toDouble(),
                        totout = if (posses.totOut == null) 0.toDouble() else posses.totOut!!.toDouble(),
                        endbal = posses.endBal?.toDouble(),
                        iscollected = posses.endTime != null,
                        usrId = posses.userId,
                        totalActualCash = posses.totalActualCash,
                        totDiffCash = posses.totalDiffCash
                    )
                    possesPostList.add(possesPost)
                }

                for (cstr in listCstr){
                    val cstrPost = PostAll.CstrPost(
                        trxno = cstr.kodeCstr,
                        trxdate = DateFormatUtils.formatLongToString(BPMConstants.DEFAULT_DATE_FORMAT, cstr.trxDate),
                        branch_id = branchId,
                        reftype = cstr.refType,
                        refno = cstr.refNo,
                        note = cstr.note,
                        cash_id1 = cstr.cashId1,
                        cash_id2 = cstr.cashId2,
                        excrate1 = BigDecimal.ONE,
                        excrate2 = BigDecimal.ONE,
                        amount1 = cstr.amount1,
                        amount2 = cstr.amount2
                    )
                    cstrPostList.add(cstrPost)
                }

                for (cadj in listCadj){
                    val cadjPost = PostAll.CadjsPost(
                        trxno = cadj.kodeCadj,
                        trxdate = DateFormatUtils.formatLongToString(BPMConstants.DEFAULT_DATE_FORMAT, cadj.trxDate),
                        branchId = branchId,
                        reftype = cadj.refType,
                        note = cadj.note,
                        cashid = cashId.toLong(),
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
                    syncAt = DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, Date())
                )

                postBody = PostAll(meta, salePostList, cadjPostList, cstrPostList, possesPostList)
            }
        }

        return syncRepository.postSyncAll(postBody)
    }
}