package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailProdukBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailProdukFragment (
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailProdukBinding = FragmentDetailProdukBinding::inflate
): BaseFragment<FragmentDetailProdukBinding>() {

    private val viewModel : RekapProdukViewModel by activityViewModels()
    private lateinit var detailProdukAdapter: DetailProdukAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (!it.getString("item").equals("null") && it.getString("item")?.isNotEmpty() == true){
                viewModel.updateState(
                    viewModel.state.copy(
                        item = Gson().fromJson(it.getString("item"), Item::class.java)
                    )
                )
            }
        }
        viewModel.getValuePid()
    }

    override fun initComponents() {
        detailProdukAdapter = DetailProdukAdapter(requireContext())
        binding.apply {
            rvProdukPid.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = detailProdukAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.item?.let {
                                tvNamaProduk.text = it.name1
                                tvhargaProduk.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it.subtotal))
                            }
                            it.listPid?.let {
                                detailProdukAdapter.submitList(it)
                            }
                        }
                    }
                }
            }
        }
    }
}