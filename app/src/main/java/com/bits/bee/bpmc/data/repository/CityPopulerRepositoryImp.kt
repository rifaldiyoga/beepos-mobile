package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CityPopulerDao
import com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity
import com.bits.bee.bpmc.domain.mapper.CityPopulerDataMapper
import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.repository.CityPopulerRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityPopulerRepositoryImp @Inject constructor(
    private val cityPopulerDao: CityPopulerDao,
    private val defaultDispatcher: CoroutineDispatcher
): CityPopulerRepository {
    override suspend fun addCity(cityPopuler: CityPopulerEntity) {
        withContext(defaultDispatcher){
            cityPopulerDao.insertSingle(cityPopuler)
        }
    }

    override fun getCityPopuler(): Flow<List<CityPopuler>> {
        return flow {
            emit(cityPopulerDao.getCityPopuler().map { CityPopulerDataMapper.fromDataToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

}