package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import javax.inject.Inject

class AddUpdatePrinterKitUseCase @Inject constructor(
    private val printerKitchenRepository: PrinterKitchenRepository
) {
    suspend operator fun invoke(printerKitchen: PrinterKitchen){
        printerKitchenRepository.addUpdatePrinterK(printerKitchen)
    }
}