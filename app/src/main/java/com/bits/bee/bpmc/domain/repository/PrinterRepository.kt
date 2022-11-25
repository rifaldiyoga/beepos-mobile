package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PrinterRepository {

    fun getByAddress(address: String): Flow<Printer?>

    fun getActiveReceiptList(): Flow<List<Printer>>

    fun getActiveReportList(): Flow<List<Printer>>

    fun getActiveKitchenList(): Flow<List<Printer>>

    fun getActiveCheckerList(): Flow<List<Printer>>

    fun getPrinterTipe(type : Int): Flow<List<Printer>>

    fun getLastId(): Flow<Printer>

    fun readPrinter(): Flow<List<Printer>>

    suspend fun addUpdatePrinter(printer: PrinterEntity?) : Long

    suspend fun delete(printer: Printer)

    suspend fun updatePrinter(printer : PrinterEntity?)
}