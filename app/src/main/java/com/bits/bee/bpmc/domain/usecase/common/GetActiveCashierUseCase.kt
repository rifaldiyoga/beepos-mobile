package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.BranchRepository
import com.bits.bee.bpmc.domain.repository.CashierRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */
class GetActiveCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository
){

    operator fun invoke() : Flow<Cashier?> {
        return cashierRepository.getActiveCashier()
    }

}