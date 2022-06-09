package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastIdUseCase @Inject constructor(
    private val printerRespository: PrinterRespository
) {
    operator fun invoke(): Flow<Resource<Printer>> {
       return printerRespository.getLastId()
    }
}