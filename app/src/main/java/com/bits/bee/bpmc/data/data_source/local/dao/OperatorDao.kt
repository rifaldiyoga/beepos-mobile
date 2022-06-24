package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.OperatorEntity

/**
 * Created by aldi on 22/06/22.
 */

@Dao
interface OperatorDao : BaseDao<OperatorEntity>{

    @Query("SELECT * FROM operator")
    fun getOperatorList() : List<OperatorEntity>

    @Query("SELECT * FROM operator WHERE active = 1")
    fun getActiveOperator() : OperatorEntity

    @Query("DELETE FROM operator")
    fun deleteAll()

}