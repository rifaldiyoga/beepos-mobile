package com.bits.bee.bpmc.domain.repository

import androidx.paging.PagingData
import com.bits.bee.bpmc.domain.model.RankItem
import com.bits.bee.bpmc.domain.model.RekapProduk
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Created by aldi on 20/05/22.
 */
interface SaledRepository {

    suspend fun addSaled(saledList : List<Saled>) : List<Long>

    fun getSaledList(saleId : Int) : Flow<List<Saled>>

    fun getRankItem(possesId: Int): Flow<List<RankItem>>

    fun getSaledDeletedItem(): Flow<List<Saled>>

    fun getSaledById(id : Int) : Flow<Saled?>

    fun queryByPenjualan(): Flow<List<Saled>>

    fun getSaledTotal(id: Int, startDate: Long, endDate: Long): Flow<List<Saled>>

    fun getStokByItem(id: Int, startDate: Long, endDate: Long): Flow<BigDecimal>

    fun getSaledByPossesChannel(possesId : Int, channelId : Int) : Flow<List<Saled>>

    fun getSaledByPosses(possesId : Int) : Flow<List<Saled>>

    fun getRekapSaledDiskon(possesId : Int, itemId : Int, channelId : Int) : Flow<List<Saled>>

    fun getRekapSaledDiskon(possesId : Int, itemId : Int, total : BigDecimal) : Flow<List<Saled>>

    fun getRekapProduk(startDate: Long, endDate: Long, query: String): Flow<PagingData<RekapProduk>>

}