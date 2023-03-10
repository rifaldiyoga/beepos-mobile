package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity
import com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface AddOnDDao : BaseDao<AddOnDEntity>{

    @Query("SELECT * FROM addond")
    fun getAddOnDList() : List<AddOnDEntity>

    @Query("select a.* from addond a join itemaddon b on b.addon = a.addon_id where b.item_id = :itemId")
    fun getAddOnDBySelectionList(itemId : Int) : List<AddOnDEntity>

}