package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity
import com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface SelectionDao : BaseDao<SelectionEntity>{

    @Query("SELECT * FROM selection")
    fun getSelectionList() : List<SelectionEntity>

    @Query("SELECT DISTINCT(a.id), a.code, a.name, a.note, a.isactive, a.ismultiselect, a.ismultiqty FROM selection a" +
            " JOIN addond b on b.selection_id = a.id JOIN itemaddon c ON c.addon = b.addon_id WHERE c.item_id = :itemId")
    fun getSelectionByItemid(itemId : Int) : List<SelectionEntity>

}