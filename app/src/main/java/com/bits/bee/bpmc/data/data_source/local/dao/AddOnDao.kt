package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface AddOnDao : BaseDao<AddOnEntity>{

    @Query("SELECT * FROM addon")
    fun getAddOnList() : List<AddOnEntity>

}