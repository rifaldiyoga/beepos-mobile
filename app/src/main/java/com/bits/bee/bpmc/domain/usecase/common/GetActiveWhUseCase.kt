package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Wh
import com.bits.bee.bpmc.domain.repository.WhRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 04/08/22.
 */
class GetActiveWhUseCase @Inject constructor(
    private val whRepository: WhRepository,
    private val getActiveCashierUseCase: GetActiveCashierUseCase
){

    suspend operator fun invoke() : Flow<Wh?> {
        val cashier = getActiveCashierUseCase().first()
        return whRepository.getActiveWh(cashier?.whId?.toInt() ?: throw Exception("No Cashier Active"))
    }

}