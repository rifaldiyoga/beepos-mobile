package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemVariant
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface ItemVariantRepository {

    fun getLatestItemVariantList() : Flow<Resource<List<ItemVariant>>>

    fun getItemVariantByVariant(variantId : Int) : Flow<List<ItemVariant>>
}