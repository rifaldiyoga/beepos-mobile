package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemPosMenuCariBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.ItemPosAdapter
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.ImageUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import java.math.BigDecimal

/**
 * Created by aldi on 05/10/22
 */
class ItemPosCariAdapter(
    private val onItemClicK : (Item) -> Unit,
    private val onMinusClick : (Item) -> Unit,
    private var saledList : List<Saled>,
) : ItemPosAdapter(onItemClicK, onMinusClick, saledList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPosMenuCariBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }


    inner class ViewHolder(private val binding : ItemPosMenuCariBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : Item){
            binding.apply {
                val qty = getSumQty(item)
                tvNamaItem.text =  item.name1
                tvHarga.text = binding.root.context.getString(R.string.mata_uang_nominal,item.crcSymbol, CurrencyUtils.formatCurrency(item.price))

                tvHarga.isVisible = !item.isVariant

                tvQty?.let {
                    it.text = CurrencyUtils.formatCurrency(qty)

                    if(qty > BigDecimal.ZERO){
                        cdContent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.red))
                        cardView.gone()
                        llMinus!!.visible()
                        llQty!!.visible()
                        tvNamaItem.setTextColor(ContextCompat.getColor(root.context, R.color.white))
                        tvHarga.setTextColor(ContextCompat.getColor(root.context, R.color.white))
                    } else {
                        cdContent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.white))
                        cardView.visible()
                        llMinus!!.gone()
                        llQty!!.gone()
                        tvNamaItem.setTextColor(ContextCompat.getColor(root.context, R.color.black))
                        tvHarga.setTextColor(ContextCompat.getColor(root.context, R.color.black))
                    }

                    llMinus.setOnClickListener {
//                    item.qty = item.qty.subtract(BigDecimal.ZERO)
                        onMinusClick(item)
                        notifyItemChanged(absoluteAdapterPosition)
                    }
                }


                imageItem.setImageDrawable(ImageUtils.generateFromInitial(binding.root.context, item.name1))

                cdContent.setOnClickListener {
//                    qty = item.qty.add(BigDecimal.ZERO)
                    onItemClicK(item)
                    notifyItemChanged(absoluteAdapterPosition)
                }
            }
        }
    }

}