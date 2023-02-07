package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DeletePrinterUseCase @Inject constructor(
    private val printerRepo: PrinterRepository,
    private val printerKitchenRepo: PrinterKitchenRepository,
    private val printerKitchenDRepo: PrinterKitchenDRepository,
) {

    suspend operator fun invoke(mPrinter: Printer) {
        mPrinter.id?.let { id ->
            printerRepo.delete(mPrinter)
            clearPrinterKitchen(id)

        }
    }

    private suspend fun clearPrinterKitchen(id: Int) {
        printerKitchenRepo.getByIdPrinter(id).first().forEach {
            printerKitchenDRepo.deleteByPrinterKitchen(it.id!!)
            printerKitchenRepo.delete(it)
        }
    }

}