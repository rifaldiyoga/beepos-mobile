package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.domain.repository.BrandRepository
import javax.inject.Inject

class AddEditMerkProdukUseCase @Inject constructor(
    private val brandRepository: BrandRepository
) {
    suspend operator fun invoke(namaMerek: String, edit: Boolean, olId: Int) {
        var brand: Brand? = null
        if (edit){
            brand = Brand(
                id = olId,
                brandName = namaMerek,
                code = "",
                active = true
            )
        }else{
            brand = Brand(
                brandName = namaMerek,
                code = "",
                active = true
            )
        }
        brandRepository.addBrand(brand, edit)
    }
}