package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.Posses
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Created by aldi on 07/06/22.
 */
interface PossesRepository {

    fun getActivePosses() : Flow<Posses?>

    suspend fun addPosses(startBal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier)

}