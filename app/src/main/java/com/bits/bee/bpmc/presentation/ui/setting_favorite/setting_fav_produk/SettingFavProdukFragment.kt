package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.FragmentSettingFavProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.custom.LoadingStateAdapter
import com.bits.bee.bpmc.presentation.ui.setting_favorite.SettingFavoriteFragmentMainDirections
import com.bits.bee.bpmc.utils.extension.decideOnState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingFavProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingFavProdukBinding = FragmentSettingFavProdukBinding::inflate
): BaseFragment<FragmentSettingFavProdukBinding>() {

    private val viewModel : SettingFavProdukViewModel by viewModels()

    private lateinit var posAdapter : FavProdukAdapter

    override fun initComponents() {
        binding.apply {
            posAdapter = FavProdukAdapter {
                viewModel.updateFavorit(it)
            }

            posAdapter.addLoadStateListener { loadState ->
                loadState.decideOnState(
                    posAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
                    showLoading = {
                        binding.progressBar.isVisible = it
                    },
                    showEmptyState = { isVisible ->
                        binding.group3.isVisible = isVisible
                        rvContent.isVisible = !isVisible
                        fabAdd.isVisible = !isVisible
                    },
                    showError = { it ->
                        showSnackbar(it)
                    }
                )
            }
            rvContent.apply {
                layoutManager =  LinearLayoutManager(requireContext())
                adapter = posAdapter.withLoadStateFooter(LoadingStateAdapter())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                viewModel.onClickAdd()
            }
            fabAdd.setOnClickListener {
                viewModel.onClickAdd()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.itemList.collect { pagingData ->
                    posAdapter.submitData(pagingData)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        SettingFavProdukViewModel.UIEvent.NavigateToPilih -> {
                            val action = SettingFavoriteFragmentMainDirections.actionSettingFavoriteFragmentMainToSettingFavPilihProdukFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }

    private fun setVisibiltyContent(isVisible : Boolean) {
        binding.apply {
            rvContent.isVisible = isVisible
            fabAdd.isVisible = isVisible
            group3.isVisible = !isVisible
        }
    }
}