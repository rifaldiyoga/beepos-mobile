package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PrinterKitchenDRepository {
    fun getPrinterKitchen(id: Int): Flow<Resource<List<PrinterKitchenD>>>

    suspend fun deletePrinterKitchen(id: Int)

    suspend fun addUpdatePrinterKitchenD(printerKitchenD: PrinterKitchenD)
}