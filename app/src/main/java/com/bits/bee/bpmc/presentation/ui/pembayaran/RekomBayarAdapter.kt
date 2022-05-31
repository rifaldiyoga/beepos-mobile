package com.bits.bee.bpmc.presentation.ui.pembayaran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRekomBayarBinding
import com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbAdapter

/**
 * Created by aldi on 25/05/22.
 */
class RekomBayarAdapter(
    private val onItemClick : (String) -> Unit
) : ListAdapter<String, RecyclerView.ViewHolder>(DiffCallback()) {

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
                tvHarga.text = model
                tvHarga.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

}