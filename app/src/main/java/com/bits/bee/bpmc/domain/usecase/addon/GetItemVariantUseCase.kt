package com.bits.bee.bpmc.domain.usecase.addon

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.VariantWithItem
import com.bits.bee.bpmc.domain.repository.ItemAddOnRepository
import com.bits.bee.bpmc.domain.repository.VariantRepository
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by aldi on 15/08/22.
 */
class GetItemVariantUseCase @Inject constructor(
    private val variantRepository: VariantRepository,
    private val getPriceItemUseCase: GetPriceItemUseCase,
    private val itemAddOnRepository: ItemAddOnRepository
) {

    operator fun invoke(variantId : Int, priceLvlId : Int, bp: Bp) : Flow<VariantWithItem>   {
        return  variantRepository.getVariant(variantId).map {
            it.also {
                it.itemList.map {
                    it.isHaveAddOn = itemAddOnRepository.getItemAddOnByItem(it.id).first() != null
                    getPriceItemUseCase(it, priceLvlId, bp)
                }
            }
        }
    }

}