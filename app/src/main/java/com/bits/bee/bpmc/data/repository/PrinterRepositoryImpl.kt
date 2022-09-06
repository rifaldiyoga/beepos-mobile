package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.domain.mapper.PrinterDataMapper
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrinterRepositoryImpl @Inject constructor(
    private val printerDao: PrinterDao,
    private val ioDispatcher: CoroutineDispatcher

): PrinterRespository {
    override fun getAddressPrinterList(address: String): Flow<Resource<List<Printer>>> {
        return flow {
            val data: List<Printer> = printerDao.readByAddress(address).map { PrinterDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override fun getActiveReceiptList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getActiveReportList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getActiveKitchenList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getActiveCheckerList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getPrinterTipe(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getLastId(): Flow<Resource<Printer>> {
        return flow {
            val data = printerDao.getLastId()
            emit(Resource.success(PrinterDataMapper.fromDbToDomain(data)))
        }.flowOn(ioDispatcher)
    }

    override fun readPrinter(): Flow<Resource<List<Printer>>> {
        return flow {
            val data = printerDao.readPrinter().map { PrinterDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdatePrinter(printer: PrinterEntity?){
        withContext(ioDispatcher){
            printerDao.insertSingle(printer!!)
        }
    }

    override suspend fun updatePrinter(printer: PrinterEntity?) {
        withContext(ioDispatcher){
            printer?.let { printerDao.update(it) }
        }
    }


//    override suspend fun addUpdatePrinter(printer: Printer) = withContext(ioDispatcher) {
//        printerDao.insertSingle(printer)
//    }

}