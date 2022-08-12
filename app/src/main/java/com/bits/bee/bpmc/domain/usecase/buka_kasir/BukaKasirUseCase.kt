package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase
import com.bits.bee.bpmc.domain.usecase.common.AddCstrUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class BukaKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
    private val cashRepository: CashRepository,
    private val addCashAUseCase: AddCashAUseCase,
    private val addCstrUseCase: AddCstrUseCase,
    private val cashARepository: CashARepository
){
    private var mCash: Cash? = null
    private var mPosses: Posses? = null
    private var mCstr: Cstr? = null
    private var mListCasha: List<CashA>? = null
    private var mShift: Int = 0

    suspend operator fun invoke(modal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {

//        cashARepository.getLastCasha().collect {
//            it.data.let {
//                mListCasha = it
//            }
//        }

//        mShift = shift
//
//        if (mListCasha!!.size > 0){
//            if (SimpleDateFormat("MMdd").format(Date()).compareTo(SimpleDateFormat("MMdd").format(
//                    mListCasha!!.get(0).trxDate)) > 0){
//                mShift = 1
//            }
//        }else{
//            mShift = 1
//        }

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

//        val possesActive = possesRepository.getActivePosses()

    }

}