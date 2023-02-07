package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemBluetoothBinding

class FindPrinterAdapter constructor(
    private val mListener: PilihBluetoothPrinterI
): ListAdapter<PrinterDevice, FindPrinterAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemBluetoothBinding.inflate(inflater, parent, false)
        )
    }

    class ViewHolder(val binding : ItemBluetoothBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.binding.apply {
            clPrinterTerhubung.visibility = View.GONE
            clPrinterTidakTerhubung.visibility = View.GONE
            itemBluetoothTvTitle.text = current.nama
            itemBluetoothTvAddress.text = current.address
            holder.itemView.setOnClickListener {
                mListener.OnItemClick(current)
            }
        }
    }

    interface PilihBluetoothPrinterI{
        fun OnItemClick(element: PrinterDevice)
    }

    class DiffCallback : DiffUtil.ItemCallback<PrinterDevice>(){
        override fun areItemsTheSame(oldItem: PrinterDevice, newItem: PrinterDevice): Boolean {
            return oldItem.address == newItem.address
        }

        override fun areContentsTheSame(
            oldItem: PrinterDevice,
            newItem: PrinterDevice
        ): Boolean {
            return oldItem.address == newItem.address
        }

    }

}