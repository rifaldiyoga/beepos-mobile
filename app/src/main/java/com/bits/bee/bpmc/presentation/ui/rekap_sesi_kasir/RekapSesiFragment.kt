package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir

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
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.FragmentRekapSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.decideOnState
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RekapSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRekapSesiBinding = FragmentRekapSesiBinding::inflate
): BaseFragment<FragmentRekapSesiBinding>() {

    private val viewModel : RekapSesiViewModel by viewModels()
    private lateinit var rekapSesiAdapter: RekapSesiAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
    }

    override fun initComponents() {
        binding.apply {
            rekapSesiAdapter = RekapSesiAdapter(mListener = object : RekapSesiAdapter.PilihRekapSesiI{
                override fun onclick(posses: Posses) {
                    val action = RekapSesiFragmentDirections.actionRekapSesiFragmentToDetailSesiKasirFragment(Gson().toJson(
                        posses
                    ))
                    findNavController().navigate(action)
                }
            })
            rekapSesiAdapter.addLoadStateListener { loadState ->
                loadState.decideOnState(
                    rekapSesiAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
                    showLoading = {
//                        setVisibilityComponent(it)
                    },
                    showEmptyState = { isVisible ->
                        lLRekapEmpty.isVisible = isVisible
                    },
                    showError = { it ->
                        showSnackbar(it)
                    }
                )
            }

            rvRekapSesi.apply {
              layoutManager = LinearLayoutManager(requireContext())
              adapter = rekapSesiAdapter
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        it.user?.let {
                            rekapSesiAdapter.submitValue(viewModel.state.user)
                        }
                        viewModel.getRekapsesi()
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.possesList.collect {
                    rekapSesiAdapter.submitData(it)
                }
            }
        }
    }

}