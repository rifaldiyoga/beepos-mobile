package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.source.local.dao.BpAddrDao
import com.bits.bee.bpmc.data.source.local.dao.BpDao
import com.bits.bee.bpmc.data.source.local.model.Bp
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.response.BpResponse
import com.bits.bee.bpmc.domain.repository.BpRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class BpRepository @Inject constructor(
    private val apiUtils: ApiUtils,
    private val bpDao: BpDao,
    private val bpAddrDao : BpAddrDao
) : BpRepositoryI {

    override fun getBpList(): Flow<Resource<List<Bp>>> {
        return object : NetworkDatabaseBoundResource<List<Bp>, BpResponse>(){
            override suspend fun loadFormDB(): List<Bp>? {
                return bpDao.getBpList()
            }

            override fun shouldFetch(data: List<Bp>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<BpResponse>> {
                return apiUtils.getBpApiService().getBpList()
            }

            override suspend fun saveCallResult(data: BpResponse) {
                bpDao.insertBulk(data.data.data.map { it.toBp() })
                data.data.data.onEach {
                    bpAddrDao.insertBulk(it.bpAddr.map { it.toBpAddr() })
                }
            }
        }.getAsFlow()
    }
}