package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.domain.mapper.PrinterDataMapper
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrinterRepositoryImpl @Inject constructor(
    private val printerDao: PrinterDao,
    private val ioDispatcher: CoroutineDispatcher
): PrinterRepository {

    override fun getByAddress(address: String): Flow<Printer?> {
        return flow {
            val data = printerDao.readByAddress(address)
            emit(data?.let { PrinterDataMapper.fromDbToDomain(data) })
        }.flowOn(ioDispatcher)
    }

    override fun getActiveReceiptList(): Flow<List<Printer>> = flow {
        val data = printerDao.readByActiveReceipt()
        emit(data.map { PrinterDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getActiveReportList(): Flow<List<Printer>> = flow {
        val data = printerDao.readByActiveReport()
        emit(data.map { PrinterDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getActiveKitchenList(): Flow<List<Printer>> = flow {
        val data = printerDao.readByActiveKitchen()
        emit(data.map { PrinterDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getActiveCheckerList(): Flow<List<Printer>> = flow {
        val data = printerDao.readByActiveChecker()
        emit(data.map { PrinterDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getPrinterTipe(type : Int): Flow<List<Printer>> = flow {
        val data = printerDao.readByTipe(type)
        emit(data.map { PrinterDataMapper.fromDbToDomain(it) })
    }.flowOn(ioDispatcher)

    override fun getLastId(): Flow<Printer> {
        return flow {
            val data = printerDao.getLastId()
            emit(PrinterDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun readPrinter(): Flow<List<Printer>> {
        return flow {
            val data = printerDao.readPrinter().map { PrinterDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdatePrinter(printer: PrinterEntity?) : Long{
        var id: Long
        withContext(ioDispatcher){
           id =  printerDao.insertSingle(printer!!)
        }
        return id
    }

    override suspend fun delete(printer: Printer) {
        withContext(ioDispatcher){
            printerDao.delete(PrinterDataMapper.fromDomainToDb(printer))
        }
    }

    override suspend fun updatePrinter(printer: PrinterEntity?) {
        withContext(ioDispatcher){
            printer?.let { printerDao.update(it) }
        }
    }

}