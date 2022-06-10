package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface CashierRepository {

    fun getCashierList(branchId : Int) : Flow<Resource<List<Cashier>>>

    suspend fun updateActiveCashier(cashier : Cashier)

    fun getActiveCashier() : Flow<Cashier?>
}