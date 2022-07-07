package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import javax.inject.Inject

class DeletePrinterKitchenDDUseCase @Inject constructor(
    private val printerKitchenDRepository: PrinterKitchenDRepository
) {
    suspend operator fun invoke(id: Int){
        printerKitchenDRepository.deletePrinterKitchen(id)
    }
}