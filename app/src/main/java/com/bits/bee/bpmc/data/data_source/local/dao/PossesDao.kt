package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.model.Posses

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface PossesDao : BaseDao<PossesEntity> {

    @Query("SELECT * FROM posses WHERE endbal is null")
    fun getActivePosses() : PossesEntity?

    @Query("SELECT * FROM posses WHERE endbal is null")
    fun getListPosses(): PagingSource<Int, PossesEntity>

    @Query("SELECT * FROM posses WHERE id = :id")
    fun getPossesById(id: Int): PossesEntity

    @Query("SELECT * FROM posses WHERE endbal is not null")
    fun getPossesHistory(): PagingSource<Int, PossesEntity>

    @Query("SELECT * FROM posses WHERE endbal is null")
    fun getNotActivePosses(): List<PossesEntity>

    @Query("SELECT * FROM posses WHERE shift LIKE '%'|| :query || '%'")
    fun searchSesi(query : String) : PagingSource<Int, PossesEntity>

    @Query("SELECT * FROM posses ORDER BY id DESC")
    fun getSortDesc(): PagingSource<Int, PossesEntity>

    @Query("SELECT * FROM posses ORDER BY id ASC")
    fun getSortAsc(): PagingSource<Int, PossesEntity>

    @Query("SELECT * FROM posses WHERE trxdate BETWEEN :current AND :yester")
    fun getFilter(current: Long, yester: Long): PagingSource<Int, PossesEntity>
}