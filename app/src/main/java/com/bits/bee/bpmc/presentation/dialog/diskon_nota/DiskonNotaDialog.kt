package com.bits.bee.bpmc.presentation.dialog.diskon_nota

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
import com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceFragmentDirections
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 27/06/22.
 */
@AndroidEntryPoint
class DiskonNotaDialog(
    private var tipe : String,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDiskonNotaBinding = DialogDiskonNotaBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDiskonNotaBinding>() {

    private val viewModel : DiskonNotaViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onResume() {
        super.onResume()
        findNavController().currentBackStackEntry?.savedStateHandle?.apply {
            getLiveData<Boolean>(BPMConstants.ACS_DISC_MASTER).observe(viewLifecycleOwner) {
                viewModel.state.isEditDisc = it
                binding.etDiskon.requestFocus()
            }
        }
    }

    override fun initComponents() {
        viewModel.loadData()
        binding.apply {

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
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        is DiskonNotaViewModel.UIEvent.RequestDiskonNota -> {
                            mainViewModel.onUpdateDiskonNota(it.diskon)
                            dismiss()
                        }
                        DiskonNotaViewModel.UIEvent.NavigateToHakAkses -> {
                            binding.etDiskon.clearFocus()
                            val dialog = TidakAdaAksesDialog {
                                it.dismiss()

                                if(mainViewModel.orientation.value == BPMConstants.SCREEN_LANDSCAPE) {
                                    tipe = "pos"
                                }

                                val action = when(tipe){
                                    "pos" -> PosFragmentDirections.actionPosFragmentToHakAksesFragment(BPMConstants.ACS_DISC_MASTER)
                                    else -> InvoiceFragmentDirections.actionInvoiceFragmentToHakAksesFragment(BPMConstants.ACS_DISC_MASTER)
                                }
                                findNavController().navigate(action)
                            }

                            dialog.show(parentFragmentManager, "")
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.viewStates().collect {
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