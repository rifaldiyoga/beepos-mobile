package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRekapProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListFilterDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class RekapProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRekapProdukBinding = FragmentRekapProdukBinding::inflate
) : BaseFragment<FragmentRekapProdukBinding>() {

    private val viewModel : RekapProdukViewModel by viewModels()
    lateinit var rekapProdukAdapter: RekapProdukAdapter
    private var pilihTgl: String = "1 Minggu Terakhir"
    private lateinit var pilihTglList : List<String>
    private var posFilter: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadRekapProduk(inilizeTgl(), viewModel.state.selectFilter, viewModel.state.searchQuery)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        pilihTglList = requireActivity().resources.getStringArray(R.array.list_pilih_tgl).toList()
        rekapProdukAdapter = RekapProdukAdapter(requireContext())
        binding.apply {
            rvRekapProduk.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rekapProdukAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        RekapProdukViewModel.UIEvent.RequestDialogFilter ->{
                            val dialog = RadioListFilterDialog(
                                getString(R.string.pilih_tanggal),
                                pilihTglList,
                                inilizeTgl(),
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            selectFilter = data.toString()
                                        )
                                    )
                                    viewModel.loadRekapProduk(inilizeTgl(), viewModel.state.selectFilter, viewModel.state.searchQuery)
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.itemList?.let { data ->
                                if (data.size > 0){
                                    imageView16.visibility = View.GONE
                                    textView90.visibility = View.GONE
//                                    viewModel.checkListItem(data)
                                    rekapProdukAdapter.submitList(data)
                                }else{
                                    rekapProdukAdapter.submitList(data)
                                    imageView16.visibility = View.VISIBLE
                                    textView90.visibility = View.VISIBLE
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_rekap_produk, menu)
//        onView()

        val searchItem = menu.findItem(R.id.search_rekap_produk)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Masukan minimal 3 huruf"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.viewStates().collect {
                            it?.let {
                                binding.apply {
                                    if (newText?.length == 0){
                                        it.itemList?.let { data ->
                                            if (data.size > 0){
                                                imageView16.visibility = View.GONE
                                                textView90.visibility = View.GONE
                                                imageView17.visibility = View.GONE
                                                textView91.visibility = View.GONE
                                                rekapProdukAdapter.submitList(data)
                                            }else{
                                                rekapProdukAdapter.submitList(data)
                                                imageView16.visibility = View.VISIBLE
                                                textView90.visibility = View.VISIBLE
                                                imageView17.visibility = View.GONE
                                                textView91.visibility = View.GONE
                                            }
                                        }
                                    }else if (newText!!.length >= 3){
//                                        viewModel.updateState(
//                                            viewModel.state.copy(
//                                                itemList = null
//                                            )
//                                        )
                                        viewModel.cariItems(newText.toString().trim(), 1, inilizeTgl(), viewModel.state.selectFilter)
                                        it.itemListResult?.let { data->
                                            viewModel.filterItems(data, inilizeTgl(), viewModel.state.selectFilter)
                                            it.resultFilteritem?.let { resultFilter ->
                                                if (resultFilter.size > 0){
                                                    imageView16.visibility = View.GONE
                                                    textView90.visibility = View.GONE
                                                    imageView17.visibility = View.GONE
                                                    textView91.visibility = View.GONE
                                                    rekapProdukAdapter.submitList(resultFilter)
                                                }else{
                                                    rekapProdukAdapter.submitList(resultFilter)
                                                    imageView16.visibility = View.GONE
                                                    textView90.visibility = View.GONE
                                                    imageView17.visibility = View.VISIBLE
                                                    textView91.visibility = View.VISIBLE
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.filter_rekap_produk ->{
                viewModel.showDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun inilizeTgl(): Int{
        pilihTgl = viewModel.state.selectFilter
        if (pilihTgl.equals(getString(R.string.last_1_week)))
            posFilter = 0
        else if(pilihTgl.equals(getString(R.string.last_1_month)))
            posFilter = 1
        else if (pilihTgl.equals(getString(R.string.last_90_days)))
            posFilter = 2
        else
            posFilter = 3

        return posFilter
    }

    private fun onView() {
        viewModel.updateState(
            viewModel.state.copy(
                itemList = null
            )
        )
        viewModel.loadRekapProduk(inilizeTgl(), viewModel.state.selectFilter, viewModel.state.searchQuery)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.itemList?.let { data ->
                                if (data.size > 0){
                                    imageView16.visibility = View.GONE
                                    textView90.visibility = View.GONE
//                                    viewModel.checkListItem(data)
                                    rekapProdukAdapter.submitList(data)
                                }else{
                                    rekapProdukAdapter.submitList(data)
                                    imageView16.visibility = View.VISIBLE
                                    textView90.visibility = View.VISIBLE
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun searchEvent(){

    }
}