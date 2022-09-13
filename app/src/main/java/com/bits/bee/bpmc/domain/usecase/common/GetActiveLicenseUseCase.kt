package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 07/09/22
 */
class GetActiveLicenseUseCase @Inject constructor(
    private val licenseRepository: LicenseRepository
){

    operator fun invoke() : Flow<License?> = licenseRepository.getActiveLicense()

}