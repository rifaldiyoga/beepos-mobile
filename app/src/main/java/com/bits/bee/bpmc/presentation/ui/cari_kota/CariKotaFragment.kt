package com.bits.bee.bpmc.presentation.ui.cari_kota

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bits.bee.bpmc.databinding.FragmentCariKotaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/05/22.
 */
@AndroidEntryPoint
class CariKotaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCariKotaBinding = FragmentCariKotaBinding::inflate
) : BaseFragment<FragmentCariKotaBinding>() {

    private val viewModel : CariKotaViewModel by viewModels()

    private lateinit var cityAdapterRekomendasi : RekomendasiKotaAdapter
    private lateinit var cityAdapterSearch : CariKotaAdapter

    override fun initComponents() {
        binding.apply {
            cityAdapterRekomendasi = RekomendasiKotaAdapter()
            cityAdapterSearch = CariKotaAdapter()
            rvRekomendasi.apply {
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                adapter = cityAdapterRekomendasi
            }
            rvCari.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = cityAdapterSearch
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etCari.addTextChangedListener {
                viewModel.onSearch(etCari.text.toString().trim())
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.cityList.collect {
                    cityAdapterRekomendasi.submitList(it.take(10))
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        if(it.cari.length >= 3){
                            binding.groupRekomendasi.gone()
                            binding.rvCari.visible()
                            viewModel.searchCity()
                        } else {
                            binding.groupRekomendasi.visible()
                            binding.rvCari.gone()
                        }
                        cityAdapterSearch.submitList(it.cityListCari)
                    }
                }
            }
        }
    }


}