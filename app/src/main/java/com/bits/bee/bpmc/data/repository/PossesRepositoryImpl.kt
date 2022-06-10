package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PossesDao
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.mapper.PossesDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 07/06/22.
 */
class PossesRepositoryImpl @Inject constructor(
    private val possesDao: PossesDao,
    private val defaultDispatcher: CoroutineDispatcher
) : PossesRepository {

    override fun getActivePosses(): Flow<Posses?> =
        flow<Posses> {
            val posses = possesDao.getActivePosses()
            posses?.let {
                PossesDataMapper.fromDataToDomain(posses)
//                emit(it)
            }
        }.flowOn(defaultDispatcher)

    override suspend fun addPosses(startBal: BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {
        val date = Date()
        withContext(defaultDispatcher){
            var posses = PossesEntity(
                startBal = startBal,
                trxDate = date,
                cashierId = 1,
                trxNo = TrxNoGeneratorUtils.generatePossesTrxNo(shift, branch, cashier),
                startTime = date,
                shift = shift,
                total = BigDecimal.ZERO,
                endBal = BigDecimal.ZERO,
                endCash = BigDecimal.ZERO,
                credit = BigDecimal.ZERO,
                operatorId = 1,
                totalActualCash = BigDecimal.ZERO,
                totalDiffCash = BigDecimal.ZERO
            )
            possesDao.insertSingle(posses)
        }
    }

}