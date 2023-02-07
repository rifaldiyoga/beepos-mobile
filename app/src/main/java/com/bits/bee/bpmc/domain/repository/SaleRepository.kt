package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.data.data_source.remote.model.LineChartData
import com.bits.bee.bpmc.domain.model.Channel
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

    fun getLatestSaleList(query : String, isDraft : Boolean, channelList : List<Int>, startDate : Long, endDate : Long) : Flow<PagingData<Sale>>

    fun getLatestDraftList() : Flow<List<Sale>>

    fun getSaleByPosses(id: Int) : Flow<List<Sale>>

    fun getSaleByPossesGroupChannel(id: Int) : Flow<List<Sale>>

    fun getSaleByPosses(id: Int, isVoid : Boolean, termType : String) : Flow<List<Sale>>

    fun getTotalNota(id: Int): Flow<BigDecimal>

    fun getTotalNotaVoid(id: Int): Flow<BigDecimal>

    fun getTotalPaidTunai(id: Int): Flow<BigDecimal>

    fun getTotalPaidDebit(id: Int): Flow<BigDecimal>

    fun getTotalPaidKredit(id: Int): Flow<BigDecimal>

    fun getTotalPaidGopay(id: Int): Flow<BigDecimal>

    fun getSaleHaventUploaded(limit_trx: Int): Flow<List<Sale>>

    suspend fun updateNewIdCust(oldIdCust: Int, idCust: Int)

    fun getSaleById(id: Int): Flow<Sale?>

    fun getSaleNotUploaded(): Flow<List<Sale>>

    fun sumQtyByHour(id: Int, hour: String): Flow<LineChartData>

    fun getSaleByPossesGroupByBp(id: Int): Flow<List<Sale>>

    fun getDraftCount() : Flow<Int>

}