package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao
import com.bits.bee.bpmc.domain.mapper.SaledDataMapper
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaledRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saledDao: SaledDao
) : SaledRepository {

    override suspend fun addSaled(saledList: List<Saled>) {
        withContext(defaultDispatcher){
            val saledNew = saledList.map {
                SaledDataMapper.fromDomainToDb(it)
            }
            saledDao.insertBulk(saledNew)
        }
    }

    override fun getSaledList(saleId: Int): Flow<List<Saled>> = flow {
        val saledList = saledDao.getSaledList(saleId)
        emit(saledList.map { SaledDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)
}