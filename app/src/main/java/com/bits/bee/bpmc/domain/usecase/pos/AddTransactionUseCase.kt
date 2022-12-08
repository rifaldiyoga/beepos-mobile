package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.*
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class  AddTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val saleAddOnRepository: SaleAddOnRepository,
    private val saleAddOnDRepository: SaleAddOnDRepository,
    private val salePromoRepository: SalePromoRepository,
    private val crcRepository: CrcRepository,
    private val getUnitItemUseCase: GetUnitItemUseCase,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveUserUseCase: GetActiveUserUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val addCashAUseCase: AddCashAUseCase,
    private val updateTotalPossesUseCase: UpdateTotalPossesUseCase,
    private val addPaymentUseCase: AddPaymentUseCase,
    private val defDispatcher: CoroutineDispatcher,
    private val getRegUseCase: GetRegUseCase,
    private val currencyConvUseCase: CurrencyConvUseCase
) {

    suspend operator fun invoke(
        sale : Sale,
        saledList : List<Saled>,
        saleAddOn : SaleAddOn? = null,
        saleAddOnDList : List<SaleAddOnD> = mutableListOf(),
        salePromoList : List<SalePromo> = mutableListOf(),
        paymentAmt : BigDecimal = BigDecimal.ZERO,
        pmtd : Pmtd? = null,
        trackNo : String = "",
        cardNo : String = "",
        note : String = "",
        counter : Int
    ) : Sale {
        withContext(defDispatcher){

            for (i in (1 .. saledList.size)) {
                val saled = saledList[i - 1]
                saled.dno = i
            }

            val branch = getActiveBranchUseCase().first()
            val cashier = getActiveCashierUseCase().first()
            val user = getActiveUserUseCase().first()
            val posses = getActivePossesUseCase().first()
            val crcId = sale.bp?.bpAccList?.firstOrNull { it.isDefault }?.crcId ?: throw IllegalArgumentException("BpAcc tidak ditemukan!")
            val crc = crcRepository.getCrcById(crcId).first()
            var total : BigDecimal = sale.total

            crc?.let {
                sale.crcId = it.id!!
                sale.excrate = it.excRate
                sale.fisrate = it.fisRate
            } ?: throw Exception("There is no active crc!")

            cashier?.let {
                sale.cashierId = it.id
                sale.cashiername = it.cashierName
            } ?: throw Exception("There is no active cashier!")

            user?.let {
                sale.userId = it.id
                sale.userName = it.name
                sale.createdBy = it.id
                sale.updatedBy = it.id
            } ?: throw Exception("There is no active user!")

            posses?.let {
                sale.possesId = it.possesId!!
                sale.kodePosses = it.trxNo
            } ?: throw Exception("There is no active posses!")

            pmtd?.let {
                val reg = getRegUseCase(BPMConstants.REG_ROUND).first()
                val surc = BigDecimal(it.surExp).divide(BigDecimal(100)).multiply(sale.total).setScale(reg?.value?.toInt() ?: 0, RoundingMode.HALF_UP)
                sale.total = sale.total.add(surc)
            }

            sale.trxNo = TrxNoGeneratorUtils.counterNoTrx(counter, cashier)
            sale.trxOrderNum = counter
            sale.trxDate = Date()
            sale.totPaid = paymentAmt
            sale.totChange = if(paymentAmt > BigDecimal.ZERO && pmtd == null) paymentAmt.subtract(sale.total) else BigDecimal.ZERO

            val id = saleRepository.addSale(sale)
            sale.id = id.toInt()

            saledList.map { saled ->
                saled.saleId = id.toInt()
                if(saled.unitId == null || saled.unit == null) {
                    val unit = getUnitItemUseCase(saled.itemId).first().sortedBy { it.conv }.firstOrNull()
                    unit?.let {
                        saled.unitId = it.id
                        saled.unit = it.unit
                        saled.conv = it.conv
                    }
                }

            }
            val list = saledRepository.addSaled(saledList)

            saledList.forEachIndexed { index, saled ->
                saled.id = list[index].toInt()
            }

            saleAddOn?.let {
                saleAddOn.saleId = sale
                val saleAddOnId = saleAddOnRepository.addSaleAddOn(saleAddOn)

                saleAddOnDList.forEach { saleAddOnD ->
                    saleAddOnD.saleAddOn?.let { saleAddOn ->
                        saleAddOn.id = saleAddOnId.toInt()
                    }
                    saleAddOnD.saled?.let { saled ->
                        saled.id = saledList.firstOrNull { saled == it }?.id
                    }
                    saleAddOnD.upSaled?.let { saled ->
                        saled.id = saledList.firstOrNull { saled == it }?.id
                    }
                }

                saleAddOnDRepository.addSaleAddOnD(saleAddOnDList)
            }

            if(salePromoList.isNotEmpty()) {
                salePromoList.forEach { salePromo ->
                    salePromo.sale = sale
                    salePromo.saleNo = sale.trxNo
                    salePromo.bp = sale.bp
                }

                salePromoRepository.addSalePromo(salePromoList)
            }
            if(!sale.isDraft) {
                val totalConv = currencyConvUseCase(crcId, sale.total).first()
                /** For input transaction to table casha for history cash in or out in active session cashier */
                addCashAUseCase(
                    refId = id,
                    refType = BPMConstants.SALE,
                    cashId = posses.possesId ?: throw Exception(""),
                    cashierId = cashier.id,
                    userId = user.id,
                    amt = totalConv ?: sale.total
                )

                /** For input transaction to table salecrcv for like change and edc */
                addPaymentUseCase(
                    sale = sale,
                    pmtd,
                    trackNo,
                    cardNo,
                    note,
                    paymentAmt,
                    total
                )

                /** For update totin for active session cashier */
                updateTotalPossesUseCase(
                    amt = totalConv ?: sale.total
                )
            }

        }
        return sale
    }

}