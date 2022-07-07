package com.bits.bee.bpmc.domain.usecase.printer

import javax.inject.Inject

class PrinterInteractor @Inject constructor(
    val getAddressPrinterUseCase: GetAddressPrinterUseCase,
    val getPrinterFromPrinterKitchen: GetPrinterFromPrinterKitchenUseCase,
    val getPrinterKitchenD: GetPrinterKitchenFromDetailUseCase,
    val getKitchenId: GetKitchenIdUseCase,
    val itemGrpId: GetItemgrpIdUseCase,
    val addUpdatePrinter: AddUpdatePrinterUseCase,
    val getLastId: GetLastIdUseCase,
    val addUpdatePrinterK: AddUpdatePrinterKitUseCase,
    val getLastIdPrinterKitchen: GetLastIdPrinterKitchen,
    val AddUpdatePrinterKitchenD: AddUpdatePrinterKitchenDUseCase,
    val getByPrinterUseCase: GetByPrinterUseCase,
    val deletePrinterKitchenD: DeletePrinterKitchenDDUseCase,
    val deletePrinterKit: DeletePrinterKitchenUseCase,
    val loadPrinter: LoadPrinterUseCase,
    val loadKitchen: LoadKitchenUseCase,
    val getItemgrpKitchen: GetItemgrpKitchenUseCase
)