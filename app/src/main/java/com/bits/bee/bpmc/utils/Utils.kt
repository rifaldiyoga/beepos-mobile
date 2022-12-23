package com.bits.bee.bpmc.utils

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.Log
import com.bits.bee.bpmc.R
import com.bluebamboo.p25library.util.StringUtil.hexStringToBytes
import kotlinx.coroutines.flow.first
import java.io.File
import java.util.*


/**
 * Created by aldi on 01/03/22.
 */
class Utils {

    companion object {

        private var dots : BitSet? = null

        private const val hexStr = "0123456789ABCDEF"
        private val binaryArray = arrayOf(
            "0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"
        )
        

        suspend fun getScreenResolution(beePreferenceManager: BeePreferenceManager, activity: Activity): String {
            var screenDevice : String
            val metrics = DisplayMetrics()
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                val display = activity.display
                display?.getRealMetrics(metrics)
            } else {
                @Suppress("DEPRECATION")
                val display = activity.windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(metrics)
            }
            val widthPixels = metrics.widthPixels
            val heightPixels = metrics.heightPixels
            val widthDpi = metrics.xdpi
            val heightDpi = metrics.ydpi
            val widthInches = widthPixels / widthDpi
            val heightInches = heightPixels / heightDpi
            val diagonalInches = Math.sqrt((widthInches * widthInches + heightInches * heightInches).toDouble())
//            val inc = diagonalInches.toString().substring(0, 3)

            //inci layar
            val orientation = beePreferenceManager.posPreferences.first().orientasi

            val isChange = beePreferenceManager.posPreferences.first().isChangeOrientasi

            if (diagonalInches < 6.5 && !isChange) {
                screenDevice = BPMConstants.SCREEN_POTRAIT
                beePreferenceManager.updatePosPreferences(
                    beePreferenceManager.posPreferences.first().copy(
                        orientasi = BPMConstants.SCREEN_POTRAIT
                    )
                )
            } else if (diagonalInches >= 6.5 && !isChange) {
                screenDevice = BPMConstants.SCREEN_LANDSCAPE
                beePreferenceManager.updatePosPreferences(
                    beePreferenceManager.posPreferences.first().copy(
                        orientasi = BPMConstants.SCREEN_LANDSCAPE
                    )
                )
            } else {
                if (orientation == BPMConstants.SCREEN_POTRAIT) {
                    screenDevice = BPMConstants.SCREEN_POTRAIT
                    beePreferenceManager.updatePosPreferences(
                        beePreferenceManager.posPreferences.first().copy(
                            orientasi = BPMConstants.SCREEN_POTRAIT
                        )
                    )
                } else {
                    screenDevice = BPMConstants.SCREEN_LANDSCAPE
                    beePreferenceManager.updatePosPreferences(
                        beePreferenceManager.posPreferences.first().copy(
                            orientasi = BPMConstants.SCREEN_LANDSCAPE
                        )
                    )
                }
            }
//            screenDevice = BPMConstants.SCREEN_POTRAIT
//            beePreferenceManager.updatePosPreferences(
//                beePreferenceManager.posPreferences.first().copy(
//                    orientasi = BPMConstants.SCREEN_POTRAIT
//                )
//            )
            return screenDevice
        }

        fun isValidEmail(target : CharSequence) : Boolean {
            return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }

        fun getVersionName(context: Context): String {
            return context.packageManager.getPackageInfo(context.packageName, 0).versionName
        }

        fun deleteApplicationData(context: Context) {
            try {
                val packageName = context.applicationContext.packageName
                val runtime = Runtime.getRuntime()
                runtime.exec("pm clear $packageName")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun clearApplicationData(context: Context) {
            val cacheDirectory: File = context.cacheDir
            val applicationDirectory = cacheDirectory.parent?.let { File(it) }
            if (applicationDirectory != null && applicationDirectory.exists()) {
                val fileNames: Array<String> = applicationDirectory.list() as Array<String>
                for (fileName in fileNames) {
                    if (fileName != "lib") {
                        deleteFile(File(applicationDirectory, fileName))
                    }
                }
            }
        }

        private fun deleteFile(file: File?): Boolean {
            var deletedAll = true
            if (file != null) {
                if (file.isDirectory) {
                    val children: Array<String> = file.list()
                    for (i in children.indices) {
                        deletedAll = deleteFile(File(file, children[i])) && deletedAll
                    }
                } else {
                    deletedAll = file.delete()
                }
            }
            return deletedAll
        }

        fun getTermType(context: Context, value : String) : String {
            return when(value){
                BPMConstants.BPM_DEFAULT_TYPE_TUNAI -> BPMConstants.BPM_DEFAULT_TYPE_TUNAI
                BPMConstants.DEBIT_CARD_CODE -> context.getString(R.string.kartu_debit)
                BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY -> context.getString(R.string.gopay)
                else -> context.getString(R.string.kartu_kredit)
            }
        }

        fun convertBitmap(inputBitmap: Bitmap): String? {
            var mWidth = 0
            var mHeight = 0
            var mStatus = ""
            mWidth = inputBitmap.width
            mHeight = inputBitmap.height
            convertArgbToGrayscale(inputBitmap, mWidth, mHeight)
            mStatus = "ok"
            return mStatus
        }

        private fun convertArgbToGrayscale(bmpOriginal: Bitmap, width: Int, height: Int) {
            var pixel: Int
            var k = 0
            var B = 0
            var G = 0
            var R = 0
            dots = BitSet()
            try {
                for (x in 0 until height) {
                    for (y in 0 until width) {
                        // get one pixel color
                        pixel = bmpOriginal.getPixel(y, x)

                        // retrieve color of all channels
                        R = Color.red(pixel)
                        G = Color.green(pixel)
                        B = Color.blue(pixel)
                        // take conversion up to one single value by calculating
                        // pixel intensity.
                        B = (0.299 * R + 0.587 * G + 0.114 * B).toInt()
                        G = B
                        R = G
                        // set bit into bitset, by calculating the pixel's luma
                        if (R < 55) {
                            dots!!.set(k) //this is the bitset that i'm printing
                        }
                        k++
                    }
                }
            } catch (e: java.lang.Exception) {
                Log.e("BITMAP-CONVERSION", e.toString())
            }
        }

        fun getDots(): BitSet? {
            return dots
        }

        fun convertHex(hex: String): String {
            var decimalString = ""
            val strHex = hex.split("\\$".toRegex()).toTypedArray()
            val decHex = IntArray(strHex.size - 1)
            val charHex = CharArray(strHex.size - 1)
            for (i in strHex.indices) {
                if (i == 0) continue
                decHex[i - 1] = strHex[i].toInt(16)
                charHex[i - 1] = decHex[i - 1].toChar()
                decimalString += charHex[i - 1]
            }
            return decimalString
        }

        fun decodeBitmap(bmp: Bitmap): ByteArray? {
            val bmpWidth = bmp.width
            val bmpHeight = bmp.height
            val list: MutableList<String> = ArrayList() //binaryString list
            var sb: StringBuffer
            var bitLen = bmpWidth / 8
            val zeroCount = bmpWidth % 8
            var zeroStr = ""
            if (zeroCount > 0) {
                bitLen = bmpWidth / 8 + 1
                for (i in 0 until 8 - zeroCount) {
                    zeroStr += "0"
                }
            }
            for (i in 0 until bmpHeight) {
                sb = StringBuffer()
                for (j in 0 until bmpWidth) {
                    val color = bmp.getPixel(j, i)
                    val r = color shr 8 and 0xff
                    val g = color shr 8 and 0xff
                    val b = color and 0xff

                    // if color close to white，bit='0', else bit='1'
                    if (r > 160 && g > 160 && b > 160) sb.append("0") else sb.append("1")
                }
                if (zeroCount > 0) {
                    sb.append(zeroStr)
                }
                list.add(sb.toString())
            }
            val bmpHexList: List<String> = binaryListToHexStringList(list)
            val commandHexString = "1D763000"
            var widthHexString = Integer
                .toHexString(if (bmpWidth % 8 == 0) bmpWidth / 8 else bmpWidth / 8 + 1)
            if (widthHexString.length > 2) {
                Log.e("decodeBitmap error", " width is too large")
                return null
            } else if (widthHexString.length == 1) {
                widthHexString = "0$widthHexString"
            }
            widthHexString += "00"
            var heightHexString = Integer.toHexString(bmpHeight)
            if (heightHexString.length > 2) {
                Log.e("decodeBitmap error", " height is too large")
                return null
            } else if (heightHexString.length == 1) {
                heightHexString = "0$heightHexString"
            }
            heightHexString += "00"
            val commandList: MutableList<String> = ArrayList()
            commandList.add(commandHexString + widthHexString + heightHexString)
            commandList.addAll(bmpHexList)
            return hexList2Byte(commandList)
        }

        fun hexList2Byte(list: List<String?>): ByteArray {
            val commandList: MutableList<ByteArray> =
                ArrayList()
            for (hexStr in list) {
                commandList.add(hexStringToBytes(hexStr))
            }
            return sysCopy(commandList)
        }


        private fun charToByte(c: Char): Byte {
            return "0123456789ABCDEF".indexOf(c).toByte()
        }

        fun sysCopy(srcArrays: List<ByteArray>): ByteArray {
            var len = 0
            for (srcArray in srcArrays) {
                len += srcArray.size
            }
            val destArray = ByteArray(len)
            var destLen = 0
            for (srcArray in srcArrays) {
                System.arraycopy(srcArray, 0, destArray, destLen, srcArray.size)
                destLen += srcArray.size
            }
            return destArray
        }

        fun binaryListToHexStringList(list: List<String>): List<String> {
            val hexList: MutableList<String> = ArrayList()
            for (binaryStr in list) {
                val sb = StringBuffer()
                var i = 0
                while (i < binaryStr.length) {
                    val str = binaryStr.substring(i, i + 8)
                    val hexString: String = myBinaryStrToHexString(str)
                    sb.append(hexString)
                    i += 8
                }
                hexList.add(sb.toString())
            }
            return hexList
        }


        fun myBinaryStrToHexString(binaryStr: String): String {
            var hex = ""
            val f4 = binaryStr.substring(0, 4)
            val b4 = binaryStr.substring(4, 8)
            for (i in binaryArray.indices) {
                if (f4 == binaryArray[i]) hex += hexStr.substring(i, i + 1)
            }
            for (i in binaryArray.indices) {
                if (b4 == binaryArray[i]) hex += hexStr.substring(i, i + 1)
            }
            return hex
        }

        fun isMyServiceRunning(context: Context, cls: Class<*>): Boolean {
            for (runningServiceInfo in (context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).getRunningServices(Int.MAX_VALUE)) {
                if (context.applicationContext.packageName == runningServiceInfo.service.packageName && cls.name == runningServiceInfo.service.className) {
                    return true
                }
            }
            return false
        }

    }

}