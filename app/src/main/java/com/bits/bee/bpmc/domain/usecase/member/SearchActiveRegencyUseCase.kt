package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.domain.repository.RegencyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchActiveRegencyUseCase @Inject constructor(
    private val regencyRepository: RegencyRepository
) {
    operator fun invoke(q : String) : Flow<List<Regency>> {
        return regencyRepository.searchRegencyList(q)
    }
}