package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import android.Manifest
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
import com.bits.bee.bpmc.presentation.custom.LoadingStateAdapter
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosFragmentDirections
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.ItemPosRetailAdapter
import com.bits.bee.bpmc.utils.PermissionUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.setSearchViewStyle
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

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var itemAdapter : ItemPosCariAdapter
    private lateinit var itemRetailPosAdapter: ItemPosRetailAdapter
    private lateinit var searchView : SearchView

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.state.usePid = mainViewModel.posModeState.value is PosModeState.RetailState
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_scan, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        menu.findItem(R.id.menu_scan).isVisible = mainViewModel.posModeState.value == PosModeState.RetailState
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
            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                findNavController().popBackStack()
                return true
            }

        })

        searchItem.expandActionView()

        searchView.setQuery(viewModel.savedStateHandle.get<String>("query"), true)

        searchView.requestFocus()
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("scan")?.observe(viewLifecycleOwner) {
            viewModel.onSearch(it)
            viewModel.onScan(it)
            searchView.setQuery(it, true)
            showSnackbar(it)
            findNavController().currentBackStackEntry?.savedStateHandle?.remove<String>("scan")
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_scan -> {
                if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.CAMERA)) {
                    val action = CariItemFragmentDirections.actionCariItemFragmentToScannerFragment()
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
                   onItemClick(item)
                },
                onMinusClick = { item ->
                    onMinusClick(item)
                },
                mainViewModel.state.saledList,
                mainViewModel.orientation.value
            )
            itemRetailPosAdapter = ItemPosRetailAdapter {
                viewModel.onClickRetail(it)
            }
            rvList.apply {
                adapter = (if(mainViewModel.posModeState.value is PosModeState.FnBState)
                    itemAdapter
                else
                    itemRetailPosAdapter).withLoadStateFooter(LoadingStateAdapter())
                layoutManager = LinearLayoutManager(requireActivity())
                itemAnimator = null
            }


        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collectLatest {
                showSnackbar(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.activeBp.collect {
                it?.let {
                    viewModel.state.bp = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.activeChannel.collect {
                it?.let {
                    viewModel.state.channel = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            if(mainViewModel.posModeState.value is PosModeState.FnBState) {
                itemAdapter.loadStateFlow.collectLatest {
                    if (it.append is LoadState.NotLoading) {
                        binding.groupEmpty.isVisible = itemAdapter.itemCount == 0  && viewModel.currentQuery.value.length > 2
                        binding.rvList.isVisible = itemAdapter.itemCount > 0 && viewModel.currentQuery.value.length > 2
                    }
                }
            } else {
                itemRetailPosAdapter.loadStateFlow.collectLatest {
                    if (it.append is LoadState.NotLoading) {
                        binding.groupEmpty.isVisible = itemRetailPosAdapter.itemCount == 0 && viewModel.currentQuery.value.length > 2
                        binding.rvList.isVisible = itemRetailPosAdapter.itemCount > 0 && viewModel.currentQuery.value.length > 2
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchItemFlow.collectLatest {
                    if(mainViewModel.posModeState.value is PosModeState.FnBState) {
                        itemAdapter.submitData(it)
                    } else {
                        itemRetailPosAdapter.submitData(it)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect {
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

    private fun onItemClick(item : Item) {
        if(item.isVariant || item.isHaveAddOn) {
            if(item.isVariant){
                var isContains = false
                mainViewModel.state.saledList.forEach { saled ->
                    item.itemVariantList.forEach {
                        if(saled.itemId == it){
                            isContains = true
                            return@forEach
                        }
                    }
                }
                if(isContains){
                    val action = CariItemFragmentDirections.actionCariItemFragmentToDetailAddOnDialogBuilder(item)
                    findNavController().navigate(action)
                } else {
                    val action = CariItemFragmentDirections.actionCariItemFragmentToAddOnFragment(item, mainViewModel.state.bp!!, mainViewModel.state.bp!!.priceLvlId)
                    findNavController().navigate(action)
                }
            } else {
                if (mainViewModel.state.saledList.firstOrNull { item.id == it.itemId } == null) {
                    val action = PosFragmentDirections.actionPosFragmentToAddOnFragment(
                        item,
                        mainViewModel.state.bp!!,
                        mainViewModel.state.bp!!.priceLvlId
                    )
                    findNavController().navigate(action)
                } else {
                    val action = CariItemFragmentDirections.actionCariItemFragmentToDetailAddOnDialogBuilder(item)
                    findNavController().navigate(action)
                }
            }
        } else {
            mainViewModel.onAddDetail(ItemWithUnit(item))
        }
    }

    private fun onMinusClick(item : Item) {
        if(item.isVariant || item.isHaveAddOn) {
            val action = CariItemFragmentDirections.actionCariItemFragmentToDetailAddOnDialogBuilder(item)
            findNavController().navigate(action)
        } else {
            mainViewModel.onMinusClick(item)
        }
    }
}