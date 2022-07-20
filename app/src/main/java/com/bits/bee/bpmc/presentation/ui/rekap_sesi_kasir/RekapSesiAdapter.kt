package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemAdapterSimpleBinding
import com.bits.bee.bpmc.databinding.ItemRekapSesiBinding
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.presentation.ui.cari_kecamatan.KecamatanAdapter
import com.bits.bee.bpmc.presentation.ui.cari_kota.RekomendasiKotaAdapter
import java.math.BigDecimal
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

class RekapSesiAdapter constructor(
    private val mListener: PilihRekapSesiI
): PagingDataAdapter<Posses, RecyclerView.ViewHolder>(DiffCallback()) {

    var mUser: User? = null

    fun submitValue(user: User?) {
        this.mUser = user!!
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRekapSesiBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding: ItemRekapSesiBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(posses: Posses){
            binding.apply {
                mUser?.let {
                    tvUserKasir.text = mUser!!.name
                }
                tvtotalRekap.text = posses.endBal.toString()

                val backToDate = Date(posses.trxDate.time)
                val format = SimpleDateFormat("yyyy.MM.dd")

                tvRekapWaktu.text = format.format(backToDate)

                lLRekapSesi.setOnClickListener {
                    mListener.onclick(posses)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Posses>(){
        override fun areItemsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem == newItem
        }

    }

    public interface PilihRekapSesiI{
        fun onclick(posses: Posses)
    }
}