package com.bits.bee.bpmc.domain.usecase.riwayat_sesi

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSortingUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    operator fun invoke(desc: Boolean): Flow<PagingData<Posses>>{
        if (desc){
            return possesRepository.getSortDesc()
        }else{
            return possesRepository.getSortAsc()
        }
    }
}