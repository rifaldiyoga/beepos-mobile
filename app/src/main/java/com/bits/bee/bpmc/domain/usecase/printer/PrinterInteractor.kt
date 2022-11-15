package com.bits.bee.bpmc.domain.usecase.printer

import javax.inject.Inject

class PrinterInteractor @Inject constructor(
    val getPrinterFromPrinterKitchen: GetPrinterFromPrinterKitchenUseCase,
    val itemGrpId: GetItemgrpIdUseCase,
    val getLastId: GetLastIdUseCase,
    val getByPrinterUseCase: GetByPrinterUseCase,
    val deletePrinterKitchenD: DeletePrinterKitchenDDUseCase,
    val deletePrinterKit: DeletePrinterKitchenUseCase,
    val loadPrinter: LoadPrinterUseCase,
)