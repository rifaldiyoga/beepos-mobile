package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse
import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.domain.repository.RegencyRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLatestRegencyUseCase @Inject constructor(
    private val regencyRepository: RegencyRepository
) {
    operator fun invoke(page: Int): Flow<Resource<RegencyResponse>> = regencyRepository.getLatestRegency(page)
}