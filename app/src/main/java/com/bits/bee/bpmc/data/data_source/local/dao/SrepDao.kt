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

    @Query("SELECT * FROM srep WHERE name LIKE '%' || :query || '%'")
    fun getSrepList(query : String) : List<SrepEntity>

    @Query("SELECT * FROM srep WHERE id = :srepId")
    fun getSrepById(srepId : Int) : SrepEntity?

    @Query("UPDATE srep SET isselected = 0 WHERE isselected = 1")
    suspend fun resetSelected()

}