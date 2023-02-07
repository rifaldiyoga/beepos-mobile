package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BpAccEntity
import javax.inject.Singleton

/**
 * Created by aldi on 17/03/22.
 */

@Singleton
@Dao
interface BpAccDao : BaseDao<BpAccEntity>{

    @Query("SELECT * FROM bpacc")
    fun getBpAccList() : List<BpAccEntity>

    @Query("SELECT * FROM bpacc where bp_id = :id AND isdefault = 1")
    fun getDefaultBpAccByBp(id: Int): List<BpAccEntity>
}