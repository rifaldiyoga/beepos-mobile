package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
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
            val data = printerKitchenDao.getByPrinter(id)
            if (data != null){
                emit(Resource.success(data))
            }else{
                emit(Resource.error(null, "Data Kosong"))
            }
        }.flowOn(ioDispatcher)
    }

    override fun getId(id: Int): Flow<Resource<PrinterKitchen>> {
        return flow{
           val data =  printerKitchenDao.getById(id)
            if (data != null){
                emit(Resource.success(data))
            }else{
                emit(Resource.error(null, "Data Kosong"))
            }
        }.flowOn(ioDispatcher)
    }

    override fun getLastId(): Flow<Resource<PrinterKitchen>> {
        return flow {
           val data = printerKitchenDao.getLastId()
            if (data != null){
                emit(Resource.success(data))
            }else{
                emit(Resource.error(null, "Data Kosong"))
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun addUpdatePrinterK(printerKitchen: PrinterKitchen) {
        withContext(ioDispatcher){
            printerKitchenDao.insertSingle(printerKitchen)
        }
    }

    override suspend fun delete(printerKitchen: PrinterKitchen) {
        withContext(ioDispatcher){
            printerKitchenDao.delete(printerKitchen)
        }
    }

}