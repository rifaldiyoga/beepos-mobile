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
class GetPriceUnitUseCase @Inject constructor(
    private val priceRepository: PriceRepository,
    private val getRegUseCase: GetRegUseCase
) {

    suspend operator fun invoke(itemId : Int, priceLvlId : Int, bp: Bp, unitPos : Int = 0) : BigDecimal {
        val crcId = bp.bpAccList.firstOrNull { it.isDefault }?.crcId ?: throw IllegalStateException("Bp Acc tidak ditemukan!")
        val price = priceRepository.getPriceByPriceLvl(priceLvlId, itemId, crcId).first()
        val reg = getRegUseCase(BPMConstants.REG_ROUND).first()
        val roundVal = if (reg != null && reg.value.isNotEmpty()) reg.value.toInt() else 0

        val priceItem = when(unitPos) {
            2 -> price?.price3
            1 -> price?.price2
            else -> price?.price1
        }?.setScale(roundVal, RoundingMode.HALF_UP) ?: BigDecimal.ZERO

        return priceItem
    }

}