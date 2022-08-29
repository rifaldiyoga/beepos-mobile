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
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Utils
import com.bits.bee.bpmc.utils.extension.decideOnState
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/04/22.
 */

const val ITGRP = "itgrp"

@AndroidEntryPoint
class PositemFragment(
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
            posAdapter = ItemPosAdapter(
                onItemClicK = {item ->
                    onItemClick(item)
                },
                onMinusClick = {item ->
                    mainViewModel.onMinusClick(item)
                },
                mainViewModel.state.saledList,
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
                    showError = { it ->
                        showSnackbar(it)
                    }
                )
            }
            rvList.apply {
                layoutManager = when(Utils.getScreenResolution(requireActivity())) {
                    BPMConstants.SCREEN_POTRAIT -> LinearLayoutManager(requireContext())
                    else -> GridLayoutManager(requireContext(), 3)
                }
                adapter = posAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collectLatest {
                    it?.let {
                        it.bp?.let { bp ->
                            viewModel.state.priceLvlId = bp.priceLvlId
                            viewModel.loadItem(bp)
                        }
                        posAdapter.submitSaledList(it.saledList)
//                        it.channel?.let { channel ->
//                            channel.priceLvlId?.let { pricelvl ->
//                                viewModel.state.priceLvlId = channel.priceLvlId!!
//                                viewModel.loadItem()
//                            }
//                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.itemGroup?.let {
                            mainViewModel.state.let {
                                it.bp?.let{ bp ->
                                    viewModel.loadItem(bp)
                                }
                            }
                        }
                        it.itemList?.let { pagingData ->
                            posAdapter.submitData(pagingData)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
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
            val action = PosFragmentDirections.actionPosFragmentToAddOnFragment(item, mainViewModel.state.bp!!, mainViewModel.state.bp!!.priceLvlId)
            findNavController().navigate(action)
        } else {
            mainViewModel.onAddDetail(ItemWithUnit(item))
        }
    }
}