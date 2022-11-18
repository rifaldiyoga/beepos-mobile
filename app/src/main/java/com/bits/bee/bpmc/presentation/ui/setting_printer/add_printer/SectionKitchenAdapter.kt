package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemSectionKitchenBinding
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.PrinterKitchen

class SectionKitchenAdapter constructor(
    private val onDapurClick : (Int) -> Unit,
): ListAdapter<PrinterKitchen, SectionKitchenAdapter.ViewHolder>(DiffCallback()) {

    private var list: MutableList<MutableList<Kitchen>> = mutableListOf()

    inner class ViewHolder(private val binding : ItemSectionKitchenBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model : PrinterKitchen){
            binding.apply {
                val pos = absoluteAdapterPosition + 1
                tvTitleDapur.text = "Nama Dapur $pos"
                etKitchenDapur.setText(model.kitchenName)
                etKitchenDapur.addTextChangedListener {
                    model.kitchenName = etKitchenDapur.text.toString().trim()
                }

                if(model.kitchenList.isNotEmpty())
                    etKitchen.setText(model.kitchenList.joinToString { "${it.name}" })

                etKitchen.setOnClickListener {
                    onDapurClick(absoluteAdapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemSectionKitchenBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val printerKitchen = getItem(position)

        holder.bind(printerKitchen)
    }

//
//    private fun loadSelectedKategori(
//        spinner: Spinner, adapterKitchen: ArrayAdapter<String>,
//        valueList: MutableList<Kitchen>?
//    ) {
//        var kitchenName: String? = null
//        for ((index, value) in valueList!!.withIndex()){
//            kitchenName = value.name
//        }
//        if (kitchenName != null){
//            val i: Int = adapterKitchen.getPosition(kitchenName)
//            spinner.setSelection(i)
//        }else{
//            spinner.setSelection(0)
//        }
//
//    }

    class DiffCallback : DiffUtil.ItemCallback<PrinterKitchen>() {
        override fun areItemsTheSame(oldItem: PrinterKitchen, newItem: PrinterKitchen): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PrinterKitchen, newItem: PrinterKitchen): Boolean {
            return oldItem == newItem
        }

    }

}