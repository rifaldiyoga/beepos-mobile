package com.bits.bee.bpmc.presentation.ui.pembayaran_debit_kredit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.FragmentPembayaranDebitKreditBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranDebitKreditFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranDebitKreditBinding = FragmentPembayaranDebitKreditBinding::inflate
) : BaseFragment<FragmentPembayaranDebitKreditBinding>() {

    private val viewModel : PembayaranDebitKreditViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}