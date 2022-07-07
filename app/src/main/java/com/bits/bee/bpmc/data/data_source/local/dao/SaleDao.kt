package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface SaleDao : BaseDao<SaleEntity> {

    @Query("SELECT * FROM sale WHERE draft = 0 ORDER BY id DESC")
    fun getLatestSaleList() : List<SaleEntity>

    @Query("SELECT * FROM sale WHERE draft = 1 ORDER BY id DESC")
    fun getLatestDraftList() : List<SaleEntity>

}