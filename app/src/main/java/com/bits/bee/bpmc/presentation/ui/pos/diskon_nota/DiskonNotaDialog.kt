package com.bits.bee.bpmc.presentation.ui.pos.diskon_nota

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.DialogDiskonNotaBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 27/06/22.
 */
@AndroidEntryPoint
class DiskonNotaDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDiskonNotaBinding = DialogDiskonNotaBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDiskonNotaBinding>() {

    private val viewModel : DiskonNotaViewModel by viewModels()

    private val mViewModel : MainViewModel by activityViewModels()

    override fun initComponents() {
        binding.apply {
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnBatal.setOnClickListener {
                dismiss()
            }
            btnTambah.setOnClickListener {
                viewModel.onTambahClick()
            }
            etDiskon.addTextChangedListener {
                viewModel.state.diskon = etDiskon.text.toString().trim()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        is DiskonNotaViewModel.UIEvent.RequestDiskonNota -> {
                            mViewModel.onUpdateDiskonNota(it.diskon)
                            dismiss()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mViewModel.viewStates().collect {
                it?.let {
                    viewModel.state.diskon = it.sale.discExp
                    viewModel.state.subtotal = it.sale.subtotal
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collect {
                it?.let {
                    binding.etDiskon.setText(it.diskon)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collectLatest {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

}