package com.bits.bee.bpmc.presentation.dialog.draft_list

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogDraftListBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 24/06/22.
 */
@AndroidEntryPoint
class DraftListDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDraftListBinding = DialogDraftListBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDraftListBinding>() {

    private val viewModel : DraftListViewModel by viewModels()
    private val mViewModel : MainViewModel by activityViewModels()

    private lateinit var draftAdapter : DraftDialogAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDraftList()
    }

    override fun initComponents() {
        binding.apply {
            draftAdapter = DraftDialogAdapter(
                onItemClick = {
                    viewModel.onItemClick(it)
                }
            )
            rvList.apply {
                adapter = draftAdapter
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTutup.setOnClickListener {
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
            btnLihatSelengkapnya.setOnClickListener {
                val action = DraftListDialogDirections.actionDraftListDialogToDraftFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
                viewModel.event.collect {
                    when(it){
                        is DraftListViewModel.UIEvent.RequestDraft -> {
                            mViewModel.loadDraft(it.sale)
                            findNavController().popBackStack(R.id.posFragment, false)
                        }
                    }
                }

        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        draftAdapter.submitList(it.saleList)
                        setVisibilityEmpty(it.saleList.isEmpty())
                    }
                }
            }
        }
    }

    private fun setVisibilityEmpty(isVisible : Boolean) {
        binding.apply {
            rvList.isVisible = !isVisible
            btnLihatSelengkapnya.isVisible = !isVisible
            group2.isVisible = isVisible
        }
    }

}