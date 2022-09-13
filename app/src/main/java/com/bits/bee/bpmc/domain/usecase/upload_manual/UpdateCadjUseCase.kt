package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import javax.inject.Inject

class UpdateCadjUseCase @Inject constructor(
    private val cadjRepository: CadjRepository
) {
    suspend operator fun invoke(cadj: Cadj){
        cadjRepository.updateCadj(cadj)
    }
}