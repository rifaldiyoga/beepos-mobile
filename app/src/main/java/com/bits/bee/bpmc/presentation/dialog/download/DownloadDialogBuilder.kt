package com.bits.bee.bpmc.presentation.dialog.download

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogDownloadBinding
import com.bits.bee.bpmc.presentation.base.BaseDialogFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.error_dialog.ErrorDialogBuilder
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/09/22
 */
@AndroidEntryPoint
class DownloadDialogBuilder(
    val isCancel : Boolean = true,
    val onFinishDownload : (Dialog) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDownloadBinding = DialogDownloadBinding::inflate
) : BaseDialogFragment<DialogDownloadBinding>() {

    private val viewModel : DownloadViewModel by viewModels()

    override fun initComponents() {
        isCancelable = false
        binding.apply {
            tvBatal.isVisible = isCancel
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            tvBatal.setOnClickListener {
                val dialog = DialogBuilderHelper.showDialogChoice(requireActivity(),
                    getString(R.string.batal_perbarui_data),
                    getString(R.string.msg_batal_perbarui_data),
                    getString(R.string.lanjut_perbarui),
                    {
                        it.dismiss()
                    },
                    getString(R.string.batalkan),
                    {
                        it.dismiss()
                        dismiss()
                    })
                dialog.show(parentFragmentManager, "")
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DownloadViewModel.UIEvent.FinishDownload -> {
                            onFinishDownload(dialog!!)
                            dismiss()
                        }
                        DownloadViewModel.UIEvent.ShowNoInternet -> {
                            val dialog = NoInternetDialogBuilder({
                                viewModel.downloadAll()
                            }, onNegative = {
                                dismiss()
                            })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        is DownloadViewModel.UIEvent.ShowError -> {
                            val dialog = ErrorDialogBuilder(it.msg,)
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        if(it.status.isNotEmpty())
                            binding.tvDownload.text = it.status
                        binding.progressBar3.progress = it.progress
                        binding.tvProgress.text = "${it.progress}%"
                    }
                }
            }
        }
    }
}