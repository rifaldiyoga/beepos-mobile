package com.bits.bee.bpmc.domain.usecase.tutup_kasir

import com.bits.bee.bpmc.domain.repository.PossesRepository
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */
class TutupKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {

    suspend operator fun invoke() {
//        possesRepository.addPosses()
    }
}