package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.SaleDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.domain.mapper.SaleDataMapper
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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
            val saleNew = SaleDataMapper.fromDomainToData(sale)

            id = saleDao.insertSingle(saleNew)
        }
        return id
    }

    override fun getLatestSaleList(): Flow<List<Sale>> = flow {
        emit(saleDao.getLatestSaleList().map { SaleDataMapper.fromDataToDomain(it) })
    }.flowOn(defaultDispatcher)

    override fun getLatestDraftList(): Flow<List<Sale>> = flow {
        val saleList = saleDao.getLatestDraftList()
        if(saleList.size <= 5)
            emit(saleList.map { SaleDataMapper.fromDataToDomain(it) } )
        else
            emit(saleList.slice(0..4).map { SaleDataMapper.fromDataToDomain(it) })
    }.flowOn(defaultDispatcher)

}