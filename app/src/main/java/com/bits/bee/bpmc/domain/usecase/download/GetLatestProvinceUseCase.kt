package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse
import com.bits.bee.bpmc.domain.repository.ProvinceRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLatestProvinceUseCase @Inject constructor(
    private val provinceRepo: ProvinceRepository
) {
    operator fun invoke(page: Int): Flow<Resource<ProvinceResponse>> = provinceRepo.getLatestProvince(page)
}