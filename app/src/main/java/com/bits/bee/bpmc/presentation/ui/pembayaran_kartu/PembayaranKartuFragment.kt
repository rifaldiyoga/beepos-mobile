package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPembayaranKartuBinding
import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranKartuFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranKartuBinding = FragmentPembayaranKartuBinding::inflate
) : BaseFragment<FragmentPembayaranKartuBinding>() {

    private val viewModel : PembayaranKartuViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private val parentViewModel : PembayaranNonTunaiViewModel by viewModels({requireParentFragment()})

    private lateinit var adapterEdc : ArrayAdapter<String>
    private lateinit var adapterEdcType : ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val type = it.getParcelable<Pmtd>("pmtd")
            viewModel.state.pmtd = type
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNomorKartu.addTextChangedListener {
                viewModel.state.nomorkartu = etNomorKartu.text.toString().trim()
            }
            etTrackNo.addTextChangedListener {
                viewModel.state.trackNo = etTrackNo.text.toString().trim()
            }
            etKeterangan.addTextChangedListener {
                viewModel.state.keterangan = etKeterangan.text.toString().trim()
            }
            btnBayar.setOnClickListener {
                viewModel.onBayarClick()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            val regCardNo = viewModel.regCardNoReq.first()
            val regTrackNo = viewModel.regTrackNoReq.first()

            binding.apply {
                tvCardNoOps.isVisible = regCardNo?.value == "1"
                tvTrackNoOps.isVisible = regTrackNo?.value == "1"
            }
        }
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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let { state ->
                        requireActivity().actionBar?.let {
                            it.title = state.pmtd?.name ?: "Pembayaran Kartu"
                        }
                        binding.tvSurcharge.text = "${state.pmtd?.surExp ?: "0"}%"
                        state.pmtd?.let {
                            val mainState = mainViewModel.state
                            val surcVal = BigDecimal(it.surExp).divide(BigDecimal(100)).multiply(mainState.sale.total)
                            state.nominalSurc = surcVal
                            val total = mainState.sale.total.add(surcVal)
                            state.total = total
                            binding.tvTotal.text = getString(R.string.mata_uang_nominal, mainState.crc?.symbol?: "", CurrencyUtils.formatCurrency(total))
                            binding.tvNominalSurcharge.text = getString(R.string.mata_uang_nominal, mainState.crc?.symbol ?: "",CurrencyUtils.formatCurrency(surcVal))
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect {
                    it?.let {

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        is PembayaranKartuViewModel.UIEvent.NavigateToTransaksiBerhasil -> {
                            val action = PembayaranKartuFragmentDirections.actionPembayaranDebitKreditFragmentToTransaksiBerhasilFragment()
                            findNavController().navigate(action)
                        }
                        PembayaranKartuViewModel.UIEvent.RequsetBayar -> {
                            val state = viewModel.state
                            var isValid = true

                            val regCardNo = viewModel.regCardNoReq.first()
                            val regTrackNo = viewModel.regTrackNoReq.first()

                            if(regCardNo?.value == "1" && state.nomorkartu.isEmpty()) {
                                binding.tilNomorKartu.error = "Nomor Kartu tidak boleh kosong!"
                                isValid = false
                            }
                            if(regTrackNo?.value == "1" && state.trackNo.isEmpty()) {
                                binding.tilTrackNo.error = "Track No tidak boleh kosong!"
                                isValid = false
                            }

                            if(isValid) {
                                mainViewModel.submitSale(
                                    context = requireContext(),
                                    termType = state.type,
                                    paymentAmt = state.total,
                                    pmtd = state.pmtd,
                                    trackNo = state.trackNo,
                                    cardNo = state.nomorkartu,
                                    note = state.keterangan
                                )
                                viewModel.onSuccessBayar()
                            }
                        }
                    }
                }
            }
        }
    }
}