package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterKitchenDDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import javax.inject.Inject

class PrinterKitchenDRepositoryImpl @Inject constructor(
    private val printerKitchenDDao: PrinterKitchenDDao
): PrinterKitchenDRepository {
    override fun getPrinterKitchen(id: Int): List<PrinterKitchenD> {
        return printerKitchenDDao.getPrinterKitchen(id)
    }

    override fun deletePrinterKitchen(id: Int) {
        return printerKitchenDDao.deletePrinterKitchen(id)
    }
}