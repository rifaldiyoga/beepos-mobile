package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface SaleDao : BaseDao<SaleEntity> {

    @Query("SELECT * FROM sale WHERE draft = :isDraft AND (trx_no LIKE '%' || :query || '%' OR bp_name LIKE '%' || :query || '%') ORDER BY id DESC")
    fun getLatestSaleList(query : String, isDraft : Boolean) : PagingSource<Int, SaleEntity>

    @Query("SELECT * FROM sale WHERE draft = 1 ORDER BY id DESC LIMIT 5")
    fun getLatestDraftList() : List<SaleEntity>

}