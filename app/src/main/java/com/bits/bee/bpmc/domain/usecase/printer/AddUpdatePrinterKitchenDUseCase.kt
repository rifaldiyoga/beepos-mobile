package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDDataMapper
import com.bits.bee.bpmc.domain.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import javax.inject.Inject

class AddUpdatePrinterKitchenDUseCase @Inject constructor(
    private val printerKitchenDRepository: PrinterKitchenDRepository
) {
    suspend operator fun invoke(printerKitchenD: PrinterKitchenD){
        printerKitchenDRepository.addUpdatePrinterKitchenD(PrinterKitchenDDataMapper.fromDomainToDb(printerKitchenD))
    }
}