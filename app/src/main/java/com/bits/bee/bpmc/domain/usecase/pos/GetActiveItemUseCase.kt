package com.bits.bee.bpmc.domain.usecase.pos

import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemAddOnRepository
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.ItemVariantRepository
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
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
    private val getPriceItemUseCase: GetPriceItemUseCase
) {

    suspend operator fun invoke(itemGrpId : Int, priceLvlId : Int = 1, bp : Bp, query : String = "", usePid : Boolean = false) : Flow<PagingData<Item>>  =
        when(itemGrpId != 1){
            true -> itemRepository.getActiveItemListByItemGrp(itemGrpId = itemGrpId, query = query, usePid)
            false -> itemRepository.getActiveItemList(query, usePid)
        }.map { data ->
            data.map { item ->
                if(item.isVariant)
                    item.itemVariantList = itemVariantRepository.getItemVariantByVariant(item.id).first().map { it.itemId }
                item.isHaveAddOn = itemAddOnRepository.getItemAddOnByItem(item.id).first() != null
                getPriceItemUseCase(item, priceLvlId, bp)
            }
        }

}