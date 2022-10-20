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
    private var newListItem: MutableList<Item>? =null

     suspend operator fun invoke(startDate: Long, endDate: Long, search: String): List<Item> {
         mListItem.clear()
         val listSaled = saledRepository.queryByPenjualan().first()
         for (saled in listSaled){
             val item = itemRepository.getItemById(saled.itemId).first()
             item!!.price = if (saled.listPrice == null) BigDecimal.ZERO else saled.listPrice
             val saledList = saledRepository.getSaledTotal(item.id, startDate, endDate).first()
             for (items in saledList){
                 item.subtotal = items.subtotal
                 item.qty = items.qty
             }
             mListItem.add(item)
         }
         val distinct = mListItem.toSet().toList();

         return distinct
    }
}