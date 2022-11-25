package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDataMapper
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
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

    override fun getByIdPrinter(id: Int): Flow<List<PrinterKitchen>>  {
        return flow {
            val data = printerKitchenDao.getByPrinter(id).map { PrinterKitchenDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getId(id: Int): Flow<PrinterKitchen> {
        return flow{
           val data =  printerKitchenDao.getById(id)
            emit(PrinterKitchenDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getLastId(): Flow<PrinterKitchen> {
        return flow {
           val data = printerKitchenDao.getLastId()
            emit(PrinterKitchenDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdatePrinterKitchen(printerKitchen: PrinterKitchen) : Long {
        var id : Long
        withContext(ioDispatcher){
            id = printerKitchenDao.insertSingle(PrinterKitchenDataMapper.fromDomainToDb(printerKitchen))
        }
        return id
    }

    override suspend fun delete(printerKitchen: PrinterKitchen) {
        withContext(ioDispatcher){
            printerKitchenDao.delete(PrinterKitchenDataMapper.fromDomainToDb(printerKitchen))
        }
    }

}