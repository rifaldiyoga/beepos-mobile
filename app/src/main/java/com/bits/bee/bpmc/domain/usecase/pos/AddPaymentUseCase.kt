package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.domain.repository.SaleCrcvRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class AddPaymentUseCase @Inject constructor(
    private val saleCrcvRepository: SaleCrcvRepository,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getRegUseCase: GetRegUseCase
){

    suspend operator fun invoke(sale : Sale, pmtd: Pmtd? = null, trackNo : String = "", cardNo : String = "", note : String = "", payment : BigDecimal = BigDecimal.ZERO, total : BigDecimal = BigDecimal.ZERO) {

        var saleCrcv = SaleCrcv(
            saleInt = sale.id!!,
            rcvTypeCode = sale.termType,
            note = "",
        )

        val reg = getRegUseCase(BPMConstants.REG_ROUND).first()

        pmtd?.let {
            saleCrcv.rcvAmt = sale.total.toString()
            saleCrcv.edcId = pmtd.id
            saleCrcv.cashId = pmtd.cashId
            saleCrcv.trackNo = trackNo
            saleCrcv.rcvTypeCode = pmtd.edcSurcType
            saleCrcv.cardNo = cardNo
            saleCrcv.note = note
            saleCrcv.surcExp = it.surExp
            saleCrcv.surcAmt = BigDecimal(it.surExp).divide(BigDecimal(100)).multiply(total).setScale(reg?.value?.toInt() ?: 0, RoundingMode.HALF_UP).toString()
            saleCrcv.mdrAmt = BigDecimal(it.mdrExp).divide(BigDecimal(100)).multiply(total).setScale(reg?.value?.toInt() ?: 0, RoundingMode.HALF_UP).toString()
            saleCrcv.mdrExp = it.mdrExp
            saleCrcv.mdrAccId = it.mdrAcc.toString()
            saleCrcv.surAccId = it.surAcc.toString()
            saleCrcv.cctypeCode = it.ccType

            saleCrcvRepository.addSaleCrcv(saleCrcv)
        } ?: run {

            val cashier = getActiveCashierUseCase().first()

            saleCrcv.cashId = cashier?.cashId?.toInt() ?: 0
            saleCrcv.rcvAmt = payment.toString()
            saleCrcv.rcvTypeCode = BPMConstants.BPM_DEFAULT_TYPE_CASH
            saleCrcvRepository.addSaleCrcv(saleCrcv)

            val chg = sale.totPaid.subtract(sale.total)
            val chgSaleCrc = saleCrcv.copy(
                rcvTypeCode = BPMConstants.BPM_DEFAULT_TYPE_CHG,
                rcvAmt = chg.toString()
            )
            saleCrcvRepository.addSaleCrcv(chgSaleCrc)
        }



    }

}