package com.bits.bee.bpmc.domain.printer.bt.bluebamboo

import android.content.Context
import android.graphics.Bitmap
import com.bits.bee.bpmc.utils.BPMConstants
import com.bluebamboo.p25library.ControlPrint
import com.bluebamboo.p25library.MagneticCardRecord
import java.lang.Exception
import  com.bluebamboo.p25library.P25Session.*

/**
 * Created by wisnu on 16/11/16.
 */
class P25Session : BmpPrintingResponseListener, FeedLineResponseListener, LinearBarcodePrintingResponseListener, MagneticCardResponseListener,
    PDF417BarcodePrintingResponseListener, PrintingResponseListener, SessionListener {
    val session: com.bluebamboo.p25library.P25Session
    var isConnected = false
        private set
    var controlPrint: ControlPrint
    private var context: Context? = null
    private var printerMac: String? = null
    private var printerName: String? = null

    fun init(context: Context?) {
        this.context = context
        initListener()
    }

    @Throws(Exception::class)
    fun connect(btDevMac: String?, btDevName: String?): Boolean {
        printerName = btDevName
        printerMac = btDevMac
        var timeout: Long = 0
        //        parentSession.ConnectToPrinter(printerMac);
//        new ConnectTask(printerMac).execute();
        session.ConnectToPrinter(printerMac)
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

    private fun initListener() {
        session.setBmpPrintingResponseListener(this)
        session.feedLineResponseListener = this
        session.setLinearBarcodePrintingResponseListener(this)
        session.magneticCardResponseListener = this
        session.setPDF417BarcodePrintingResponseListener(this)
        session.setPrintingResponseListener(this)
        session.setSessionListener(this)
    }

    val address: String?
        get() = if (isConnected) {
            printerMac
        } else {
            "Not Connected"
        }
    val name: String?
        get() = if (isConnected) {
            printerName
        } else {
            "Not Connected"
        }

    fun controlPrint(): ControlPrint {
        return controlPrint
    }

    fun print(s: String?) {
        controlPrint.fontSize = ControlPrint.Font.NORMAL
        controlPrint.printData(s)
    }

    fun printImage(imagedata: Bitmap?) {
        controlPrint.printJustification = ControlPrint.PrintJustification.CENTER
        controlPrint.printImage(imagedata)
    }

    fun disconnect() {
        session.DisconnectFromPrinter()
    }

    override fun onReadPlainTextCardRecord(magneticCardRecord: MagneticCardRecord) {}
    override fun onReadEncryptedCardRecord(magneticCardRecord: MagneticCardRecord) {}
    override fun onReadFailedResponse() {}
    override fun onFinishedResponse() {}
    override fun onFailedResponse() {}
    override fun onConnected() {
        isConnected = true
        //        Toast.makeText(context, "Connected to P25_055709_01", Toast.LENGTH_SHORT).show();
//        DialogBuilder.showInfoDialog(
//            context, "Informasi",
//            "Printer $printerName Telah Terhubung"
//        )
        controlPrint.printData("Test Print P25\n")
    }

    override fun onConnectFailed() {
        isConnected = false
        //        DialogBuilder.showInfoDialog(context, "Informasi",
//                "Tidak Dapat Terkoneksi Dengan Printer");
//        Toast.makeText(context, "Failed to connect to P25_055709_01", Toast.LENGTH_SHORT).show();
    }

    override fun onDisconnected() {
        isConnected = false
        //        DialogBuilder.showInfoDialog(context, "Error",
//                "Putus Koneksi Dengan Printer");
//        Toast.makeText(context, "P25_055709_01 has been disconnected", Toast.LENGTH_SHORT).show();
    } //    private class ConnectTask extends AsyncTask<Void, Void, Void> {

    //        MaterialDialog dialog;
    //        String btDeviceMac;
    //
    //        public ConnectTask(String btDeviceMac) {
    //            this.btDeviceMac = btDeviceMac;
    //        }
    //
    //        @Override
    //        protected void onPreExecute() {
    //            dialog = DialogBuilder.showLoadingDialog(context, "Connecting", "Try to connect to P25_055709_01", false);
    //        }
    //
    //        @Override
    //        protected Void doInBackground(Void... arg0) {
    //            parentSession.ConnectToPrinter(btDeviceMac);
    //            return null;
    //        }
    //
    //        @Override
    //        protected void onPostExecute(Void aVoid) {
    //            dialog.dismiss();
    //            super.onPostExecute(aVoid);
    //        }
    //    }
    companion object {
        private var session: P25Session? = null

        var MAXCHAR = 32

        val instance: P25Session
            get() {
                if (session == null) {
                    session = P25Session()
                }
                return session!!
            }
    }

    init {
        this.session = getInstance()
        controlPrint = ControlPrint()
    }
}