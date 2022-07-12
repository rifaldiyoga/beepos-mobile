package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDataMapper
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import javax.inject.Inject

class AddUpdatePrinterKitUseCase @Inject constructor(
    private val printerKitchenRepository: PrinterKitchenRepository
) {
    suspend operator fun invoke(printerKitchen: PrinterKitchen){
        printerKitchenRepository.addUpdatePrinterK(PrinterKitchenDataMapper.fromDomainToDb(printerKitchen))
    }
}