package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import javax.inject.Singleton

@Singleton
@Dao
interface CashADao: BaseDao<CashAEntity> {

}