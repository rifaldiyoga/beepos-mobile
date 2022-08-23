package com.bits.bee.bpmc.domain.usecase.riwayat_sesi

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilterSortingUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    operator fun invoke(desc: Boolean, current: Long, end: Long): Flow<Resource<List<Posses>>>{
        if (desc){
            return possesRepository.getFilterDesc(current, end)
        }else{
            return possesRepository.getFilterAsc(current, end)
        }
    }
}