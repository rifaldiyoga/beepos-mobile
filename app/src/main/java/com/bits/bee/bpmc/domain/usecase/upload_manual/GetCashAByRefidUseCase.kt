package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCashAByRefidUseCase @Inject constructor(
    private val cashARepository: CashARepository
) {
    operator fun invoke(refId: Long, refType: String): Flow<Resource<List<CashA>>>{
        return cashARepository.getCashAByRefId(refId, refType)
    }
}