package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao
import com.bits.bee.bpmc.domain.mapper.SaleCrcvDataMapper
import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.domain.repository.SaleCrcvRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class SaleCrcvRepositoryImpl @Inject constructor(
    private val saleCrcvDao: SaleCrcvDao,
    private val defDispatcher: CoroutineDispatcher
) : SaleCrcvRepository {

    override suspend fun addSaleCrcv(saleCrcv: SaleCrcv) {
        withContext(defDispatcher){
            saleCrcvDao.insertSingle(SaleCrcvDataMapper.fromDomainToDb(saleCrcv))
        }
    }

    override fun getSalecrcvBySale(id: Int): Flow<Resource<List<SaleCrcv>>> {
        return flow {
            val data = saleCrcvDao.getSalecrcvBySale(id).map { SaleCrcvDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defDispatcher)
    }

}