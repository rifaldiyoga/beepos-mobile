package com.bits.bee.bpmc.domain.printer.bt.bluebamboo.connector

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import com.bits.bee.bpmc.domain.printer.bt.bluebamboo.connector.P25ConnectionException
import java.io.IOException
import java.io.OutputStream

/**
 * P25 printer connection class.
 *
 * @author Lorensius W. L. T <lorenz></lorenz>@londatiga.net>
 */
class P25Connector(private val mListener: P25ConnectionListener) {
    private var mSocket: BluetoothSocket? = null
    private var mOutputStream: OutputStream? = null
    private var mConnectTask: Any? = null
    var isConnecting = false
        private set
    val isConnected: Boolean
        get() = mSocket != null

    @Throws(P25ConnectionException::class)
    fun connect(device: BluetoothDevice) {
        if (isConnecting && mConnectTask != null) {
            throw P25ConnectionException("Connection in progress")
        }
        if (mSocket != null) {
            throw P25ConnectionException("Socket already connected")
        }
//        ConnectTask(device).also { mConnectTask = it }.execute()
    }

    @Throws(P25ConnectionException::class)
    fun disconnect() {
        if (mSocket == null) {
            throw P25ConnectionException("Socket is not connected")
        }
        try {
            mSocket!!.close()
            mSocket = null
            mListener.onDisconnected()
        } catch (e: IOException) {
            throw P25ConnectionException(e.message)
        }
    }

    @Throws(P25ConnectionException::class)
    fun cancel() {
        if (isConnecting && mConnectTask != null) {
//            mConnectTask!!.cancel(true)
        } else {
            throw P25ConnectionException("No connection is in progress")
        }
    }

    @Throws(P25ConnectionException::class)
    fun sendData(msg: ByteArray?) {
        if (mSocket == null) {
            throw P25ConnectionException("Socket is not connected, try to call connect() first")
        }
        try {
            mOutputStream!!.write(msg)
            mOutputStream!!.flush()

//			Log.i(TAG, StringUtil.byteToString(msg));
        } catch (e: Exception) {
            throw P25ConnectionException(e.message)
        }
    }

    interface P25ConnectionListener {
        fun onStartConnecting()
        fun onConnectionCancelled()
        fun onConnectionSuccess()
        fun onConnectionFailed(error: String?)
        fun onDisconnected()
    }

//    inner class ConnectTask(var device: BluetoothDevice) : AsyncTask<URL?, Int?, Long>() {
//        var error: String? = ""
//        override fun onCancelled() {
//            isConnecting = false
//            mListener.onConnectionCancelled()
//        }
//
//        override fun onPreExecute() {
//            mListener.onStartConnecting()
//            isConnecting = true
//        }
//
//        override fun doInBackground(vararg urls: URL): Long {
//            var result: Long = 0
//            try {
////				mSocket			= device.createRfcommSocketToServiceRecord(UUID.fromString(SPP_UUID));
//                val m = device.javaClass.getMethod(
//                    "createRfcommSocket", *arrayOf<Class<*>?>(
//                        Int::class.javaPrimitiveType
//                    )
//                )
//                mSocket = m.invoke(device, 1) as BluetoothSocket
//                mSocket!!.connect()
//                mOutputStream = mSocket!!.outputStream
//                result = 1
//            } catch (e: IOException) {
//                e.printStackTrace()
//                error = e.message
//            } catch (e: NoSuchMethodException) {
//                e.printStackTrace()
//            } catch (e: IllegalAccessException) {
//                e.printStackTrace()
//            } catch (e: InvocationTargetException) {
//                e.printStackTrace()
//            }
//            return result
//        }
//
//        override fun onPostExecute(result: Long) {
//            isConnecting = false
//            if (mSocket != null && result == 1L) {
//                mListener.onConnectionSuccess()
//            } else {
//                mListener.onConnectionFailed("Connection failed $error")
//            }
//        }
//    }

    companion object {
        private const val TAG = "P25"
        private const val SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB"
    }
}