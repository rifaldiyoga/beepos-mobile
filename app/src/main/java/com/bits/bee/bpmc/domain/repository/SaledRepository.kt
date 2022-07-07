package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Saled
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/05/22.
 */
interface SaledRepository {

    suspend fun addSaled(saledList : List<Saled>)

    fun getSaledList(saleId : Int) : Flow<List<Saled>>

}