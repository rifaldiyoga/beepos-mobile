package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.domain.repository.BrandRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastBrandUseCase @Inject constructor(
    private val brandRepository: BrandRepository
) {
    operator fun invoke(): Flow<Brand?> = brandRepository.getLastBrand()
}