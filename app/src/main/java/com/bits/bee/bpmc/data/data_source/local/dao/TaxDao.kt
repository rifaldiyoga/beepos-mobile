package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.TaxEntity

@Dao
interface TaxDao : BaseDao<TaxEntity> {

    @Query("SELECT * FROM tax")
    fun getTaxList() : List<TaxEntity>

    @Query("DELETE FROM tax")
    fun deleteAll()

}