package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCounterShiftUseCase @Inject constructor(
    private val cashARepository: CashARepository
) {
    operator fun invoke(): Flow<List<CashA>>{
       return cashARepository.getLastCasha()
    }
}