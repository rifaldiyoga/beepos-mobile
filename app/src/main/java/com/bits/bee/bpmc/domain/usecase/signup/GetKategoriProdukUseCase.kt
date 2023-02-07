package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetKategoriProdukUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {

    suspend operator fun invoke(): List<KategoriProduk>{
        return mutableListOf()
    }
}