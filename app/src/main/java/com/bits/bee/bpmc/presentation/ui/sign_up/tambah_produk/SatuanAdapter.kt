package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.text.InputFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemSatuanInputBinding
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone

/**
 * Created by aldi on 27/10/22
 */
class SatuanAdapter(
    private val onSatuanChange: (Int, String) -> Unit,
    private val onQtyChange: (Int, String) -> Unit,
    private val onDelete: (Int) -> Unit,
    private val onUpdateSatuan: (String) -> Unit,
    private val msgQty: String?,
) : ListAdapter<UnitDummy, RecyclerView.ViewHolder>(DiffCallback()) {

    private lateinit var txtFnb: String
    private var isFnb: Boolean = false
    private var errorQty: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemSatuanInputBinding.inflate(inflater, parent, false)
        )
    }

    fun setTxtView(txtView: String, fnb: Boolean){
        this.txtFnb = txtView
        this.isFnb = fnb
    }

    fun setError(error: String){
        this.errorQty = error
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding : ItemSatuanInputBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model : UnitDummy) {
            binding.apply {
                if(absoluteAdapterPosition == 0){
                    clKonversi.gone()
                } else {
                    tvSatuanParent.text = getItem(0).unit
                }
                txtSatuan.text = if (isFnb) txtFnb else lLSatuan.context.getString(R.string.satuan1, absoluteAdapterPosition + 1)
                etSatuan.setText(model.unit)
                etQty.setText(CurrencyUtils.formatCurrency(model.conv))
                etSatuan.filters = arrayOf(InputFilter.AllCaps(), InputFilter.LengthFilter(11))
                etSatuan.addTextChangedListener {
                    if (absoluteAdapterPosition == 0){
                        model.unitUp = etSatuan.text.toString().trim()
                        onSatuanChange(absoluteAdapterPosition, etSatuan.text.toString().trim())
                        onUpdateSatuan(etSatuan.text.toString().trim())
                    }else{
                        model.unit = etSatuan.text.toString().trim()
                        onSatuanChange(absoluteAdapterPosition, etSatuan.text.toString().trim())
                    }
                    if (etSatuan.length() > 10){
                        tilSatuan.error = "Tidak bisa melebihi 10 karakter"
                    }else{
                        tilSatuan.isErrorEnabled = false
                    }
                }
                etQty.addTextChangedListener {
                    if(etQty.text.toString().isNotEmpty()){
                        onQtyChange(absoluteAdapterPosition, etQty.text.toString().trim())
                    }
                    if (absoluteAdapterPosition == 2){
                        errorQty?.let {
                            tilQty.error = it
                        }
                    }
                }
                btnDelete.setOnClickListener {
                    onDelete(absoluteAdapterPosition)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<UnitDummy>() {
        override fun areItemsTheSame(oldItem: UnitDummy, newItem: UnitDummy): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UnitDummy, newItem: UnitDummy): Boolean {
            return oldItem == newItem
        }

    }

}