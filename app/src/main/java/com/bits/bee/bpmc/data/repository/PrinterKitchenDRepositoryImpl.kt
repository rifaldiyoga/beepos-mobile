package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDDataMapper
import com.bits.bee.bpmc.domain.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrinterKitchenDRepositoryImpl @Inject constructor(
    private val printerKitchenDDao: PrinterKitchenDDao,
    private val ioDispatcher: CoroutineDispatcher
): PrinterKitchenDRepository {
    override fun getPrinterKitchen(id: Int): Flow<List<PrinterKitchenD>> {
        return flow{
            val data = printerKitchenDDao.getPrinterKitchen(id).map { PrinterKitchenDDataMapper.fromDbToDomain(it) }
            emit(data)

        }.flowOn(ioDispatcher)
    }

    override suspend fun deleteByPrinterKitchen(id: Int) {
        withContext(ioDispatcher){
            printerKitchenDDao.deleteByPrinterKitchen(id)
        }
    }

    override suspend fun addUpdatePrinterKitchenD(printerKitchenD: PrinterKitchenD) : Long{
        var id : Long
        withContext(ioDispatcher) {
            id = printerKitchenDDao.insertSingle(PrinterKitchenDDataMapper.fromDomainToDb(printerKitchenD))
        }
        return id
    }
}