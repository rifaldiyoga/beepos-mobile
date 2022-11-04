package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SrepDao
import com.bits.bee.bpmc.domain.mapper.SrepDataMapper
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.repository.SrepRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class SrepRepositoryImpl @Inject constructor(
    private val srepDao: SrepDao,
    private val defDispatcher: CoroutineDispatcher
) : SrepRepository {

    override fun getSrepList(query : String): Flow<List<Srep>> = flow{
        val data = srepDao.getSrepList(query)
        emit(data.map { SrepDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

    override fun getDefaultSrep(): Flow<Srep?> = flow{
        val data = srepDao.getSrepList("").firstOrNull()
        emit(data?.let { SrepDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

    override fun getSrepById(id: Int): Flow<Srep?> = flow{
        val data = srepDao.getSrepById(id)
        emit(data?.let { SrepDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

}