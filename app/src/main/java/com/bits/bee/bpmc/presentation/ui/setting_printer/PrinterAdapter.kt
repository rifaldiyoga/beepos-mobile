package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.databinding.ItemBluetoothBinding
import com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.FindPrinterAdapter

class PrinterAdapter constructor(
    listPrinter: List<Printer>
): RecyclerView.Adapter<PrinterAdapter.ViewHolder>() {

    private var mList: List<Printer> = mutableListOf()

    init {
        this.mList = listPrinter
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
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setPrinterList(list: List<Printer>){
        this.mList = list
    }
}