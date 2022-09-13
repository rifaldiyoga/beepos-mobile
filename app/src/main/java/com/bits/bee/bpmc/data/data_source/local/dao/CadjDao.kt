package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CadjDao: BaseDao<CadjEntity> {

    @Query("SELECT * from cadj where isuploaded = 0")
    fun getCadjByReftypeInOutHaventUpload(): List<CadjEntity>
}