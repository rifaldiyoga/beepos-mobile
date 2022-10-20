package com.bits.bee.bpmc.domain.usecase.rekap_produk

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LoadCariItemsUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(query: String, prclv: Int): List<Item>{
        val itemList = itemRepository.cariItems(query).first()
        return itemList
    }
}