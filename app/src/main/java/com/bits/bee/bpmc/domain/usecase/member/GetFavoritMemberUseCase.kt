package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpAddrRepository
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
class GetFavoritMemberUseCase @Inject constructor(
    private val bpRepository: BpRepository,
    private val bpAddrRepository: BpAddrRepository,
    private val defDispatcher: CoroutineDispatcher
) {

    operator fun invoke() : Flow<List<Bp>> {
        return flow {
            val bpList = bpRepository.getFavoritBpList().first()
            bpList.map {
                it.bpAddr = bpAddrRepository.getBpAddrByBp(it.id!!).first()
            }
            emit(bpList)
        }.flowOn(defDispatcher)
    }

}