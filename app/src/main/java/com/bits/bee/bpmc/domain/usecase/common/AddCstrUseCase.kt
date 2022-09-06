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
) {

    suspend operator fun invoke(refNo : String, refType : String, amt : BigDecimal, branch : Branch, cashier : Cashier){

        val cstr = Cstr(
            trxDate = DateFormatUtils.formatDateToLong(BPMConstants.DEFAULT_DATE_FORMAT, Date()),
            amount1 = amt,
            amount2 = amt,
            excrate1 = BigDecimal.ZERO,
            excrate2 = BigDecimal.ZERO,
            note = false,
            refType = refType,
            refNo = refNo,
            autoGen = "",
            cashId1 = 1,
            cashId2 = 1,
            isUploaded = false,
            kodeCstr = "",
        )
        cstrRepository.addCstr(CstrDataMapper.fromDomainToDb(cstr))

        val lastCstr = cstrRepository.getLastId().first()

        val code = TrxNoGeneratorUtils.counterNoTrxCstr(lastCstr?.id ?: 1, branch, cashier)

        cstrRepository.updateCode(code, lastCstr?.id?:1)
    }
}