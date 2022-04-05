package com.bits.bee.bpmc.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.source.local.base.BaseDao
import com.bits.bee.bpmc.data.source.local.model.Channel
import com.bits.bee.bpmc.data.source.local.model.City

/**
 * Created by aldi on 30/03/22.
 */
@Dao
interface ChannelDao : BaseDao<Channel>{

    @Query("SELECT * FROM channel")
    fun getChannelList() : List<Channel>

    @Query("DELETE FROM channel")
    fun deleteAll()
}