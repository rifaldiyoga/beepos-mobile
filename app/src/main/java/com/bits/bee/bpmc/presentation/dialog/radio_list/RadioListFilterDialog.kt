package com.bits.bee.bpmc.presentation.dialog.radio_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogRadioListFilterBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RadioListFilterDialog(
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
//            radioAdapter = RadioListAdapter(stringList, posSelected)
//            recyclerView.apply {
//                layoutManager = LinearLayoutManager(requireContext())
//                adapter = radioAdapter
//            }
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
                    onSaveClick(radioDateAdapter.getTextDate())
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