package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.UsrGrpEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface UsrGrpDao : BaseDao<UsrGrpEntity>{

    @Query("SELECT * FROM usrgrp")
    fun getUsrGrpList() : List<UsrGrpEntity>

    @Query("DELETE FROM usrgrp")
    fun deleteAll()

    @Query("SELECT * FROM usrgrp WHERE usr_id = :id")
    fun getByUsrId(id : Int) : UsrGrpEntity?

}