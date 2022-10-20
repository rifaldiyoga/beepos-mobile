package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository
import com.bits.bee.bpmc.domain.repository.PriceRepository
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 22/08/22.
 */
class GetPriceItemUseCase @Inject constructor(
    private val priceRepository: PriceRepository,
    private val itemSaleTaxRepository: ItemSaleTaxRepository,
    private val getDefaultCrc : GetDefaultCrcUseCase,
    private val getUnitItemUse: GetUnitItemUseCase
){

    suspend operator fun invoke(item : Item, priceLvlId : Int, bp: Bp) : Item {
//        if (!item.isVariant) {
            val price = priceRepository.getPriceByPriceLvl(priceLvlId, item.id).first()
            val tax = itemSaleTaxRepository.getItemTaxByCodeItem(item.code).first()
            val crc = getDefaultCrc().first()

            val saleistaxed = bp.isTaxedOnSale
            val saletaxinc = bp.isTaxIncOnSale

            item.tax = tax?.expr?.replace("%", "") ?: ""
            item.taxCode = tax?.code ?: ""
            item.price = price?.price ?: BigDecimal.ZERO
            item.crcSymbol = crc?.symbol ?: ""
            item.crcId = crc?.id!!

            if (!saleistaxed && !saletaxinc) {
                item.tax = ""
            }
//        }
        return item
    }

}