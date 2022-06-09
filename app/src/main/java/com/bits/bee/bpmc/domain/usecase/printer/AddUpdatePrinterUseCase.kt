package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import javax.inject.Inject

class AddUpdatePrinterUseCase @Inject constructor(
    private val printerRespository: PrinterRespository
) {
    suspend operator fun invoke(printer : Printer?){
        printerRespository.addUpdatePrinter(printer)
    }

    suspend fun update(printer : Printer?){
        printerRespository.updatePrinter(printer)
    }
}