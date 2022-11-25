package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.databinding.ItemBluetoothBinding
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.presentation.service.BluetoothConnectService
import javax.inject.Inject

class PrinterAdapter constructor(
    private val mListener: PilihPrinterI,
    private val bluetoothConnectService: BluetoothConnectService
): RecyclerView.Adapter<PrinterAdapter.ViewHolder>() {

    private var mList: List<Printer> = mutableListOf()

    fun submitList(list:List<Printer>){
        mList = list
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemBluetoothBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemBluetoothBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val printer = mList.get(position)
        holder.binding.apply {
            itemBluetoothTvTitle.text = printer.printerName
            itemBluetoothTvAddress.text = printer.address
            itemListClPrinter.setOnClickListener {
                mListener.onItemClick(printer)
            }
            val isConnected = bluetoothConnectService.getMapPrinterByAddress(printer.address)?.isConnected ?: false
            clPrinterTidakTerhubung.isVisible = !isConnected
            clPrinterTerhubung.isVisible = isConnected
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setPrinterList(list: List<Printer>){
        this.mList = list
    }

    interface PilihPrinterI{
        fun onItemClick(printer: Printer)
    }
}