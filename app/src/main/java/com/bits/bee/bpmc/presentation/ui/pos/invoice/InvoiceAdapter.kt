package com.bits.bee.bpmc.presentation.ui.pos.invoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemInvoiceBinding
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import java.math.BigDecimal

/**
 * Created by aldi on 24/05/22.
 */
class InvoiceAdapter(
    private val onItemClicK : (Saled) -> Unit,
    private val onDeleteClick : (Saled) -> Unit,
    private val isDelete : Boolean = true
) : ListAdapter<Saled, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemInvoiceBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemInvoiceBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Saled) {
            binding.apply {
                val context = binding.root.context
                tvNamaItem.text = model.name
                tvQty.text = CurrencyUtils.formatCurrency(model.qty)
                tvHarga.text =  context.getString(R.string.mata_uang_nominal, model.crcSymbol, CurrencyUtils.formatCurrency(model.listPrice))

                if(model.discAmt.compareTo(BigDecimal.ZERO) == 0){
                    tvLabelItem.gone()
                    tvHargaDiskon.gone()
                } else {
                    tvLabelItem.visible()
                    tvHargaDiskon.visible()
                    tvLabelItem.text = "Diskon"
                }
                if(isDelete){
                    ivDelete.gone()
                }

                tvAddon.gone()

                clContent.setOnClickListener {
                    onItemClicK(model)
                }
                ivDelete.setOnClickListener {
                    onDeleteClick(model)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Saled>() {

        override fun areItemsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem.id == newItem.id
        }

    }
}