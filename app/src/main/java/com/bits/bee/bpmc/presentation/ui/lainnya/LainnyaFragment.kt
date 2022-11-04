package com.bits.bee.bpmc.presentation.ui.lainnya

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentLainnyaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class LainnyaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLainnyaBinding = FragmentLainnyaBinding::inflate
) : BaseFragment<FragmentLainnyaBinding>() {

    private val viewModel : LainnyaViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            clUploadManual.setOnClickListener {
                viewModel.onUploadManual()
            }
            clCekStok.setOnClickListener {
                viewModel.onCekStok()
            }
            clKelolaProduk.setOnClickListener {
                viewModel.onKelolaProduk()
            }
            clPengaturan.setOnClickListener {
                viewModel.onPengaturan()
            }
            clRekapKas.setOnClickListener {
                viewModel.onRekapKas()
            }
            clRekapProduk.setOnClickListener {
                viewModel.onRekapProduk()
            }
            clPerbaruiData.setOnClickListener {
                viewModel.onDownload()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        LainnyaViewModel.UIEvent.NavigateToCekStok -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToCekStokFragment()
                            findNavController().navigate(action)
                        }
                        LainnyaViewModel.UIEvent.NavigateToKelolaProduk -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToInsightKelolaProdukFragment()
                            findNavController().navigate(action)
                        }
                        LainnyaViewModel.UIEvent.NavigateToPengaturan -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToSettingListFragment()
                            findNavController().navigate(action)
                        }
                        LainnyaViewModel.UIEvent.NavigateToRekapKas -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToRekapKasFragment()
                            findNavController().navigate(action)
                        }
                        LainnyaViewModel.UIEvent.NavigateToUploadManual -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToUploadManualFragment()
                            findNavController().navigate(action)
                        }
                        LainnyaViewModel.UIEvent.NavigateToRekapProduk -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToRekapProdukFragment()
                            findNavController().navigate(action)
                        }
                        LainnyaViewModel.UIEvent.NavigateToDownload -> {
                            val action = LainnyaFragmentDirections.actionLainnyaFragmentToDownloadDialogBuilder()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}