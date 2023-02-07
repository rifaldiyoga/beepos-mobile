package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CheckLicenseUseCase @Inject constructor(
    private val licenseRepository: LicenseRepository,
) {

    suspend operator fun invoke(deviceInfo : String) : Flow<Resource<List<License>>> {
        val license = licenseRepository.getActiveLicense().first()
        return licenseRepository.checkLicense(license?.licNumber ?: "", deviceInfo)
    }

}