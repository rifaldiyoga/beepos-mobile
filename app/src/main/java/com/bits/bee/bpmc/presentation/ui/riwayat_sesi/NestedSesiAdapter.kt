package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemNestedSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.sql.Date
import java.text.SimpleDateFormat

class NestedSesiAdapter constructor(
    private val mListener: PilihRiwayatSesiI,
    private val ctx: Context
): ListAdapter<Posses, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemNestedSesiBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as NestedSesiAdapter.ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemNestedSesiBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Posses) {
            binding.apply {
                tvSesi.text = "Sesi#${model.shift}"
                tvtotalRekap.text = ctx.getString(R.string.mata_uang_nominal,
                        "Rp", CurrencyUtils.formatCurrency(model.startBal.add(model.total)))

                val backToDate = Date(model.trxDate.time)
                val format = SimpleDateFormat("kk:mm")

                tvRekapWaktu.text = format.format(backToDate)

                clNestedSesi.setOnClickListener {
                    mListener.onclick(model)
                }
//                lLContentMember.setOnClickListener {
//                    onMemberClick(model)
//                }
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Posses>(){

        override fun areItemsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem.possesId == newItem.possesId
        }

    }

    interface PilihRiwayatSesiI{
        fun onclick(posses: Posses)
    }

}