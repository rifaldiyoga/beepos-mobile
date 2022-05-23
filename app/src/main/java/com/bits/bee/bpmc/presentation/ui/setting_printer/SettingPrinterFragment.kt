package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentSettingPrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.presentation.ui.setting_list.SettingListFragmentDirections
import com.bits.bee.bpmc.presentation.ui.setting_list.SettingListViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SettingPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingPrinterBinding = FragmentSettingPrinterBinding::inflate
): BaseFragment<FragmentSettingPrinterBinding>() {

    private val viewModel : SettingPrinterViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            btnTambah.setOnClickListener {
                viewModel.onClickAddPrinter()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        SettingPrinterViewModel.UIEvent.RequestAddPrinter -> {
                            val action = SettingPrinterFragmentDirections.actionSettingPrinterFragmentToAddPrinterFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }

}