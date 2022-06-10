package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.FragmentPembayaranGopayBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranGopayFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranGopayBinding = FragmentPembayaranGopayBinding::inflate
) : BaseFragment<FragmentPembayaranGopayBinding>() {

    private val viewModel : PembayaranNonTunaiViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}