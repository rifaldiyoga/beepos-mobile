package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.BranchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */
class GetActiveBranchUseCase @Inject constructor(
    private val branchRepository: BranchRepository
){

    operator fun invoke() : Flow<Branch?> {
        return branchRepository.getActiveBranch()
    }
}