package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemPosMenuBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.ViewUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import java.math.BigDecimal


/**
 * Created by aldi on 22/04/22.
 */
class ItemPosAdapter constructor(
    private val onItemClicK : (Item) -> Unit,
    private val onMinusClick : (Item) -> Unit,
    private var saledList : List<Saled>
) : PagingDataAdapter<Item, RecyclerView.ViewHolder>(DiffCallback()){

    fun submitSaledList(list : List<Saled>) {
        this.saledList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPosMenuBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemPosMenuBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : Item){
            binding.apply {
                var qty = getSumQty(item)
                tvNamaItem.text =  item.name1
                tvHarga.text = binding.root.context.getString(R.string.mata_uang_nominal,"Rp.", CurrencyUtils.formatCurrency(item.price))
                tvQty.text = CurrencyUtils.formatCurrency(qty)
                val generatorCol = ColorGenerator.MATERIAL
                val text = getInitial(item.name1)

                val color = generatorCol.getColor(item.name1)

                var font = 92
                if (text.length == 4) font = 64
                if (text.length == 5) font = 54

                val hexColor = String.format("#%06X", 0xFFFFFF and color)
                val txtColor: String = ViewUtils.pickTextColorBasedOnBg(hexColor)

                val titleImg = TextDrawable.builder()
                    .beginConfig()
                    .fontSize(font)
                    .textColor(Color.parseColor(txtColor))
                    .endConfig()
                    .buildRect(text.uppercase(), color)

                if(qty > BigDecimal.ZERO){
                    cdContent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.red))
                    cardView.gone()
                    llMinus.visible()
                    llQty.visible()
                    tvNamaItem.setTextColor(ContextCompat.getColor(root.context, R.color.white))
                    tvHarga.setTextColor(ContextCompat.getColor(root.context, R.color.white))
                } else {
                    cdContent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.white))
                    cardView.visible()
                    llMinus.gone()
                    llQty.gone()
                    tvNamaItem.setTextColor(ContextCompat.getColor(root.context, R.color.black))
                    tvHarga.setTextColor(ContextCompat.getColor(root.context, R.color.black))
                }

                imageItem.setImageDrawable(titleImg)

                cdContent.setOnClickListener {
//                    qty = item.qty.add(BigDecimal.ZERO)
                    onItemClicK(item)
                    notifyItemChanged(absoluteAdapterPosition)
                }
                llMinus.setOnClickListener {
//                    item.qty = item.qty.subtract(BigDecimal.ZERO)
                    onMinusClick(item)
                    notifyItemChanged(absoluteAdapterPosition)
                }
            }
        }

    }

    private fun getSumQty(item : Item) : BigDecimal {
        var qty = BigDecimal.ZERO
        saledList.forEach {
            if(item.id == it.itemId)
                qty = qty.add(it.qty)
        }
        return qty
    }

    private fun getInitial(title: String): String {
        val lists = title.split(" ").toTypedArray()
        val list: MutableList<String> = ArrayList()
        for (s in lists) {
            if (s.isNotEmpty()) {
                list.add(s)
            }
        }
        return when {
            list.size == 1 -> {
                list[0][0].toString()
            }
            list.size == 2 -> {
                list[0][0].toString() + list[1][0]
            }
            list.size >= 3 -> {
                list[0][0].toString() + list[1][0] + list[2][0]
            }
            else -> "I"
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