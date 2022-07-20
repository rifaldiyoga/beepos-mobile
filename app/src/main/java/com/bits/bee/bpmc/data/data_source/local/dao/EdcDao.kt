package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.EdcEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface EdcDao : BaseDao<EdcEntity>{

    @Query("SELECT * FROM edc")
    fun getEdcList() : List<EdcEntity>

    @Query("SELECT * FROM edc WHERE active = 1 AND (branch_id = :branchId OR branch_id IS NULL)")
    fun getActiveEdc(branchId : Int) : List<EdcEntity>

}