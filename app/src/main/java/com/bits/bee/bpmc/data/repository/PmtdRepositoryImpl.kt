package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BranchDao
import com.bits.bee.bpmc.data.data_source.local.dao.EdcDao
import com.bits.bee.bpmc.data.data_source.local.dao.EdcSurcDao
import com.bits.bee.bpmc.data.data_source.local.dao.PmtdDao
import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.domain.mapper.PmtdDataMapper
import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.domain.repository.PmtdRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class PmtdRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val pmtdDao: PmtdDao,
    private val edcDao: EdcDao,
    private val edcSurcDao: EdcSurcDao,
    private val branchDao : BranchDao,
    private val defaultDispatcher: CoroutineDispatcher
) : PmtdRepository {

    override fun getLatestPmtdList(): Flow<Resource<List<Pmtd>>> {
//        return object : NetworkDatabaseBoundResource<List<PmtdEntity>, PmtdResponse>(){
//            override suspend fun loadFormDB(): List<PmtdEntity>? {
//                return pmtdDao.getPmtdList()
//            }
//
//            override fun shouldFetch(data: List<PmtdEntity>?): Boolean {
//                return true
//            }
//
//            override suspend fun createCall(): Flow<ApiResponse<PmtdResponse>> {
//                return apiUtils.getPmtdApiService().getPmtdList()
//            }
//
//            override suspend fun saveCallResult(data: PmtdResponse) {
//                pmtdDao.insertBulk(data.data.data.map { it.toPmtd() })
//            }
//        }.getAsFlow()
        return flow {
            val edcList = edcDao.getEdcList()
            var pmtNewList = mutableListOf<PmtdEntity>()

            for (edc in edcList){
                val edcSurcList = edcSurcDao.getEdcSurcByEdc(edc.id)
                val branch = edc.branchId?.let { branchDao.getBranchById(it) }
                for (edcSurc in edcSurcList){
                    val pmtd = PmtdEntity(
                        branchId = edc.branchId,
                        branchName = branch?.name,
                        surAcc = edcSurc.surcAccId,
                        surExp = edcSurc.surcExp,
                        cashId = edc.cash,
                        ccType = edcSurc.ccType,
                        mdrAcc = edcSurc.mdrAccId,
                        mdrExp = edcSurc.mdrExp,
                        code = edc.code,
                        name = edc.name,
                        cashName = null,
                        id = null,
                        settleDays = null,
                        idx = null,
                        edcSurcType = edcSurc.edcSurcType
                    )

                    pmtNewList.add(pmtd)
                }
            }

            pmtdDao.insertBulk(pmtNewList)

            val pmtdList = pmtdDao.getPmtdList()
            emit(Resource.success(pmtdList.map { PmtdDataMapper.fromDbToDomain(it) }))
        }.flowOn(defaultDispatcher)
    }

    override fun getActivePmtdList(): Flow<List<Pmtd>> = flow<List<Pmtd>> {
        val data = pmtdDao.getPmtdList()
        emit( data.map { PmtdDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)
}