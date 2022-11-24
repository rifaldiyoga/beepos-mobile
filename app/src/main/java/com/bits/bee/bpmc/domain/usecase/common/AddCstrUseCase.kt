package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.mapper.CstrDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.domain.repository.CstrRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class AddCstrUseCase @Inject constructor(
    private val cstrRepository: CstrRepository,
    private val getActiveUserUseCase: GetActiveUserUseCase
) {

    suspend operator fun invoke(isBuka : Boolean, refNo : String, refType : String, amt : BigDecimal, branch : Branch, cashier : Cashier, shift : Int){

        val user = getActiveUserUseCase().first()

        val cstr = Cstr(
            trxDate = DateFormatUtils.formatDateToLong(BPMConstants.DATE_FORMAT_RESPONSE, Date()),
            amount1 = amt,
            amount2 = amt,
            excrate1 = BigDecimal.ZERO,
            excrate2 = BigDecimal.ZERO,
            note = if(isBuka) "Modal untuk Kasir : ${cashier.cashierName} Shift : $shift" else "Setoran Kasir : ${cashier.cashierName} Shift : $shift",
            refType = refType,
            refNo = refNo,
            autoGen = "",
            cashId1 = (if(isBuka) cashier.cashBranchId else cashier.cashId).toLong(),
            cashId2 = (if(isBuka) cashier.cashId else cashier.cashBranchId).toLong(),
            isUploaded = false,
            kodeCstr = "",
            createdBy = user?.id ?: throw Exception("No default user active!")
        )
        cstrRepository.addCstr(CstrDataMapper.fromDomainToDb(cstr))

        val lastCstr = cstrRepository.getLastId().first()

        val code = TrxNoGeneratorUtils.counterNoTrxCstr(lastCstr?.id ?: 1, cashier)

        cstrRepository.updateCode(code, lastCstr?.id?:1)
    }
}