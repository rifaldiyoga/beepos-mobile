package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.PossesRepository
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class BukaKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
){

    suspend operator fun invoke(modal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {
        possesRepository.addPosses(modal, shift, branch, cashier)

        val possesActive = possesRepository.getActivePosses()

    }

}