package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetDefaultBpUseCase @Inject constructor(
    private val bpRepository: BpRepository,
    private val getActiveBranchUseCase: GetActiveBranchUseCase
) {

    suspend operator fun invoke() : Flow<Bp?> {
        val branch = getActiveBranchUseCase().first()
        return bpRepository.getBpById(branch?.custDeftId ?: 1)
    }

}