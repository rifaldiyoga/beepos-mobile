package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTransaksiPenjualanBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class TransaksiPenjualanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTransaksiPenjualanBinding = FragmentTransaksiPenjualanBinding::inflate
) : BaseFragment<FragmentTransaksiPenjualanBinding>() {

    private val viewModel : TransaksiPenjualanViewModel by viewModels()

    private lateinit var transAdapter : TransaksiPenjualanAdapter

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.length >= 3) {
                    viewModel.onSearch(newText)
                } else {
                    viewModel.onSearch("")
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
    }

    override fun subscribeListeners() {
        binding.apply {
            transAdapter = TransaksiPenjualanAdapter(
                onItemClick = {
                    val action = TransaksiPenjualanFragmentDirections.actionTransaksiPenjualanFragmentToDetailTransaksiPenjualanFragment(it)
                    findNavController().navigate(action)
                }
            )
            rvList.apply {
                adapter = transAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            transAdapter.loadStateFlow.collectLatest {
                if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                    setVisibilityList(transAdapter.itemCount != 0)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.saleList.collectLatest {
                    transAdapter.submitData(it)
                }
            }
        }
    }

    private fun setVisibilityList(isVisible : Boolean) {
        binding.apply {
            if(isVisible){
                rvList.visible()
                groupEmpty.gone()
            } else {
                rvList.gone()
                groupEmpty.visible()
            }
        }
    }
}