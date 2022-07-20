package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity
import javax.inject.Singleton

@Singleton
@Dao
interface CashDao: BaseDao<CashEntity> {
    @Query("SELECT * FROM cash ORDER BY id DESC LIMIT 1")
    fun getLastId(): CashEntity
}