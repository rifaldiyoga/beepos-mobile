package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_member

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
import com.bits.bee.bpmc.databinding.FragmentSettingFavMemberBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.setting_favorite.SettingFavoriteFragmentMainDirections
import com.bits.bee.bpmc.utils.extension.decideOnState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingFavMemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingFavMemberBinding = FragmentSettingFavMemberBinding::inflate
): BaseFragment<FragmentSettingFavMemberBinding>() {

    private val viewModel : SettingFavMemberViewModel by viewModels()

    private lateinit var memberAdapter: FavMemberAdapter

    override fun initComponents() {
        binding.apply {
            memberAdapter = FavMemberAdapter {
                viewModel.updateFavorit(it)
            }
            rvContent.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = memberAdapter
            }
            memberAdapter.addLoadStateListener { loadState ->
                loadState.decideOnState(
                    memberAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
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
                viewModel.memberList.collectLatest {
                    memberAdapter.submitData(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        SettingFavMemberViewModel.UIEvent.NavigateToPilih -> {
                            val action = SettingFavoriteFragmentMainDirections.actionSettingFavoriteFragmentMainToSettingFavPilihMemberFragment()
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