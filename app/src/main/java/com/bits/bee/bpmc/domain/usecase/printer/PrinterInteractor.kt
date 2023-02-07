package com.bits.bee.bpmc.domain.usecase.printer

import javax.inject.Inject

class PrinterInteractor @Inject constructor(
    val getPrinterFromPrinterKitchen: GetPrinterFromPrinterKitchenUseCase,
    val itemGrpId: GetItemgrpIdUseCase,
    val loadPrinter: LoadPrinterUseCase,
)