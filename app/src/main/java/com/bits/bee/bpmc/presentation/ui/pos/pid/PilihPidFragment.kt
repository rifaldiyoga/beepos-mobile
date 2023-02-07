package com.bits.bee.bpmc.presentation.ui.pos.pid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentPidBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 04/08/22.
 */
@AndroidEntryPoint
class PilihPidFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPidBinding = FragmentPidBinding::inflate
) : BaseFragment<FragmentPidBinding>(){

    private val viewModel : PilihPidViewModel by viewModels()

    private lateinit var pidAdapter : PilihPidAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val item = it.getParcelable<Item>("item")
            viewModel.state.item = item

            viewModel.loadData()
        }
    }

    override fun initComponents() {
        binding.apply {
            pidAdapter = PilihPidAdapter{
                viewModel.onItemClick(it)
            }
            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = pidAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect {
                when(it){
                    is PilihPidViewModel.UIEvent.NavigateToAddItem -> {
                        val action = PilihPidFragmentDirections.actionPilihPidFragmentToEditItemDialog(item = it.item, pid = it.stock)
                        findNavController().navigate(action)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let { state ->
                        binding.textView102.text = state.item?.name1 ?: ""
                        pidAdapter.submitList(state.stockList)
                        binding.progressBar.isVisible = state.isLoading
                    }
                }
            }
        }
    }


}