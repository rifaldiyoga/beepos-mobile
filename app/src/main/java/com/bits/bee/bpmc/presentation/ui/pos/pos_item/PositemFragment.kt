package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentPosItemBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.math.BigDecimal

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
            Toast.makeText(requireContext(), itgrp.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun initComponents() {
        binding.apply {
            posAdapter = ItemPosAdapter(
                onItemClicK = {item ->
                    mainViewModel.onAddDetail(item)
                },
                onMinusClick = {item ->
                    onMinusClick(item)
                },
                mainViewModel.state.saledList
            )
            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
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
                            viewModel.loadItem()
                        }
                        posAdapter
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
                            viewModel.loadItem()
                        }
                        if(it.itemList.isEmpty())
                            binding.groupEmpty.visible()
                        else
                            binding.groupEmpty.gone()

                        posAdapter.submitList(it.itemList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.itemList.collectLatest {
                    when(it.status){
                        Resource.Status.LOADING -> {
                            setVisibilityComponent(true)
                        }
                        Resource.Status.SUCCESS -> {
                            setVisibilityComponent(false)
                            it.data?.let { data ->
                                viewModel.updateState(
                                    viewModel.state.copy(
                                        itemList = data
                                    )
                                )
                            }
                        }
                        Resource.Status.ERROR -> {
                            setVisibilityComponent(false)

                        }
                    }
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

    private fun onMinusClick(item : Item){
        val saled = mainViewModel.state.saledList.firstOrNull {
            item.id == it.itemId
        }
        saled?.let {
            if(it.qty > BigDecimal.ONE) {
                var saledCopy = it.copy(qty = it.qty - BigDecimal.ONE)
                mainViewModel.onEditDetail(saled)
            } else {
                mainViewModel.onDeleteDetail(saled)
            }
        }
    }
}