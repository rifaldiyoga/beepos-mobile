package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity
import com.bits.bee.bpmc.domain.model.PrinterKitchenD
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PrinterKitchenDRepository {
    fun getPrinterKitchen(id: Int): Flow<Resource<List<PrinterKitchenD>>>

    suspend fun deletePrinterKitchen(id: Int)

    suspend fun addUpdatePrinterKitchenD(printerKitchenD: PrinterKitchenDEntity)
}