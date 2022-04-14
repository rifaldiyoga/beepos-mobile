package com.bits.bee.bpmc.presentation.ui.setting_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentSettingListBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 04/04/22.
 */
@AndroidEntryPoint
class SettingListFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingListBinding = FragmentSettingListBinding::inflate
) : BaseFragment<FragmentSettingListBinding>() {

    private val viewModel : SettingListViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            clPos.setOnClickListener {
                viewModel.onClickSettingPos()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        SettingListViewModel.UIEvent.NavigateToSettingPos -> {
                            val action = SettingListFragmentDirections.actionSettingListFragmentToSettingPosFragment()
                            findNavController().navigate(action)
                        }
                        SettingListViewModel.UIEvent.NavigateToSettingFavorit -> {

                        }
                        SettingListViewModel.UIEvent.NavigateToSettingLisensi -> {

                        }
                        SettingListViewModel.UIEvent.NavigateToSettingNota -> {

                        }
                        SettingListViewModel.UIEvent.NavigateToSettingPrint -> {

                        }
                        SettingListViewModel.UIEvent.NavigateToSettingSistem -> {

                        }
                    }
                }
            }
        }
    }


}