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

}