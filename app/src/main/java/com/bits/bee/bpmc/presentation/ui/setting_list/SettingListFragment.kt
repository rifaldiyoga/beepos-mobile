package com.bits.bee.bpmc.presentation.ui.setting_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingListBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
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
            clFavorit.setOnClickListener {
                viewModel.onClickSettingFavorit()
            }
            clSistem.setOnClickListener {
                viewModel.onClickSettingSistem()
            }
            clNota.setOnClickListener {
                viewModel.onClickSettingNota()
            }
            clHelp.setOnClickListener {
                viewModel.onClickHelp()
            }
            clPrint.setOnClickListener {
                viewModel.onClickSettingPrint()
            }
            clKeluar.setOnClickListener {
                viewModel.onClickKeluar()
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
                            val action = SettingListFragmentDirections.actionSettingListFragmentToSettingFavoriteFragmentMain()
                            findNavController().navigate(action)
                        }
                        SettingListViewModel.UIEvent.NavigateToSettingNota -> {
                            val action = SettingListFragmentDirections.actionSettingListFragmentToSettingNotaFragment()
                            findNavController().navigate(action)
                        }
                        SettingListViewModel.UIEvent.NavigateToSettingPrint -> {
                            val action = SettingListFragmentDirections.actionSettingListFragmentToSettingPrinterFragment()
                            findNavController().navigate(action)
                        }
                        SettingListViewModel.UIEvent.NavigateToSettingSistem -> {
                            val action = SettingListFragmentDirections.actionSettingListFragmentToSettingSistemFragment()
                            findNavController().navigate(action)
                        }
                        SettingListViewModel.UIEvent.NavigateToLoginOperator ->{
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
                                R.string.page_pilih_operator))
                            val action = SettingListFragmentDirections.actionSettingListFragmentToInitialActivity()
                            findNavController().navigate(action)
                        }
                        SettingListViewModel.UIEvent.NavigateToDetailHelp ->{
                            val action = SettingListFragmentDirections.actionSettingListFragmentToDetailMenuHelpFragment()
                            findNavController().navigate(action)
                        }
                        else -> {}
                    }
                }
            }
        }
    }


}