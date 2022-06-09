package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetByPrinterUseCase @Inject constructor(
    private val printerKitchenRepo: PrinterKitchenRepository
) {
    operator fun invoke(id: Int): Flow<Resource<List<PrinterKitchen>>>{
        return printerKitchenRepo.getByIdPrinter(id)
    }
}