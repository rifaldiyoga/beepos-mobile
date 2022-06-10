package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentAnalisaSesiBinding
import com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class DetailTutupKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTutupKasirBinding = FragmentDetailTutupKasirBinding::inflate
) : BaseFragment<FragmentDetailTutupKasirBinding>() {

    override fun initComponents() {
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
    }


}