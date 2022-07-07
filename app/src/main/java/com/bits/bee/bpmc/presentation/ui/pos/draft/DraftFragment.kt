package com.bits.bee.bpmc.presentation.ui.pos.draft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentDraftListBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 27/06/22.
 */
@AndroidEntryPoint
class DraftFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDraftListBinding = FragmentDraftListBinding::inflate
) : BaseFragment<FragmentDraftListBinding>() {

    private val viewModel : DraftViewModel by viewModels()
    private lateinit var draftAdapter : DraftAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadDraft()
    }

    override fun initComponents() {
        draftAdapter = DraftAdapter()
        binding.apply {
            rvList.apply {
                adapter = draftAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        draftAdapter.submitList(it.saleList)
                        setVisibilityEmptyView(it.saleList.isEmpty())
                    }
                }
            }
        }
    }

    private fun setVisibilityEmptyView(isVisible : Boolean) {
        binding.apply {
            if(isVisible){
                groupEmpty.visible()
                rvList.gone()
            } else {
                groupEmpty.gone()
                rvList.visible()
            }
        }
    }
}