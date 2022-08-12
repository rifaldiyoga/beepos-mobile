package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Sale
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 20/05/22.
 */
interface SaleRepository {

    suspend fun addSale(sale : Sale) : Long

    suspend fun deleteSale(sale : Sale)

    suspend fun updateSale(sale : Sale)

    fun getLatestSaleList(query : String, isDraft : Boolean) : Flow<PagingData<Sale>>

    fun getLatestDraftList() : Flow<List<Sale>>

}