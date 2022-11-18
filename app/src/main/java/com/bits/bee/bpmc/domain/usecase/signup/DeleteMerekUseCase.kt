package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.domain.repository.BrandRepository
import javax.inject.Inject

class DeleteMerekUseCase @Inject constructor(
    private val brandRepository: BrandRepository
) {
    suspend operator fun invoke(brand: Brand){
        brandRepository.deleteMerk(brand)
    }
}