package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BranchDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.repository.BranchRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by aldi on 17/03/22.
 */
class BranchRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val branchDao: BranchDao
) : BranchRepository {

    override fun getBranchList(): Flow<Resource<List<Branch>>> {
        return object : NetworkDatabaseBoundResource<List<Branch>, BranchResponse>(){
            override suspend fun loadFormDB(): List<Branch> = branchDao.getBranchList().map { it.toBranch() }

            override fun shouldFetch(data: List<Branch>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<BranchResponse>> {
                return apiUtils.getBranchApiService().getBranchList()
            }

            override suspend fun saveCallResult(data: BranchResponse) {
                    branchDao.insertBulk(data.data.data.map { it.toBranchEntity() })
            }
        }.getAsFlow()
    }


}