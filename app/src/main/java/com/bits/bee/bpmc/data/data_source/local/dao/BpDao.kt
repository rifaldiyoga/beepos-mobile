package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import javax.inject.Singleton

/**
 * Created by aldi on 17/03/22.
 */

@Singleton
@Dao
interface BpDao : BaseDao<BpEntity> {

    @Query("SELECT * FROM bp")
    fun getBpList() : List<BpEntity>

    @Query("SELECT * FROM bp WHERE id = :id")
    fun getBpById(id : Int) : BpEntity?

    @Query("SELECT * FROM bp Where (name LIKE '%'|| :query || '%' OR code LIKE '%'|| :query || '%') AND active = 1 ORDER BY isselected DESC")
    fun getBpPagedList(query: String) : PagingSource<Int, BpEntity>

    @Query("SELECT * FROM bp Where (name LIKE '%'|| :query || '%' OR code LIKE '%'|| :query || '%') AND isfavorit = :isFav AND active = 1 ORDER BY isfavorit DESC")
    fun getFavoritBpPagedList(query: String, isFav: Boolean) : PagingSource<Int, BpEntity>

    @Query("SELECT * FROM bp ORDER BY id DESC LIMIT 1")
    fun getLastId(): BpEntity

    @Query("SELECT * FROM bp WHERE name LIKE '%'|| :query || '%'")
    fun searchBp(query : String) : List<BpEntity>

    @Query("SELECT * FROM bp WHERE created_at BETWEEN :startDate AND :endDate")
    fun getBpByDate(startDate: Long, endDate: Long): List<BpEntity>

    @Query("SELECT * FROM bp where active = 0")
    fun getBpHaventUploaded(): List<BpEntity>

    @Query("SELECT * FROM bp WHERE code LIKE '%'|| :code || '%'")
    fun getBpByCode(code: String): BpEntity?

    @Query("UPDATE bp SET isselected = 0 WHERE isselected = 1")
    suspend fun resetSelected()


}