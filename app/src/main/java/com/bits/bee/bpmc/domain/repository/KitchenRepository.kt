package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.ItemVariant
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface KitchenRepository {

    fun getLatestKitchen() : Flow<Resource<List<Kitchen>>>

    fun getKitchenId(id: Int): Flow<Kitchen>

    fun getLastKitchen(): Flow<Kitchen>

    fun readKitchen(): Flow<MutableList<Kitchen>>
}