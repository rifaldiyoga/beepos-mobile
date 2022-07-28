package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.SaleCrcv

/**
 * Created by aldi on 20/07/22.
 */
interface SaleCrcvRepository {

    suspend fun addSaleCrcv(saleCrcv: SaleCrcv)

}