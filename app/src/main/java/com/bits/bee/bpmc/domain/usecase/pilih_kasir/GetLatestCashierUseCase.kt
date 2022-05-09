package com.bits.bee.bpmc.domain.usecase.pilih_kasir

import com.bits.bee.bpmc.data.repository.CashierRepository
import com.bits.bee.bpmc.data.source.local.model.Cashier
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 23/03/22.
 */

class GetLatestCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository
) {

    operator fun invoke(): Flow<Resource<List<Cashier>>> {
        return cashierRepository.getCashierList()
    }

}