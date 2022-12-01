package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class GetKategoriProdukUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {
    val listKategoriPrd: MutableList<KategoriProduk> = mutableListOf()

    suspend operator fun invoke(): List<KategoriProduk>{
        listKategoriPrd.clear()
        val itgrpList = itemGroupRepository.getItemgrpParent().first()
        for (kategoriprd in itgrpList) {
            val valueSubKat = itemGroupRepository.getItemgrpByUpId(kategoriprd.id!!).first()
            listKategoriPrd.add(KategoriProduk(kategoriprd.name, valueSubKat))
        }
        val distinct = listKategoriPrd.toSet().toList();
        return distinct
    }
}