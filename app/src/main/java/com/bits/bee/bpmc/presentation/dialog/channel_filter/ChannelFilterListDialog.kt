package com.bits.bee.bpmc.presentation.dialog.channel_filter

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
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogChannelFilterBinding
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 24/06/22.
 */
@AndroidEntryPoint
class ChannelFilterListDialog(
    private val selectedChannelList : List<Channel>,
    private val onFinish : (List<Channel>) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogChannelFilterBinding = DialogChannelFilterBinding::inflate
) : BaseBottomSheetDialogFragment<DialogChannelFilterBinding>() {

    private val viewModel : ChannelFilterListViewModel by viewModels()

    private lateinit var channelAdapter : ChannelDialogAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.selectedChannelList = selectedChannelList
        viewModel.getChannelList()
    }

    override fun initComponents() {
        binding.apply {
            channelAdapter = ChannelDialogAdapter(
                onItemClick = {
                    viewModel.onItemClick(it)
                }
            )
            recyclerView.apply {
                adapter = channelAdapter
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            imageView2.setOnClickListener {
                dismiss()
            }
            btnSimpan.setOnClickListener {
                onFinish(viewModel.state.channelList.filter { it.isSelected })
                dismiss()
            }
            tvReset.setOnClickListener {
                viewModel.onResetClick()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
                viewModel.event.collect {
                    when(it){
                        is ChannelFilterListViewModel.UIEvent.RequestChannel -> {
                            findNavController().popBackStack(R.id.posFragment, false)
                        }
                    }
                }

        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        channelAdapter.submitList(it.channelList)
                        setVisibilityEmpty(it.channelList.isEmpty())
                    }
                }
            }
        }
    }

    private fun setVisibilityEmpty(isVisible : Boolean) {
        binding.apply {
            recyclerView.isVisible = !isVisible
        }
    }

}