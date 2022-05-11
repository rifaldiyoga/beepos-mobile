package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity

/**
 * Created by aldi on 30/03/22.
 */
@Dao
interface ChannelDao : BaseDao<ChannelEntity>{

    @Query("SELECT * FROM channel")
    fun getChannelList() : List<ChannelEntity>

    @Query("DELETE FROM channel")
    fun deleteAll()

    @Query("SELECT * FROM channel WHERE ispos = 1 AND active = 1")
    fun getActiveChannelList() : List<ChannelEntity>

}