package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao
import com.bits.bee.bpmc.domain.mapper.KitchenDataMapper
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitchenRepositoryImpl @Inject constructor(
    private val kitchenDao: KitchenDao,
    private val ioDispatcher: CoroutineDispatcher
): KitchenRepository {
    override fun getKitchenId(id: Int): Flow<Kitchen> {
        return flow {
            val data = kitchenDao.getByKitchenId(id)
            emit(KitchenDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getLastKitchen(): Flow<Kitchen> {
        return flow {
            val data = kitchenDao.getLastKitchen()
            emit(KitchenDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun readKitchen(): Flow<MutableList<Kitchen>> {
        return flow {
            val data = kitchenDao.read().map { KitchenDataMapper.fromDbToDomain(it) }
            emit(data.toMutableList())
        }.flowOn(ioDispatcher)
    }
}