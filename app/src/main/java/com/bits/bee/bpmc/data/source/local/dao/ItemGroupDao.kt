package com.bits.bee.bpmc.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.source.local.base.BaseDao
import com.bits.bee.bpmc.data.source.local.model.ItemGroupEntity

@Dao
interface ItemGroupDao : BaseDao<ItemGroupEntity> {

    @Query("SELECT * FROM itemgrp")
    fun getItemGroupList() : List<ItemGroupEntity>

    @Query("DELETE FROM itemgrp")
    fun deleteAll()

    @Query("SELECT * FROM itemgrp WHERE ispos = 1")
    fun getActiveItemGroupList() : List<ItemGroupEntity>

}