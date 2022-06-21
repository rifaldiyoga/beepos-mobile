package com.bits.bee.bpmc.domain.usecase.tutup_kasir

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */

class TutupKasirUseCase @Inject constructor (
    private val possesRepository: PossesRepository
) {

    suspend operator fun invoke(posses: Posses) {
        posses.endBal = posses.startBal.add(posses.totIn).subtract(posses.totOut)
        posses.endTime = Date()
        possesRepository.updatePosses(posses)
    }

}