package com.bits.bee.bpmc.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SaleRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val saleDao: SaleDao
) : SaleRepository {

    override suspend fun addSale(sale: Sale) : Long{
        var id : Long = 1
        withContext(defaultDispatcher){
            val saleNew = SaleDataMapper.fromDomainToDb(sale)

            id = saleDao.insertSingle(saleNew)
        }
        return id
    }

    override suspend fun deleteSale(sale: Sale) {
        withContext(defaultDispatcher){
            saleDao.delete(SaleDataMapper.fromDomainToDb(sale))
        }
    }

    override suspend fun updateSale(sale: Sale) {
        withContext(defaultDispatcher) {
            saleDao.update(SaleDataMapper.fromDomainToDb(sale))
        }
    }

    override fun getLatestSaleList(query : String, isDraft: Boolean): Flow<PagingData<Sale>> =  Pager(
        config = PagingConfig(
            pageSize = BPMConstants.BPM_LIMIT_PAGINATION,
            maxSize = BPMConstants.BPM_MAX_PAGINATION,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            saleDao.getLatestSaleList(query, isDraft)
        }
    ).flow.mapLatest {
        it.map { SaleDataMapper.fromDbToDomain(it) }
    }.flowOn(defaultDispatcher)

    override fun getLatestDraftList(): Flow<List<Sale>> = flow {
        val saleList = saleDao.getLatestDraftList()
        emit(saleList.map { SaleDataMapper.fromDbToDomain(it) } )
    }.flowOn(defaultDispatcher)

}