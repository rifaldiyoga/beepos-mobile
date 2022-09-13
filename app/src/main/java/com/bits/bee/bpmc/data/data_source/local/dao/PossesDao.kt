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
    fun getActivePossesList(): List<PossesEntity>

    @Query("SELECT * FROM posses WHERE shift LIKE '%'|| :query || '%'")
    fun searchSesi(query : String) : PagingSource<Int, PossesEntity>

    @Query("SELECT * FROM posses WHERE trxdate BETWEEN :current AND :end")
    fun getFilter(current: Long, end: Long): List<PossesEntity>

    @Query("SELECT * FROM posses WHERE endbal is not null and trxdate between :startDate and :endDate")
    fun getJmlPossesByDate(startDate: Long, endDate: Long): List<PossesEntity>

    @Query("SELECT * FROM posses WHERE endbal is not null")
    fun getListPossesHistory(): List<PossesEntity>

    @Query("SELECT * FROM posses WHERE endbal is not null and trxdate BETWEEN :current AND :end ORDER BY id asc")
    fun getFilterAsc(current: Long, end: Long): List<PossesEntity>

    @Query("SELECT * FROM posses WHERE endbal is not null and trxdate BETWEEN :current AND :end ORDER BY id desc")
    fun getFilterDesc(current: Long, end: Long): List<PossesEntity>

    @Query("SELECT posses.id, posses.user_id, posses.cashier_id, posses.shift, posses.startbal, posses.starttime, posses.endbal, posses.endtime, posses.credit, " +
            "posses.total, posses.trxdate, posses.trxno, posses.totin, posses.totout, posses.endcash, posses.totactualcash, posses.totdiffcash, posses.isuploaded FROM posses where isuploaded = 0")
    fun getPossesHaventUpload(): List<PossesEntity>
}