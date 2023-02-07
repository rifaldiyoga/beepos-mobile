package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import javax.inject.Singleton

@Singleton
@Dao
interface CashADao: BaseDao<CashAEntity> {

    @Query("SELECT * FROM casha WHERE refid = :refId AND reftype = :refType")
    fun getCashAByRef(refId : Long, refType : String) : CashAEntity?

    @Query("SELECT * FROM casha where reftype = 'POSSES' ORDER BY id DESC LIMIT 1")
    fun getLastCasha(): List<CashAEntity>

    @Query("SELECT * FROM casha WHERE cash_id = :cashId AND is_void = 0")
    fun getCashAByCashId(cashId : Int) : List<CashAEntity>

    @Query("SELECT * FROM casha WHERE refid = :refId AND reftype = :refType")
    fun getCashAByRefId(refId : Int, refType : String): CashAEntity?



}