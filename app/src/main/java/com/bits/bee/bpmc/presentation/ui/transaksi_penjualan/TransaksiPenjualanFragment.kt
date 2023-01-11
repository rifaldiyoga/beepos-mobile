package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
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
import com.bits.bee.bpmc.presentation.dialog.channel_filter.ChannelFilterListDialog
import com.bits.bee.bpmc.presentation.dialog.radio_list.filter.RadioListFilterDialog
import com.bits.bee.bpmc.presentation.ui.home.HomeActivity
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.FilterUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.setSearchViewStyle
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
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
        menu.clear()
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView

        searchView.queryHint = getString(R.string.cari_transaksi_min_3_karakter)

        searchView.setSearchViewStyle(requireActivity(), R.color.black)


        if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE) {
            (requireActivity() as HomeActivity).setVisibilityBottom(false)
        } else {
            searchView.setOnQueryTextFocusChangeListener { _, b ->
                (requireActivity() as HomeActivity).setVisibilityBottom(!b)
            }
        }

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
//        val slidingPaneLayout = binding.slidingPaneLayout
//        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED

//        requireActivity().onBackPressedDispatcher.addCallback(
//            viewLifecycleOwner,
//            TransaksiPenjualanOnBackPressedCallback(slidingPaneLayout)
//        )
        binding.apply {
            transAdapter = TransaksiPenjualanAdapter(
                onItemClick = {
                    viewModel.updateActiveSale(it)
                    if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT) {
                        val action = TransaksiPenjualanFragmentDirections.actionTransaksiPenjualanFragmentToDetailTransaksiPenjualanFragment(it)
                        findNavController().navigate(action)
                    }
//                    binding.slidingPaneLayout.openPane()
                },
                viewModel.activeSale.value
            )
            toolbar3?.let {
                toolbar3.inflateMenu(R.menu.menu_search)
                toolbar3.setNavigationOnClickListener {
                    findNavController().popBackStack()
                }
                val searchItem = toolbar3.menu.findItem(R.id.menu_search)
                val searchView = searchItem.actionView as SearchView

                searchView.queryHint = getString(R.string.cari_transaksi_min_3_karakter)

                searchView.setSearchViewStyle(requireActivity(), R.color.black)


                if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE) {
                    (requireActivity() as HomeActivity).setVisibilityBottom(false)
                } else {
                    searchView.setOnQueryTextFocusChangeListener { _, b ->
                        (requireActivity() as HomeActivity).setVisibilityBottom(!b)
                    }
                }

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
            }

            transAdapter.refresh()
            rvList.apply {
                adapter = transAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            tilChannel.root.setOnClickListener {
                val dialog = ChannelFilterListDialog(
                    selectedChannelList = viewModel.channelList.value,
                    onFinish = {
                        viewModel.onFilterChannel(it)
                    })
                dialog.show(parentFragmentManager, "")
            }
            tilPeriode.root.setOnClickListener {
                val dialog = RadioListFilterDialog(
                    requireActivity(),
                    "Pilih Periode",
                    requireActivity().resources.getStringArray(R.array.list_pilih_tgl).toList(),
                    viewModel.filterDate.value,
                    onSaveClick = {
                        viewModel.onFilterPeriode(it)
                    }
                )
                dialog.show(parentFragmentManager, "")
            }
            tvReset.setOnClickListener {
                viewModel.onResetFilter()
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
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.saleList.collectLatest {
                    transAdapter.submitData(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.channelList.collectLatest {
                val channel = if(it.isNotEmpty()) if(it.size > 1) it[0].name+", +${it.size -1 }" else it[0].name else getString(R.string.pilih_channel)
                binding.tilChannel.tvTitle.text = channel
                setVisibilityReset()
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.filterDate.collectLatest {
                val channel = FilterUtils.getFilterDateLabel(it.selectedPos)
                binding.tilPeriode.tvTitle.text = channel
                setVisibilityReset()
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.activeSale.collectLatest {
                transAdapter.setActiveSale(it)
            }
        }
    }

    private fun setVisibilityReset() {
        binding.tvReset.isVisible = viewModel.filterDate.value.selectedPos != 0 || viewModel.channelList.value.isNotEmpty()
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