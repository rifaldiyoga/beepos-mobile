package com.bits.bee.bpmc.presentation.dialog.radio_list.filter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogRadioListFilterBinding
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.FilterUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RadioListFilterDialog(
    val ctx: Context,
    val title : String,
    private val stringList: List<String>,
    var filterDate : FilterDate,
    val onSaveClick : (FilterDate) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListFilterBinding = DialogRadioListFilterBinding::inflate
):BaseBottomSheetDialogFragment<DialogRadioListFilterBinding>() {

    private lateinit var radioDateAdapter: RadioDateAdapter

    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
            radioDateAdapter = RadioDateAdapter(childFragmentManager ,requireContext(), stringList, filterDate.selectedPos)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = radioDateAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                if (radioDateAdapter.getSelectedPosition() == 3 && radioDateAdapter.getTextDate().isEmpty()){
                    Toast.makeText(ctx, "Tanggal belum diatur", Toast.LENGTH_SHORT).show()
                } else {
                    onSaveClick(FilterUtils.getFilterDate(radioDateAdapter.getSelectedPosition(), radioDateAdapter.getTextDate()))
                    dismiss()
                }
            }
            imageView2.setOnClickListener {
                dismiss()
            }
            tvReset.setOnClickListener {
                radioDateAdapter = RadioDateAdapter(childFragmentManager ,requireContext(), stringList, 0)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = radioDateAdapter
                }
            }
        }
    }

    override fun subscribeObservers() {

    }

}