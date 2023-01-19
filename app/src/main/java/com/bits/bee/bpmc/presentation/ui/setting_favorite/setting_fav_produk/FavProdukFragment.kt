package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.FragmentPosItemBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.custom.LoadingStateAdapter
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
class FavProdukFragment (
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPosItemBinding = FragmentPosItemBinding::inflate
) : BaseFragment<FragmentPosItemBinding>() {


    private val mainViewModel : SettingFavProdukViewModel by viewModels({requireParentFragment()})

    private lateinit var posAdapter: FavProdukAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val itgrp : ItemGroup = it.getParcelable(ITGRP)!!
//            viewModel.onReciveItemGroup(itgrp)
        }
    }

    override fun initComponents() {
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {

                posAdapter = FavProdukAdapter {
                    mainViewModel.updateFavorit(it)
                }

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
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = posAdapter.withLoadStateFooter(LoadingStateAdapter())
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

//        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            posAdapter.loadStateFlow.collectLatest {
//                if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
//                    if (posAdapter.itemCount == 0)
//                        binding.groupEmpty.visible()
//                    else
//                        binding.groupEmpty.gone()
//                }
//            }
//        }

    }

    private fun setVisibilityComponent(isLoading : Boolean) {
        binding.apply {
            if(isLoading){
                progressBar.visible()
//                rvList.gone()
            } else {
                progressBar.gone()
//                rvList.visible()
            }
        }
    }
}