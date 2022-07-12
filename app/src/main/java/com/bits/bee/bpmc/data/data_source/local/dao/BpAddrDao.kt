package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import javax.inject.Singleton

/**
 * Created by aldi on 17/03/22.
 */

@Singleton
@Dao
interface BpAddrDao : BaseDao<BpAddrEntity>{

    @Query("SELECT * FROM bpaddr")
    fun getBpAddrList() : List<BpAddrEntity>

    @Query("SELECT * FROM bpaddr where bp_id = :id")
    fun getBpAddrByBp(id: Int): BpAddrEntity
}