package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPembayaranKartuBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranKartuFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranKartuBinding = FragmentPembayaranKartuBinding::inflate
) : BaseFragment<FragmentPembayaranKartuBinding>() {

    private val viewModel : PembayaranKartuViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var adapterEdc : ArrayAdapter<String>
    private lateinit var adapterEdcType : ArrayAdapter<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val type = it.getString("type")
            viewModel.state.type = type ?: "CC"
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        viewModel.loadEdc()
        adapterEdc = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1)
        adapterEdcType = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1)
        binding.apply {


        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etEdc.setOnItemClickListener { _, _, i, _ ->
                viewModel.onItemEdcClick(i)
            }
            etTipeEdc.setOnItemClickListener { _, _, i, _ ->
                viewModel.onItemEdcTypeClick(i)
            }
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
                val state = mainViewModel.state
                viewModel.onBayarClick(state.sale, state.saledList)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let { state ->
                        adapterEdc.clear()
                        adapterEdc.addAll(state.edcList.map { it.name })
                        binding.etEdc.setAdapter(adapterEdc)

                        adapterEdcType.clear()
                        adapterEdcType.addAll(state.edcSurcList.map {it.ccType.cctypeDesc })
                        binding.etTipeEdc.setAdapter(adapterEdcType)

                        state.edcSurc?.let {
                            binding.tvSurcharge.text = "${it.edcSurc.surcExp} %"
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect {
                    it?.let {
                        binding.tvTotal.text = getString(R.string.mata_uang_nominal, it.crc?.symbol?: "", CurrencyUtils.formatCurrency(it.sale.total))
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        PembayaranKartuViewModel.UIEvent.NavigateToTransaksiBerhasil -> {
                            val action = PembayaranKartuFragmentDirections.actionPembayaranDebitKreditFragmentToTransaksiBerhasilFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}