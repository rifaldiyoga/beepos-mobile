package com.bits.bee.bpmc.presentation.ui.pos.channel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogChannelBinding
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 05/04/22.
 */
@AndroidEntryPoint
class ChannelListDialogBuilder(
    private val channelList : List<Channel>,
    private val onChannelClick : (Channel) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogChannelBinding = DialogChannelBinding::inflate
) : BaseBottomSheetDialogFragment<DialogChannelBinding>() {

    private val viewModel : ChannelDialogViewModel by viewModels()

    private lateinit var channelListAdapter: ChannelListAdapter

    override fun initComponents() {
        binding.apply {
            channelListAdapter = ChannelListAdapter(onChannelClick = {
                onChannelClick(it)
                dismiss()
            })
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = channelListAdapter
                channelListAdapter.submitList(channelList)
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            imageView2.setOnClickListener {
                dismiss()
            }
        }

    }

    override fun subscribeObservers() {

    }

}