package com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_kategori

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRbPilihKategoriBinding
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterAdapter

class RbPilihKategoriAdapter(
    selected: Int,
    val ctx: Context,
    private val mListener: EditKategoriAdapterI
): RecyclerView.Adapter<RbPilihKategoriAdapter.ViewHolder>() {

    private var mSubKatList : MutableList<String> = mutableListOf()
    private var mStrKatList: MutableList<String> = mutableListOf()
    private var mKatPrdList : List<KategoriProduk> = mutableListOf()
    private var selectedPosition : Int = 0
    private lateinit var rbSubKategoriAdapter: RbSubKategoriAdapter
    private var subKatPosition: Int = 0

    init {
        this.selectedPosition = selected
    }

    fun initList(list: List<KategoriProduk>){
        this.mKatPrdList = list
    }

    fun getSelectedPosition() : Int = selectedPosition

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        parseStrKat(mKatPrdList)
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRbPilihKategoriBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val katPrd = mKatPrdList.get(position)
        holder.binding.apply {
            materialRadioButton.text = getItem(holder.absoluteAdapterPosition)

            materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

            materialRadioButton.setOnClickListener {
                selectedPosition = holder.absoluteAdapterPosition
                this@RbPilihKategoriAdapter.notifyDataSetChanged()
            }
            imgEdit.setOnClickListener {
                mListener.onClick(holder.absoluteAdapterPosition)
            }

            mSubKatList.clear()
            for (str in katPrd.subKategori!!){
                mSubKatList.add(str.name)
            }

//            if (materialRadioButton.isChecked){
//                subKatPosition = 0
//            }else{
//                subKatPosition = 1
//            }

            rbSubKategoriAdapter = RbSubKategoriAdapter(mSubKatList)
            rvChildKategori.apply {
                layoutManager = LinearLayoutManager(ctx)
                adapter = rbSubKategoriAdapter
            }
        }
    }

    override fun getItemCount(): Int = mKatPrdList.size

    fun getItem(i : Int) = mStrKatList[i]

    class ViewHolder(val binding : ItemRbPilihKategoriBinding) : RecyclerView.ViewHolder(binding.root)

    fun parseStrKat(mKatPrdList: List<KategoriProduk>) {
        mStrKatList.clear()
        for (str in mKatPrdList){
            mStrKatList.add(str.name)
        }
    }

    interface EditKategoriAdapterI{
        fun onClick(pos: Int)
    }
}