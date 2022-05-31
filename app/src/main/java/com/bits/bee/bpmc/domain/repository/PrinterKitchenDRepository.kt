package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD

interface PrinterKitchenDRepository {
    fun getPrinterKitchen(id: Int): List<PrinterKitchenD>

    fun deletePrinterKitchen(id: Int)
}