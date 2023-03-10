package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRekapProdukBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.filter.RadioListFilterDialog
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.FilterUtils
import com.bits.bee.bpmc.utils.gone
import com.bits.bee.bpmc.utils.setSearchViewStyle
import com.bits.bee.bpmc.utils.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class RekapProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRekapProdukBinding = FragmentRekapProdukBinding::inflate
) : BaseFragment<FragmentRekapProdukBinding>() {

    private val viewModel : RekapProdukViewModel by activityViewModels()
    private lateinit var rekapProdukAdapter: RekapProdukAdapter
    private lateinit var pilihTglList : List<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onFilterPeriode(viewModel.filterDate.value, viewModel.state.searchQuery)
//        viewModel.loadRekapProduk(inilizeTgl(), viewModel.state.selectFilter, viewModel.state.searchQuery)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        pilihTglList = requireActivity().resources.getStringArray(R.array.list_pilih_tgl).toList()
        rekapProdukAdapter = RekapProdukAdapter(requireContext(), mlistener = object : RekapProdukAdapter.PilihProdukPidI{
            override fun onClick(item: Item) {
                val action = RekapProdukFragmentDirections.actionRekapProdukFragmentToDetailProdukFragment(
                    Gson().toJson(item))
                findNavController().navigate(action)
            }

        })
        binding.apply {
            rvRekapProduk.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rekapProdukAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            tilPeriode.root.setOnClickListener {
                val dialog = RadioListFilterDialog(
                        requireContext(),
                        getString(R.string.pilih_tanggal),
                        pilihTglList,
                        viewModel.filterDate.value,
                        onSaveClick = {
                            viewModel.onFilterPeriode(it, viewModel.state.searchQuery)
                        }
                )
                dialog.show(parentFragmentManager, "")
            }
        }
    }

    override fun subscribeObservers() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
//                            it.itemList?.let { data ->
//                                if (data.size > 0){
//                                    imageView16.visibility = View.GONE
//                                    textView90.visibility = View.GONE
////                                    viewModel.checkListItem(data)
//                                    rekapProdukAdapter.submitList(data)
//                                }else{
//                                    rekapProdukAdapter.submitList(data)
//                                    imageView16.visibility = View.VISIBLE
//                                    textView90.visibility = View.VISIBLE
//                                }
//                            }
                            it.start?.let {
                                tvLastSync.text = getString(R.string.menampilkan_data_pada) +" "+ DateFormatUtils.formatLongToString(BPMConstants.NEW_DATE_FORMAT,
                                    viewModel.state.start!!
                                ) +" - " + DateFormatUtils.formatLongToString(BPMConstants.NEW_DATE_FORMAT, viewModel.state.end!!)
                            }
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            rekapProdukAdapter.loadStateFlow.collectLatest {
                if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                    setVisibilityList(rekapProdukAdapter.itemCount != 0)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.itemList.collectLatest {
                rekapProdukAdapter.submitData(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.filterDate.collectLatest {
                val filter = FilterUtils.getFilterDateLabel(it.selectedPos)
                binding.tilPeriode.tvTitle.text = filter
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_rekap_produk, menu)

        val searchItem = menu.findItem(R.id.search_rekap_produk)
        val searchView = searchItem.actionView as SearchView

        searchView.queryHint = "Masukan minimal 3 huruf"
        searchView.setSearchViewStyle(requireActivity(), R.color.black)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.length >= 3) {
                    viewModel.searching(newText)
                } else {
                    viewModel.searching("")
                }
//                viewLifecycleOwner.lifecycleScope.launch {
//                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                        viewModel.viewStates().collect {
//                            it?.let {
//                                binding.apply {
//                                    if (newText?.length == 0){
//                                        it.itemList?.let { data ->
//                                            if (data.size > 0){
//                                                imageView16.visibility = View.GONE
//                                                textView90.visibility = View.GONE
//                                                imageView17.visibility = View.GONE
//                                                textView91.visibility = View.GONE
////                                                rekapProdukAdapter.submitList(data)
//                                            }else{
////                                                rekapProdukAdapter.submitList(data)
//                                                imageView16.visibility = View.VISIBLE
//                                                textView90.visibility = View.VISIBLE
//                                                imageView17.visibility = View.GONE
//                                                textView91.visibility = View.GONE
//                                            }
//                                        }
//                                    }else if (newText!!.length >= 3){
////                                        viewModel.updateState(
////                                            viewModel.state.copy(
////                                                itemList = null
////                                            )
////                                        )
//                                        viewModel.cariItems(newText.toString().trim(), 1, viewModel.filterDate.value)
//                                        it.itemListResult?.let { data->
//                                            viewModel.filterItems(data, viewModel.filterDate.value)
//                                            it.resultFilteritem?.let { resultFilter ->
//                                                if (resultFilter.size > 0){
//                                                    imageView16.visibility = View.GONE
//                                                    textView90.visibility = View.GONE
//                                                    imageView17.visibility = View.GONE
//                                                    textView91.visibility = View.GONE
////                                                    rekapProdukAdapter.submitList(resultFilter)
//                                                }else{
////                                                    rekapProdukAdapter.submitList(resultFilter)
//                                                    imageView16.visibility = View.GONE
//                                                    textView90.visibility = View.GONE
//                                                    imageView17.visibility = View.VISIBLE
//                                                    textView91.visibility = View.VISIBLE
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
//            R.id.filter_rekap_produk ->{
//                viewModel.showDialog()
//            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setVisibilityList(isVisible : Boolean) {
        binding.apply {
            if(isVisible){
                rvRekapProduk.visible()
                imageView16.gone()
                textView90.gone()
            } else {
                rvRekapProduk.gone()
                textView90.visible()
                imageView16.visible()
            }
        }
    }

}