package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentDetailTransaksiPenjualanBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 23/06/22.
 */
@AndroidEntryPoint
class DetailTransaksiPenjualanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTransaksiPenjualanBinding = FragmentDetailTransaksiPenjualanBinding::inflate
) : BaseFragment<FragmentDetailTransaksiPenjualanBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
//            val
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}