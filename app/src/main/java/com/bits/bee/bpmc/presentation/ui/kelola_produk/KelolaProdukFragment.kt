package com.bits.bee.bpmc.presentation.ui.kelola_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentKelolaProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class KelolaProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKelolaProdukBinding = FragmentKelolaProdukBinding::inflate
) : BaseFragment<FragmentKelolaProdukBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}