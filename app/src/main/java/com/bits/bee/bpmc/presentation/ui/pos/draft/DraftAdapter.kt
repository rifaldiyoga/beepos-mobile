package com.bits.bee.bpmc.presentation.ui.pos.draft

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemDraftListBinding
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 27/06/22.
 */
class DraftAdapter(private val onClickItem : (Sale) -> Unit, private val onDeleteItem : (Sale) -> Unit) : PagingDataAdapter<Sale, RecyclerView.ViewHolder>(DiffCallback()) {

    private val hourFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemDraftListBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemDraftListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model : Sale) {
            binding.apply {
                binding.root.setOnClickListener {
                    onClickItem(model)
                }
                ivDelete.setOnClickListener {
                    onDeleteItem(model)
                }
                tvCust.text = model.bpName
                tvOperator.text = model.userName
                tvTotal.text = CurrencyUtils.formatCurrency(model.total)
                tvJam.text = hourFormat.format(model.trxDate)
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Sale>() {
        override fun areItemsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem == newItem
        }

    }
}