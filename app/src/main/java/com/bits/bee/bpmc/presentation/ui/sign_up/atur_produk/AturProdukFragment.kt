package com.bits.bee.bpmc.presentation.ui.sign_up.atur_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentAturProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.download.DownloadDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class AturProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAturProdukBinding = FragmentAturProdukBinding::inflate
) : BaseFragment<FragmentAturProdukBinding>() {

    private val viewModel : AturProdukViewModel by viewModels()

    private lateinit var itemDummyAdapter: ItemDummyAdapter

    private lateinit var dialog : LoadingDialogHelper

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireActivity())
        viewModel.loadData(requireActivity())
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
            R.string.page_atur_produk))
        binding.apply {
            itemDummyAdapter = ItemDummyAdapter(onItemClick = { item ->
                val action = AturProdukFragmentDirections.actionAturProdukFragmentToTambahProdukFragment(if(item.id != null) item else null)
                findNavController().navigate(action)
            })
            rvList.apply {
                adapter = itemDummyAdapter
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btntambahPrd.setOnClickListener {
                viewModel.onClickTambah()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.itemDummyList.collect {
                    when(it.status){
                        Resource.Status.LOADING -> {
                            binding.progressBar.visible()
                            binding.constraintLayout9.gone()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.gone()
                            binding.constraintLayout9.visible()
                            it.data?.let {
                                binding.apply {
                                    rvList.isVisible = it.isNotEmpty()
                                    constraintLayout9.isVisible = it.isEmpty()
                                    if(it.isNotEmpty()){
                                        btntambahPrd.text = "Mulai Jualan"
                                    }
                                }
                                if(it.isNotEmpty()) {
                                    clearPref()
                                    viewModel.state.itemList = it
                                    itemDummyAdapter.submitList(it.toMutableList())
                                }
                            }
                        }
                        Resource.Status.ERROR -> {
                            binding.progressBar.gone()
                        }
                        Resource.Status.NOINTERNET -> {

                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        AturProdukViewModel.UIEvent.FinishTambahProduk -> {
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_is_sign_up), false)
                            val action = AturProdukFragmentDirections.actionAturProdukFragmentToHomeActivity()
                            findNavController().navigate(action)
                        }
                        AturProdukViewModel.UIEvent.NavigateToTambahProduk -> {
                            val action = AturProdukFragmentDirections.actionAturProdukFragmentToTambahProdukFragment()
                            findNavController().navigate(action)
                        }
                        AturProdukViewModel.UIEvent.HideLoading -> {
                            dialog.hide()
                        }
                        is AturProdukViewModel.UIEvent.ShowLoading -> {
                            if(it.msg.isNotEmpty())
                                dialog.show(message = it.msg)
                            else
                                dialog.show()
                        }
                        AturProdukViewModel.UIEvent.NavigateToDownload -> {
                            val dialog = DownloadDialogBuilder(false, {
                                it.dismiss()
                                viewModel.onFinsihDownload()
                            })
                            dialog.show(parentFragmentManager, "")
                        }
                    }
                }
            }
        }
    }

    private fun clearPref(){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()
        sharedPreferences.remove(getString(R.string.pref_add_nama_prd))
        sharedPreferences.remove(getString(R.string.pref_add_harga_prd))
        sharedPreferences.remove(getString(R.string.pref_add_tipe_prd))
        sharedPreferences.remove(getString(R.string.pref_add_list_unit))
        sharedPreferences.remove(getString(R.string.pref_add_pid))
        sharedPreferences.commit()
    }
}