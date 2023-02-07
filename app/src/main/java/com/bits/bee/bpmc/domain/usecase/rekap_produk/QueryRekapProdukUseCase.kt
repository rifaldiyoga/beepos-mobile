package com.bits.bee.bpmc.domain.usecase.rekap_produk

import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.RekapProduk
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.math.BigDecimal
import javax.inject.Inject

class QueryRekapProdukUseCase @Inject constructor(
    private val saledRepository: SaledRepository,
    private val itemRepository: ItemRepository
) {

    private var mListItem: MutableList<Item> = mutableListOf()
    private var mListSaled: List<Saled>? = null
    private var newListItem: MutableList<Item>? =null
    private lateinit var listFLow: Flow<PagingData<Item>>

    operator fun invoke(startDate: Long, endDate: Long, query: String): Flow<PagingData<RekapProduk>> =
        saledRepository.getRekapProduk(startDate, endDate, query).map { data ->
            data.map { rekapPrd  ->
                rekapPrd
            }
        }
//        mListItem.clear()
//        val listSaled = saledRepository.queryByPenjualan().first()
//        for (saled in listSaled) {
//            val item = itemRepository.getItemById(saled.itemId).first()
//            item!!.price = saled.listPrice
//            saledRepository.getSaledTotal(item.id, startDate, endDate).collectLatest {
//                mListSaled = it
//            }
//            for (itemss in mListSaled!!){
//                item.subtotal = item.subtotal.add(itemss.subtotal)
//                item.qty = item.qty.add(itemss.qty)
//            }
//            mListItem.add(item)
//        }
//        val distinct = mListItem.toSet().toList();
//
//        return distinct


}