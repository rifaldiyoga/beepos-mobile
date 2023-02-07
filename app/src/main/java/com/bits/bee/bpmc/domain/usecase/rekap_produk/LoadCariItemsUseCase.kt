package com.bits.bee.bpmc.domain.usecase.rekap_produk

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

class LoadCariItemsUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val saledRepository: SaledRepository,
) {

    private var mListItem: MutableList<Item> = mutableListOf()
    private var tempItem: List<Item>? = null

   suspend operator fun invoke(query: String, prclv: Int, startDate: Long, endDate: Long): List<Item>{
       itemRepository.cariItems(query).collect{
           tempItem = it
       }
//       var str = ""
//       mListItem.clear()
//       for (itemss in tempItem ?: mutableListOf()){
//           val saledList = saledRepository.getSaledTotal(itemss.id, startDate, endDate).first()
//           var str =""
//           for (items in saledList){
//               itemss.subtotal = items.subtotal
//               itemss.qty = items.qty
//           }
//           mListItem.add(itemss)
//       }
//       val distinct = mListItem.toSet().toList();

       return tempItem ?: mutableListOf()
    }
}