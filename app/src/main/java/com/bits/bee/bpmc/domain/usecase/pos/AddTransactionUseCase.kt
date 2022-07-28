package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class AddTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveOperatorUseCase: GetActiveOperatorUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val getDefaultCrcUseCase: GetDefaultCrcUseCase,
    private val addCashAUseCase: AddCashAUseCase,
    private val addTotalPossesUseCase: AddTotalPossesUseCase,
    private val addPaymentUseCase: AddPaymentUseCase,
    private val defDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(sale : Sale, saled : List<Saled>, paymentAmt : BigDecimal, pmtd : Pmtd? = null, trackNo : String = "", cardNo : String = "", note : String = "") {
        withContext(defDispatcher){
            val branch = getActiveBranchUseCase().first()
            val cashier = getActiveCashierUseCase().first()
            val user = getActiveOperatorUseCase().first()
            val posses = getActivePossesUseCase().first()
            val crc = getDefaultCrcUseCase().first()

            crc?.let {
                sale.crcId = it.id!!
            } ?: throw Exception("There is no active crc!")

            cashier?.let {
                sale.cashierId = it.id
                sale.cashiername = it.cashierName
            } ?: throw Exception("There is no active cashier!")

            user?.let {
                sale.operatorId = it.id
                sale.userName = it.name
            } ?: throw Exception("There is no active user!")

            posses?.let {
                sale.possesId = it.possesId!!
                sale.kodePosses = it.trxNo
            } ?: throw Exception("There is no active posses!")

            sale.trxNo = TrxNoGeneratorUtils.counterNoTrx(1, branch!!, cashier)
            sale.trxDate = Date()
            sale.totPaid = paymentAmt
            sale.totChange = paymentAmt.subtract(sale.total)

            pmtd?.let {
                val surc = BigDecimal(it.surExp).divide(BigDecimal(100)).multiply(sale.total)
                sale.total.add(surc)
            }

            val id = saleRepository.addSale(sale)
            sale.id = id.toInt()

            saled.map {
                it.saleId = id.toInt()
            }
            saledRepository.addSaled(saled)

            if(!sale.isDraft) {
                /** For input transaction to table casha for history cash in or out in active session cashier */
                addCashAUseCase(
                    refId = id,
                    refType = BPMConstants.SALE,
                    cashId = posses.possesId ?: throw Exception(""),
                    cashierId = cashier.id,
                    userId = user.id,
                    amt = sale.total
                )

                /** For input transaction to table salecrcv for like change and edc */
                addPaymentUseCase(
                    sale = sale,
                    pmtd,
                    trackNo
                )

                /** For update totin for active session cashier */
                addTotalPossesUseCase(
                    amt = sale.total
                )
            }

        }
    }

}