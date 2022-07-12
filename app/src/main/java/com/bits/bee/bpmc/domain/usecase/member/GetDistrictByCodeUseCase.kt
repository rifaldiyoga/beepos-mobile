package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.repository.DistrictRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDistrictByCodeUseCase @Inject constructor(
    private val districtRepository: DistrictRepository
) {
    operator fun invoke(districtCode: String): Flow<Resource<District>>{
        return districtRepository.getNameByCode(districtCode)
    }
}