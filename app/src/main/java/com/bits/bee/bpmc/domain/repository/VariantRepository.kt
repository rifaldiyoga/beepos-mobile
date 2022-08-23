package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Variant
import com.bits.bee.bpmc.domain.model.VariantWithItem
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface VariantRepository {

    fun getLatestVariantList() : Flow<Resource<List<Variant>>>

    fun getVariant(variantId : Int) : Flow<VariantWithItem>

}