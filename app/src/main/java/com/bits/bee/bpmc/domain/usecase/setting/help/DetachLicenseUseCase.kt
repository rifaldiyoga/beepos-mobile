package com.bits.bee.bpmc.domain.usecase.setting.help

import com.bits.bee.bpmc.data.data_source.remote.model.DetachPost
import com.bits.bee.bpmc.data.data_source.remote.response.DetachResponse
import com.bits.bee.bpmc.domain.repository.LicenseRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetachLicenseUseCase @Inject constructor(
    private val licenseRepository: LicenseRepository
) {
    suspend operator fun invoke(detachPost: DetachPost): Flow<Resource<DetachResponse>>{
        return licenseRepository.detachLic(detachPost)
    }
}