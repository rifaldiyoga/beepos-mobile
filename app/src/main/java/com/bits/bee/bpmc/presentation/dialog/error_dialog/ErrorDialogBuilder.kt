package com.bits.bee.bpmc.presentation.dialog.error_dialog

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bits.bee.bpmc.databinding.DialogErrorBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ErrorDialogBuilder constructor(
    private val detailError : String,
    private val exception: Exception? = null,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogErrorBinding = DialogErrorBinding::inflate
) : BaseBottomSheetDialogFragment<DialogErrorBinding>() {

    private var isExpanded : Boolean = false

    override fun initComponents() {
        binding.apply {
            tvErrorDetail.text = detailError
            tvErrorDetail.isSingleLine = !isExpanded
            tvShowDetail.isVisible = detailError.length > 59
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnHubungi.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://bee.id/z/kontak")))
            }
            btnTutup.setOnClickListener {
                dismiss()
            }
            imagClose.setOnClickListener {
                dismiss()
            }
            tvShowDetail.setOnClickListener {
                isExpanded = !isExpanded
                tvErrorDetail.isSingleLine = !isExpanded
                tvShowDetail.text = if(isExpanded) "Tutup Detail" else "Lihat Detail"
            }
        }
    }

    override fun subscribeObservers() {

    }

}