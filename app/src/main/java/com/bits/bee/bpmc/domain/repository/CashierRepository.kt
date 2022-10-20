package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.model.CashierPost
import com.bits.bee.bpmc.data.data_source.remote.response.CashierReturn
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface CashierRepository {

    fun getCashierList(branchId : Int) : Flow<Resource<List<Cashier>>>

    suspend fun updateActiveCashier(cashier : Cashier)

    fun postActivateCashier(cashierPost: CashierPost) : Flow<Resource<CashierStatusResponse>>

    fun detachActivateCashier(cashierPost: CashierPost) : Flow<Resource<CashierStatusResponse>>

    fun getActiveCashier() : Flow<Cashier?>

    fun getCashierById(id: Int): Flow<Cashier?>

    fun detachCashier(cashierPost: CashierPost): Flow<Resource<CashierStatusResponse>>


}