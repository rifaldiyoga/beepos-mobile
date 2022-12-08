package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpAccRepository
import com.bits.bee.bpmc.domain.repository.BpAddrRepository
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetBpByIdUseCase @Inject constructor(
    private val bpRepository: BpRepository,
    private val bpAddrRepository: BpAddrRepository,
    private val bpAccRepository: BpAccRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int): Flow<Bp?> {
        return flow {
            val bp = bpRepository.getBpById(id).first()
            bp?.let {
                bp.bpAccList = bpAccRepository.getDefaultBpAccByBp(bp.id!!).first()
                bp.bpAddr = bpAddrRepository.getBpAddrByBp(bp.id!!).first()
            }
            emit(bp)
        }.flowOn(coroutineDispatcher)
    }
}