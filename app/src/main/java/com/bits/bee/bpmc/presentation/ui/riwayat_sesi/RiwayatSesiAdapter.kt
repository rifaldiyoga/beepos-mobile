package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRekapSesiBinding
import com.bits.bee.bpmc.databinding.ItemRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiAdapter
import java.sql.Date
import java.text.SimpleDateFormat

class RiwayatSesiAdapter constructor(
    private val mListener: PilihRiwayatSesiI
):  PagingDataAdapter<Posses, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRiwayatSesiBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding: ItemRiwayatSesiBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(posses: Posses){
            binding.apply {
                tvSesi.text = "Sesi#${posses.shift}"
                tvtotalRekap.text = posses.endBal.toString()

                val backToDate = Date(posses.trxDate.time)
                val format = SimpleDateFormat("yyyy.MM.dd")

                tvRekapWaktu.text = format.format(backToDate)

                lLRiwayatSesi.setOnClickListener {
                    mListener.onclick(posses)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Posses>(){
        override fun areItemsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem.possesId == newItem.possesId
        }

        override fun areContentsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem == newItem
        }

    }

    interface PilihRiwayatSesiI{
        fun onclick(posses: Posses)
    }
}