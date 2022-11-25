package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Kitchen
import kotlinx.coroutines.flow.Flow

interface KitchenRepository {
    fun getKitchenId(id: Int): Flow<Kitchen>

    fun getLastKitchen(): Flow<Kitchen>

    fun readKitchen(): Flow<MutableList<Kitchen>>
}