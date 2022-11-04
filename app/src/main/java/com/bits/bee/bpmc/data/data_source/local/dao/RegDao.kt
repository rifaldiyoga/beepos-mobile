package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.RegEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface RegDao : BaseDao<RegEntity>{

    @Query("SELECT * FROM reg")
    fun getRegList() : List<RegEntity>

    @Query("SELECT * FROM reg WHERE code = :code")
    fun getRegByCode(code : String) : RegEntity?

}