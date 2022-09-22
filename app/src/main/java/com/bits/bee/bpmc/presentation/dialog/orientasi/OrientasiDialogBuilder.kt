package com.bits.bee.bpmc.presentation.dialog.orientasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogRadioListBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.extension.gone
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 05/04/22.
 */
@AndroidEntryPoint
class OrientasiDialogBuilder(
    private val value : String,
    private val onFinish : (String) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListBinding = DialogRadioListBinding::inflate
) : BaseBottomSheetDialogFragment<DialogRadioListBinding>() {

    private lateinit var radioAdapter: OrientasiAdapter
    private var orientasiList = mutableListOf<String>()

    override fun initComponents() {
        binding.apply {
            tvTitle.text = getString(R.string.posisi_orientasi)
            orientasiList = resources.getStringArray(R.array.list_orientation).toMutableList()
            radioAdapter = OrientasiAdapter(orientasiList, orientasiList.indexOf(value))
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = radioAdapter
            }
            groupCustomButton.gone()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                radioAdapter.getSelectedPosition()?.let { selectedPos ->
                    onFinish(orientasiList[selectedPos])
                }
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {

    }

}