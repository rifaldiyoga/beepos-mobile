package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.UnitEntity

@Dao
interface UnitDao : BaseDao<UnitEntity> {

    @Query("SELECT * FROM unit")
    fun getUnitList() : List<UnitEntity>

    @Query("DELETE FROM unit")
    fun deleteAll()

    @Query("SELECT * FROM unit WHERE item_id = :itemId")
    fun getUnitByItem(itemId : Int) : List<UnitEntity>

}