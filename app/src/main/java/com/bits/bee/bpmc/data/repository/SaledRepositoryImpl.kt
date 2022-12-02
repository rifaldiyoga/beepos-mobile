package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.data.data_source.local.dao.SaledDao
import com.bits.bee.bpmc.domain.mapper.RankItemDataMapper
import com.bits.bee.bpmc.domain.mapper.RekapProdukDataMapper
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.mapper.SaledDataMapper
import com.bits.bee.bpmc.domain.model.RankItem
import com.bits.bee.bpmc.domain.model.RekapProduk
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaledRepository
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaledRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saledDao: SaledDao
) : SaledRepository {


    override suspend fun addSaled(saledList: List<Saled>) : List<Long> {
        var list : List<Long> = mutableListOf()
        withContext(defaultDispatcher) {
            val saledNew = saledList.map {
                SaledDataMapper.fromDomainToDb(it)
            }
            list = saledDao.insertBulk(saledNew)
        }
        return list
    }

    override fun getSaledList(saleId: Int): Flow<List<Saled>> = flow {
        val saledList = saledDao.getSaledList(saleId)
        emit(saledList.map { SaledDataMapper.fromDbToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getRankItem(possesId: Int): Flow<List<RankItem>> {
        return flow {
            val rankItem = saledDao.getRankItem(possesId).map { RankItemDataMapper.fromDbToDomain(it) }
            emit(rankItem)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledDeletedItem(): Flow<List<Saled>> {
        return flow {
            val data = saledDao.getSaledDeletedItem().map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledById(id: Int): Flow<Saled?> {
        return flow {
            val data = saledDao.getSaledById(id)
            emit(data?.let { SaledDataMapper.fromDbToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

//    override fun queryByPenjualan(): Flow<PagingData<Saled>> = Pager(
//            config = PagingConfig(
//                    pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
//                    maxSize = BPMConstants.BPM_MAX_PAGINATION,
//                    enablePlaceholders = true,
//                    initialLoadSize = BPMConstants.BPM_MAX_PAGINATION
//            ),
//            pagingSourceFactory = {
//                saledDao.queryByPenjualan()
//            }
//    ).flow.mapLatest {
//        it.map { SaledDataMapper.fromDbToDomain(it) }
//    }.flowOn(defaultDispatcher)

    override fun queryByPenjualan(): Flow<List<Saled>> {
        return flow {
            val data = saledDao.queryByPenjualan().map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledTotal(id: Int, startDate: Long, endDate: Long): Flow<List<Saled>> {
        return flow{
            val data = saledDao.sumTotalByItem(id, startDate, endDate).map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getStokByItem(id: Int, startDate: Long, endDate: Long): Flow<BigDecimal> {
        val qty = BigDecimal.ZERO
        return flow<BigDecimal> {
            val data = saledDao.sumStokByItem(id, startDate, endDate).map { SaledDataMapper.fromDbToDomain(it) }
            for (saled in data){
                qty.add(saled.qty)
            }
            emit(qty)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledByPossesChannel(possesId: Int, channelId: Int): Flow<List<Saled>> {
        return flow{
            val data = saledDao.getSaledByPossesChannel(possesId, channelId).map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getSaledByPosses(possesId: Int): Flow<List<Saled>> {
        return flow{
            val data = saledDao.getSaledByPosses(possesId).map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getRekapSaledDiskon(
        possesId: Int,
        itemId: Int,
        channelId: Int
    ): Flow<List<Saled>> {
        return flow{
            val data = saledDao.getRekapSaledDiskon(possesId,itemId, channelId).map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getRekapSaledDiskon(
        possesId: Int,
        itemId: Int,
        total: BigDecimal
    ): Flow<List<Saled>> {
        return flow{
            val data = saledDao.getRekapSaledDiskonNumerik(possesId, itemId, total).map { SaledDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getRekapProduk(startDate: Long, endDate: Long, query: String): Flow<PagingData<RekapProduk>> = Pager(
            config = PagingConfig(
                    pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
                    maxSize = BPMConstants.BPM_MAX_PAGINATION,
                    enablePlaceholders = true,
                    initialLoadSize = BPMConstants.BPM_MAX_PAGINATION
            ),
            pagingSourceFactory = {
                if (query.isEmpty())
                    saledDao.getRekapProduk(startDate, endDate)
                else
                    saledDao.searchRekapProduk(startDate, endDate, query)
            }
    ).flow.mapLatest {
        it.map { RekapProdukDataMapper.fromDbToDomain(it)}
    }.flowOn(defaultDispatcher)
}