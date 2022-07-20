package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.BigInteger
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class AddTotalPossesUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
){

    suspend operator fun invoke(amt : BigDecimal) {
        val posses = possesRepository.getActivePosses().first()
        posses?.let {
            if(amt >= BigDecimal.ZERO){
                posses.totIn = posses.totIn!!.add(amt)
            } else {
                posses.totOut = posses.totOut?.subtract(amt) ?: BigDecimal(BigInteger.ZERO).subtract(amt)
            }

            possesRepository.updatePosses(posses)
        } ?: throw Exception("")
    }
}