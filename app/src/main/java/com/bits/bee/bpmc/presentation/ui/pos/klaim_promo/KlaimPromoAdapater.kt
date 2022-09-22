package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.bits.bee.bpmc.databinding.ItemPosMenuPromoBinding
=======
import com.bits.bee.bpmc.databinding.ItemNestedSesiBinding
import com.bits.bee.bpmc.databinding.ItemPosMenuBinding
import com.bits.bee.bpmc.databinding.ItemPromoBinding
>>>>>>> origin/manual_up
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.ImageUtils
import java.math.BigDecimal

/**
 * Created by aldi on 09/09/22
 */
class KlaimPromoAdapater (
    private val onAddClick : (Item) -> Unit,
    private val onMinusClick : (Item) -> Unit,
) : ListAdapter<Item, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPosMenuPromoBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding : ItemPosMenuPromoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Item){
            binding.apply {
                tvNamaItem.text = model.name1
                tvQty.text = CurrencyUtils.formatCurrency(model.qty)

                imageItem.setImageDrawable(ImageUtils.generateFromInitial(model.name1))

                ivPlus.setOnClickListener {
                    onAddClick(model)
                }
                ivMinus.setOnClickListener {
                    onMinusClick(model)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Item>(){

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }

}