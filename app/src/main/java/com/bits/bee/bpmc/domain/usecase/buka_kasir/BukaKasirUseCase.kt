package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.mapper.CashADataMapper
import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.mapper.CstrDataMapper
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.CstrRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.flow.collect
import java.math.BigDecimal
import java.text.SimpleDateFormat
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class BukaKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
    private val cashRepository: CashRepository,
    private val cashARepository: CashARepository,
    private val cstrRepository: CstrRepository
){
    private var mCash: Cash? = null
    private var mPosses: Posses? = null
    private var mCstr: Cstr? = null

    suspend operator fun invoke(modal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {
        possesRepository.addPosses(modal, shift, branch, cashier)

        possesRepository.getActivePosses().collect {
            it?.let {
                mPosses = it
            }
        }

        var cash = Cash(
            code = "",
            name = "",
            balance = modal
        )
        cashRepository.addCash(CashDataMapper.fromDomainToDb(cash))

        cashRepository.getLastId().collect {
            it.data?.let {
                mCash = it
            }
        }

        var cashA = CashA(
            trxDate = DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, mPosses!!.trxDate),
            amount = modal,
            note = "",
            inOut = "i".first(),
            refType = "POSSES",
            refId = mPosses!!.possesId!!.toLong(),
            autoGen = true,
            cashId = mCash!!.id!!,
            userId = mPosses!!.operatorId,
            cashierId = mPosses!!.cashierId,
            isUploaded = true
        )
        cashARepository.addCashA(CashADataMapper.fromDomainToDb(cashA))

        var cstr = Cstr(
            trxDate = DateFormatUtils.formatDateToLong(BPMConstants.DEFAULT_DATE_FORMAT, mPosses!!.trxDate),
            amount1 = modal,
            amount2 = modal,
            excrate1 = BigDecimal.ZERO,
            excrate2 = BigDecimal.ZERO,
            note = false,
            refType = "POSSES",
            refNo = mPosses!!.trxNo,
            autoGen = "",
            cashId1 = 1,
            cashId2 = 1,
            isUploaded = true,
            kodeCstr = "",
        )
        cstrRepository.addCstr(CstrDataMapper.fromDomainToDb(cstr))

        cstrRepository.getLastId().collect {
            it.data?.let {
                mCstr = it
            }
        }

        var code = TrxNoGeneratorUtils.counterNoTrxCstr(mCstr!!.id!!, branch, cashier)
        cstrRepository.updateCode(code.toString(), mCstr!!.id!!)

//        select so_id, d.item_id, d.unit, d.conv as conv_sod, u.conv as conv_unit from sod d join unit u on d.unit=u.id
    //        where d.conv<>u.conv

//        val possesActive = possesRepository.getActivePosses()

    }

}