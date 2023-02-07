package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemBranchEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface ItemBranchDao : BaseDao<ItemBranchEntity>{

    @Query("SELECT * FROM item_branch")
    fun getItemBranchList() : List<ItemBranchEntity>

}