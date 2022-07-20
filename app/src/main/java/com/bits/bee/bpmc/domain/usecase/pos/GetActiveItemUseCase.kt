package com.bits.bee.bpmc.domain.usecase.pos

import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository
import com.bits.bee.bpmc.domain.repository.PriceRepository
import com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
class GetActiveItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val priceRepository: PriceRepository,
    private val itemSaleTaxRepository: ItemSaleTaxRepository,
    private val getDefaultCrc : GetDefaultCrcUseCase
) {

    suspend operator fun invoke(itemGrpId : Int, priceLvlId : Int = 1, bp : Bp, query : String = "") : Flow<PagingData<Item>>  =
        when(itemGrpId != 1){
            true -> itemRepository.getActiveItemListByItemGrp(itemGrpId = itemGrpId, query = query)
            false -> itemRepository.getActiveItemList(query)
        }.map { data ->
            data.map { item ->
                val price = priceRepository.getPriceByPriceLvl(priceLvlId, item.id).first()
                val tax = itemSaleTaxRepository.getItemTaxByCodeItem(item.code).first()?.expr ?: ""
                val crc = getDefaultCrc().first()

                val saleistaxed = bp.isTaxedOnSale
                val saletaxinc = bp.isTaxIncOnSale

                item.tax = tax.replace("%", "")
                item.price = price?.price ?: BigDecimal.ZERO
                item.crcSymbol = crc?.symbol ?: ""
                item.crcId = crc?.id!!

                if (!saleistaxed && !saletaxinc) {
                    item.tax = ""
                }
                item
            }
        }

}