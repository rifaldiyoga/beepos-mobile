package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemNestedSesiBinding
import com.bits.bee.bpmc.databinding.ItemRekapKasBinding
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.ui.riwayat_sesi.NestedSesiAdapter
import java.sql.Date
import java.text.SimpleDateFormat

class NestedKasAdapter constructor(

): ListAdapter<Cadj, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRekapKasBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemRekapKasBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Cadj) {
            binding.apply {
                tvNamaKasir.text = "Kasir#${model.cashAId}"
                tvDeskripsi.text = model.note
                tvJmlKas.text = model.amount.toString()

                val backToDate = Date(model.trxDate)
                val format = SimpleDateFormat("kk:mm")

                tvKasWaktu.text = format.format(backToDate)

            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Cadj>(){

        override fun areItemsTheSame(oldItem: Cadj, newItem: Cadj): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cadj, newItem: Cadj): Boolean {
            return oldItem.id == newItem.id
        }

    }
}