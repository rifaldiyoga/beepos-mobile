package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.PrinterKitchen
import kotlinx.coroutines.flow.Flow

interface PrinterKitchenRepository {

    fun getByIdPrinter(id: Int): Flow<List<PrinterKitchen>>

    fun getId(id: Int): Flow<PrinterKitchen>

    fun getLastId(): Flow<PrinterKitchen>

    suspend fun addUpdatePrinterKitchen(printerKitchen: PrinterKitchen) : Long

    suspend fun delete(printerKitchen: PrinterKitchen)
}