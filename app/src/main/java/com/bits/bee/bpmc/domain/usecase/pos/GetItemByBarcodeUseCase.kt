package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemAddOnRepository
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.ItemVariantRepository
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
class GetItemByBarcodeUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val itemAddOnRepository: ItemAddOnRepository,
    private val itemVariantRepository: ItemVariantRepository,
    private val getPriceItemUseCase: GetPriceItemUseCase,
    private val getRegUseCase: GetRegUseCase
) {

    suspend operator fun invoke(barcode : String, channel : Channel?, bp : Bp?) : Flow<Item?> = flow {
        val item = itemRepository.getItemByBarcode(barcode).first()
        if(item != null) {
            if (bp != null && channel != null) {
                val reg = getRegUseCase(BPMConstants.REG_CHANNEL_PRICE).first()
                val priceLvlId = if (reg?.value == "1") channel.priceLvlId ?: 1 else bp.priceLvlId
                getPriceItemUseCase(item, priceLvlId, bp)
            }
            if (item.isVariant)
                item.itemVariantList =
                    itemVariantRepository.getItemVariantByVariant(item.id).first().map { it.itemId }
            item.isHaveAddOn = itemAddOnRepository.getItemAddOnByItem(item.id).first() != null
        }
        emit(item)
    }

}