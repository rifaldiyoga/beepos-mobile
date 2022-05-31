package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PrinterKitchenRepositoryImpl @Inject constructor(
    private val printerKitchenDao: PrinterKitchenDao
): PrinterKitchenRepository {
    override fun getIdPrinter(id: Int): List<PrinterKitchen> {
        return printerKitchenDao.getByPrinter(id)
    }

    override fun getId(id: Int): Flow<Resource<PrinterKitchen>> {
        return flow {
            printerKitchenDao.getById(id)
        }
    }

    override fun getLastId(id: Int): Flow<Resource<PrinterKitchen>> {
        return flow {
            printerKitchenDao.getLastId(id)
        }
    }

}