package com.bits.bee.bpmc.presentation.ui.cek_stok

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentCekStokBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class CekStokFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCekStokBinding = FragmentCekStokBinding::inflate
) : BaseFragment<FragmentCekStokBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}