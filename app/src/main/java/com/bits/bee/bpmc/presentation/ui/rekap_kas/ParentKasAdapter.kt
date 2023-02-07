package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemParentKasAdptBinding
import com.bits.bee.bpmc.domain.model.Kas
import java.text.SimpleDateFormat
import java.util.*

class ParentKasAdapter constructor(
    val ctx: Context
): RecyclerView.Adapter<ParentKasAdapter.ViewHolder>() {

    private var mList: MutableList<Kas> = mutableListOf()
    private val sf = SimpleDateFormat("dd-MM-yyyy")
    private lateinit var nestedKasAdapter: NestedKasAdapter

    fun initList(kasList: MutableList<Kas>) {
        this.mList = kasList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemParentKasAdptBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemParentKasAdptBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val kasModel = mList.get(position)
        holder.binding.apply {
            tvTglKas.text = getDate(Date(kasModel.date))
            tvJmlTrans.text = "${kasModel.jmltrans} Transaksi"

            nestedKasAdapter = NestedKasAdapter(ctx)

            rvChildKas.apply {
                layoutManager = LinearLayoutManager(ctx)
                adapter = nestedKasAdapter
            }
            nestedKasAdapter.submitList(kasModel.listCadj)

//            clHeaderExpand.setOnClickListener {
//                sesiModel.expand = !sesiModel.expand
//                notifyItemChanged(holder.absoluteAdapterPosition)
//            }

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun getDate(dates: Date): String{
        val dateToday = sf.format(Date())
        val date = sf.format(dates)
        return if (dateToday == date) "Hari ini" else date
    }
}