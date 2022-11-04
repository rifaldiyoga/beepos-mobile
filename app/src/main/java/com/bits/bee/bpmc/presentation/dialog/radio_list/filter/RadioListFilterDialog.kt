package com.bits.bee.bpmc.presentation.dialog.radio_list.filter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogRadioListFilterBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RadioListFilterDialog(
    val ctx: Context,
    val title : String,
    val stringList: List<String>,
    var posSelected: Int,
    val onSaveClick : (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListFilterBinding = DialogRadioListFilterBinding::inflate
):BaseBottomSheetDialogFragment<DialogRadioListFilterBinding>() {

    private lateinit var radioDateAdapter: RadioDateAdapter

//    private lateinit var selectedStr: String

    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
            radioDateAdapter = RadioDateAdapter(childFragmentManager ,requireContext(), stringList, posSelected)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = radioDateAdapter
            }

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                if (radioDateAdapter.getSelectedPosition() == 3){
                    if (radioDateAdapter.getTextDate().isNotEmpty()){
                        onSaveClick(radioDateAdapter.getTextDate())
                    }else{
                        Toast.makeText(ctx, "Pilih tgl terlebih dahulu!!", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    onSaveClick(stringList[radioDateAdapter.getSelectedPosition()])
                }
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
            tvReset.setOnClickListener {
                posSelected = 0
                initComponents()
            }
        }
    }

    override fun subscribeObservers() {

    }

}