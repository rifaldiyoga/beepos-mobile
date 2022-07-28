package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentPembayaranNonTunaiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranNonTunaiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranNonTunaiBinding = FragmentPembayaranNonTunaiBinding::inflate
) : BaseFragment<FragmentPembayaranNonTunaiBinding>() {

    private val viewModel : PembayaranNonTunaiViewModel by viewModels()

    private lateinit var pembayaranAdapter : PembayaranAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadPmtd()
    }

    override fun initComponents() {
        binding.apply {
            pembayaranAdapter = PembayaranAdapter(
                onItemClick = {
                    viewModel.onClickItem(it)
                }
            )
            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = pembayaranAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        pembayaranAdapter.submitList(it.pmtdList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        is PembayaranNonTunaiViewModel.UIEvent.NavigateToDebitKredit -> {
                            val action = PembayaranNonTunaiFragmentDirections.actionPembayaranNonTunaiFragmentToPembayaranDebitKreditFragment(it.pmtd)
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