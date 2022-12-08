package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.BigInteger
import javax.inject.Inject

/**
 * Created by aldi on 20/07/22.
 */
class UpdateTotalPossesUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
    private val cashRepository: CashRepository
){

    suspend operator fun invoke(amt : BigDecimal) {
        val posses = possesRepository.getActivePosses().first()
        posses?.let {
            if(amt >= BigDecimal.ZERO){
                posses.totIn = posses.totIn?.add(amt) ?: BigDecimal(BigInteger.ZERO).add(amt)
            } else {
                posses.totOut = posses.totOut?.subtract(amt) ?: BigDecimal(BigInteger.ZERO).subtract(amt)
            }
            posses.total = posses.total.add(amt)

            possesRepository.updatePosses(posses)

            val cash = cashRepository.getLastId().first()
            cash!!.balance = posses.total

            cashRepository.updateCash(cash)

        } ?: throw Exception("")
    }

}