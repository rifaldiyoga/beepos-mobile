package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCariItemBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.ItemPosRetailAdapter
import com.bits.bee.bpmc.utils.PermissionUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.setSearchViewStyle
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


/**
 * Created by aldi on 21/07/22.
 */
@AndroidEntryPoint
class CariItemFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCariItemBinding = FragmentCariItemBinding::inflate
) : BaseFragment<FragmentCariItemBinding>() {

    private val viewModel : CariItemViewModel by viewModels()

    private val mViewModel : MainViewModel by activityViewModels()

    private lateinit var itemAdapter : ItemPosCariAdapter
    private lateinit var itemRetailPosAdapter: ItemPosRetailAdapter
    private lateinit var searchView : SearchView

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.state.usePid = mViewModel.posModeState.value is PosModeState.RetailState
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_scan, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        menu.findItem(R.id.menu_scan).isVisible = mViewModel.posModeState.value == PosModeState.RetailState
        searchView = searchItem.actionView as SearchView
        searchView.queryHint = getString(R.string.cari_produk_min_3_karakter)
        searchView.setSearchViewStyle(requireActivity(), R.color.white)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onSearch(newText ?: viewModel.currentQuery.value)
                if(newText != null && newText.length < 3){
                    binding.groupEmpty.gone()
                    binding.rvList.gone()
                }
                return true
            }
        })
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                findNavController().popBackStack()
                return true
            }

        })

        searchItem.expandActionView()

        searchView.requestFocus()
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("scan")?.observe(viewLifecycleOwner) {
            viewModel.onSearch(it)
            searchView.setQuery(it, true)
            showSnackbar(it)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_scan -> {
                if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.CAMERA)) {
                    val action =
                        CariItemFragmentDirections.actionCariItemFragmentToScannerFragment()
                    findNavController().navigate(action)
                } else {
                    requestPermissionCamera.launch(Manifest.permission.CAMERA)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            groupEmpty.gone()
            rvList.gone()
            itemAdapter = ItemPosCariAdapter(
                onItemClicK = { item ->
                    mViewModel.onAddDetail(ItemWithUnit(item))
                },
                onMinusClick = { item ->
                    mViewModel.onMinusClick(item)
                },
                mViewModel.state.saledList
            )
            itemRetailPosAdapter = ItemPosRetailAdapter {
                viewModel.onClickRetail(it)
            }
            rvList.apply {
                adapter = if(mViewModel.posModeState.value is PosModeState.FnBState)
                    itemAdapter
                else
                    itemRetailPosAdapter
                layoutManager = LinearLayoutManager(requireActivity())
            }


        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            mViewModel.activeBp.collect {
                it?.let {
                    viewModel.state.bp = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            mViewModel.activeChannel.collect {
                it?.let {
                    viewModel.state.channel = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            if(mViewModel.posModeState.value is PosModeState.FnBState) {
                itemAdapter.loadStateFlow.collectLatest {
                    if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                        binding.groupEmpty.isVisible = itemAdapter.itemCount == 0  && viewModel.currentQuery.value.length > 2
                        binding.rvList.isVisible = itemAdapter.itemCount > 0 && viewModel.currentQuery.value.length > 2
                    }
                }
            } else {
                itemRetailPosAdapter.loadStateFlow.collectLatest {
                    if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                        binding.groupEmpty.isVisible = itemRetailPosAdapter.itemCount == 0 && viewModel.currentQuery.value.length > 2
                        binding.rvList.isVisible = itemRetailPosAdapter.itemCount > 0 && viewModel.currentQuery.value.length > 2
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchItemFlow.collectLatest {
                    if(mViewModel.posModeState.value is PosModeState.FnBState) {
                        itemAdapter.submitData(it)
                    } else {
                        itemRetailPosAdapter.submitData(it)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mViewModel.viewStates().collect {
                    it?.let {
                        itemAdapter.submitSaledList(it.saledList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect {
                when(it){
                    is CariItemViewModel.UIEvent.RequestItem -> {
                        val action = if(it.item.usePid){
                            CariItemFragmentDirections.actionCariItemFragmentToPilihPidFragment(
                                item = it.item
                            )
                        } else {
                            CariItemFragmentDirections.actionCariItemFragmentToEditItemDialog(
                                item = it.item
                            )
                        }
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 20) {
            if (resultCode === RESULT_OK && android.R.attr.data != null) {
                val code: String = ""
            }
        }
    }
}