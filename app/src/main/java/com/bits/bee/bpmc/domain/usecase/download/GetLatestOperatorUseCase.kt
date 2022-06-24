package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Operator
import com.bits.bee.bpmc.domain.repository.OperatorRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
class GetLatestOperatorUseCase @Inject constructor(
    private val operatorRepository: OperatorRepository
){

    suspend operator fun invoke() : Flow<Resource<List<Operator>>> {
        return operatorRepository.getOperator()
    }

}