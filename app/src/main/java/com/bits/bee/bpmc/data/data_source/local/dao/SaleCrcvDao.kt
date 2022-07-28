package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface SaleCrcvDao : BaseDao<SaleCrcvEntity>{

    @Query("SELECT * FROM salecrcvs")
    fun getSaleCrcvList() : List<SaleCrcvEntity>

}