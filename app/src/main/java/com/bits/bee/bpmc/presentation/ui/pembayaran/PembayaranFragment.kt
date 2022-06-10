package com.bits.bee.bpmc.presentation.ui.pembayaran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bits.bee.bpmc.databinding.FragmentPembayaranBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 25/04/22.
 */
@AndroidEntryPoint
class PembayaranFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranBinding = FragmentPembayaranBinding::inflate
) : BaseFragment<FragmentPembayaranBinding>() {

    private val viewModel : PembayaranViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var rekomBayarAdapter: RekomBayarAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initComponents() {
        binding.apply {
            rekomBayarAdapter = RekomBayarAdapter(
                onItemClick = { data ->
                    etNominalBayar.setText(data)
                }
            )
            rvList.apply {
                adapter = rekomBayarAdapter
                layoutManager = GridLayoutManager(requireContext(), 2)
            }
            numpad.setInputConnection(etNominalBayar.onCreateInputConnection(EditorInfo())!!)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTunai.setOnClickListener {
                viewModel.onTunaiClick()
            }
            btnNonTunai.setOnClickListener {
                viewModel.onNonTunaiClick()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        PembayaranViewModel.UIEvent.NavigateNonTunai -> {
                            val action = PembayaranFragmentDirections.actionPembayaranFragmentToPembayaranNonTunaiFragment()
                            findNavController().navigate(action)
                        }
                        PembayaranViewModel.UIEvent.NavigateTransaksiBerhasil -> {
                            val action = PembayaranFragmentDirections.actionPembayaranFragmentToTransaksiBerhasilFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        rekomBayarAdapter.submitList(it.rekomBayarList.values.toList())
                    }
                }
            }
        }
    }

}