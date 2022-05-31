package com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.databinding.ItemBluetoothBinding
import com.bits.bee.bpmc.databinding.ItemSectionKitchenBinding
import com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer.FindPrinterAdapter
import java.util.ArrayList

class SectionKitchenAdapter constructor(
    val ctx: Context
): RecyclerView.Adapter<SectionKitchenAdapter.ViewHolder>() {

    lateinit var mList: List<PrinterKitchen>
    lateinit var mMap: HashMap<Int, MutableList<Kitchen>>

    fun initList(list: List<PrinterKitchen>, map:HashMap<Int, MutableList<Kitchen>>){
        this.mList = list
        this.mMap = map
    }

    class ViewHolder(val binding : ItemSectionKitchenBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemSectionKitchenBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val printerKitchen: PrinterKitchen = mList.get(position)
        val pos = position + 1
        holder.binding.apply {
            tvTitleDapur.text = "Nama Dapur {$pos}"
            etKitchenDapur.setText(printerKitchen.kitchenName)
        }
        val spinner = holder.binding.spinnerKategori
        if (spinner != null){
//            val adapter = ArrayAdapter(ctx, android.R.layout.simple_list_item_1, mMap)
//            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(ctx," " +
                                "" + mMap[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}