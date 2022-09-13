package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.domain.repository.CstrRepository
import javax.inject.Inject

class UpdateCstrUseCase @Inject constructor(
    private val cstrRepository: CstrRepository
) {
    suspend operator fun invoke(cstr: Cstr){
        cstrRepository.updateCstr(cstr)
    }
}