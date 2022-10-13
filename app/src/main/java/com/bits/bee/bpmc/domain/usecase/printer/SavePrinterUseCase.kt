package com.bits.bee.bpmc.domain.usecase.printer

import com.bits.bee.bpmc.domain.mapper.PrinterDataMapper
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDDataMapper
import com.bits.bee.bpmc.domain.mapper.PrinterKitchenDataMapper
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.model.PrinterKitchenD
import com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SavePrinterUseCase @Inject constructor(
    private val printerRepo: PrinterRespository,
    private val printerKitchenRepo: PrinterKitchenRepository,
    private val printerKitchenDRepo: PrinterKitchenDRepository,
) {
    private var mlistPrinter: List<Printer>? = null
    private var mprinter: Printer? = null
    private var mprinterKitchen: PrinterKitchen? = null
    private var mlistPrinterKitchen: List<PrinterKitchen>? = null

    suspend operator fun invoke(
        printer: Printer?,
        printerKitchenList: List<PrinterKitchen>,
        mListKitchen: MutableList<Kitchen>
    ) {
        printerRepo.getAddressPrinterList(printer!!.address).collect {
            it.data?.let { data ->
                mlistPrinter = data
            }
        }
        if (mlistPrinter!!.isEmpty()){
            printerRepo.addUpdatePrinter(printer.let { PrinterDataMapper.fromDomainToDb(it) })

            if (printerKitchenList.isNotEmpty()){
                for ((index, value) in printerKitchenList.withIndex()){

                    printerRepo.getLastId().collect {
                        it.data?.let { data ->
                            mprinter = data
                        }
                    }
                    val printerKitchen = printerKitchenList.get(index)
                    printerKitchen.kitchenName = printerKitchen.kitchenName
                    printerKitchen.printerId = mprinter!!.id!!

                    printerKitchenRepo.addUpdatePrinterK(PrinterKitchenDataMapper.fromDomainToDb(printerKitchen))

                    printerKitchenRepo.getLastId().collect {
                        it.data?.let { data ->
                            mprinterKitchen = data
                        }
                    }

                    for (kit in mListKitchen){
                        val printerKitchenD = PrinterKitchenD(printerKitchenId = mprinterKitchen!!.id, kitchenId = kit.id)
                        printerKitchenDRepo.addUpdatePrinterKitchenD(PrinterKitchenDDataMapper.fromDomainToDb(printerKitchenD))
                    }
                }
            }
        }else{
            printer.id = mlistPrinter!!.get(0).id
            printerRepo.updatePrinter(printer.let { PrinterDataMapper.fromDomainToDb(it) })
            clearPrinterKitchen(printer.id!!)

            for ((index, value) in printerKitchenList.withIndex()){
                val printerKitchen = printerKitchenList[index]
                val id = printer.id
                printerKitchen.copy(printerId = id!!, kitchenName = printerKitchen.kitchenName)
                printerKitchenRepo.addUpdatePrinterK(PrinterKitchenDataMapper.fromDomainToDb(printerKitchen))
//                val idPrinterKit = state.mPrinterKitchen!!.id

//                val kitchenList = mListKitchen.get(index)
//                for (kitchen in kitchenList!!){
//                    val printerKitchenD = PrinterKitchenD(printerKitchenId = idPrinterKit, kitchenId = kitchen.id)
//                    addPrinterKitchenD(printerKitchenD)
//                }
            }
        }
    }

    private suspend fun clearPrinterKitchen(id: Int) {
        printerKitchenRepo.getByIdPrinter(id).collect {
            it.data?.let { data ->
                mlistPrinterKitchen = data
            }
        }
        val printerKitchenL = mlistPrinterKitchen
        for (printK in printerKitchenL!!){
            printerKitchenDRepo.deletePrinterKitchen(printK.id)
            printerKitchenRepo.delete(PrinterKitchenDataMapper.fromDomainToDb(printK))
        }

    }

}