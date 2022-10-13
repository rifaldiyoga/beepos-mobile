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
import com.bits.bee.bpmc.databinding.FragmentPosItemBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.setting_favorite.SettingFavoriteFragmentMainDirections
import com.bits.bee.bpmc.utils.extension.decideOnState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingFavPilihMemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPosItemBinding = FragmentPosItemBinding::inflate
): BaseFragment<FragmentPosItemBinding>() {

    private val viewModel : SettingFavMemberViewModel by viewModels()

    private lateinit var memberAdapter: FavMemberAdapter

    override fun initComponents() {
        viewModel.setFavorit(false)
        binding.apply {
            memberAdapter = FavMemberAdapter {
                viewModel.updateFavorit(it)
            }
            rvList.apply {
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
                        binding.groupEmpty.isVisible = isVisible
                        rvList.isVisible = !isVisible
                    },
                    showError = { it ->
                        showSnackbar(it)
                    }
                )
            }
        }
    }

    override fun subscribeListeners() {

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
            rvList.isVisible = isVisible
            progressBar.isVisible = isVisible
            groupEmpty.isVisible = !isVisible
        }
    }
}