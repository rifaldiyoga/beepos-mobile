package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity
import com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface UnitDummyDao : BaseDao<UnitDummyEntity>{

    @Query("SELECT * FROM unit_dummy where item_id = :id")
    fun getUnitByItemId(id: Int) : List<UnitDummyEntity>

    @Query("DELETE FROM unit_dummy where item_id = :id")
    suspend fun deleteByItem(id: Int)
}