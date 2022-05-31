package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.domain.repository.KitchenRepository
import javax.inject.Inject

class KitchenRepositoryImpl @Inject constructor(
    private val kitchenDao: KitchenDao
): KitchenRepository {
    override fun getKitchenId(id: Int): Kitchen {
        return kitchenDao.getByKitchenId(id)
    }

    override fun getLastKitchen(): Kitchen {
        return kitchenDao.getLastKitchen()
    }
}