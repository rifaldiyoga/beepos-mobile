package com.bits.bee.bpmc.presentation.dialog.radio_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogRadioListBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.ui.setting_sistem.SettingSistemViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 05/04/22.
 */
@AndroidEntryPoint
class RadioListDialogBuilder(
    val title : String,
    val stringList: List<String>,
    val posSelected: Int,
    val onSaveClick : (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListBinding = DialogRadioListBinding::inflate
) : BaseBottomSheetDialogFragment<DialogRadioListBinding>() {

    private lateinit var radioAdapter: RadioListAdapter
    private lateinit var selectedStr: String

    override fun initComponents() {
        selectedStr = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_value_selected), "") as String
        binding.apply {
            tvTitle.text = title
            radioAdapter = RadioListAdapter(stringList, posSelected)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = radioAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                onSaveClick(stringList[radioAdapter.getSelectedPosition()])
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