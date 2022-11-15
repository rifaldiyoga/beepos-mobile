package com.bits.bee.bpmc.domain.printer.helper

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.printer.factory.PrinterFactory
import com.bits.bee.bpmc.domain.printer.wifi.WifiPrinterHandler
import com.bits.bee.bpmc.domain.report.ReportGeneratorInvoice
import com.bits.bee.bpmc.domain.repository.ItemKitchenRepository
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.PrinterKitchenRepository
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import com.bits.bee.bpmc.domain.usecase.common.GetSaledBySaleUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrinterHelper @Inject constructor(
    private val printerFactory: PrinterFactory,
    private val wifiPrinterHandler: WifiPrinterHandler,
    private val reportGeneratorInvoice: ReportGeneratorInvoice,
    private val printerRepository: PrinterRepository,
    private val printerKitchenRepository: PrinterKitchenRepository,
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val beePreferenceManager: BeePreferenceManager,
    private val itemKitchenRepository: ItemKitchenRepository,
    private val itemRepository: ItemRepository
) {

    enum class PrintType {
        RECEIPT, KITCHEN, REPORT, GOPAY, CHECKER, TEST_PRINT
    }

    @Throws(Exception::class)
    suspend fun printInvoice(context: Context, sale: Sale, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT) {
        val printerList: List<Printer> = getListPrinter(PrintType.RECEIPT)
        for (printer in printerList) {
            val paperSize = getPaperSize(printer.size)
            val toPrint: String = reportGeneratorInvoice.printRptInvoice(sale, paperSize)
            doPrintImageHeader(context, printer)
            doPrint(printer, toPrint, font, align, true)
        }
        Log.i("Print", "Invoice")
    }

    @Throws(Exception::class)
    suspend fun printKitchen(sale: Sale, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT) {
        val printerList: List<Printer> = getListPrinter(PrintType.KITCHEN)
        for (printer in printerList) {
            val paperSize = getPaperSize(printer.size)
            val printerKitchenList = printerKitchenRepository.getByIdPrinter(printer.id!!).first()
            for (printerKitchen in printerKitchenList) {
                val saledList: List<Saled> = saledsByCategory(sale, printerKitchen)
                if (saledList.isNotEmpty()) {
                    val toPrint: String = reportGeneratorInvoice.printKitchen(sale, printerKitchen.kitchenName, saledList, paperSize)
                    doPrint(printer, toPrint, font, align, true)
                }
            }
        }
        Log.i("Print", "Invoice")
    }

    @Throws(Exception::class)
    private suspend fun saledsByCategory(sale: Sale, printerKitchen: PrinterKitchen): List<Saled> {
        val result: MutableList<Saled> = ArrayList()
        val saledList = getSaledBySaleUseCase(sale.id!!).first()
        val sistemPreferences = beePreferenceManager.sistemPreferences.first()

        if (sistemPreferences.isCloudDapur) {
            val itemKitchenList = itemKitchenRepository.getByPrinterKitchen(printerKitchen.id!!).first()
            for (saled in saledList) {
                for (itemKitchen in itemKitchenList) {
                    if (saled.itemId == itemKitchen.itemId) {
                        result.add(saled)
                    }
                }
            }
        } else {
            val itemList = itemRepository.getItemByPrinterKitchen(printerKitchen.id!!).first()
            for (saled in saledList) {
                for (item in itemList) {
                    if (saled.itemId == item.id) {
                        result.add(saled)
                    }
                }
            }
        }
        return result
    }

    @Throws(Exception::class)
    suspend fun printChecker(context: Context, sale: Sale, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT) {
        val printerList: List<Printer> = getListPrinter(PrintType.CHECKER)
        for (printer in printerList) {
            val paperSize = getPaperSize(printer.size)
        }
        Log.i("Print", "Invoice")
    }

    @Throws(Exception::class)
    suspend fun printInvoiceDuplicate(context: Context, sale: Sale, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT) {
        val printerList = getListPrinter(PrintType.RECEIPT)
        for (printer in printerList) {
            val paperSize = getPaperSize(printer.size)
            val toPrint = reportGeneratorInvoice.printRptInvoiceDuplicate(sale, paperSize)
            doPrintImageHeader(context, printer)
            doPrint(printer, toPrint, font, align, true)
        }
        Log.i("Print", "Invoice Duplicate")
    }

    @Throws(Exception::class)
    suspend fun printClosingCashier(posses: Posses, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT) {
        val printerList: List<Printer> = getListPrinter(PrintType.REPORT)
        for (printer in printerList) {
            val paperSize = getPaperSize(printer.size)
            val toPrint = reportGeneratorInvoice.printRptClosingCashierNew(posses, paperSize)
            doPrint(printer, toPrint, font, align, true)
        }
        Log.i("Print", "Closing Cashier")
    }

    @Throws(Exception::class)
    suspend fun printBillGopay(context: Context, data: Bitmap, sale: Sale) {
        val printerList: List<Printer> = getListPrinter(PrintType.RECEIPT)
        for (printer in printerList) {
            val paperSize = getPaperSize(printer.size)
            doPrintImageHeader(context, printer)
            doPrint(printer, reportGeneratorInvoice.printRptInvoiceBillGopay(sale, paperSize), BPMConstants.BPM_FONT_REGULAR, BPMConstants.BPM_ALIGN_LEFT, false)
            doPrintImage(data, printer)
            doPrint(printer, reportGeneratorInvoice.printRptFooterBillGopay(sale, paperSize), BPMConstants.BPM_FONT_REGULAR, BPMConstants.BPM_ALIGN_LEFT, true)
        }
        Log.i("Print", "Gopay")
    }

    suspend fun testPrint( context: Context, printer: Printer, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT) {
        doPrintImageHeader(context, printer)
        doPrint(printer, "Test Print " + printer.printerName, font, align, true)
        Log.i("Print", "Test Print")
    }

    private suspend fun doPrint(printer: Printer, text: String, font: String = BPMConstants.BPM_FONT_REGULAR, align: String = BPMConstants.BPM_ALIGN_LEFT, feed: Boolean) {
        when (printer.tipe) {
            BPMConstants.BPM_PRINTER_BLUETOOH -> printerFactory.print(printer, text, font, align, feed)
            BPMConstants.BPM_PRINTER_WIFI -> wifiPrinterHandler.print(text, printer.address)
            BPMConstants.BPM_PRINTER_USB -> {}
            else -> {}
        }
    }

    //    private void doKickDrawerOut(Printer printer){
    //        switch (printer.tipe){
    //            case BPMConstants.BPM_PRINTER_BLUETOOH :
    //                printerFactory.kickDrawerOut(printer);
    //                break;
    //            default:
    //                break;
    //        }
    //    }

    suspend fun checkPrinter(type: PrintType, loadData: Boolean): Boolean {
        var printerList: List<Printer> = ArrayList<Printer>()
        try {
            printerList = getListPrinter(type)
        } catch (e: Exception) {
            e.printStackTrace()
        }
//        if (printerList.isEmpty()) {
//            val dialog: MaterialDialog = DialogBuilder.showPositiveNegativeDialog(
//                context,
//                "Setting Printer",
//                "Lewati",
//                "Printer " + getKetPrinter(type) + " belum tersetting, pastikan setting Printer " + getKetPrinter(
//                    type
//                ) + " sudah aktif, setting printer terlebih dahulu?"
//            )
//            dialog.getBuilder().onPositive(object : SingleButtonCallback() {
//                fun onClick(dialog: MaterialDialog, which: DialogAction) {
//                    context.startActivity(
//                        if (Utils.getScreenResolution(context as Activity)
//                                .equals(BPMConstants.BPM_SCREEN_LANDSCAPE)
//                        ) IntentChooser.getSettingIntent(
//                            context,
//                            loadData
//                        ) else IntentChooser.getSettingIntentP(context)
//                    )
//                }
//            })
//            dialog.getBuilder().onNegative(object : SingleButtonCallback() {
//                fun onClick(dialog: MaterialDialog, which: DialogAction) {
//                    dialog.dismiss()
//                }
//            })
//            dialog.show()
//        } else if (!BluetoothConnectService.getStatusPrinter()) {
//            EventBus.getDefault().post(ConnectAllBluetoothEvent())
//        }
        return printerList.isEmpty()
    }

    private suspend fun doPrintImageHeader(context: Context, printer: Printer?) {
        if (printer != null) {
            when (printer.tipe) {
                BPMConstants.BPM_PRINTER_BLUETOOH -> printerFactory.printImageLogo(context, printer)
                BPMConstants.BPM_PRINTER_WIFI -> wifiPrinterHandler.printImageLogo(context, printer)
                BPMConstants.BPM_PRINTER_USB -> {}
                else -> {}
            }
        }
    }

    private fun doPrintImage(bitmap: Bitmap, printer: Printer) {
        when (printer.tipe) {
            BPMConstants.BPM_PRINTER_BLUETOOH -> printerFactory.printImageGopay(bitmap, printer)
            BPMConstants.BPM_PRINTER_WIFI -> wifiPrinterHandler.printImage(printer, bitmap)
            else -> {}
        }
    }

    private suspend fun getListPrinter(type: PrintType): List<Printer> {
        return when (type) {
            PrintType.REPORT -> printerRepository.getActiveReportList().first()
            PrintType.KITCHEN -> printerRepository.getActiveKitchenList().first()
            PrintType.RECEIPT -> printerRepository.getActiveReceiptList().first()
            PrintType.CHECKER -> printerRepository.getActiveCheckerList().first()
            PrintType.GOPAY -> mutableListOf()
            PrintType.TEST_PRINT -> mutableListOf()
        }
    }

    private fun getPaperSize(size: String): Int {
        var paperSize = 0
        paperSize = when (size) {
            "80 mm" -> 48
            "72 mm" -> 40
            else -> 32
        }
        return paperSize
    }

    fun getKetPrinter(type: PrintType): String {
        var ket = ""
        when (type) {
            PrintType.REPORT -> ket = "Laporan"
            PrintType.KITCHEN -> ket = "Dapur"
            PrintType.RECEIPT -> ket = "Kasir"
            PrintType.CHECKER -> ket = "Checker"
            PrintType.GOPAY -> {}
            PrintType.TEST_PRINT -> {}
        }
        return ket
    }

}