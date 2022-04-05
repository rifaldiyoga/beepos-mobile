package com.bits.bee.bpmc.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.source.local.base.BaseDao
import com.bits.bee.bpmc.data.source.local.model.ItemGroup

@Dao
interface ItemGroupDao : BaseDao<ItemGroup> {

    @Query("SELECT * FROM itemgrp")
    fun getItemGroupList() : List<ItemGroup>

    @Query("DELETE FROM itemgrp")
    fun deleteAll()

}