package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.utils.BeePreferenceManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPrinterFromPrinterKitchenUseCase @Inject constructor(
    private val printerKitchenRepository: PrinterKitchenRepository,
    private val getListKitchenUseCase: GetListKitchenUseCase,
    private val ioDispatcher: CoroutineDispatcher,
    private val beePreferenceManager: BeePreferenceManager
) {
    operator fun invoke(id: Int): Flow<List<PrinterKitchen>> = flow {
        val printerKitchenList = printerKitchenRepository.getByIdPrinter(id).first()
        val sistemPreferences = beePreferenceManager.sistemPreferences.first()
        printerKitchenList.forEach {
            val list = getListKitchenUseCase(it, sistemPreferences.isCloudDapur).first()
            it.kitchenList = list
        }
        emit(printerKitchenList)
    }.flowOn(ioDispatcher)
}