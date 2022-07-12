package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.data_source.remote.response.DistrictResponse
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.repository.DistrictRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLatestDistrictUseCase @Inject constructor(
    private val districtRepository: DistrictRepository
) {
    operator fun invoke(page: Int): Flow<Resource<DistrictResponse>> = districtRepository.getLatestDistrict(page)
}