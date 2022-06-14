package com.bits.bee.bpmc.presentation.ui.beranda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentBerandaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class BerandaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBerandaBinding = FragmentBerandaBinding::inflate
) : BaseFragment<FragmentBerandaBinding>() {

    private val viewModel : BerandaViewModel by viewModels()

    override fun initComponents() {
    }

    override fun subscribeListeners() {
        binding.apply {
            tvDetail.setOnClickListener {
                viewModel.onDetailBukaKasirClick()
            }
            btnBukaKasir.setOnClickListener {
                viewModel.onBukaKasirClick()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getActiveBranch.collect {
                    it?.let {
                        viewModel.updateState(
                            viewModel.state.copy(
                                activeBranch = it
                            )
                        )
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getActiveCashier.collect {
                    it?.let {
                        viewModel.updateState(
                            viewModel.state.copy(
                                activeCashier = it
                            )
                        )
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let{
                        it.activeCashier?.let {
                            binding.tvGreeting.text = getString(R.string.halo_kasir_2, it.cashierName)
                        }
                        it.activeBranch?.let {
                            binding.tvKota.text = getString(R.string.di_surabaya, it.name)
                        }
                        if(it.posses != null){
                            binding.apply {
                                groupPendapatan.visible()
                                tvInfoKasir.text = getString(R.string.klik_tutup_kasir_untuk_mengakhiri_shift_3_ya, 1)
                                btnBukaKasir.text = getString(R.string.tutup_kasir)
                                tvTotalPendapatan.text = CurrencyUtils.formatCurrency(it.posses!!.total)
                            }
                        } else {
                            binding.apply {
                                groupPendapatan.gone()
                                tvInfoKasir.text = getString(R.string.klik_buka_kasir_untuk_memulai_shift_3_ya, 1)
                                btnBukaKasir.text = getString(R.string.buka_kasir)
                            }
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        BerandaViewModel.UIEvent.NavigateToBukaKasir -> {
                            val action = BerandaFragmentDirections.actionBerandaFragmentToDetailBukaKasirFragment()
                            findNavController().navigate(action)
                        }
                        BerandaViewModel.UIEvent.NavigateToTutupKasir -> {
                            val action = BerandaFragmentDirections.actionBerandaFragmentToDetailTutupKasirFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }

}