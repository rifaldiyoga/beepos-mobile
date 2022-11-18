package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.pid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInsightPidBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk.AturProdukViewModel
import com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.TambahProdukViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InsightPidFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInsightPidBinding = FragmentInsightPidBinding::inflate
): BaseFragment<FragmentInsightPidBinding>() {

    private val viewModel : TambahProdukViewModel by activityViewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            bpCbPajak.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    viewModel.updateIsPid(b)
                }else{
                    viewModel.updateIsPid(b)
                }
            }

            btnPrimary.setOnClickListener {
                viewModel.onClickActivePid()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect {
                    when (it) {
                        TambahProdukViewModel.UIEvent.AfterAcivePId ->{
                            findNavController().popBackStack()
                        }
                        else -> {}
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            btnPrimary.apply {
                                background = ContextCompat.getDrawable(requireContext(), when(it.isActivePid){
                                    true -> R.drawable.btn_rect_primary
                                    false -> R.drawable.btn_rect_disable
                                })
                                isEnabled = it.isActivePid
                            }
                        }
                    }
                }
            }
        }
    }
}