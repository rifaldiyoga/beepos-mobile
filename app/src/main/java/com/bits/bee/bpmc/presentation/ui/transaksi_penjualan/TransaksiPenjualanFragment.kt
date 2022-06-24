package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentAnalisaSesiBinding
import com.bits.bee.bpmc.databinding.FragmentTransaksiPenjualanBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class TransaksiPenjualanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTransaksiPenjualanBinding = FragmentTransaksiPenjualanBinding::inflate
) : BaseFragment<FragmentTransaksiPenjualanBinding>() {

    private val viewModel : TransaksiPenjualanViewModel by viewModels()

    private lateinit var transAdapter : TransaksiPenjualanAdapter

    override fun initComponents() {
        viewModel.getLatestSale()
    }

    override fun subscribeListeners() {
        binding.apply {
            transAdapter = TransaksiPenjualanAdapter(
                onItemClick = {
                    val action = TransaksiPenjualanFragmentDirections.actionTransaksiPenjualanFragmentToDetailTransaksiPenjualanFragment(it)
                    findNavController().navigate(action)
                }
            )
            rvList.apply {
                adapter = transAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        if(it.saleList.isNotEmpty()){
                            transAdapter.submitList(it.saleList)
                        }
                        setVisibilityList(it.saleList.isNotEmpty())
                    }
                }
            }
        }
    }

    private fun setVisibilityList(isVisible : Boolean) {
        binding.apply {
            if(isVisible){
                rvList.visible()
                groupEmpty.gone()
            } else {
                rvList.gone()
                groupEmpty.visible()
            }
        }
    }
}