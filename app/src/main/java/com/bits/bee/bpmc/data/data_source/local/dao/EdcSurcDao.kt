package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity
import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcWithCcTypeEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface EdcSurcDao : BaseDao<EdcSurcEntity>{

    @Query("SELECT  * FROM edcsurc")
    fun getEdcSurcList() : List<EdcSurcEntity>

    @Query("SELECT * FROM edcsurc WHERE edc_id = :edcId AND edcsurctype = :type")
    fun getActiveEdcSurc(edcId : Int, type : String) : List<EdcSurcWithCcTypeEntity>


}