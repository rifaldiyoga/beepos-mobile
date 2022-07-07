package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity

/**
 * Created by aldi on 30/03/22.
 */
@Dao
interface PmtdDao : BaseDao<PmtdEntity>{

    @Query("SELECT * FROM pmtd")
    fun getPmtdList() : List<PmtdEntity>

    @Query("DELETE FROM pmtd")
    fun deleteAll()
}