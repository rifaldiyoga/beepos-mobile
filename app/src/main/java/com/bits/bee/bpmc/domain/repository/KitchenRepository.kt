package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.Kitchen

interface KitchenRepository {
    fun getKitchenId(id: Int): Kitchen

    fun getLastKitchen(): Kitchen
}