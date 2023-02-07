package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity
import com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface GrpPrvDao : BaseDao<GrpPrvEntity>{

    @Query("SELECT * FROM grpprv")
    fun getGrpPrvList() : List<GrpPrvEntity>

    @Query("DELETE FROM grpprv")
    fun deleteAll()

    @Query("SELECT * FROM grpprv WHERE grp_id = :id")
    fun getGrpPrvByGrpId(id : Int) : List<GrpPrvEntity>

}