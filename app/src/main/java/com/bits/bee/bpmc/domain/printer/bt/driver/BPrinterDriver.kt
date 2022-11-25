package com.bits.bee.bpmc.domain.printer.bt.driver

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.graphics.Bitmap
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.bits.bee.bpmc.domain.printer.factory.PrinterCommands
import com.bits.bee.bpmc.domain.printer.model.PrinterData
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Utils
import com.zj.btsdk.BluetoothService
import com.zj.btsdk.PrintPic
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.experimental.or

/**
 * Created by wisnu on 27/11/16.
 */
class BPrinterDriver {

    var name = ""
    var address = ""

    private lateinit var mService: BluetoothService
    private var mDevice: BluetoothDevice? = null
    var isConnected = false

    private var mContext: Context? = null

    private var callBackPrinter: CallBackPrinter? = null
    private var mHandler: BtHandler? = null
    private val printerDataList: MutableList<PrinterData> = ArrayList()

    constructor()

    constructor(context: Context?) {
        mHandler = BtHandler(Looper.getMainLooper())
        mContext = context
        mService = BluetoothService(mContext, mHandler)
    }

    //v2
    interface CallBackPrinter {
        fun onConnected(printerDriver: BPrinterDriver?, address: String?)
        fun onConnectedFailed(address: String?)
        fun onDisconnected(printerDriver: BPrinterDriver?)
    }

    //v2
    fun setCallBackPrinter(callBackPrinter: CallBackPrinter?) {
        this.callBackPrinter = callBackPrinter
    }

    fun init(context: Context?) {
        mContext = context
    }

    val isStateConected: Boolean
        get() = mService.state == 3

    @Throws(Exception::class)
    fun connect(address: String, name: String): Boolean {
        this.address = address
        this.name = name
        var timeout: Long = 0
        mDevice = mService.getDevByMac(address)
        disconnect()
        Thread.sleep(1000)
        mService.connect(mDevice!!)
        while (!isConnected && timeout <= BPMConstants.BPM_DEFAULT_THREAD_TIMEOUT) {
            timeout++
        }
        if (isConnected) {
            println("CONNECTED")
        } else {
            println("CONNECT FAILED")
        }
        println("isconnected=$isConnected")
        return isConnected
    }

    fun disconnect() {
        mService.stop()
    }

    fun print(toBePrinted: String) {
        mService.write(PrinterCommands.SELECT_FONT_B)
        mService.write(PrinterCommands.ESC_ALIGN_LEFT)
        mService.write(PrinterCommands.LF)
        mService.sendMessage(toBePrinted.trimIndent(), "CMD")
    }

    fun print(toBePrinted: String, fontType: ByteArray?) {
        mService.write(fontType)
        mService.write(PrinterCommands.LF)
        mService.sendMessage(toBePrinted.trimIndent(), "CMD")
    }

    fun print(toBePrinted: String, fontType: ByteArray?, alignMode: ByteArray?) {
        val format = byteArrayOf(27, 33, 0)
        val arrayOfByte1 = byteArrayOf(27, 33, 0)
        format[2] = (0x10 or arrayOfByte1[2].toInt()).toByte()
        val arrOfStr = toBePrinted.split("\n".toRegex()).toTypedArray()
        for (s in arrOfStr) {
            if (s.isNotEmpty()) {
                if (s.substring(0, 1) == "^") {
                    mService.write(format)
                    mService.write(s.substring(1).toByteArray())
                    mService.write(PrinterCommands.LF)
                } else {
                    mService.write(fontType)
                    mService.write(alignMode)
                    mService.write(s.toByteArray())
                    mService.write(PrinterCommands.LF)
                }
            } else {
                mService.write(PrinterCommands.LF)
            }
        }
    }

    fun printFeed() {
        mService.write(PrinterCommands.LF)
        mService.write(PrinterCommands.LF)
        mService.write(PrinterCommands.LF)
        mService.write(PrinterCommands.LF)
        mService.write(PrinterCommands.CUT_PAPER)
    }

    fun refresh() {
        mService.write(PrinterCommands.INIT)
        mService.write(PrinterCommands.LF)
    }

    fun printImage(imagedata: ByteArray?) {
        mService.write(PrinterCommands.ESC_ALIGN_CENTER)
        mService.write(imagedata)
    }

    fun printImage(bmp: Bitmap) {
        Utils.convertBitmap(bmp)
        //        mService.write(PrinterCommands.SELECT_BIT_IMAGE_MODE);
//        mService.write(PrinterCommands.SET_LINE_SPACING_24);
        var offset = 0
        while (offset < bmp.height) {
            mService.write(PrinterCommands.SELECT_BIT_IMAGE_MODE)
            for (x in 0 until bmp.width) {
                for (k in 0..2) {
                    var slice: Byte = 0
                    for (b in 0..7) {
                        val y = (offset / 8 + k) * 8 + b
                        val i = y * bmp.width + x
                        var v = false
                        if (i < Utils.getDots()!!.length()) {
                            v = Utils.getDots()!!.get(i)
                        }
                        slice = slice or ((if (v) 1 else 0) shl 7 - b).toByte()
                    }
                    mService.write(byteArrayOf(slice))
                }
            }
            offset += 24
            mService.write(PrinterCommands.FEED_LINE)
            mService.write(PrinterCommands.FEED_LINE)
            mService.write(PrinterCommands.FEED_LINE)
            mService.write(PrinterCommands.FEED_LINE)
            mService.write(PrinterCommands.FEED_LINE)
            mService.write(PrinterCommands.FEED_LINE)
        }
        mService.write(PrinterCommands.SET_LINE_SPACING_30)
    }

    fun printImageWithTab(imagedata: ByteArray) {
        val pg = PrintPic()
        pg.initCanvas(400)
        pg.initPaint()
        pg.drawImage(0F, 0F, Environment.getExternalStorageDirectory().absolutePath + "/Londree/struk_londree.png")
        val sendData: ByteArray = pg.printDraw()
        mService.write(PrinterCommands.ESC_ALIGN_CENTER)
        mService.write(sendData)
        printText(imagedata)
    }

    fun printImageGopay(imagedata: ByteArray) {
        printText(imagedata)
        printNewLine()
        printNewLine()
    }

    //print byte[]
    private fun printText(msg: ByteArray) {
        // Print normal text
//        mService.write(PrinterCommands.SELECT_BIT_IMAGE_MODE_CENTER);
        mService.write(PrinterCommands.ESC_ALIGN_CENTER)
        //        mService.write(PrinterCommands.ESC_HORIZONTAL_CENTER);
        mService.write(msg)
        printNewLine()
    }

    //print new line
    private fun printNewLine() {
        mService.write(PrinterCommands.FEED_LINE)
    }

    fun printImg(path: String?) {
        var xPosBigDecimal = BigDecimal(MAXCHAR)
        xPosBigDecimal = xPosBigDecimal.divide(BigDecimal(2), RoundingMode.HALF_UP)
        val xPos = xPosBigDecimal.toFloat()
        try {
            var sendData: ByteArray? = null
            val pg = PrintPic()
            pg.initCanvas(384)
            pg.initPaint()
            pg.drawImage(xPos, 0F, path)
            sendData = pg.printDraw()
            mService.write(sendData) //��ӡbyte�����
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //    public void printImageWithTab(byte[] imagedata) {
    //        mService.write(PrinterCommands.ESC_HORIZONTAL_CENTER);
    //        mService.write(PrinterCommands.HT);
    //        mService.write(imagedata);
    //    }
    fun disconnectPrint() {
        mDevice = null
        mService.stop()
    }

    inner class BtHandler(looper: Looper?) : Handler(looper!!) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                BluetoothService.MESSAGE_STATE_CHANGE -> {
                    when (msg.arg1) {
                        BluetoothService.STATE_CONNECTED -> {
                            isConnected = true
                            callBackPrinter!!.onConnected(this@BPrinterDriver, address)
                        }
                        BluetoothService.STATE_CONNECTING -> {}
                        BluetoothService.STATE_LISTEN, BluetoothService.STATE_NONE -> {}
                    }
                    Log.i("BPRINTERDRIVER", msg.arg1.toString())
                }
                BluetoothService.MESSAGE_CONNECTION_LOST -> {
                    disconnectPrint()
                    isConnected = false
                    callBackPrinter!!.onDisconnected(this@BPrinterDriver)
                    if (null != mContext) {
                        Log.i("BPRINTERDRIVER", msg.what.toString())
                    }
                }
                BluetoothService.MESSAGE_UNABLE_CONNECT -> {
                    isConnected = false
                    callBackPrinter!!.onConnectedFailed(address)
                    if (null != mContext) {
                        Log.i("BPRINTERDRIVER", msg.what.toString())
                    }
                }
            }
        }
    }

    //    private class ConnectedThread extends Thread{
    //        private boolean isRunning = true;
    //
    //        @Override
    //        public void run() {
    //            ConnectedThread connectedThread;
    //            ConnectedThread connectedThread2 = this;
    //
    //            while (connectedThread2.isRunning){
    //
    //
    //            }
    //
    //        }
    //
    //        private void cancel(){
    //
    //        }
    //
    //    }
    fun addTaskToPrint(data: PrinterData) {
        if (!printerDataList.contains(data)) printerDataList.add(data)
    }

    val task: List<PrinterData>
        get() = printerDataList

    fun removeTask(data: PrinterData) {
        if (printerDataList.contains(data)) printerDataList.remove(data)
    }

    fun kickDrawerOut() {
        try {
            val command = "$1B$70$30$19\$FA"
            mService.write(Utils.convertHex(command).toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val MAXCHAR = 32
        private var singleton: BPrinterDriver? = null
        val instance: BPrinterDriver
            get() {
                if (singleton == null) {
                    singleton = BPrinterDriver()
                }
                return singleton!!
            }
    }
}