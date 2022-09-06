package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDataMapper
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrinterKitchenRepositoryImpl @Inject constructor(
    private val printerKitchenDao: PrinterKitchenDao,
    private val ioDispatcher: CoroutineDispatcher
): PrinterKitchenRepository {
    override fun getByIdPrinter(id: Int): Flow<Resource<List<PrinterKitchen>>>  {
        return flow {
            val data = printerKitchenDao.getByPrinter(id).map { PrinterKitchenDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun getId(id: Int): Flow<Resource<PrinterKitchen>> {
        return flow{
           val data =  printerKitchenDao.getById(id)
            emit(Resource.success(PrinterKitchenDataMapper.fromDbToDomain(data)))
        }.flowOn(ioDispatcher)
    }

    override fun getLastId(): Flow<Resource<PrinterKitchen>> {
        return flow {
           val data = printerKitchenDao.getLastId()
            emit(Resource.success(PrinterKitchenDataMapper.fromDbToDomain(data)))
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdatePrinterK(printerKitchen: PrinterKitchenEntity) {
        withContext(ioDispatcher){
            printerKitchenDao.insertSingle(printerKitchen)
        }
    }

    override suspend fun delete(printerKitchen: PrinterKitchenEntity) {
        withContext(ioDispatcher){
            printerKitchenDao.delete(printerKitchen)
        }
    }

}