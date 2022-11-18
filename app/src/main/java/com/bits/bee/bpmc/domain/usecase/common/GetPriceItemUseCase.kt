package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.CrcRepository
import com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository
import com.bits.bee.bpmc.domain.repository.PriceRepository
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

/**
 * Created by aldi on 22/08/22.
 */
class GetPriceItemUseCase @Inject constructor(
    private val priceRepository: PriceRepository,
    private val itemSaleTaxRepository: ItemSaleTaxRepository,
    private val crcRepository: CrcRepository,
    private val getUnitItemUse: GetUnitItemUseCase,
    private val getRegUseCase: GetRegUseCase
){

    suspend operator fun invoke(item : Item, priceLvlId : Int, bp: Bp) : Item {
        val tax = itemSaleTaxRepository.getItemTaxByCodeItem(item.code).first()
        val crcId = bp.bpAccList.firstOrNull { it.isDefault }?.crcId ?: throw IllegalStateException("Bp Acc tidak ditemukan!")
        val crc = crcRepository.getCrcById(crcId).first()
        val price = priceRepository.getPriceByPriceLvl(priceLvlId, item.id, crcId).first()
        val reg = getRegUseCase(BPMConstants.REG_ROUND).first()
        val roundVal = if (reg != null && reg.value.isNotEmpty()) reg.value.toInt() else 0
        val saleistaxed = bp.isTaxedOnSale
        val saletaxinc = bp.isTaxIncOnSale

        item.tax = tax?.expr?.replace("%", "") ?: ""
        item.taxCode = tax?.code ?: ""
        item.price = (price?.price ?: BigDecimal.ZERO).setScale(roundVal, RoundingMode.HALF_UP)
        item.crcSymbol = crc?.symbol ?: ""
        item.crcId = crc?.id!!

        if (!saleistaxed && !saletaxinc) {
            item.tax = ""
        }
        return item
    }

}