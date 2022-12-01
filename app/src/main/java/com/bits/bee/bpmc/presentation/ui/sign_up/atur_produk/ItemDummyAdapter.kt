package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemProdukDummyBinding
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.FileHandlerUtils
import com.bits.bee.bpmc.utils.ImageUtils
import java.math.BigDecimal


/**
 * Created by aldi on 31/08/22.
 */
class ItemDummyAdapter(
    private val onItemClick : (ItemDummy) -> Unit
) : ListAdapter<ItemDummy, RecyclerView.ViewHolder>(DiffCallback()) {

    private val VIEW_ITEM = 1
    private val VIEW_ADD = 0

    override fun submitList(list: MutableList<ItemDummy>?) {
        val newList : MutableList<ItemDummy> = mutableListOf()
        newList.addAll(list ?: mutableListOf())
        if(newList.size < 10){
            newList.add(ItemDummy())
        }
        super.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return  ViewHolder(
            ItemProdukDummyBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
        viewHolder.itemView.setOnClickListener {
            onItemClick(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position == currentList.size - 1){
            true -> VIEW_ITEM
            false -> VIEW_ADD
        }
    }

    inner class ViewHolder(private val binding : ItemProdukDummyBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : ItemDummy){
            binding.apply {
                val context = binding.root.context

                tvPid.isVisible = model.id != null
                ivPencil.isVisible = model.id != null
                tvHarga.isVisible = model.id != null

                model.id?.let {
                    tvNamaItem.text = model.name
                    tvPid.isVisible = model.pid.isNotEmpty()
                    tvPid.text = model.pid
                    if (model.price.isEmpty()){
                        tvHarga.text = "0"
                    }else{
                        tvHarga.text = context.getString(R.string.mata_uang_nominal, "Rp.", CurrencyUtils.formatCurrency(
                            BigDecimal(model.price.replace(",", "") ?: "0")
                        ))
                    }
                    if (model.picPath.isNotEmpty()){
                        imageItem.setImageBitmap(FileHandlerUtils.checkDirPath(model.picPath))
                    }else{
                        imageItem.setImageDrawable(ImageUtils.generateFromInitial(context, model.name))
                    }
                } ?: run {
                    tvNamaItem.text = context.getString(R.string.tambah_baru)
                    imageItem.setImageDrawable(ImageUtils.generateFromInitial(context, "+"))
                }
            }
        }
    }


    class DiffCallback() : DiffUtil.ItemCallback<ItemDummy>(){
        override fun areItemsTheSame(oldItem: ItemDummy, newItem: ItemDummy): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemDummy, newItem: ItemDummy): Boolean {
            return oldItem == newItem
        }

    }
}