package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SrepEntity

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface SrepDao : BaseDao<SrepEntity> {

    @Query("SELECT * FROM srep")
    fun getSrepList() : List<SrepEntity>

    @Query("SELECT * FROM srep WHERE id = :srepId")
    fun getSrepById(srepId : Int) : SrepEntity?

}