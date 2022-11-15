package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetByPrinterUseCase @Inject constructor(
    private val printerKitchenRepo: PrinterKitchenRepository
) {
    operator fun invoke(id: Int): Flow<List<PrinterKitchen>>{
        return printerKitchenRepo.getByIdPrinter(id)
    }
}