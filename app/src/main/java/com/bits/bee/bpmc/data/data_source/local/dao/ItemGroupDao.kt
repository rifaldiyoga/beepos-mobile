package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.domain.model.ItemGroup

@Dao
interface ItemGroupDao : BaseDao<ItemGroupEntity> {

    @Query("SELECT * FROM itemgrp")
    fun getItemGroupList() : List<ItemGroupEntity>

    @Query("DELETE FROM itemgrp")
    fun deleteAll()

    @Query("SELECT * FROM itemgrp WHERE ispos = 1 ORDER BY COALESCE(up_id, id)")
    fun getActiveItemGroupList() : List<ItemGroupEntity>

    @Query("SELECT * FROM itemgrp WHERE code != 'ADDON' AND ispos = :ispos ")
    fun getItgrpNotAddon(ispos: Boolean): List<ItemGroupEntity>

    @Query("SELECT * FROM itemgrp WHERE id = :id")
    fun getId(id: Int): ItemGroupEntity

    @Query("SELECT * FROM itemgrp WHERE code = 'ADDON'")
    fun getItgrpAddOn() : ItemGroupEntity?

    @Query("SELECT * FROM itemgrp where up_id = :upid")
    fun getItemgrpByUpId(upid: Int?): List<ItemGroupEntity>


    @Query("SELECT * FROM itemgrp where up_id is null")
    fun getItemgrpParent(): List<ItemGroupEntity>

    @Query("SELECT * FROM itemgrp where name = :kategori")
    fun getItgrpByKategori(kategori: String): ItemGroupEntity

    @Query("delete from itemgrp where up_id = :id")
    fun deleteChildKategori(id: Int)

    @Query("select * from itemgrp order by id desc limit 1")
    fun getLastItemgrp(): ItemGroupEntity?

}