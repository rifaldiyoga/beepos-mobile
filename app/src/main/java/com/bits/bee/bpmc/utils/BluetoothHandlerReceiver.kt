package com.bits.bee.bpmc.utils

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BluetoothHandlerReceiver: BroadcastReceiver() {

    companion object{
        val instance: BluetoothHandlerReceiver by lazy { BluetoothHandlerReceiver() }
    }

    override fun onReceive(ctx: Context?, intent: Intent?) {
        val action = intent?.action
        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)){
            val state = intent?.getIntExtra(
                BluetoothAdapter.EXTRA_STATE,
                BluetoothAdapter.ERROR)
            when(state){
                BluetoothAdapter.STATE_OFF ->{
                    //                    PrinterFactory.disconnect();
                    Toast.makeText(ctx, "Bluetooth Off", Toast.LENGTH_SHORT).show()
                }
                BluetoothAdapter.STATE_TURNING_OFF ->{
//                    BluetoothConnectService.disconnect()
                    Toast.makeText(ctx, "Bluetooth Turning Off...", Toast.LENGTH_SHORT).show()
                }
                BluetoothAdapter.STATE_ON ->{
                    //                    ConnectionUtil.PrinterDiagnose(context);
                    Toast.makeText(ctx, "Bluetooth ON", Toast.LENGTH_SHORT).show()
                }
                BluetoothAdapter.STATE_TURNING_ON ->{

                }
            }
        }
    }
}