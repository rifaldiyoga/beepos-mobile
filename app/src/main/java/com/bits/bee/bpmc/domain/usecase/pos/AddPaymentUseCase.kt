package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.domain.repository.SaleCrcvRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class AddPaymentUseCase @Inject constructor(
    private val saleCrcvRepository: SaleCrcvRepository,
    private val getActiveCashierUseCase: GetActiveCashierUseCase
){

    suspend operator fun invoke(sale : Sale, pmtd: Pmtd? = null, trackNo : String = "", cardNo : String = "", note : String = "") {

        var saleCrcv = SaleCrcv(
            saleInt = sale.id!!,
            rcvTypeCode = sale.termType,
            note = "",
        )

        pmtd?.let {
            saleCrcv.rcvAmt = sale.total.toString()
            saleCrcv.edcId = pmtd.id
            saleCrcv.cashId = pmtd.cashId
            saleCrcv.trackNo = trackNo
            saleCrcv.rcvTypeCode = pmtd.edcSurcType
            saleCrcv.cardNo = cardNo
            saleCrcv.note = note
            saleCrcv.surcExp = it.surExp
            saleCrcv.surcAmt = BigDecimal(it.surExp).divide(BigDecimal(100)).multiply(sale.total).toString()
            saleCrcv.mdrAmt = BigDecimal(it.mdrExp).divide(BigDecimal(100)).multiply(sale.total).toString()
            saleCrcv.mdrExp = it.mdrExp

            saleCrcvRepository.addSaleCrcv(saleCrcv)
        } ?: run {

            val cashier = getActiveCashierUseCase().first()

            saleCrcv.cashId = cashier?.cashId?.toInt() ?: 0
            saleCrcv.rcvAmt = sale.total.toString()
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