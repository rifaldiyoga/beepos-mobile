package com.bits.bee.bpmc.presentation.ui.detail_menu_bantuan

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentDetailMenuHelpBinding
import com.bits.bee.bpmc.databinding.FragmentSettingListBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.setting_list.SettingListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailMenuHelpFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailMenuHelpBinding = FragmentDetailMenuHelpBinding::inflate
): BaseFragment<FragmentDetailMenuHelpBinding>() {

    private val viewModel : DetailMenuHelpViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            clFiturBeepos.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bee.id/news_category/beepos_mobile/")))
            }
            clKontakBee.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bee.id/kontak/")))
            }
            clPrivacy.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bee.id/privasi/")))
            }
            clLisensi.setOnClickListener {
                viewModel.onClickLisensi()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        DetailMenuHelpViewModel.UIEvent.NavigateToSettingLisensi ->{
                            val action = DetailMenuHelpFragmentDirections.actionDetailMenuHelpFragmentToSettingLisensiFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}