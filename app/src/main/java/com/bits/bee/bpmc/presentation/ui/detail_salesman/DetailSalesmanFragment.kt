package com.bits.bee.bpmc.presentation.ui.detail_salesman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.FragmentDetailSalesmanBinding
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.TaxInfoDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class DetailSalesmanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailSalesmanBinding = FragmentDetailSalesmanBinding::inflate
) : BaseFragment<FragmentDetailSalesmanBinding>() {

    private val viewModel : DetailSalesmanViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val bp = it.getParcelable<Srep>("srep")
            bp?.let {
                viewModel.updateState(
                    viewModel.state.copy(
                        srep = it
                    )
                )
            }
        }
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {

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
                            it.srep?.let { bp ->
                                tvSalesman.text = bp.name
                                tvNoTelp.text = bp.phone?.ifEmpty { "-" }
                                tvAlamat.text = bp.address?.ifEmpty { "-" }
                                tvKota.text = bp.cityCode?.ifEmpty { "-" }
                                tvEmail.text = bp.email?.ifEmpty { "-" }
                            }
                        }
                    }
                }
            }
        }
    }
}