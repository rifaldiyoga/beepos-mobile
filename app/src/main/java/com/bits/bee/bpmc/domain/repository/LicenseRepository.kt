package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.model.LicensePost
import com.bits.bee.bpmc.data.data_source.remote.post.LicPost
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 06/09/22
 */
interface LicenseRepository {

    fun postLicense(licensePost: LicensePost) : Flow<Resource<License>>

    fun getActiveLicense() : Flow<License?>

//=======
//interface LicenseRepository {
//    fun getLicense(): Flow<Resource<List<License>>>
//
//    fun postLicense(licPost: LicPost): Flow<Resource<Any>>
//>>>>>>> 1ddb2a9... ^ login operator
}