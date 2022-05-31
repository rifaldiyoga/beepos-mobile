package com.bits.bee.bpmc.domain.usecase.printer

import javax.inject.Inject

class PrinterInteractor @Inject constructor(
    val getAddressPrinterUseCase: GetAddressPrinterUseCase,
    val getPrinterFromPrinterKitchen: GetPrinterFromPrinterKitchenUseCase,
    val getPrinterKitchenFromDetail: GetPrinterKitchenFromDetailUseCase,
    val getKitchenId: GetKitchenIdUseCase,
    val itemGrpId: GetItemgrpIdUseCase
)