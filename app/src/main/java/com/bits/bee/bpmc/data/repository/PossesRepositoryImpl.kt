package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.data.data_source.local.dao.PossesDao
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.mapper.ItemDataMapper
import com.bits.bee.bpmc.domain.mapper.PossesDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import retrofit2.http.POST
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 07/06/22.
 */
class PossesRepositoryImpl @Inject constructor(
    private val possesDao: PossesDao,
    private val defaultDispatcher: CoroutineDispatcher
) : PossesRepository {

    override suspend fun getActivePosses(): Flow<Posses?> = flow<Posses?> {
        val posses = possesDao.getActivePosses()
        emit(posses?.let{PossesDataMapper.fromDbToDomain(posses)})
    }.flowOn(defaultDispatcher)

    override suspend fun getPosses(): Flow<PagingData<Posses>> = Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            possesDao.getListPosses()
        }
    ).flow.mapLatest {
        it.map { PossesDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override suspend fun addPosses(startBal: BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {
        val date = Date()
        withContext(defaultDispatcher) {
            var posses = PossesEntity(
                startBal = startBal,
                trxDate = date,
                cashierId = cashier.id,
                trxNo = TrxNoGeneratorUtils.generatePossesTrxNo(shift, branch, cashier),
                startTime = date,
                shift = shift,
                total = BigDecimal.ZERO,
                endBal = null,
                endCash = BigDecimal.ZERO,
                credit = BigDecimal.ZERO,
                userId = 3,
                totalActualCash = startBal,
                totalDiffCash = BigDecimal.ZERO,
                totIn = startBal,
            )
            possesDao.insertSingle(posses)
        }
    }

    override suspend fun updatePosses(posses: Posses) {
        withContext(defaultDispatcher){
            possesDao.update(PossesDataMapper.fromDomainToDb(posses))
        }
    }

    override fun getPossesById(id: Int): Flow<Resource<Posses>> {
        return flow {
            val data = possesDao.getPossesById(id)
            emit(Resource.success(PossesDataMapper.fromDbToDomain(data)))
        }.flowOn(defaultDispatcher)
    }

    override suspend fun getPossesHistory(): Flow<PagingData<Posses>> = Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            possesDao.getPossesHistory()
        }
    ).flow.mapLatest {
        it.map { PossesDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override suspend fun getActivePossesList(): Flow<Resource<List<Posses>>> {
        return flow {
            val data = possesDao.getActivePossesList().map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getSortDesc(): Flow<Resource<List<Posses>>> {
        return flow {
            val data = possesDao.getSortDesc().map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getSortAsc(): Flow<Resource<List<Posses>>>{
        return flow {
            val data = possesDao.getSortAsc().map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getFilter(current: Long, end: Long): Flow<Resource<List<Posses>>> {
        return flow {
            val data = possesDao.getFilter(current, end).map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getListPossesHistory(): Flow<Resource<List<Posses>>> {
        return flow {
            val data = possesDao.getListPossesHistory().map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher) as Flow<Resource<MutableList<Posses>>>
    }

    override fun getJmlPossesByDate(startDate: Long, endDate: Long): Flow<Resource<List<Posses>>> {
        return flow {
           val data = possesDao.getJmlPossesByDate(startDate, endDate).map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getFilterAsc(current: Long, end: Long): Flow<Resource<List<Posses>>> {
        return flow {
            val data = possesDao.getFilterAsc(current, end).map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override fun getFilterDesc(current: Long, end: Long): Flow<Resource<List<Posses>>> {
        return flow {
            val data = possesDao.getFilterDesc(current, end).map { PossesDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

}