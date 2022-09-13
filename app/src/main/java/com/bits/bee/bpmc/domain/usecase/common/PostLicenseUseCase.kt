package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.data.data_source.remote.model.LicensePost
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 06/09/22
 */
class PostLicenseUseCase @Inject constructor(
    private val licenseRepository: LicenseRepository,
){

    operator fun invoke(username : String, deviceName : String, version : String) : Flow<Resource<License>> {

        val licensePost = LicensePost(
            email = username,
            deviceinfo = deviceName,
            type = BPMConstants.BPM_DEFAULT_LICENSE_TYPE,
            reactive = false,
            version = version,
        )

        return licenseRepository.postLicense(licensePost)
    }

}