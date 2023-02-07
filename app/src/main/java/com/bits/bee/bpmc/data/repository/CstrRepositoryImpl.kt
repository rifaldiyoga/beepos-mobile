package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CstrDao
import com.bits.bee.bpmc.data.data_source.local.model.CstrEntity
import com.bits.bee.bpmc.domain.mapper.CstrDataMapper
import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.domain.repository.CstrRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class CstrRepositoryImpl @Inject constructor(
    private val cstrDao: CstrDao,
    private val defaultDispatcher: CoroutineDispatcher
)
: CstrRepository {
    override suspend fun addCstr(cstr: CstrEntity) {
        withContext(defaultDispatcher){
            cstrDao.insertSingle(cstr)
        }
    }

    override suspend fun updateCode(code: String, id: Int) {
        withContext(defaultDispatcher){
            cstrDao.updateCode(code, id)
        }
    }

    override fun getLastId(): Flow<Cstr?> {
        return flow {
            val data = cstrDao.getLastId()
            emit(data?.let { CstrDataMapper.fromDbToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun getCstrByReftypeHaventUpload(): Flow<List<Cstr>> {
        return flow {
            val data = cstrDao.getCstrByReftypeHaventUpload().map { CstrDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override suspend fun updateCstr(cstr: Cstr) {
        withContext(defaultDispatcher){
            cstrDao.update(CstrDataMapper.fromDomainToDb(cstr))
        }
    }


}