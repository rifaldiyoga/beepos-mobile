package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadKasMasukSortUseCase @Inject constructor(
    private val cadjRepository: CadjRepository
) {
    operator fun invoke(desc: Boolean, query: String): Flow<List<Cadj>>{
        if (desc){
            return cadjRepository.getKasMasukDesc(query)
        }else{
            return cadjRepository.getKasMasukAsc(query)
        }
    }
}