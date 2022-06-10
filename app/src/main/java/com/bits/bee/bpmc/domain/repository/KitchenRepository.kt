package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface KitchenRepository {
    fun getKitchenId(id: Int): Flow<Resource<Kitchen>>

    fun getLastKitchen(): Flow<Resource<Kitchen>>

    fun readKitchen(): Flow<Resource<MutableList<Kitchen>>>
}