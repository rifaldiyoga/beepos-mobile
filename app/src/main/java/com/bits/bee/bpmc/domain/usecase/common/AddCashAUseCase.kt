package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.mapper.CashADataMapper
import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */

class AddCashAUseCase @Inject constructor(
    private val cashARepository: CashARepository
){

    suspend operator fun invoke(refId : Long, refType : String, cashId : Int, userId : Int, cashierId : Int, amt : BigDecimal){
        val cashA = CashA(
            trxDate = DateFormatUtils.formatDateToString(BPMConstants.DATE_FORMAT_RESPONSE, Date()),
            amount = amt,
            note = "",
            inOut = (if(amt >= BigDecimal.ZERO) "i" else "o"),
            refType = refType,
            refId = refId,
            autoGen = true,
            cashId = cashId,
            userId = userId,
            cashierId = cashierId
        )

        cashARepository.addCashA(CashADataMapper.fromDomainToDb(cashA))
    }
}