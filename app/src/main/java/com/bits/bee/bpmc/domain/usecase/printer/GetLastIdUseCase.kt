package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastIdUseCase @Inject constructor(
    private val printerRepository: PrinterRepository
) {
    operator fun invoke(): Flow<Printer> {
       return printerRepository.getLastId()
    }
}