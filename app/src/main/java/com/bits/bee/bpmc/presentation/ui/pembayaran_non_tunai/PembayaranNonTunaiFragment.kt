package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentPembayaranNonTunaiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
class PembayaranNonTunaiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranNonTunaiBinding = FragmentPembayaranNonTunaiBinding::inflate
) : BaseFragment<FragmentPembayaranNonTunaiBinding>() {

    private val viewModel : PembayaranNonTunaiViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            clGopay.setOnClickListener {
                viewModel.onClickGopay()
            }
            clDebit.setOnClickListener {
                viewModel.onClickDebitKredit()
            }
            clKartuKredit.setOnClickListener {
                viewModel.onClickDebitKredit()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        PembayaranNonTunaiViewModel.UIEvent.NavigateToDebitKredit -> {
                            val action = PembayaranNonTunaiFragmentDirections.actionPembayaranNonTunaiFragmentToPembayaranDebitKreditFragment()
                            findNavController().navigate(action)
                        }
                        PembayaranNonTunaiViewModel.UIEvent.NavigateToGopay -> {
                            val action = PembayaranNonTunaiFragmentDirections.actionPembayaranNonTunaiFragmentToPembayaranGopayFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}