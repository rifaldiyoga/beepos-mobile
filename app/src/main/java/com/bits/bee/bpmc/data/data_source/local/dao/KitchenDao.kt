package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import javax.inject.Singleton

@Singleton
@Dao
interface KitchenDao: BaseDao<Kitchen> {
    @Query("SELECT * FROM kitchen WHERE id = :id")
    fun getByKitchenId(id: Int): Kitchen

    @Query("SELECT * FROM kitchen ORDER BY id DESC LIMIT 1")
    fun getLastKitchen(): Kitchen
}