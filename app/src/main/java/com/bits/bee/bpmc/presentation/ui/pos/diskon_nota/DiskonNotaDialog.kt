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
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.DialogDiskonNotaBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.TidakAdaAksesDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.edit_item.EditItemFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
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
        viewModel.loadData()
        binding.apply {
            findNavController().currentBackStackEntry?.savedStateHandle?.apply {
                getLiveData<Boolean>(BPMConstants.ACS_DISC_MASTER).observe(viewLifecycleOwner) {
                    viewModel.state.isEditDisc = it
                    etDiskon.requestFocus()
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etDiskon.setOnFocusChangeListener { _, b ->
                if(b)
                    viewModel.onDiscFocus()
            }
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
                        DiskonNotaViewModel.UIEvent.NavigateToHakAkses -> {
                            val dialog = TidakAdaAksesDialog {
                                it.dismiss()
                                val action = DiskonNotaDialogDirections.actionDiskonNotaDialogToHakAksesFragment(BPMConstants.ACS_PRICE_EDIT)
                                findNavController().navigate(action)
                            }

                            dialog.show(parentFragmentManager, "")
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