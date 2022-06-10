package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity
import com.bits.bee.bpmc.domain.model.Cashier

/**
 * Created by aldi on 23/03/22.
 */

@Dao
interface CashierDao : BaseDao<CashierEntity>{

    @Query("SELECT * FROM cashier")
    fun getListCashier() : List<CashierEntity>

    @Query("UPDATE cashier SET active = 0")
    fun resetActive()

    @Query("SELECT * FROM cashier WHERE active = 1 LIMIT 1")
    fun getActiveCashier() : CashierEntity?
}