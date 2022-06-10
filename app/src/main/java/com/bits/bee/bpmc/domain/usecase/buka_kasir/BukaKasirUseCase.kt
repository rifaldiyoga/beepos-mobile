package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.domain.repository.PossesRepository
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class BukaKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository
){

    suspend operator fun invoke(modal : BigDecimal, shift : Int) {
        possesRepository.createPosses(modal, )
    }

}