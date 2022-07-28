package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase
import com.bits.bee.bpmc.domain.usecase.common.AddCstrUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class BukaKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
    private val cashRepository: CashRepository,
    private val addCashAUseCase: AddCashAUseCase,
    private val addCstrUseCase: AddCstrUseCase
){
    private var mCash: Cash? = null
    private var mPosses: Posses? = null
    private var mCstr: Cstr? = null

    suspend operator fun invoke(modal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {
        possesRepository.addPosses(modal, shift, branch, cashier)

        mPosses  = possesRepository.getActivePosses().first()

        var cash = Cash(
            code = "",
            name = "",
            balance = modal
        )
        cashRepository.addCash(CashDataMapper.fromDomainToDb(cash))

        mCash = cashRepository.getLastId().first()

        addCashAUseCase(
            refId = mPosses?.possesId?.toLong() ?: throw Exception(),
            refType = BPMConstants.BPM_DEFAULT_TYPE_POSSES,
            cashId = mCash?.id ?: throw Exception(),
            cashierId = cashier.id,
            userId = mPosses?.userId ?: throw Exception(),
            amt = modal
        )

        addCstrUseCase(
            refType = BPMConstants.BPM_DEFAULT_TYPE_POSSES,
            refNo = mPosses?.trxNo ?: throw Exception("adasd"),
            amt = modal,
            cashier = cashier,
            branch = branch
        )

//        select so_id, d.item_id, d.unit, d.conv as conv_sod, u.conv as conv_unit from sod d join unit u on d.unit=u.id
    //        where d.conv<>u.conv

//        val possesActive = possesRepository.getActivePosses()

    }

}