package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleCrcv
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Created by aldi on 20/07/22.
 */
interface SaleCrcvRepository {

    suspend fun addSaleCrcv(saleCrcv: SaleCrcv)

    fun getSalecrcvBySale(id: Int): Flow<List<SaleCrcv>>

    fun getSalecrcvByPosses(possesId : Int, rcvType : String) : Flow<List<SaleCrcv>>

    fun getTotalSurchargeByPossesNonCashAll(possesId : Int, termType : String) : Flow<BigDecimal>

    fun getTotalSurchargeByPossesNonCash(possesId : Int, termType : String) : Flow<BigDecimal>

    fun getTotalSurchargeByPossesVoid(possesId : Int) : Flow<BigDecimal>

    fun getTotalSurchargeByPosses(possesId : Int) : Flow<BigDecimal>

    fun getSurcamt(possesId : Int) : Flow<BigDecimal>



}