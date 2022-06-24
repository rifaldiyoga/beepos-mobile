package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 20/05/22.
 */
interface SaledRepository {

    suspend fun addSaled(saledList : List<Saled>)

}