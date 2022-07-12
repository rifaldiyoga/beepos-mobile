package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMemberUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {
    operator fun invoke(search: String): Flow<Resource<List<Bp>>>{
        return bpRepository.searchBp(search)
    }
}