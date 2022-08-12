package com.bits.bee.bpmc.presentation.dialog.radio_list

import android.app.DatePickerDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogRadioListBinding
import com.bits.bee.bpmc.databinding.DialogRadioListFilterBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class RadioListFilterDialog(
    val title : String,
    val stringList: List<String>,
    val posSelected: Int,
    val onSaveClick : (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListFilterBinding = DialogRadioListFilterBinding::inflate
):BaseBottomSheetDialogFragment<DialogRadioListFilterBinding>() {

    private lateinit var radioAdapter: RadioListAdapter

//    private lateinit var selectedStr: String

    override fun initComponents() {
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
            dialogFilterEtStartDate.setOnClickListener {
                val calendar: Calendar = Calendar.getInstance()
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH)
                val year = calendar.get(Calendar.YEAR)
                val format = SimpleDateFormat("dd/MM/yyyy")

                DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                    // Display Selected date in textbox
                    calendar.set(year, monthOfYear, dayOfMonth)
                    dialogFilterEtStartDate.setText(format.format(calendar.time))

                }, year, month, day).show()

            }
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
        TODO("Not yet implemented")
    }

}