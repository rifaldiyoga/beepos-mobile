package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPrinterFromPrinterKitchenUseCase @Inject constructor(
    private val printerKitchenRepository: PrinterKitchenRepository
) {
    operator fun invoke(id: Int): Flow<List<PrinterKitchen>>{
        return printerKitchenRepository.getByIdPrinter(id)
    }
}