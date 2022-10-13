package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadKasKeluarSortUseCase @Inject constructor(
    private val cadjRepository: CadjRepository
) {
    operator fun invoke(desc: Boolean, query: String): Flow<List<Cadj>>{
        if (desc){
            return cadjRepository.getKasKeluarDesc(query)
        }else{
            return cadjRepository.getKasKeluarAsc(query)
        }
    }
}