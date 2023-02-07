package com.bits.bee.bpmc.presentation.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogAturHeaderfooterBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AturDialogBuilder(
    val title: String,
    val title2: String,
    val onSaveClick : (Any) -> Unit,
    val setEdt: String,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogAturHeaderfooterBinding = DialogAturHeaderfooterBinding::inflate
): BaseBottomSheetDialogFragment<DialogAturHeaderfooterBinding>() {

    lateinit var content: String

    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
            tVTitle2.text = title2
            txtInputEContent.setText(setEdt)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                onSaveClick(getEditText())
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {

    }

    private fun getEditText(): String{
        binding.apply {
            content = txtInputEContent.text.toString()
        }
        return content
    }
}