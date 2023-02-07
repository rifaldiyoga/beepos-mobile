package com.bits.bee.bpmc.presentation.ui.pembayaran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemRekomBayarBinding
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.getColorFromAttr
import java.math.BigDecimal

/**
 * Created by aldi on 25/05/22.
 */
class RekomBayarAdapter(
    private val onItemClick : (String) -> Unit
) : ListAdapter<String, RecyclerView.ViewHolder>(DiffCallback()) {

    private var selectedPos = -1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRekomBayarBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemRekomBayarBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : String) {
            binding.apply {
                tvHarga.text = CurrencyUtils.formatCurrency(BigDecimal(model))
                val context = binding.root.context
                if(selectedPos == absoluteAdapterPosition){
                    tvHarga.background = ContextCompat.getDrawable(context, R.drawable.bg_rect_stroke_primary)
                    tvHarga.setTextColor(context.getColorFromAttr(R.attr.colorPrimary))
                } else {
                    tvHarga.background = ContextCompat.getDrawable(context, R.drawable.bg_rect_stroke_light_gray)
                    tvHarga.setTextColor(context.getColorFromAttr(R.attr.colorOnBackground))
                }

                tvHarga.setOnClickListener {
                    setSelectedPosition(absoluteAdapterPosition)
                    onItemClick(model)
                    notifyDataSetChanged()
                }
            }
        }
    }

    private fun setSelectedPosition(pos : Int) {
        if(selectedPos != pos) {
            this.selectedPos = pos
        } else {
            this.selectedPos = -1
        }
    }

    fun getSelectedPosition() : Int = selectedPos

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

}