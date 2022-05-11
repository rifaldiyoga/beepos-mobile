package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.Pmtd

/**
 * Created by aldi on 30/03/22.
 */
@Dao
interface PmtdDao : BaseDao<Pmtd>{

    @Query("SELECT * FROM pmtd")
    fun getPmtdList() : List<Pmtd>

    @Query("DELETE FROM pmtd")
    fun deleteAll()
}