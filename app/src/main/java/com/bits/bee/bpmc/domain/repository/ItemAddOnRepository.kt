package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemAddOn
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface ItemAddOnRepository {

    fun getLatestItemAddOn() : Flow<Resource<List<ItemAddOn>>>

    fun getItemAddOnByItem(itemId : Int) : Flow<ItemAddOn?>

}