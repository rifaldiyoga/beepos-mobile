package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemKitchen
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface ItemKitchenRepository {

    fun getLatestItemKitchen() : Flow<Resource<List<ItemKitchen>>>

    fun getByPrinterKitchen(id : Int) : Flow<List<ItemKitchen>>

}