package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitchenRepositoryImpl @Inject constructor(
    private val kitchenDao: KitchenDao,
    private val ioDispatcher: CoroutineDispatcher
): KitchenRepository {
    override fun getKitchenId(id: Int): Flow<Resource<Kitchen>> {
        return flow<Resource<Kitchen>> {
            kitchenDao.getByKitchenId(id)
        }.flowOn(ioDispatcher)
    }

    override fun getLastKitchen(): Kitchen {
        return kitchenDao.getLastKitchen()
    }
}