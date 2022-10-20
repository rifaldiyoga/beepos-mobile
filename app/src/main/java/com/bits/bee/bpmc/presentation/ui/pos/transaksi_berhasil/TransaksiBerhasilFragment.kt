package com.bits.bee.bpmc.presentation.ui.pos.transaksi_berhasil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTransaksiBerhasilBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class TransaksiBerhasilFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTransaksiBerhasilBinding = FragmentTransaksiBerhasilBinding::inflate
) : BaseFragment<FragmentTransaksiBerhasilBinding>() {

    private val viewModel : TransaksiBerhasilViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun initComponents() {
        binding.apply {
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {

            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTutup.setOnClickListener {
                viewModel.onTutupClick()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect {
                    when(it){
                        TransaksiBerhasilViewModel.UIEvent.NavigateToPos -> {
//                            val action = TransaksiBerhasilFragmentDirections.actionTransaksiBerhasilFragmentToPosFragment()
                            findNavController().popBackStack(R.id.posFragment, false)
                            mainViewModel.resetState()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.viewStates().collect {
                    it?.let { state ->
                        val kembali = getString(R.string.mata_uang_nominal, state.crc?.symbol ?: "", CurrencyUtils.formatCurrency(state.sale.totChange))
                        val bayar = termType(state.sale.termType)
                        binding.tvKembali.text =  getString(R.string.kembali_4_500_dibayar_tunai, kembali, bayar)
                    }
                }
            }
        }
    }

    private fun termType(value : String) : String {
        return when(value){
            BPMConstants.BPM_DEFAULT_TYPE_TUNAI -> BPMConstants.BPM_DEFAULT_TYPE_TUNAI
            BPMConstants.DEBIT_CARD_CODE -> getString(R.string.kartu_debit)
            BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY -> getString(R.string.gopay)
            else -> getString(R.string.kartu_kredit)
        }
    }
}