package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.PrinterKitchenD
import kotlinx.coroutines.flow.Flow

interface PrinterKitchenDRepository {

    fun getPrinterKitchen(id: Int): Flow<List<PrinterKitchenD>>

    suspend fun deleteByPrinterKitchen(id: Int)

    suspend fun addUpdatePrinterKitchenD(printerKitchenD: PrinterKitchenD) : Long
}