package com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemSectionKitchenBinding
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.PrinterKitchen

class SectionKitchenAdapter constructor(
    val ctx: Context
): RecyclerView.Adapter<SectionKitchenAdapter.ViewHolder>() {

    private var mList: List<PrinterKitchen> = listOf()
    private var mMap: HashMap<Int, MutableList<Kitchen>> = HashMap()
    private var mutableList: MutableList<PrinterKitchen> = mutableListOf()
    private var mListKitchen: MutableList<Kitchen> = mutableListOf()

    fun initList(list: List<PrinterKitchen>, listMap :HashMap<Int, MutableList<Kitchen>>){
        this.mList = list
        this.mMap = listMap
        this.mutableList = mList.toMutableList()
        notifyDataSetChanged()
    }

    fun setPrinterKitchenList(list: List<PrinterKitchen>){
        this.mList = list
        this.mutableList = mList.toMutableList()
    }

    fun setKitchenList(mutable: MutableList<Kitchen>) {
        this.mListKitchen = mutable
        val str= ""
    }

    fun getPrinterKitchenList(): List<PrinterKitchen>{
        return mutableList
    }

    fun getPrinterKitchenListmap(): MutableList<Kitchen>{
        return mListKitchen
    }

    fun addPrinterKitchen(printerKitchen: PrinterKitchen){
        mutableList.add(printerKitchen)
        mMap.put(mutableList.size - 1, mutableListOf())
        notifyDataSetChanged()
    }

    fun delePrinterKitchen(){
        mMap.remove(mutableList.size - 1)
        mutableList.removeAt(mutableList.size - 1)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemSectionKitchenBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemSectionKitchenBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val printerKitchen: PrinterKitchen = mutableList.get(position)
        val pos = position + 1
        holder.binding.apply {
            tvTitleDapur.text = "Nama Dapur "+pos
            etKitchenDapur.setText(printerKitchen.kitchenName)
        }
        val spinner = holder.binding.spinnerKategori
        if (spinner != null){

            var listStr = mutableListOf<String>()
            listStr.add("Pilih Kategori")
//            var valuesList: List<MutableList<Kitchen>> = mMap.values.toList()
//            for (kitList in valuesList){
//                for (kit in kitList){
//                    listStr.add(kit.name)
//                }
//            }
            for (kit in mListKitchen){
                listStr.add(kit.name)
            }
            val adapterKitchen = ArrayAdapter(ctx, R.layout.simple_list_item_1, listStr )
            spinner.adapter = adapterKitchen

            loadSelectedKategori(spinner, adapterKitchen, mMap.get(position))

//            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//                override fun onItemSelected(parent: AdapterView<*>,
//                                            view: View, position: Int, id: Long) {
//                    Toast.makeText(ctx," " +
//                                "" + listStr[position], Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>) {
//                    // write code to perform some action
//                }
//
//            }
        }
    }

    private fun loadSelectedKategori(
        spinner: Spinner, adapterKitchen: ArrayAdapter<String>,
        valueList: MutableList<Kitchen>?
    ) {
        var kitchenName: String? = null
        for ((index, value) in valueList!!.withIndex()){
            if (value != null){
//                var coma = if (valueList.size != index + 1) ", " else ""
                kitchenName = value.name
            }
        }
        if (kitchenName != null){
            val i: Int = adapterKitchen.getPosition(kitchenName)
            spinner.setSelection(i)
        }else{
            spinner.setSelection(0)
        }

    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

}