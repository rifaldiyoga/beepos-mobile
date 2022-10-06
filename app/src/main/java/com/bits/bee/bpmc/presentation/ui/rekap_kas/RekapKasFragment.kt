package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRekapKasBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class RekapKasFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRekapKasBinding = FragmentRekapKasBinding::inflate
) : BaseFragment<FragmentRekapKasBinding>() {
    private lateinit var vpAdapterRekapKas: VPAdapterRekapKas

    override fun initComponents() {
        setHasOptionsMenu(true)
        vpAdapterRekapKas = VPAdapterRekapKas(childFragmentManager, lifecycle, requireContext())

        with(binding){
            vPRekapKas.adapter = vpAdapterRekapKas

            TabLayoutMediator(tLRekapKas, vPRekapKas){ tab, position ->
                when(position){
                    0 -> tab.text = requireActivity().getString(R.string.kas_masuk)
                    1 -> tab.text = requireActivity().getText(R.string.kas_kelaur)
                }
            }.attach()
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}