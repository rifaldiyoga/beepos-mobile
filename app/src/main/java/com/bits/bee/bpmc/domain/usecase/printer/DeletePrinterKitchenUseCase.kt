package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import javax.inject.Inject

class DeletePrinterKitchenUseCase @Inject constructor(
    private val printerKitchenRepo: PrinterKitchenRepository
) {
    suspend operator fun invoke(printerKitchen: PrinterKitchen){
        printerKitchenRepo.delete(printerKitchen)
    }
}