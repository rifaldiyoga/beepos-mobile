package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Created by aldi on 20/05/22.
 */
interface SaleRepository {

    suspend fun addSale(sale : Sale) : Long

    suspend fun deleteSale(sale : Sale)

    suspend fun updateSale(sale : Sale)

    fun getLatestSaleList(query : String, isDraft : Boolean) : Flow<PagingData<Sale>>

    fun getLatestDraftList() : Flow<List<Sale>>

    fun getSaleByPosses(id: Int) : Flow<Resource<List<Sale>>>

    fun getTotalNota(id: Int): Flow<BigDecimal>

    fun getTotalNotaVoid(id: Int): Flow<BigDecimal>

    fun getTotalPaidTunai(id: Int): Flow<BigDecimal>

    fun getTotalPaidDebit(id: Int): Flow<BigDecimal>

    fun getTotalPaidKredit(id: Int): Flow<BigDecimal>

    fun getTotalPaidGopay(id: Int): Flow<BigDecimal>

}