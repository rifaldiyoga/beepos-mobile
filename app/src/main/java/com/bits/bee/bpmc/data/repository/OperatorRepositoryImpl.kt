package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.OperatorDao
import com.bits.bee.bpmc.data.data_source.local.model.OperatorEntity
import com.bits.bee.bpmc.domain.mapper.OperatorDataMapper
import com.bits.bee.bpmc.domain.model.Operator
import com.bits.bee.bpmc.domain.repository.OperatorRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 22/06/22.
 */
class OperatorRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val operatorDao : OperatorDao
) : OperatorRepository {

    override suspend fun getOperator(): Flow<Resource<List<Operator>>> = flow<Resource<List<Operator>>> {
        operatorDao.deleteAll()

        val operator = OperatorEntity(
            1,
            13,
            "",
            "Aldi",
            "121212",
            true
        )

        operatorDao.insertSingle(operator)

        emit(Resource.success(operatorDao.getOperatorList().map { OperatorDataMapper.fromDataToDomain(it) }))
    }.flowOn(defaultDispatcher)

    override fun getActiveOperator(): Flow<Operator?> = flow {
        emit(OperatorDataMapper.fromDataToDomain(operatorDao.getActiveOperator()))
    }. flowOn(defaultDispatcher)

}