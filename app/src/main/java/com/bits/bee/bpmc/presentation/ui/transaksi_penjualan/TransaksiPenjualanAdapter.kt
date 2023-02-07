package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemHeaderBinding
import com.bits.bee.bpmc.databinding.ItemTransaksiPenjualanBinding
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 23/06/22.
 */
class TransaksiPenjualanAdapter(
    private val onItemClick : (Sale) -> Unit,
    private var activeSale : Sale?,
) : PagingDataAdapter<Sale, RecyclerView.ViewHolder>(DiffCallback()){

    private val hourFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    fun setActiveSale(sale : Sale?){
        this.activeSale = sale
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if(viewType == 1)
            ViewHolder(
                ItemTransaksiPenjualanBinding.inflate(inflater, parent, false)
            )
        else
            HeaderViewHolder(
                ItemHeaderBinding.inflate(inflater, parent, false)
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == 1) {
            val viewHolder = holder as ViewHolder
            getItem(position)?.let {
                viewHolder.bind(it)
            }
        } else {
            val viewHolder = holder as HeaderViewHolder
            getItem(position)?.let {
                viewHolder.bind(it)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position)?.id == null) 0 else 1
    }

    inner class ViewHolder(private val binding : ItemTransaksiPenjualanBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : Sale){
            binding.apply {

                activeSale?.let {
                    if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE && model.id == it.id)
                        clContent.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.light_red))
                    else
                        clContent.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.white))
                }

                tvNamaCust.text = model.bpName

                tvTotal.text = CurrencyUtils.formatCurrency(model.total)

                tvChannel.text = model.channel

                tvJam.text = hourFormat.format(model.trxDate)

                cvVoid.isVisible = model.isVoid

                clContent.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    inner class HeaderViewHolder(private val binding : ItemHeaderBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : Sale){
            binding.apply {
                tvTglSesi.text = DateFormatUtils.getDate(model.trxDate)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Sale>(){
        override fun areItemsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem.id == newItem.id
        }
    }
}