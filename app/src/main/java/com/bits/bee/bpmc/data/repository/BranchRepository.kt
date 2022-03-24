package com.bits.bee.bpmc.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bits.bee.bpmc.data.source.local.dao.BranchDao
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.BranchResponse
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.repository.BranchRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import javax.inject.Inject

/**
 * Created by aldi on 17/03/22.
 */
class BranchRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val branchDao: BranchDao
) : BranchRepositoryI{

    override fun getBranchList(): LiveData<Resource<List<Branch>>> {
        return object : NetworkDatabaseBoundResource<List<Branch>, BranchResponse>(){
            override fun loadFormDB(): LiveData<List<Branch>>? {
                val a = MutableLiveData<List<Branch>>()
                a.postValue(branchDao.getListBranch().map { it.toBranch() })
                return a
            }

            override fun shouldFetch(data: List<Branch>?): Boolean {
                return true
            }

            override fun createCall(): LiveData<ApiResponse<BranchResponse>> {
                return apiUtils.getBranchApiService().getListBranch()
            }

            override suspend fun saveCallResult(data: BranchResponse) {
                branchDao.insertBulk(data.data.data.map { it.toBranchEntity() })
            }

        }.getAsLiveData()
    }

}