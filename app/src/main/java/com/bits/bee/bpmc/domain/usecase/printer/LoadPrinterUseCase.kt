package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadPrinterUseCase @Inject constructor(
    private val printerRepo: PrinterRespository
) {
    operator fun invoke(): Flow<Resource<List<Printer>>>{
        return printerRepo.readPrinter()
    }
}