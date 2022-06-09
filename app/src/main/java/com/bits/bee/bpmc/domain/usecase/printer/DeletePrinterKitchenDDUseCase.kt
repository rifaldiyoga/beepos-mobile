package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeletePrinterKitchenDDUseCase @Inject constructor(
    private val printerKitchenDRepository: PrinterKitchenDRepository
) {
    suspend operator fun invoke(id: Int){
        printerKitchenDRepository.deletePrinterKitchen(id)
    }
}