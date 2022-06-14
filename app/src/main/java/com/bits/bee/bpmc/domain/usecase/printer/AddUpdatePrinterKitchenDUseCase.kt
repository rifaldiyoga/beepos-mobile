package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import javax.inject.Inject

class AddUpdatePrinterKitchenDUseCase @Inject constructor(
    private val printerKitchenDRepository: PrinterKitchenDRepository
) {
    suspend operator fun invoke(printerKitchenD: PrinterKitchenD){
        printerKitchenDRepository.addUpdatePrinterKitchenD(printerKitchenD)
    }
}