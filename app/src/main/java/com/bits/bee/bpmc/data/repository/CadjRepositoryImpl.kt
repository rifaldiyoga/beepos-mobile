package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.CadjDao
import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.domain.mapper.CadjDataMapper
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class CadjRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cadjDao: CadjDao,
    private val ioDispatcher: CoroutineDispatcher
): CadjRepository {
    override suspend fun addCadj(cadjEntity: CadjEntity) {
        withContext(ioDispatcher){
            cadjDao.insertSingle(cadjEntity)
        }
    }

    override fun getCadjByReftypeInOutHaventUpload(): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getCadjByReftypeInOutHaventUpload().map { CadjDataMapper.fromDbToDomain(it) }
            emit((data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun updateCadj(cadj: Cadj) {
        withContext(ioDispatcher){
            cadjDao.update(CadjDataMapper.fromDomainToDb(cadj))
        }
    }

    override fun getCadjLastRow(): Flow<Cadj> {
        return flow {
            val data = cadjDao.getCadjLastRow()
            emit(CadjDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun updateCode(code: String, id: Int) {
        withContext(ioDispatcher){
            cadjDao.updateCode(code, id)
        }
    }

    override fun getLastInOutStatus(cashid: Long): Flow<Cadj> {
        return flow {
            val data = cadjDao.getLastInOutStatus(cashid)
            emit(CadjDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getKasMasukDesc(query: String): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getKasMasukDesc(query).map { CadjDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getKasMasukAsc(query: String): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getKasMasukAsc(query).map { CadjDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getKasKeluarDesc(query: String): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getKasKeluarDesc(query).map { CadjDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getKasKeluarAsc(query: String): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getKasKeluarAsc(query).map { CadjDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getJmlCadjInByDate(startDate: Long, endDate: Long): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getJmlCadjInByDate(startDate, endDate).map { CadjDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getJmlCadjOutByDate(startDate: Long, endDate: Long): Flow<List<Cadj>> {
        return flow {
            val data = cadjDao.getJmlCadjOutByDate(startDate, endDate).map { CadjDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

}