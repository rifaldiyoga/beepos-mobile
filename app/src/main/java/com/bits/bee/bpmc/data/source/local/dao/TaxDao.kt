package com.bits.bee.bpmc.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.source.local.base.BaseDao
import com.bits.bee.bpmc.data.source.local.model.Tax

@Dao
interface TaxDao : BaseDao<Tax> {

    @Query("SELECT * FROM tax")
    fun getTaxList() : List<Tax>

    @Query("DELETE FROM tax")
    fun deleteAll()

}