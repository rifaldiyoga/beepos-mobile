package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Sale
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/05/22.
 */
interface SaleRepository {

    suspend fun addSale(sale : Sale) : Long

    fun getLatestSaleList() : Flow<List<Sale>>

    fun getLatestDraftList() : Flow<List<Sale>>

}