package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadKasMasukUseCase @Inject constructor(
    private val cadjRepository: CadjRepository
) {
    operator fun invoke(): Flow<List<Cadj>>{
        return cadjRepository.getKasMasuk()
    }
}