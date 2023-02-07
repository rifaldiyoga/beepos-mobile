package com.bits.bee.bpmc.presentation.ui.cek_stok_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCekStokDetailBinding
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CekStokDetailFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCekStokDetailBinding = FragmentCekStokDetailBinding::inflate
) : BaseFragment<FragmentCekStokDetailBinding>() {

    private val viewModel : CekStokDetailViewModel by viewModels()

    private lateinit var cekStockAdapter : StokPIDAdapter

    override fun initComponents() {
        arguments?.let {
            val stok = it.getParcelable<Stock>("stok")
            viewModel.state.stock = stok
        }

        cekStockAdapter = StokPIDAdapter()
        binding.apply {
            rvPid.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = cekStockAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stockRepository.getPidByItem(viewModel.state.stock?.itemId ?: 1).collectLatest {
                cekStockAdapter.submitList(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collectLatest {
                it?.let {
                    binding.apply {
                        tvNama.text = it.stock?.itemName ?: ""
                        tvHarga.text = root.context.getString(R.string.mata_uang_nominal, it.stock?.symbol, CurrencyUtils.formatCurrency(it.stock?.harga))
                    }
                }
            }
        }
    }

}