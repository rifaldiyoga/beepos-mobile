package com.bits.bee.bpmc.domain.usecase.pos

import androidx.paging.PagingData
import androidx.paging.map
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
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
class GetActiveItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val itemAddOnRepository: ItemAddOnRepository,
    private val itemVariantRepository: ItemVariantRepository,
    private val getPriceItemUseCase: GetPriceItemUseCase,
    private val getRegUseCase: GetRegUseCase
) {

    suspend operator fun invoke(itemGrpId : Int = -1, channel : Channel?, bp : Bp?, query : String = "", usePid : Boolean = false) : Flow<PagingData<Item>>  =
        when(itemGrpId){
            -1 -> itemRepository.getFavoriteItemListPaged( query = query)
            1 -> itemRepository.getActiveItemListPaged(query, usePid)
            else -> itemRepository.getActiveItemListPagedByItemGrp(itemGrpId = itemGrpId, query = query, usePid)
        }.map { data ->
            data.map { item ->
                if(bp != null && channel != null) {
                    val reg = getRegUseCase(BPMConstants.REG_CHANNEL_PRICE).first()
                    val priceLvlId = if(reg?.value == "1") channel.priceLvlId ?: 1 else bp.priceLvlId
                    getPriceItemUseCase(item, priceLvlId, bp)
                }
                if(item.isVariant)
                    item.itemVariantList = itemVariantRepository.getItemVariantByVariant(item.id).first().map { it.itemId }
                item.isHaveAddOn = itemAddOnRepository.getItemAddOnByItem(item.id).first() != null
                item
            }
        }

}