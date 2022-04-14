package com.bits.bee.bpmc.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.source.local.base.BaseDao
import com.bits.bee.bpmc.data.source.local.model.Bp
import com.bits.bee.bpmc.data.source.local.model.BpAddr
import com.bits.bee.bpmc.data.source.local.model.BranchEntitiy
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

/**
 * Created by aldi on 17/03/22.
 */

@Singleton
@Dao
interface BpAddrDao : BaseDao<BpAddr>{

    @Query("SELECT * FROM bpaddr")
    fun getBpAddrList() : List<BpAddr>

}