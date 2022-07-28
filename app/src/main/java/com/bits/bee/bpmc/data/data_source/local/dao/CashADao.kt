package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import javax.inject.Singleton

@Singleton
@Dao
interface CashADao: BaseDao<CashAEntity> {

    @Query("SELECT * FROM casha WHERE refid = :refId AND reftype = :refType")
    fun getCashAByRef(refId : Long, refType : String) : CashAEntity?

    @Insert
    suspend fun insert(en : CashAEntity)

}