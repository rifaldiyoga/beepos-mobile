package com.bits.bee.bpmc.domain.usecase.member

import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpAddrRepository
import com.bits.bee.bpmc.domain.repository.BpRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
class GetActiveMemberUseCase @Inject constructor(
    private val bpRepository: BpRepository,
    private val bpAddrRepository: BpAddrRepository,
) {

    operator fun invoke(query : String, isFavorit : Boolean) : Flow<PagingData<Bp>> =
        bpRepository.getActiveBpPagedList(query, isFavorit)
            .map { data ->
                data.map {
                    it.bpAddr = bpAddrRepository.getBpAddrByBp(it.id!!).first()
                    it
                }
            }

}