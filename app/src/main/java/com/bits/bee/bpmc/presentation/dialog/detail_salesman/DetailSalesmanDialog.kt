package com.bits.bee.bpmc.presentation.dialog.detail_salesman

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.DialogDetailSalesmanBinding
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.TaxInfoDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class DetailSalesmanDialog(
    private val srep : Srep,
    private val onSubmit : (Dialog) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDetailSalesmanBinding = DialogDetailSalesmanBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDetailSalesmanBinding>() {

    private val viewModel : DetailSalesmanViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val bp = it.getParcelable<Srep>("srep")
            bp?.let {

            }
        }
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            imgViewClose.setOnClickListener {
                dismiss()
            }
            buttonClosed.setOnClickListener {
                mainViewModel.updateActiveSrep(srep)
                dialog?.let {
                    onSubmit(it)
                }
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DetailSalesmanViewModel.UIEvent.RequestInfoTax -> {
                            val dialog = TaxInfoDialog()
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            srep.let { bp ->
                                tvSalesman.text = bp.name
                                tvNoTelp.text = bp.phone ?: "-"
                                tvAlamat.text = bp.address ?: "-"
                                tvKota.text = bp.cityCode ?: "-"
                                tvEmail.text = bp.email ?: "-"
                            }
                        }
                    }
                }
            }
        }
    }
}