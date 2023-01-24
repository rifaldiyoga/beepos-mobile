package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.data.data_source.remote.model.LicensePost
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 06/09/22
 */
class PostLicenseUseCase @Inject constructor(
    private val licenseRepository: LicenseRepository,
    private val getActiveUserUseCase: GetActiveUserUseCase
){

    suspend operator fun invoke(username : String = "", deviceName : String, version : String, reactive : Boolean = false) : Flow<Resource<License>> {



        val licensePost = LicensePost(
            email = username.ifEmpty { getActiveUserUseCase().first()?.username ?: "" },
            deviceinfo = deviceName,
            type = BPMConstants.BPM_DEFAULT_LICENSE_TYPE,
            reactive = reactive,
            version = version,
        )

        return licenseRepository.postLicense(licensePost)
    }

}