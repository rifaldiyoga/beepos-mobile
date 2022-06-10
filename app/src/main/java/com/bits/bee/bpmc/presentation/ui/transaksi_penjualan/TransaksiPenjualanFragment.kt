package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentAnalisaSesiBinding
import com.bits.bee.bpmc.databinding.FragmentTransaksiPenjualanBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class TransaksiPenjualanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTransaksiPenjualanBinding = FragmentTransaksiPenjualanBinding::inflate
) : BaseFragment<FragmentTransaksiPenjualanBinding>() {

    override fun initComponents() {
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
    }


}