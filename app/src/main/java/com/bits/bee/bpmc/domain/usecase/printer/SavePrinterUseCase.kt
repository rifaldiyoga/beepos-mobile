package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.mapper.PrinterDataMapper
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SavePrinterUseCase @Inject constructor(
    private val printerRepo: PrinterRepository,
    private val printerKitchenRepo: PrinterKitchenRepository,
    private val printerKitchenDRepo: PrinterKitchenDRepository,
) {

    suspend operator fun invoke(mPrinter: Printer, printerKitchenList: List<PrinterKitchen>) {
        mPrinter.id?.let { id ->
            printerRepo.updatePrinter(mPrinter.let { PrinterDataMapper.fromDomainToDb(it) })
            clearPrinterKitchen(id)

            for (printerKitchen in printerKitchenList){
                printerKitchen.printerId = id
                val idPrinterKit =  printerKitchenRepo.addUpdatePrinterKitchen(printerKitchen)
                for (kitchen in printerKitchen.kitchenList){
                    val printerKitchenD = PrinterKitchenD(printerKitchenId = idPrinterKit.toInt(), kitchenId = kitchen.id)
                    printerKitchenDRepo.addUpdatePrinterKitchenD(printerKitchenD)
                }
            }

        } ?: run {
            val id = printerRepo.addUpdatePrinter(mPrinter.let { PrinterDataMapper.fromDomainToDb(it) })
            if (printerKitchenList.isNotEmpty()){
                for ((index, _) in printerKitchenList.withIndex()){

                    val printerKitchen = printerKitchenList[index]
                    printerKitchen.kitchenName = printerKitchen.kitchenName
                    printerKitchen.printerId = id.toInt()

                    val idPrinterKit = printerKitchenRepo.addUpdatePrinterKitchen(printerKitchen)

                    for (kit in printerKitchen.kitchenList){
                        val printerKitchenD = PrinterKitchenD(printerKitchenId = idPrinterKit.toInt(), kitchenId = kit.id)
                        printerKitchenDRepo.addUpdatePrinterKitchenD(printerKitchenD)
                    }
                }
            }

        }
    }

    private suspend fun clearPrinterKitchen(id: Int) {
        printerKitchenRepo.getByIdPrinter(id).first().forEach {
            printerKitchenDRepo.deleteByPrinterKitchen(it.id!!)
            printerKitchenRepo.delete(it)
        }
    }

}