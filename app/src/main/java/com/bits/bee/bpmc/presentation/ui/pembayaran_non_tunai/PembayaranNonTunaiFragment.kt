package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPembayaranNonTunaiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pembayaran_gopay.PembayaranGopayFragment
import com.bits.bee.bpmc.presentation.ui.pembayaran_kartu.PembayaranKartuFragment
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranNonTunaiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranNonTunaiBinding = FragmentPembayaranNonTunaiBinding::inflate
) : BaseFragment<FragmentPembayaranNonTunaiBinding>() {

    private val viewModel : PembayaranNonTunaiViewModel by viewModels()

    private lateinit var pembayaranAdapter : PembayaranAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadPmtd()
    }

    override fun initComponents() {
        binding.apply {
            requireActivity().onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                PembayaranaOnBackPressedCallback(slidingPaneLayout)
            )
            pembayaranAdapter = PembayaranAdapter(
                onItemClick = {
                    viewModel.onClickItem(it)
                }
            )
            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = pembayaranAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        pembayaranAdapter.submitList(it.pmtdList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        is PembayaranNonTunaiViewModel.UIEvent.RequestClick -> {

                            val fragment = if(it.pmtd.ccType == BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY) PembayaranGopayFragment() else PembayaranKartuFragment()

                            val ft = childFragmentManager.beginTransaction()

                            ft.replace(R.id.fragment, fragment)
                            ft.commit()

                            setToolbarTitle("Bayar Dengan ${it.pmtd.name}")

                            viewModel.updateActivePmtd(it.pmtd)
                            binding.slidingPaneLayout.openPane()
                        }
                    }
                }
            }
        }
    }

    fun closePane() {
        binding.slidingPaneLayout.closePane()
    }

    inner class PembayaranaOnBackPressedCallback(
        private val slidingPaneLayout: SlidingPaneLayout
    ) : OnBackPressedCallback(
        slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen
    ), SlidingPaneLayout.PanelSlideListener {

        init {
            slidingPaneLayout.addPanelSlideListener(this)
        }

        override fun handleOnBackPressed() {
            slidingPaneLayout.closePane()
        }

        override fun onPanelSlide(panel: View, slideOffset: Float) {

        }

        override fun onPanelOpened(panel: View) {
            isEnabled = true
        }

        override fun onPanelClosed(panel: View) {
            isEnabled = false
            setToolbarTitle("Non Tunai")
        }

    }
}