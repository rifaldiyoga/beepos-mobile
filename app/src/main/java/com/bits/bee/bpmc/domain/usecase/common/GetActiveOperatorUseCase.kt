package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Operator
import com.bits.bee.bpmc.domain.repository.OperatorRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
class GetActiveOperatorUseCase @Inject constructor(
    private val operatorRepository: OperatorRepository
) {

    operator fun invoke() : Flow<Operator?> {
        return operatorRepository.getActiveOperator()
    }
}