package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao
import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import com.bits.bee.bpmc.domain.mapper.BpAddrDataMapper
import com.bits.bee.bpmc.domain.model.BpAddr
import com.bits.bee.bpmc.domain.repository.BpAddrRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 09/05/22.
 */
class BpAddrRepositoryImpl @Inject constructor(
    private val bpAddrDao: BpAddrDao,
    private val ioDispatcher: CoroutineDispatcher
): BpAddrRepository {
    override suspend fun addUpdateBpAddr(bpaddr: BpAddrEntity) {
        withContext(ioDispatcher){
            bpAddrDao.insertSingle(bpaddr)
        }
    }

    override fun getBpAddrByBp(id: Int): Flow<Resource<BpAddr>> {
        return flow {
            val data = bpAddrDao.getBpAddrByBp(id)
            emit(Resource.success(BpAddrDataMapper.fromDataToDomain(data)))
        }.flowOn(ioDispatcher)
    }

}