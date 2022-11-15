package com.bits.bee.bpmc.domain.printer.factory

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.printer.bt.bluebamboo.P25Session
import com.bits.bee.bpmc.domain.printer.bt.driver.BPrinterDriver
import com.bits.bee.bpmc.domain.printer.bt.hpm200.Hpm200Printer
import com.bits.bee.bpmc.presentation.service.BluetoothConnectService
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Utils
import kotlinx.coroutines.flow.first
import java.util.*
import javax.inject.Inject

/**
 * Created by wisnu on 17/11/16.
 */
class PrinterFactory @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager,
    private val bluetoothConnectService: BluetoothConnectService
){

    private var printername = ""

    fun initPrinter(context: Context?) {
        P25Session.instance.init(context)
        Hpm200Printer.instance.init(context)
        BPrinterDriver.instance.init(context)
    }

    @Throws(Exception::class)
    fun connect(name: String, address: String): Boolean {
        val isConnected = BPrinterDriver.instance.connect(address, name)
        printername = name

//        if(name.toLowerCase().contains("P25".toLowerCase())) {
//            isConnected = P25Session.instance.connect(address, name);
//            printername = name;
//        }else if(name.toLowerCase().contains("HP-M200".toLowerCase())) {
//            isConnected = Hpm200Printer.instance.connect(address, "HP-M200");
//            printername = name;
//        }else {
//            isConnected = BPrinterDriver.instance.connect(address, name);
//            printername = name;
//        }

//        else if (name.toLowerCase().contains("BlueTooth Printer".toLowerCase())){
//            isConnected = Eni58Printer.instance.connect(address, "Eni P58-M");
//        }else if(name.toLowerCase().contains("RP58BU".toLowerCase()) || name.toLowerCase().contains("RP58_BU".toLowerCase())){
//            isConnected = Eni58Printer.instance.connect(address, name);
//        }else if(name.toLowerCase().contains("printer001".toLowerCase())){
//            isConnected = Eni58Printer.instance.connect(address, name);
//        }
        return isConnected
    }

    fun disconnect() {
        if (P25Session.instance.isConnected) {
            P25Session.instance.disconnect()
        } else if (Hpm200Printer.instance.isConnected) {
            Hpm200Printer.instance.disconnect()
        } else if (BPrinterDriver.instance.isConnected) {
            BPrinterDriver.instance.disconnect()
        }
//        EventBus.getDefault().post(PrinterBluetoothEvent(""))
    }

    val isConnected: Boolean
        get() {
            var connected = false
            if (P25Session.instance.isConnected) {
                connected = true
            } else if (Hpm200Printer.instance.isConnected) {
                connected = true
            } else if (BPrinterDriver.instance.isConnected) {
                connected = true
            }
            return connected
        }

    suspend fun print(printer: Printer, toBePrint: String, fontType: String, alignMode: String, feed: Boolean) {
        goPrint(printer, toBePrint, fontType, alignMode, feed)
        Log.i("PRINTERFACTORY", "Printer Name: $printername")
    }

    suspend fun goPrint(printer: Printer, toBePrint: String, fontType: String, alignMode: String, feed: Boolean) {
        val alignment: ByteArray
        val font: ByteArray

        if (printername.lowercase(Locale.getDefault()).contains("P25".lowercase(Locale.getDefault()))) {
            alignment = if (alignMode.equals(BPMConstants.BPM_ALIGN_LEFT, ignoreCase = true))
                PrinterCommands.ESC_ALIGN_LEFT
            else if (alignMode.equals(BPMConstants.BPM_ALIGN_RIGHT, ignoreCase = true))
                PrinterCommands.ESC_ALIGN_RIGHT
            else
                PrinterCommands.ESC_ALIGN_CENTER

            font = when (fontType) {
                "LARGE" ->  PrinterCommands.SELECT_FONT_A
                "REGULAR" ->  PrinterCommands.SELECT_FONT_A
                "BOLD" ->  PrinterCommands.SELECT_FONT_EMPHASIZE
                "STRONG" ->  PrinterCommands.SELECT_FONT_DOUBLE_SIZE
                "UNDERLINE" ->  PrinterCommands.SELECT_FONT_UNDERLINE
                else -> PrinterCommands.SELECT_FONT_A
            }
        } else if (printername.lowercase(Locale.getDefault()).contains("RP58BU".lowercase(Locale.getDefault()))
            || printername.lowercase(Locale.getDefault()).contains("RP58_BU".lowercase(Locale.getDefault()))) {

            alignment = if (alignMode.equals(BPMConstants.BPM_ALIGN_LEFT, ignoreCase = true))
                PrinterCommands.ESC_ALIGN_LEFT
            else if (alignMode.equals(BPMConstants.BPM_ALIGN_RIGHT, ignoreCase = true))
                PrinterCommands.ESC_ALIGN_RIGHT
            else
                PrinterCommands.ESC_ALIGN_CENTER

            font = when (fontType) {
                "LARGE" ->  PrinterCommands.SELECT_FONT_A
                "REGULAR" ->  PrinterCommands.SELECT_FONT_A
                "BOLD" ->  PrinterCommands.SELECT_FONT_EMPHASIZE
                "STRONG" ->  PrinterCommands.SELECT_FONT_DOUBLE_SIZE
                "UNDERLINE" ->  PrinterCommands.SELECT_FONT_UNDERLINE
                else -> PrinterCommands.SELECT_FONT_A
            }
        } else {
            alignment = if (alignMode.equals(BPMConstants.BPM_ALIGN_LEFT, ignoreCase = true))
                PrinterCommands.ESC_ALIGN_LEFT
            else if (alignMode.equals(BPMConstants.BPM_ALIGN_RIGHT, ignoreCase = true))
                PrinterCommands.ESC_ALIGN_RIGHT
            else
                PrinterCommands.ESC_ALIGN_CENTER

            font = when (fontType) {
                "LARGE" ->  PrinterCommands.SELECT_FONT_A
                "REGULAR" ->  PrinterCommands.SELECT_FONT_A
                "BOLD" ->  PrinterCommands.SELECT_FONT_EMPHASIZE
                "STRONG" ->  PrinterCommands.SELECT_FONT_DOUBLE_SIZE
                "UNDERLINE" ->  PrinterCommands.SELECT_FONT_UNDERLINE
                else -> PrinterCommands.SELECT_FONT_A
            }
        }
        bluetoothConnectService.onEventPrintBluetooth(printer, toBePrint, font, alignment, feed)
    }

    fun resetPrintSetting() {
        BPrinterDriver.instance.refresh()
    }

    fun printImageGopay(bitmap_url: Bitmap, printer: Printer?) {
        try {
            val size = 255
            Log.i("TAG_RESOURCES", "width : " + bitmap_url.width)
            val data: Bitmap = Bitmap.createScaledBitmap(bitmap_url, size, size, true)
            Log.i("TAG_RESOURCES", "" + bitmap_url)
            val rawdata = Utils.decodeBitmap(data)
//            EventBus.getDefault().post(PrintImageBluetoothEvent(printer, rawdata))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val deviceName: String
        get() {
            val deviceName = if (P25Session.instance.isConnected) {
                P25Session.instance.name ?: ""
            } else if (Hpm200Printer.instance.isConnected) {
                Hpm200Printer.instance.name
            } else if (BPrinterDriver.instance.isConnected) {
                BPrinterDriver.instance.name
            } else {
                "no device connected"
            }
            return deviceName
        }

    val deviceAddress: String
        get() {
            val deviceAddress = if (P25Session.instance.isConnected) {
                P25Session.instance.address ?: ""
            } else if (Hpm200Printer.instance.isConnected) {
                Hpm200Printer.instance.address
            } else if (BPrinterDriver.instance.isConnected) {
                BPrinterDriver.instance.address
            } else {
                "no address or device connected"
            }
            return deviceAddress
        }

    val maxChar: Int
        get() {
            val maxChar = if (P25Session.instance.isConnected) {
                P25Session.MAXCHAR
            } else if (Hpm200Printer.instance.isConnected) {
                Hpm200Printer.MAXCHAR
            } else if (BPrinterDriver.instance.isConnected) {
                BPrinterDriver.MAXCHAR
            } else {
                32
            }
            return maxChar
        }

    suspend fun printImageLogo(context: Context, printer: Printer?) {

        val notaPreferences = beePreferenceManager.notaPreferences.first()
        val logoValueStatus = notaPreferences.isLoadLogo
        val imagesrc = notaPreferences.logoPath

        if (printer != null) {
            try {
                if (imagesrc.isNotEmpty() && logoValueStatus && imagesrc != BPMConstants.BPM_INIT_DEFAULT_LOGO) {
                    val bitmap: Bitmap = BitmapFactory.decodeFile(imagesrc)
                    val width = bitmap.width
                    val height = bitmap.height
                    val maxDimension = 200
                    var newHeight = height
                    var newWidth = width
                    if (height > maxDimension) {
                        newHeight = maxDimension
                        newWidth = newHeight * width / height
                    }
                    val data: Bitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
                    Log.i("TAG_RESOURCES", "" + bitmap)
                    Log.i("TAG_RESOURCES_img", "" + imagesrc)
                    val rawdata = Utils.decodeBitmap(data)
                    rawdata?.let {
                        bluetoothConnectService.onEventPrintImage(printer, rawdata)
                    }
//                    EventBus.getDefault().post(PrintImageBluetoothEvent(printer, rawdata))
                }

                if (imagesrc == BPMConstants.BPM_INIT_DEFAULT_LOGO && logoValueStatus) {
                    val data = BitmapFactory.decodeResource(context.resources, R.drawable.image_logo_beepos)
                    val dataimage: Bitmap = Bitmap.createScaledBitmap(data, 400, 60, true)
                    Log.i("TAG_RESOURCES", "" + data)
                    Log.i("TAG_RESOURCES_img", "" + imagesrc)
                    if (data != null) {
                        val rawdata = Utils.decodeBitmap(dataimage)
//                        EventBus.getDefault().post(PrintImageBluetoothEvent(printer, rawdata))
                    } else
                        Log.e("PRINTERFACTORY", "Read Bitmap File Failed")
                }
                if (imagesrc.isEmpty() && !logoValueStatus) {
                    val data: Bitmap =
                        BitmapFactory.decodeResource(context.resources, R.drawable.image_logo_beepos)
                    val rawdata = Utils.decodeBitmap(data)
                    rawdata?.let {
                        bluetoothConnectService.onEventPrintImage(printer, rawdata)
                    }
//                    EventBus.getDefault().post(PrintImageBluetoothEvent(printer, rawdata))
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun kickDrawerOut(printer: Printer?) {
//        EventBus.getDefault().post(KickDrawerOutEvent(printer))
    }
}