package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PrinterKitchenRepository {
    fun getByIdPrinter(id: Int): Flow<Resource<List<PrinterKitchen>>>

    fun getId(id: Int): Flow<Resource<PrinterKitchen>>

    fun getLastId(): Flow<Resource<PrinterKitchen>>

    suspend fun addUpdatePrinterK(printerKitchen: PrinterKitchen)

    suspend fun delete(printerKitchen: PrinterKitchen)
}