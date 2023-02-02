package com.bits.bee.bpmc.presentation.ui.cek_stok

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCekStokBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.setSearchViewStyle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class CekStokFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCekStokBinding = FragmentCekStokBinding::inflate
) : BaseFragment<FragmentCekStokBinding>() {

    private val viewModel : CekStokViewModel by viewModels()
    private lateinit var cekStokAdapter: CekStokAdapter
    private lateinit var dialog : LoadingDialogHelper
    private var desc = false
    private var menuSort: MenuItem? = null

    override fun initComponents() {
        setHasOptionsMenu(true)
        dialog = LoadingDialogHelper(requireContext())
        cekStokAdapter = CekStokAdapter {
            val action = CekStokFragmentDirections.actionCekStokFragmentToCekStokDetailFragment(it)
            findNavController().navigate(action)
        }
        binding.apply {
            rvCekStok.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = cekStokAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.sortDesc.collectLatest {
                menuSort?.let { menu ->
                    if (it) {
                        menu.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
                    } else {
                        menu.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_ascending)
                    }
                }

            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stockList.collectLatest {
                when(it.status){
                    Resource.Status.LOADING -> {
                        binding.progressBar.isVisible = true
                        binding.lLStockEmpty.isVisible = false
                        binding.rvCekStok.isVisible = false
                    }
                    Resource.Status.SUCCESS -> {
                        binding.progressBar.isVisible = false
                        binding.rvCekStok.isVisible = true
                        cekStokAdapter.submitList(it.data)
                        binding.lLStockEmpty.isVisible = it.data?.isEmpty() == true

                        if(it.data?.isEmpty() == true && viewModel.currentQuery.value.isEmpty()){
                            binding.tvDesc.text = getString(R.string.cari_produknya_dulu)
                        } else {
                            binding.tvDesc.text = getString(R.string.cari_produk_not_found)
                        }
                    }
                    Resource.Status.ERROR -> {
                        binding.progressBar.isVisible = false
                        binding.lLStockEmpty.isVisible = true
                        dialog.hide()
                    }
                    Resource.Status.NOINTERNET -> {
                        binding.progressBar.isVisible = false
                        binding.lLStockEmpty.isVisible = true
                        val dialog = NoInternetDialogBuilder({
//                            viewModel.loadStock()
                        })
                        dialog.show(parentFragmentManager, "")
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        CekStokViewModel.UIEvent.RequestWaitDialog ->{
                            dialog.show()
                        }
                        CekStokViewModel.UIEvent.HideDialog ->{
                            dialog.hide()
                        }
                        CekStokViewModel.UIEvent.NoInternetDialog -> {

                        }
                    }
                }
            }
        }


        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            tvLastSync.text = "Menampilkan data stok pada "+DateFormatUtils.formatDateToString(BPMConstants.NEW_DATE_FORMAT, Date())
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_cek_stok, menu)

        val searchItem = menu.findItem(R.id.search_cek_stok)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Masukan minimal 3 huruf"
        searchView.setSearchViewStyle(requireActivity(), R.color.black)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onQueryChange(newText ?: "")
                return false
            }
        })

        menuSort = menu.findItem(R.id.sort_cek_stok)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sort_cek_stok ->{
                viewModel.onSortDesc(viewModel.sortDesc.value)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}