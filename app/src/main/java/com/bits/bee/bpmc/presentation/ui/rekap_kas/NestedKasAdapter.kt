package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemRekapKasBinding
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.sql.Date
import java.text.SimpleDateFormat

class NestedKasAdapter(private  val ctx: Context) : ListAdapter<Cadj, RecyclerView.ViewHolder>(Diffcallback()) {

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
                tvNamaKasir.text = BeePreferenceManager.getDataFromPreferences(ctx, ctx.getString(R.string.pref_user_kasir), "") as String
                tvDeskripsi.text = model.note
                tvJmlKas.text = ctx.getString(R.string.mata_uang_nominal,
                    "Rp", CurrencyUtils.formatCurrency(model.amount))

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