package com.bits.bee.bpmc.domain.usecase.riwayat_sesi

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.CashierRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCashierByIdUseCase @Inject constructor(
    private val cashierRepository: CashierRepository
) {
    operator fun invoke(id: Int): Flow<Resource<Cashier>>{
        return cashierRepository.getCashierById(id)
    }
}