package com.bits.bee.bpmc.presentation.ui.insight_kelola_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentInsightKelolaProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class InsightKelolaProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInsightKelolaProdukBinding = FragmentInsightKelolaProdukBinding::inflate
) : BaseFragment<FragmentInsightKelolaProdukBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}