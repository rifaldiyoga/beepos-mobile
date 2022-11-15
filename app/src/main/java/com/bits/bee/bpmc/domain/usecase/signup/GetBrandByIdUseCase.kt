package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.domain.repository.BrandRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBrandByIdUseCase @Inject constructor(
    private val brandRepository: BrandRepository
) {
    operator fun invoke(id: Int): Flow<Brand>{
        return brandRepository.getBrandById(id)
    }
}