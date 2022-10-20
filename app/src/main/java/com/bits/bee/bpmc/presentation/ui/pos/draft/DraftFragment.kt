package com.bits.bee.bpmc.presentation.ui.pos.draft

import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDraftListBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.setSearchViewStyle
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 27/06/22.
 */
@AndroidEntryPoint
class DraftFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDraftListBinding = FragmentDraftListBinding::inflate
) : BaseFragment<FragmentDraftListBinding>() {

    private val viewModel : DraftViewModel by viewModels()

    private val mViewModel : MainViewModel by activityViewModels()

    private lateinit var draftAdapter : DraftAdapter

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setSearchViewStyle(requireActivity(), R.color.black)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null && newText.length >= 3) {
                    viewModel.onSearch(newText)
                } else {
                    viewModel.onSearch("")
                }
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun initComponents() {
        setHasOptionsMenu(true)
        draftAdapter = DraftAdapter(
            onClickItem = {
                viewModel.onItemClick(it)
            },
            onDeleteItem = { sale ->
                val dialog = DialogBuilderHelper.showDialogChoice(
                    requireContext(),
                    title = "Hapus Draft",
                    msg = "Apakah anda yakin ingin menghapus draft? Transaksi yang dihapus tidak dapat dikembalikan lagi",
                    positiveTxt = getString(R.string.batal),
                    positiveListener = {
                        it.dismiss()
                    },
                    negativeTxt = getString(R.string.hapus),
                    negativeListener = {
                        it.dismiss()
                        viewModel.onDeleteClick(sale)
                    }
                )
                dialog.show(parentFragmentManager, "")
            }
        )
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
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect {
                when(it){
                    is DraftViewModel.UIEvent.RequestDraft -> {
                        mViewModel.loadDraft(it.sale)
                        findNavController().popBackStack()
//                        findNavController().previousBackStackEntry?.savedStateHandle?.set("sale", it.sale)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            draftAdapter.loadStateFlow.collectLatest {
                if (it.append is LoadState.NotLoading && it.append.endOfPaginationReached) {
                    setVisibilityEmptyView(draftAdapter.itemCount == 0)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.draftList.collectLatest {
                    draftAdapter.submitData(it)
                }
            }
        }
    }

    private fun setVisibilityEmptyView(isVisible : Boolean) {
        binding.apply {
            if(isVisible){
                groupEmpty.visible()
                tvDesc.text = if (viewModel.currentQuery.length > 3) getString(R.string.draft_tidak_ditemukan) else getString(R.string.tidak_ada_draft_yang_disimpan)
                rvList.gone()
            } else {
                groupEmpty.gone()
                rvList.visible()
            }
        }
    }
}