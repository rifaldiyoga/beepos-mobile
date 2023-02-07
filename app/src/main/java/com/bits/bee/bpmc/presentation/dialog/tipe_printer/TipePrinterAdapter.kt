package com.bits.bee.bpmc.presentation.dialog.tipe_printer

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemTipePrinterBinding

class TipePrinterAdapter constructor(
    private var tipeList: MutableList<ListTipe>,
    private var ctx: Context,
    private val mListener: PilihTipePrinterAddapterI
): RecyclerView.Adapter<TipePrinterAdapter.ViewHolder>() {

    private var mTipeList : MutableList<ListTipe> = mutableListOf()
    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var mWifiManager: WifiManager

    init {
        this.mTipeList = tipeList
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemTipePrinterBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = mTipeList.get(position)
        holder.binding.apply {
            imgviewTipe.setImageResource(current.imageSrc)
            tvNamaTipe.text = current.label
            clTipePrinter.setOnClickListener {
                checkTypePrinter(position)
            }
        }
    }

    override fun getItemCount(): Int = mTipeList.size

    fun getItem(i : Int) = mTipeList[i]

    fun checkTypePrinter(tipe: Int){
        if (tipe == 0){
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
            if (!mBluetoothAdapter.isEnabled){
                val i = Intent(Settings.ACTION_BLUETOOTH_SETTINGS)
                ctx.startActivity(i)
            }else{
                mListener.OnItemClick(tipe)
            }
        }else{
            mListener.OnItemClick(tipe)
//            mWifiManager = ctx.getSystemService(Context.WIFI_SERVICE) as WifiManager
//            if (!mWifiManager.isWifiEnabled){
//                Toast.makeText(ctx, "Enabling WiFi..", Toast.LENGTH_LONG).show()
//                mWifiManager.isWifiEnabled = true
//            }
//            if (mWifiManager.isWifiEnabled){
//                mListener.OnItemClick(tipe)
//            }
        }
    }

    class ViewHolder(val binding : ItemTipePrinterBinding) : RecyclerView.ViewHolder(binding.root)

    interface PilihTipePrinterAddapterI{
        fun OnItemClick(position: Int)
    }
}