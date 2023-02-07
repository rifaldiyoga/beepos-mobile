package com.bits.bee.bpmc.presentation.dialog.detail_addon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemDetailAddonBinding
import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceAddOnAdapter
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.math.BigDecimal

/**
 * Created by aldi on 12/12/22
 */
class DetailAddOnAdapter constructor(
    private val onItemClick : (Saled) -> Unit,
    private val onMinusClick: (Saled) -> Unit,
    private val onPlusClick: (Saled) -> Unit,
    private var saleAddOnList : List<SaleAddOnD> = mutableListOf()
) : ListAdapter<Saled, RecyclerView.ViewHolder>(DiffCallback()){

    fun submitSaleAddOnDList(saleAddOnList: List<SaleAddOnD>){
        this.saleAddOnList = saleAddOnList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemDetailAddonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding: ItemDetailAddonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Saled) {
            binding.apply {
                val context = binding.root.context
                binding.root.setOnClickListener {
                    onItemClick(model)
                }
                ivMinus.setOnClickListener {
                    onMinusClick(model)
                }
                ivPlus.setOnClickListener {
                    onPlusClick(model)
                }
                tvNamaItem.text = model.name
                var subtotal = model.subtotal
                etQty.setText(CurrencyUtils.formatCurrency(model.qty))

                val saledAddonList = saleAddOnList.filter { model == it.upSaled ||(model.id != null && it.upSaled != null && it.upSaled!!.id != null && model.id == it.upSaled!!.id) }.map { it.saled }

                rvAddon.isVisible = saledAddonList.isNotEmpty()
                if(saledAddonList.isNotEmpty()) {
                    val addOnAdapter = InvoiceAddOnAdapter(model.qty)

                    rvAddon.apply {
                        adapter = addOnAdapter
                        layoutManager = LinearLayoutManager(context)
                    }

                    addOnAdapter.submitList(saledAddonList)

                    saledAddonList.forEach {
                        subtotal += it?.subtotal ?: BigDecimal.ZERO
                    }
                }

                tvHarga.text = context.getString(R.string.mata_uang_nominal, "", CurrencyUtils.formatCurrency(subtotal))
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Saled>() {
        override fun areItemsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem == newItem
        }

    }

}