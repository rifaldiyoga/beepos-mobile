package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.LicenseDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.model.DetachPost
import com.bits.bee.bpmc.data.data_source.remote.model.LicensePost
import com.bits.bee.bpmc.data.data_source.remote.post.CheckLicPost
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.data.data_source.remote.response.CheckLicResponse
import com.bits.bee.bpmc.data.data_source.remote.response.DetachResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LicenseResponse
import com.bits.bee.bpmc.domain.mapper.LicenseDataMapper
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class LicenseRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val licDao: LicenseDao,
    private val dispatcher: CoroutineDispatcher
) : LicenseRepository {

    override fun postLicense(licensePost: LicensePost): Flow<Resource<License>> {
        return object : NetworkDatabaseBoundResource<License,LicenseResponse>(){
            override suspend fun loadFormDB(): License {
                return licDao.getLicense().map { LicenseDataMapper.fromDbToDomain(it) }.first()
            }

            override fun shouldFetch(data: License?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<LicenseResponse>> {
                return apiUtils.getLicenseApiService().postLic(licensePost)
            }

            override suspend fun saveCallResult(data: LicenseResponse) {
                licDao.deleteAll()
                licDao.insertSingle(LicenseDataMapper.fromNetworkToDb(data.data))
            }

        }.getAsFlow()
    }

    override fun getActiveLicense(): Flow<License?> = flow {
        emit(licDao.getLicense().map { LicenseDataMapper.fromDbToDomain(it) }.firstOrNull())
    }.flowOn(dispatcher)

    override fun detachLic(detachPost: DetachPost): Flow<Resource<DetachResponse>> {
        return object : NetworkBoundResource<DetachResponse>(){
            override fun createCall(): Flow<ApiResponse<DetachResponse>> {
                return apiUtils.getLicenseApiService().detachLic(detachPost)
            }

        }.getAsFlow()
    }

    override fun checkLicense(email: String, deviceInfo: String): Flow<Resource<List<License>>> {
        return object : NetworkDatabaseBoundResource<List<License>,CheckLicResponse>() {
            override suspend fun loadFormDB(): List<License> = licDao.getLicense().map { LicenseDataMapper.fromDbToDomain(it) }

            override fun shouldFetch(data: List<License>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<CheckLicResponse>> {
                val checkLicensePost = CheckLicPost(email, deviceInfo)
                return apiUtils.getLicenseApiService().postCheckLic(checkLicensePost)
            }

            override suspend fun saveCallResult(data: CheckLicResponse) {
                data.data?.let { data ->
                    val license = licDao.getLicense().firstOrNull()
                    license?.let {
                        licDao.insertSingle(
                            license.copy(
                                licExp =
                                if(data.expDate != null && data.expDate!!.isNotEmpty())
                                    SimpleDateFormat("yyyy-MM-dd").parse(data.expDate!!) as Date
                                else
                                    null,
                                data = data.data ?: "expired"
                            )
                        )
                    }
                }
            }
        }.getAsFlow()
    }

}