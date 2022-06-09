package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastIdPrinterKitchen @Inject constructor(
    private val printerKitchenRepository: PrinterKitchenRepository
) {
    operator fun invoke(): Flow<Resource<PrinterKitchen>>{
        return printerKitchenRepository.getLastId()
    }
}