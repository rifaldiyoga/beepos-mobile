package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.domain.model.Edc
import com.bits.bee.bpmc.domain.repository.EdcRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 18/07/22.
 */
class GetActiveEdc @Inject constructor(
    private val edcRepository: EdcRepository,
    private val getActiveBranchUseCase: GetActiveBranchUseCase
){

    suspend operator fun invoke() : Flow<List<Edc>> {
        val branch = getActiveBranchUseCase().first()
        return edcRepository.getActiveEdcList(branch!!.id)
    }
}