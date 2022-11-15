package com.bits.bee.bpmc.domain.printer.bt.hpm200

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.os.Handler
import android.os.Message
import com.bits.bee.bpmc.utils.BPMConstants
import com.zj.btsdk.BluetoothService

/**
 * Created by wisnu on 27/11/16.
 */
class Hpm200Printer {
    var name = ""
    var address = ""
    private var mService: BluetoothService? = null
    private var mDevice: BluetoothDevice? = null
    var isConnected = false
    private var mContext: Context? = null
    fun init(context: Context?) {
        mContext = context
        if (mService == null) {
            mService = BluetoothService(mContext, mHandler)
        }
    }

    @Throws(Exception::class)
    fun connect(address: String, name: String): Boolean {
        this.address = address
        this.name = name
        var timeout: Long = 0
        mService?.let {
            mDevice = it.getDevByMac(address)
            disconnect()
            it.connect(mDevice)
        }
        while (!isConnected && timeout <= BPMConstants.BPM_DEFAULT_THREAD_TIMEOUT) {
            println("CONNECTING")
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
        if(mService != null)
            mService!!.stop()
    }

    fun print(toBePrinted: String) {
        if(mService != null)
            mService!!.sendMessage(toBePrinted.trimIndent(), "CMD")
    }

    fun printImage(imagedata: ByteArray?) {
        if(mService != null) {
            mService!!.write(imagedata)
            val tail = byteArrayOf(10.toByte(), 13.toByte(), 0.toByte())
            mService!!.write(tail)
        }
    }

    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                BluetoothService.MESSAGE_STATE_CHANGE -> {
                    when (msg.arg1) {
                        BluetoothService.STATE_CONNECTED -> {
                            isConnected = true
                            if (null != mContext) {
//                                try {
//                                    DialogBuilder.showInfoDialog(
//                                        mContext, "Informasi",
//                                        "Printer " + name + "Telah Terhubung"
//                                    )
//                                } catch (e: Exception) {
//                                    e.printStackTrace()
//                                }
//                            }
                            try {
                                print("Test Print " + "" + name)
                            } catch (e: Exception) {
                                // TODO Auto-generated catch block
                                e.printStackTrace()
                            }
                        }
//                        BluetoothService.STATE_CONNECTING -> {}
//                        BluetoothService.STATE_LISTEN, BluetoothService.STATE_NONE -> {}
                    }
//                    Log.i("Hpm200FACTORY", msg.arg1.toString())
                }
//                BluetoothService.MESSAGE_CONNECTION_LOST -> {
//                    isConnected = false
////                    if (null != mContext) {
////                        try {
////                            DialogBuilder.showInfoDialog(
////                                mContext, "Error",
////                                "Putus Koneksi Dengan Printer " + name
////                            )
////                        } catch (e: Exception) {
////                            e.printStackTrace()
////                        }
////                    }
//                }
//                BluetoothService.MESSAGE_UNABLE_CONNECT -> {
//                    isConnected = false
////                    if (null != mContext) {
////                        try {
////                            DialogBuilder.showInfoDialog(
////                                mContext, "Informasi",
////                                "Tidak Dapat Terkoneksi Dengan Printer " + name
////                            )
////                        } catch (e: Exception) {
////                            e.printStackTrace()
////                        }
//                    }
                }
            }
        }
    }

    companion object {
        private var singleton: Hpm200Printer? = null
        const val MAXCHAR = 42
        val instance: Hpm200Printer
            get() {
                if (singleton == null) {
                    singleton = Hpm200Printer()
                }
                return singleton!!
            }
    }
}