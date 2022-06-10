package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentAnalisaSesiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class AnalasisiSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAnalisaSesiBinding = FragmentAnalisaSesiBinding::inflate
) : BaseFragment<FragmentAnalisaSesiBinding>() {

    override fun initComponents() {
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
    }


}