package com.bits.bee.bpmc.presentation.ui.beranda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentBerandaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class BerandaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBerandaBinding = FragmentBerandaBinding::inflate
) : BaseFragment<FragmentBerandaBinding>() {

    override fun initComponents() {
    }

    override fun subscribeListeners() {
        binding.apply {
            linearLayout14.setOnClickListener {
                val action = BerandaFragmentDirections.actionBerandaFragmentToMainActivity()
                findNavController().navigate(action)
            }
            linearLayout15.setOnClickListener {
                val action = BerandaFragmentDirections.actionBerandaFragmentToSettingListFragment()
                findNavController().navigate(action)
            }
            linearLayout16.setOnClickListener {
                val action = BerandaFragmentDirections.actionBerandaFragmentToDownloadActivity()
                findNavController().navigate(action)
            }
        }
    }

    override fun subscribeObservers() {
    }


}