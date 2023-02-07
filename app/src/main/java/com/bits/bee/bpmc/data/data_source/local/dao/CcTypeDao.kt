package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CcTypeEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface CcTypeDao : BaseDao<CcTypeEntity>{

    @Query("SELECT * FROM cc_type")
    fun getCcTypeList() : List<CcTypeEntity>

}