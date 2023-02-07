package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.StockEntity
import com.bits.bee.bpmc.data.data_source.local.model.WhEntity

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface WhDao : BaseDao<WhEntity> {

    @Query("SELECT * FROM wh")
    fun getWhList() : List<WhEntity>

    @Query("SELECT * FROM wh WHERE id = :whId")
    fun getWhById(whId : Int) : WhEntity?

}