package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.model.Posses

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface PossesDao : BaseDao<PossesEntity> {

    @Query("SELECT * FROM posses WHERE endbal is null")
    fun getActivePosses() : PossesEntity?

}