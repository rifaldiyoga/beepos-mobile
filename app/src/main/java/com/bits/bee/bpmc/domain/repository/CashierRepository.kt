package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.Cashier
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface CashierRepository {

    fun getCashierList() : Flow<Resource<List<Cashier>>>

}