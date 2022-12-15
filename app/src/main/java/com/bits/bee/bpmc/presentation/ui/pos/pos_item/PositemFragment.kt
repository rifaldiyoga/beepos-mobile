package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.FragmentPosItemBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.cari_item.CariItemFragmentDirections
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.extension.decideOnState
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/04/22.
 */

const val ITGRP = "itgrp"

@AndroidEntryPoint
class PositemFragment (
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPosItemBinding = FragmentPosItemBinding::inflate
) : BaseFragment<FragmentPosItemBinding>() {

    private val viewModel : PosItemViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var posAdapter: ItemPosAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val itgrp : ItemGroup = it.getParcelable(ITGRP)!!
            viewModel.onReciveItemGroup(itgrp)
        }
    }

    override fun initComponents() {
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                mainViewModel.posPreferences.collect {
                    posAdapter = ItemPosAdapter(
                        onItemClicK = {item ->
                            onItemClick(item)
                        },
                        onMinusClick = {item ->
                            onMinusClick(item)
                        },
                        mainViewModel.state.saledList,
                        it.ukuranFont,
                        it.isMultiLine,
                        it.isMuatGambar
                    )

                    posAdapter.addLoadStateListener { loadState ->
                        loadState.decideOnState(
                            posAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
                            showLoading = {
                                setVisibilityComponent(it)
                            },
                            showEmptyState = { isVisible ->
                                binding.groupEmpty.isVisible = isVisible
                            },
                            showError = {
                                showSnackbar(it)
                            }
                        )
                    }
                    rvList.apply {
                        layoutManager = when(mainViewModel.orientation.value) {
                            BPMConstants.SCREEN_POTRAIT -> LinearLayoutManager(requireContext())
                            else -> GridLayoutManager(requireContext(), 3)
                        }
                        adapter = posAdapter
                        itemAnimator = null
                    }
                }
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.itemList.collectLatest { pagingData ->
                    posAdapter.submitData(pagingData)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collectLatest {
                    it?.let {
                        if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT)
                            posAdapter.submitSaledList(it.saledList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            posAdapter.loadStateFlow.collectLatest {
                if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                    if (posAdapter.itemCount == 0)
                        binding.groupEmpty.visible()
                    else
                        binding.groupEmpty.gone()
                }
            }
        }
        
    }

    private fun setVisibilityComponent(isLoading : Boolean) {
        binding.apply {
            if(isLoading){
                progressBar.visible()
                rvList.gone()
            } else {
                progressBar.gone()
                rvList.visible()
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
                    val action = PosFragmentDirections.actionPosFragmentToDetailAddOnDialogBuilder(item)
                    findNavController().navigate(action)
                } else {
                    val action = PosFragmentDirections.actionPosFragmentToAddOnFragment(item, mainViewModel.state.bp!!, mainViewModel.state.bp!!.priceLvlId)
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
                    val action =
                        PosFragmentDirections.actionPosFragmentToDetailAddOnDialogBuilder(item)
                    findNavController().navigate(action)
                }
            }
        } else {
            mainViewModel.onAddDetail(ItemWithUnit(item))
        }
    }

    private fun onMinusClick(item : Item) {
        if(item.isVariant || item.isHaveAddOn) {
            val action = CariItemFragmentDirections.actionCariItemFragmentToAddOnFragment(item, mainViewModel.state.bp!!, mainViewModel.state.bp!!.priceLvlId)
            findNavController().navigate(action)
        } else {
            mainViewModel.onMinusClick(item)
        }
    }
}