package com.bits.bee.bpmc.domain.usecase.rekap_produk

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

class QueryRekapProdukUseCase @Inject constructor(
    private val saledRepository: SaledRepository,
    private val itemRepository: ItemRepository
) {

    private var mListItem: MutableList<Item> = mutableListOf()

     suspend operator fun invoke(): MutableList<Item> {
         val listSaled = saledRepository.queryByPenjualan().first()
         for (saled in listSaled){
             val item = itemRepository.getItemById(saled.itemId).first()
             item!!.price = if (saled.listPrice == null) BigDecimal.ZERO else saled.listPrice
             mListItem.add(item)
         }
         return mListItem
    }
}