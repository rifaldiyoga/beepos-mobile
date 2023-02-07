package com.bits.bee.bpmc.domain.usecase.riwayat_sesi

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilterSesiUseCase @Inject constructor(
   private val possesRepository: PossesRepository
) {
    operator fun invoke(current: Long, yester: Long): Flow<Resource<List<Posses>>>{
        return possesRepository.getFilter(current, yester)
    }

}