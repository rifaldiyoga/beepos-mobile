package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemgrpByKategoriUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {
    operator fun invoke(kategori: String): Flow<ItemGroup>{
        return itemGroupRepository.getItgrpByKategori(kategori)
    }
}