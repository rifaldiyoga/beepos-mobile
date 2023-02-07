package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadPrinterUseCase @Inject constructor(
    private val printerRepo: PrinterRepository
) {
    operator fun invoke(): Flow<List<Printer>>{
        return printerRepo.readPrinter()
    }
}