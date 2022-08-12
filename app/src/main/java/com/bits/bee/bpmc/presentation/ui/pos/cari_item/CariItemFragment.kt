package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCariItemBinding
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.ItemPosAdapter
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.ItemPosRetailAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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

    private lateinit var itemAdapter : ItemPosAdapter

    private lateinit var itemRetailPosAdapter: ItemPosRetailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.state.usePid = mViewModel.posModeState.value is PosModeState.RetailState
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_scan, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.length >= 3) {
                    viewModel.onSearch(newText)
                }
                setVisiblitySearch(newText != null && newText.length < 3)
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
        searchView.setIconifiedByDefault(false)
        searchView.requestFocus()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_scan -> {
                val action = CariItemFragmentDirections.actionCariItemFragmentToScannerFragment()
                findNavController().navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            itemAdapter = ItemPosAdapter(
                onItemClicK = {item ->
                    mViewModel.onAddDetail(ItemWithUnit(item))
                },
                onMinusClick = {item ->
                    mViewModel.onMinusClick(item)
                },
                mViewModel.state.saledList)
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
            mViewModel.viewStates().collect {
                it?.let {
                    viewModel.state.bp = it.bp
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.searchItemFlow.collectLatest {
                    if(mViewModel.posModeState.value is PosModeState.FnBState)
                        itemAdapter.submitData(it)
                    else
                        itemRetailPosAdapter.submitData(it)
                    setVisiblitySearch(itemAdapter.itemCount == 0)
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

    fun setVisiblitySearch(isVisible : Boolean) {
        binding.apply {
            groupEmpty.isVisible = isVisible
            rvList.isVisible = !isVisible
        }
    }

}