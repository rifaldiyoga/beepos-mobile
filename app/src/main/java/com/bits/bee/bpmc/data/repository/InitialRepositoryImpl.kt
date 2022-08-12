package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.*
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse
import com.bits.bee.bpmc.domain.mapper.*
import com.bits.bee.bpmc.domain.repository.InitialRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 13/07/22.
 */
class InitialRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val cmpDao: CmpDao,
    private val regDao: RegDao,
    private val userDao: UserDao,
    private val usrGrpDao: UsrGrpDao,
    private val grpPrvDao: GrpPrvDao,
    private val crcDao: CrcDao,
    private val whDao: WhDao
) : InitialRepository {

    override fun getInitialData(): Flow<Resource<Any>> {
        return object : NetworkDatabaseBoundResource<Any, InitialResponse>(){
            override suspend fun loadFormDB(): Any = Any()

            override fun shouldFetch(data: Any?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<InitialResponse>> {
                return apiUtils.getInitialApiService().getInitial()
            }

            override suspend fun saveCallResult(response: InitialResponse) {
                val data = response.data
                cmpDao.insertBulk(data.cmp.map { CmpDataMapper.fromNetworkToDb(it) })
                regDao.insertBulk(data.reg.map { RegDataMapper.fromNetworkToDb(it) })
                userDao.insertBulk(data.usr.map { UserDataMapper.fromNetworkToDb(it) })
                usrGrpDao.insertBulk(data.usrGrp.map { UsrGrpDataMapper.fromNetworkToDb(it) })
                grpPrvDao.insertBulk(data.grpPrv.map { GrpPrvDataMapper.fromNetworkToDb(it) })
                crcDao.insertBulk(data.crc.map { CrcDataMapper.fromNetworkToDb(it) })
                whDao.insertBulk(data.wh.map { WhDataMapper.fromNetworkToDb(it) })
            }

        }.getAsFlow()
    }

}