package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity
import com.bits.bee.bpmc.data.data_source.local.model.RegEntity
import com.bits.bee.bpmc.domain.model.Reg

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface RegDao : BaseDao<RegEntity>{

    @Query("SELECT * FROM reg")
    fun getRegList() : List<RegEntity>

    @Query("SELECT * FROM reg where code = 'POSSES_ACTUAL_ENDCASH'")
    fun getRegPossesActualEndcash(): RegEntity
}