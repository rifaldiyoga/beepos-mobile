package com.bits.bee.bpmc.data.data_source.local.dao

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
interface BpDao : BaseDao<BpEntity>{

    @Query("SELECT * FROM bp")
    fun getBpList() : List<BpEntity>

    @Query("SELECT * FROM bp WHERE id = :id")
    fun getBpById(id : Int) : BpEntity?

    @Query("SELECT * FROM bp Where isfavorit = :isFav ")
    fun getFavoritBpList(isFav: Boolean) : List<BpEntity>

}