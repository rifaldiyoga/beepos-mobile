package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemBluetoothBinding

class FindPrinterAdapter constructor(
    private var listDevice: MutableList<ListPrinter>,
    private val mListener: PilihBluetoothPrinterI
): RecyclerView.Adapter<FindPrinterAdapter.ViewHolder>() {

    var mListDevice: MutableList<ListPrinter> = mutableListOf()

    init {
        this.mListDevice = listDevice
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemBluetoothBinding.inflate(inflater, parent, false)
        )
    }

    override fun getItemCount(): Int = mListDevice.size

    class ViewHolder(val binding : ItemBluetoothBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = mListDevice.get(position)
        holder.binding.apply {
            clPrinterTerhubung.visibility = View.GONE
            clPrinterTidakTerhubung.visibility = View.GONE
            itemBluetoothTvTitle.text = current.namaPrinter
            itemBluetoothTvAddress.text = current.address
            itemListClPrinter.setOnClickListener {
                mListener.OnItemClick(current)
            }
        }
    }

    interface PilihBluetoothPrinterI{
        fun OnItemClick(element: ListPrinter)
    }

}