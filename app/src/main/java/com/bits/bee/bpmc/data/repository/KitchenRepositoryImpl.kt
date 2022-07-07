package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao
import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity
import com.bits.bee.bpmc.domain.mapper.KitchenDataMapper
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDataMapper
import com.bits.bee.bpmc.domain.model.Kitchen
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
        return flow {
            val data = kitchenDao.getByKitchenId(id)
            if (data != null)
                emit(Resource.success(KitchenDataMapper.fromDataToDomain(data)))
            else
                emit(Resource.error(null, "data kosong"))
        }.flowOn(ioDispatcher)
    }

    override fun getLastKitchen(): Flow<Resource<Kitchen>> {
        return flow {
            val data = kitchenDao.getLastKitchen()
            if (data != null)
                emit(Resource.success(KitchenDataMapper.fromDataToDomain(data)))
        }.flowOn(ioDispatcher)
    }

    override fun readKitchen(): Flow<Resource<MutableList<Kitchen>>> {
        return flow {
            val data = kitchenDao.read().map { KitchenDataMapper.fromDataToDomain(it) }
            if (data != null){
                emit(Resource.success(data))
            }else{
                emit(Resource.error(null,"data kosong"))
            }
        }.flowOn(ioDispatcher) as Flow<Resource<MutableList<Kitchen>>>
    }
}