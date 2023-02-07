package com.bits.bee.bpmc.domain.printer.wifi

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Utils
import kotlinx.coroutines.flow.first
import java.io.IOException
import java.io.PrintWriter
import java.net.Socket
import java.net.UnknownHostException
import javax.inject.Inject

class WifiPrinterHandler @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) {

    fun print(toPrint: String, ipAddress: String) {
        printText(ipAddress, toPrint)
        feed(ipAddress)
    }

    fun feed(ipAddress: String) {
        printText(ipAddress, "")
    }

    fun printImage(printer: Printer, bitmap: Bitmap) {
        try {
            var height = 250
            var width = 250
            when (printer.size) {
                "80 mm" -> {
                    width = 350
                    height = 350
                }
                "72 mm" -> {
                    width = 275
                    height = 275
                }
            }
            val dataimage: Bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true)
            Log.i("TAG_RESOURCES", "" + dataimage)
            val rawdata = Utils.decodeBitmap(dataimage)
            printImage(printer.address, rawdata)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun printImageLogo(context: Context, printer: Printer) {
        val notaPreferences = beePreferenceManager.notaPreferences.first()
        val logoValueStatus = notaPreferences.isLoadLogo
        val imagesrc = notaPreferences.logoPath

        var height = 60
        var width = 400
        when (printer.size) {
            "80 mm" -> {
                width = 550
                height = 100
            }
            "72 mm" -> width = 475
            else -> width = 400
        }
        try {
            if (imagesrc.isNotEmpty() && logoValueStatus && imagesrc != BPMConstants.BPM_INIT_DEFAULT_LOGO) {
                val bitmap: Bitmap = BitmapFactory.decodeFile(imagesrc)
                val heightBitmap: Int = bitmap.height
                val widthBitmap: Int = bitmap.width
                val maxDimension = 200
                var newHeight = heightBitmap
                var newWidth = widthBitmap
                if (height > maxDimension) {
                    newHeight = maxDimension
                    newWidth = newHeight * widthBitmap / heightBitmap
                }
                val data: Bitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
                Log.i("TAG_RESOURCES", "" + bitmap)
                Log.i("TAG_RESOURCES_img", "" + imagesrc)
                val rawdata = Utils.decodeBitmap(data)
                printImage(printer.address, rawdata)
            }
            if (imagesrc == BPMConstants.BPM_INIT_DEFAULT_LOGO && logoValueStatus) {
                val data = BitmapFactory.decodeResource(context.resources, R.drawable.image_logo_beepos)
                val dataimage = Bitmap.createScaledBitmap(data, width, height, true)
                Log.i("TAG_RESOURCES", "" + data)
                Log.i("TAG_RESOURCES_img", "" + imagesrc)
                val rawdata = Utils.decodeBitmap(dataimage)
                printImage(printer.address, rawdata)
            }
            if (imagesrc.isEmpty() && !logoValueStatus) {
                val data: Bitmap =
                    BitmapFactory.decodeResource(context.resources, R.drawable.image_logo_beepos)
                val rawdata = Utils.decodeBitmap(data)
                printImage(printer.address, rawdata)
            }
            feed(printer.address)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun printHeaderGopay(context: Context, printer: Printer) {
        try {
            var height = 60
            var width = 400
            when (printer.size) {
                "80 mm" -> {
                    width = 550
                    height = 100
                }
                "72 mm" -> width = 475
                else -> width = 400
            }
            val data: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.image_logo_beepos)
            val dataimage: Bitmap = Bitmap.createScaledBitmap(data, width, height, true)
            Log.i("TAG_RESOURCES", "" + dataimage)
            val rawdata = Utils.decodeBitmap(data)
            printImage(printer.address, rawdata)
            feed(printer.address)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun printText(socket : String, string : String) {
        try {
            Log.i("INFO", "PRINT WIFI")
            val socket = Socket(socket, 9100)
            val oStream = PrintWriter(socket.getOutputStream())
            oStream.println(string)
            oStream.println("\n\n")
            oStream.close()
            socket.close()
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun printImage(socket : String, rawData: ByteArray?){
        try {
            Log.i("INFO", "PRINT WIFI")
            val socket = Socket(socket, 9100)
            val outputStream = socket.getOutputStream()
            outputStream.write(rawData)
            outputStream.flush()
            try {
                Thread.sleep(12000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            outputStream.close()
            socket.close()
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}