package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao
import com.bits.bee.bpmc.domain.mapper.RankItemDataMapper
import com.bits.bee.bpmc.domain.mapper.SaledDataMapper
import com.bits.bee.bpmc.domain.model.RankItem
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

    override suspend fun addSaled(saledList: List<Saled>) : List<Long> {
        var list : List<Long> = mutableListOf()
        withContext(defaultDispatcher) {
            val saledNew = saledList.map {
                SaledDataMapper.fromDomainToDb(it)
            }
            list = saledDao.insertBulk(saledNew)
        }
        return list
    }

    override fun getSaledList(saleId: Int): Flow<List<Saled>> = flow {
        val saledList = saledDao.getSaledList(saleId)
        emit(saledList.map { SaledDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getRankItem(possesId: Int): Flow<List<RankItem>> {
        return flow {
            val rankItem = saledDao.getRankItem(possesId).map { RankItemDataMapper.fromDbToDomain(it) }
            emit(rankItem)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledDeletedItem(): Flow<List<Saled>> {
        return flow {
            val data = saledDao.getSaledDeletedItem().map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledById(id: Int): Flow<Saled?> {
        return flow {
            val data = saledDao.getSaledById(id)
            emit(data?.let { SaledDataMapper.fromDbToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun queryByPenjualan(): Flow<List<Saled>> {
        return flow {
            val data = saledDao.queryByPenjualan().map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }
}