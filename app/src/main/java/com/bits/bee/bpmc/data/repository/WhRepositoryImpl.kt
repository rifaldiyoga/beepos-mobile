package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.WhDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.domain.mapper.WhDataMapper
import com.bits.bee.bpmc.domain.model.Wh
import com.bits.bee.bpmc.domain.repository.WhRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class WhRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val whDao: WhDao,
    private val defDispatcher: CoroutineDispatcher
) : WhRepository {

    override fun getActiveWh(whId: Int): Flow<Wh?> = flow{
        val data = whDao.getWhById(whId)
        emit(data?.let { WhDataMapper.fromDbToDomain(it) })
    }.flowOn(defDispatcher)

}