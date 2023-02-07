package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpAccRepository
import com.bits.bee.bpmc.domain.repository.BpAddrRepository
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetDefaultBpUseCase @Inject constructor(
    private val bpRepository: BpRepository,
    private val bpAddrRepository: BpAddrRepository,
    private val bpAccRepository: BpAccRepository,
    private val dispatcher: CoroutineDispatcher,
    private val getActiveBranchUseCase: GetActiveBranchUseCase
) {

    suspend operator fun invoke() : Flow<Bp?> = flow {
        val branch = getActiveBranchUseCase().first()
        val bp = bpRepository.getBpById(branch?.custDeftId ?: 1).first()
        bp?.let {
            bp.bpAccList = bpAccRepository.getDefaultBpAccByBp(bp.id!!).first()
            bp.bpAddr = bpAddrRepository.getBpAddrByBp(bp.id!!).first()
        }
        emit(bp)
    }.flowOn(dispatcher)

}