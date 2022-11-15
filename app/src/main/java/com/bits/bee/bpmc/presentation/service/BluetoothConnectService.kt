package com.bits.bee.bpmc.presentation.service

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.printer.bt.driver.BPrinterDriver
import com.bits.bee.bpmc.domain.printer.model.PrinterData
import com.bits.bee.bpmc.domain.repository.PrinterRepository
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aldi on 08/11/22
 */
@Singleton
class BluetoothConnectService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val printerRepository: PrinterRepository
) : BPrinterDriver.CallBackPrinter {

    private var isConnecting = false
    private var statePrinterBluetooth = 0
    private var toast: Toast? = null
    private var mBluetoothAdapter: BluetoothAdapter
    private var mBluetoothManager: BluetoothManager = context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager

    init {
        mBluetoothAdapter = mBluetoothManager.adapter
    }

//    override fun onCreate() {
//        super.onCreate()
//        isServiceRunning = true
//        isConnecting = false
//        mapPrinter = HashMap()
//    }
//
//    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
//        super.onStartCommand(intent, flags, startId)
//        if (mBluetoothAdapter.isEnabled) {
//            onEventConnectAllPrinter(0)
//        }
//        return START_STICKY
//    }
//
//    override fun onTaskRemoved(rootIntent: Intent) {
//        stopSelf()
//        Log.e("stopservice", "stopServices")
//        super.onTaskRemoved(rootIntent)
//    }

    suspend fun onEventConnectAllPrinter(task : Int) {
        if (!isConnecting) {
            isConnecting = true
            when (task) {
                1 -> disconnectAllPrinter()
                else ->  {
                    val printerList = printerRepository.getPrinterTipe(BPMConstants.BPM_PRINTER_BLUETOOH).first()

                    for (printer in printerList) {
                        connectPrinter(printer)
                    }
                }
            }
            isConnecting = false
        }
    }

    fun onEventConnectPrinter(printer : Printer, connection : Int) {
        when (connection) {
            0 -> connectPrinter(printer)
            1 -> disconnectPrinter(printer)
        }
    }

    suspend fun onKickDrawerOut() {
        val printerList = printerRepository.getPrinterTipe(BPMConstants.BPM_PRINTER_BLUETOOH).first()
        for (printer in printerList) {
            kickDrawerOut(printer)
        }
    }

    suspend fun onEventPrintBluetooth(printer: Printer?, text : String, font : ByteArray, mode : ByteArray, isFeed : Boolean = false) {
        if (printer == null) {
            val printerList = printerRepository.getActiveReceiptList().first()
            for (printer in printerList) {
                printText(printer, text, font, mode)
                if (isFeed) printFeed(printer)
            }
        } else {
            printText(printer, text, font, mode)
            if (isFeed)
                printFeed(printer)
        }
    }

    fun onEventPrintImage(printer : Printer, image : ByteArray) {
        printImage(printer, image)
    }

    private fun connectPrinter(printer: Printer) {
        if (mBluetoothAdapter.isEnabled) {
            var printerDriver: BPrinterDriver?
            val obj = printer.address
            printerDriver = mapPrinter[obj]
            if (printerDriver == null) {
                printerDriver = BPrinterDriver(context)
                printerDriver.setCallBackPrinter(this)
                printerDriver.connect(printer.address, printer.printerName)
                statePrinterBluetooth = 1
            } else {
                if (printerDriver.isStateConected) {
                    Log.i("Printer", "Connected" + printer.address)
                } else {
                    if (printerDriver.isConnected)
                        printerDriver.disconnect()

                    mapPrinter.remove(obj)
                    printerDriver = BPrinterDriver(context)
//                    printerDriver.setCallBackPrinter(this)
                    printerDriver.connect(printer.address, printer.printerName)

                    statePrinterBluetooth = 1
                }
            }
        }
    }

    private fun disconnectPrinter(printer: Printer) {
        val obj: Any = printer.address
        val bPrinterDriver = mapPrinter[obj]
        if (bPrinterDriver != null) {
            if (bPrinterDriver.isStateConected) {
                bPrinterDriver.disconnect()
            }
            mapPrinter.remove(obj)
            return
        }
        Log.i("Printer", "Printer tidak ditemukan")
        showToast("Printer tidak ditemukan")
    }

    private fun disconnectAllPrinter() {
        for (pr in mapPrinter.values) {
            pr.disconnect()
        }
        mapPrinter.clear()
    }

    private fun showToast(str: String) {
        toast = Toast.makeText(context, str, Toast.LENGTH_LONG)
        toast!!.show()
    }

    private fun printText(printer: Printer, toBePrint: String?, fontType: ByteArray, alignMode: ByteArray) {
        if (mBluetoothAdapter.isEnabled) {
            val obj: Any = printer.address
            val data = PrinterData()
            data.printer = printer
            data.toPrint = toBePrint
            data.fontType = fontType
            data.alignMode = alignMode
            var bPrinterDriver = mapPrinter[obj]
            if (bPrinterDriver != null) {
                if (!bPrinterDriver.isStateConected) {
                    bPrinterDriver.disconnect()
                    mapPrinter.remove(obj)
                    bPrinterDriver = BPrinterDriver(context)
                    bPrinterDriver.init(context)
                    bPrinterDriver.setCallBackPrinter(this)
                    bPrinterDriver.addTaskToPrint(data)
                    try {
                        bPrinterDriver.connect(printer.address, printer.printerName)
                        bPrinterDriver.addTaskToPrint(data)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                    bPrinterDriver.refresh()
                    bPrinterDriver.print(toBePrint!!, fontType, alignMode)
                    bPrinterDriver.removeTask(data)
                }
            }
        }
    }

    private fun printFeed(printer: Printer) {
        if (mBluetoothAdapter.isEnabled) {
            val obj: Any = printer.address
            var bPrinterDriver = mapPrinter[obj]
            if (bPrinterDriver != null) {
                if (!bPrinterDriver.isStateConected) {
                    bPrinterDriver.disconnect()
                    mapPrinter.remove(obj)
                    bPrinterDriver = BPrinterDriver(context)
                    bPrinterDriver.init(context)
                    bPrinterDriver.setCallBackPrinter(this)
                    //                bPrinterDriver.addTaskToPrint(data);
                    try {
                        bPrinterDriver.connect(printer.address, printer.printerName)
                        //                    bPrinterDriver.addTaskToPrint(data);
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                    bPrinterDriver.refresh()
                    bPrinterDriver.printFeed()
                }
            }
        }
    }

    private fun printImage(printer: Printer, dataImage: ByteArray) {
        if (mBluetoothAdapter.isEnabled) {
            val obj: Any = printer.address
            val printername: String = printer.printerName
            var bPrinterDriver = mapPrinter[obj]
            if (bPrinterDriver != null) {
                if (!bPrinterDriver.isStateConected) {
                    bPrinterDriver.disconnect()
                    mapPrinter.remove(obj)
                    bPrinterDriver = BPrinterDriver()
                    bPrinterDriver.init(context)
                    bPrinterDriver.setCallBackPrinter(this)
                    try {
                        bPrinterDriver.connect(printer.address, printer.printerName)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                    if (printername.contains("P25")) {
                        bPrinterDriver.printImage(dataImage)
                    } else {
                        bPrinterDriver.printImageWithTab(dataImage)
                    }
                }
            }
        }
    }

    fun getMapPrinterByAddress(address: String?): BPrinterDriver? {
        return mapPrinter[address]
    }

    override fun onConnected(printerDriver: BPrinterDriver?, address: String?) {
        showToast("Terhubung di port $address")
        printerDriver!!.print("Test Print " + printerDriver.name)
        mapPrinter[address ?: ""] = printerDriver
        if (printerDriver.task.isNotEmpty()) {
            for (data in printerDriver.task) {
                printText(data.printer!!, data.toPrint, data.fontType!!, data.alignMode!!)
            }
        }
        statePrinterBluetooth = 0
    }

    override fun onConnectedFailed(address: String?) {
        Log.i("onConnectedFailed: ", "Gagal Terhubung ke port $address")
        statePrinterBluetooth = 0
    }

    override fun onDisconnected(printerDriver: BPrinterDriver?) {
        showToast("Koneksi dengan printer " + printerDriver!!.name + " terputus!")
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        isServiceRunning = false
//        unregisterReceiver(mBroadcastReceiver1)
//    }

    private val mBroadcastReceiver1: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (action == BluetoothAdapter.ACTION_STATE_CHANGED) {
                when (intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)) {
                    BluetoothAdapter.STATE_OFF -> {}
                    BluetoothAdapter.STATE_TURNING_OFF -> {}
                    BluetoothAdapter.STATE_ON -> {}
                    BluetoothAdapter.STATE_TURNING_ON -> {}
                }
            }
        }
    }

    private fun kickDrawerOut(printer: Printer) {
        if (mBluetoothAdapter.isEnabled) {
            val obj: Any = printer.address
            val printername = printer.printerName
            mapPrinter[obj]?.kickDrawerOut()
        }
    }

    companion object {
        private var mapPrinter = HashMap<String, BPrinterDriver>()
        private val mBluetoothConnectService: BluetoothConnectService? = null

        fun getPrinter(printer: Printer): BPrinterDriver {
            return if (mapPrinter[printer.address] == null) BPrinterDriver() else mapPrinter[printer.address]!!
        }

        fun disconnect() {
            for (printerDriver in mapPrinter.values) {
                printerDriver.disconnectPrint()
            }
        }

        val statusPrinter: Boolean
            get() {
                var stat = true
                if (mapPrinter.size <= 0) {
                    stat = false
                } else {
                    for (printerDriver in mapPrinter.values) {
                        if (!printerDriver.isConnected) stat = false
                    }
                }
                return stat
            }
    }
}