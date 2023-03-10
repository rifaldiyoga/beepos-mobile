package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPosMenuPromoBinding

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.FileHandlerUtils
import com.bits.bee.bpmc.utils.ImageUtils
import com.squareup.picasso.Picasso
import java.io.File
import java.math.BigDecimal

/**
 * Created by aldi on 09/09/22
 */
class KlaimPromoAdapater (
    private val onAddClick : (Item) -> Unit,
    private val onMinusClick : (Item) -> Unit,
    private val orientation : String
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

                if(model.objKey?.isEmpty()!!) {
                    imageItem.setImageDrawable(
                        ImageUtils.generateFromInitial(
                            binding.root.context,
                            model.name1
                        )
                    )
                } else {
                    if(!model.tempUrl.isNullOrEmpty())
                        Picasso.get().load(File(BPMConstants.getDatapath()+BPMConstants.BPM_PRODUKPATH + "/" , model.tempUrl!!)).into(imageItem)
                    else
                        imageItem.setImageDrawable(
                            ImageUtils.generateFromInitial(
                                binding.root.context,
                                model.name1
                            )
                        )
                }
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