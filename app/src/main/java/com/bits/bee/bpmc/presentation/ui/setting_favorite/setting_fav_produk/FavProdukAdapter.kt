package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemMenuFavBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.ImageUtils

/**
 * Created by aldi on 06/10/22
 */
class FavProdukAdapter constructor (
    private val onMemberClick : (Item) -> Unit,
) : PagingDataAdapter<Item, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemMenuFavBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder

        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemMenuFavBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Item) {
            binding.apply {
                root.setOnClickListener {
                    onMemberClick(model)
                    notifyDataSetChanged()
                }

                tvNamaItem.text = model.name1

                val drawable = ContextCompat.getDrawable(tvNamaItem.context, when(model.isFavorit){
                    true -> R.drawable.ic_star_enabled
                    false -> R.drawable.ic_star_disabled
                })

                ivFav.setImageDrawable(drawable)
                imageItem.setImageDrawable(ImageUtils.generateFromInitial(binding.root.context, model.name1, if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE) 20 else null))
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Item>(){

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }
}