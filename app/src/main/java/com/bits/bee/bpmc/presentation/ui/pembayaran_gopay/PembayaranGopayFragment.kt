package com.bits.bee.bpmc.presentation.ui.pembayaran_gopay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.FragmentPembayaranGopayBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranGopayFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranGopayBinding = FragmentPembayaranGopayBinding::inflate
) : BaseFragment<FragmentPembayaranGopayBinding>() {

    private val viewModel : PembayaranGopayViewModel by viewModels()

    private val parentViewModel : PembayaranNonTunaiViewModel by viewModels({requireParentFragment()})

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                parentViewModel.activePmtd.collect {
                    viewModel.updateState(
                        viewModel.state.copy(
                            pmtd = it
                        )
                    )
                }
            }
        }
    }
}