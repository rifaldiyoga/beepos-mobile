package com.bits.bee.bpmc.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.source.local.base.BaseDao
import com.bits.bee.bpmc.data.source.local.model.Cashier

/**
 * Created by aldi on 23/03/22.
 */

@Dao
interface CashierDao : BaseDao<Cashier>{

    @Query("SELECT * FROM cashier")
    fun getListCashier() : List<Cashier>


}