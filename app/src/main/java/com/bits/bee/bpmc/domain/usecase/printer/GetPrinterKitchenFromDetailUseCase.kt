package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import javax.inject.Inject

class GetPrinterKitchenFromDetailUseCase @Inject constructor(
    private val printerKitchenDRepository: PrinterKitchenDRepository
) {
    operator fun invoke(id: Int): List<PrinterKitchenD>{
        return printerKitchenDRepository.getPrinterKitchen(id)
    }
}