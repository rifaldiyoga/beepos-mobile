package com.bits.bee.bpmc.domain.usecase.login.operator

import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLicenseUseCase @Inject constructor(
    private val licenseRepository: LicenseRepository
) {
    operator fun invoke(): Flow<Resource<List<License>>>{
        return licenseRepository.getLicense()
    }
}