package com.bits.bee.bpmc.presentation.ui.cek_stok

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCekStokBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.AndroidEntryPoint
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
    private var mMenu: Menu? = null

    override fun initComponents() {
        setHasOptionsMenu(true)
        dialog = LoadingDialogHelper(requireContext())
        viewModel.loadStock()
        cekStokAdapter = CekStokAdapter()

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
                            it.stockList?.let { stock ->
                                viewModel.initStock(stock)
                                it.itemsList?.let {
                                    cekStokAdapter.initLists(stock, viewModel.state.itemsList!!)
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
        inflater.inflate(R.menu.menu_cek_stok, menu)

        OnClickSort(desc)
        if (!desc) {
            menu.getItem(1).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
            desc = false
        }
        this.mMenu = menu

        val searchItem = menu.findItem(R.id.search_cek_stok)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.viewStates().collect {
                            it?.let {
                                if (newText?.length == 0){
                                    viewModel.filterStock("")
                                    it.itemsList?.let {
                                        cekStokAdapter.initLists(viewModel.state.stockList!!, it)
                                    }
                                }else if (newText!!.length >= 3){
                                    viewModel.filterStock(newText.toString().trim())
                                    it.itemsList?.let {
                                        cekStokAdapter.initLists(viewModel.state.stockList!!, it)
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
            R.id.search_cek_stok ->{

            }
            R.id.sort_cek_stok ->{
                if (desc){
                    mMenu!!.getItem(1).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
                    desc = false
                }else{
                    mMenu!!.getItem(1).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_ascending)
                    desc = true
                }

                OnClickSort(desc)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun OnClickSort(desc: Boolean) {

        viewModel.updateState(
            viewModel.state.copy(
                stockList = null
            )
        )

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.stockList?.let { data ->
                            viewModel.sort(desc, data)
                            it.itemsList?.let {
                                cekStokAdapter.initLists(data, viewModel.state.itemsList!!)
                            }
                        }
                    }
                }
            }
        }
    }
}