package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import com.bits.bee.bpmc.utils.Resource
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
    override fun getPrinterKitchen(id: Int): Flow<Resource<List<PrinterKitchenD>>> {
        return flow{
            val data = printerKitchenDDao.getPrinterKitchen(id)
            if (data != null)
                emit(Resource.success(data))
            else
                emit(Resource.error(null, "Data Kosong"))

        }.flowOn(ioDispatcher)
    }

    override suspend fun deletePrinterKitchen(id: Int) {
        withContext(ioDispatcher){
            printerKitchenDDao.deletePrinterKitchen(id)
        }
    }

    override suspend fun addUpdatePrinterKitchenD(printerKitchenD: PrinterKitchenD) {
        withContext(ioDispatcher){
            printerKitchenDDao.insertSingle(printerKitchenD)
        }
    }
}