package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentAturProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class AturProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAturProdukBinding = FragmentAturProdukBinding::inflate
) : BaseFragment<FragmentAturProdukBinding>() {

    private val viewModel : AturProdukViewModel by viewModels()

    private lateinit var itemDummyAdapter: ItemDummyAdapter

    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
            R.string.page_atur_produk))
        binding.apply {
            itemDummyAdapter = ItemDummyAdapter(onItemClick = { item ->
                val action = AturProdukFragmentDirections.actionAturProdukFragmentToTambahProdukFragment(if(item.id != null) item else null)
                findNavController().navigate(action)
            })
            rvList.apply {
                adapter = itemDummyAdapter
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btntambahPrd.setOnClickListener {
                val action = AturProdukFragmentDirections.actionAturProdukFragmentToTambahProdukFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.itemDummyList.collect {
                    when(it.status){
                        Resource.Status.LOADING -> {
                            binding.progressBar.visible()
                            binding.constraintLayout9.gone()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.gone()
                            binding.constraintLayout9.visible()
                            it.data?.let {
                                binding.apply {
                                    rvList.isVisible = it.isNotEmpty()
                                    constraintLayout9.isVisible = it.isEmpty()
                                }
                                if(it.isNotEmpty()) {
                                    itemDummyAdapter.submitList(it.toMutableList())
                                }
                            }
                        }
                        Resource.Status.ERROR -> {
                            binding.progressBar.gone()
                        }
                    }
                }
            }
        }
    }
}