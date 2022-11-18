package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BpAccDao
import com.bits.bee.bpmc.data.data_source.local.model.BpAccEntity
import com.bits.bee.bpmc.domain.mapper.BpAccDataMapper
import com.bits.bee.bpmc.domain.model.BpAcc
import com.bits.bee.bpmc.domain.repository.BpAccRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 09/05/22.
 */
class BpAccRepositoryImpl @Inject constructor(
    private val bpAddrDao: BpAccDao,
    private val ioDispatcher: CoroutineDispatcher
): BpAccRepository {

    override suspend fun addUpdateBpAcc(bpaddr: BpAccEntity) {
        withContext(ioDispatcher){
            bpAddrDao.insertSingle(bpaddr)
        }
    }

    override fun getDefaultBpAccByBp(id: Int): Flow<List<BpAcc>> {
        return flow {
            val data = bpAddrDao.getDefaultBpAccByBp(id)
            emit(data.map { BpAccDataMapper.fromDbToDomain(it) })
        }.flowOn(ioDispatcher)
    }

}