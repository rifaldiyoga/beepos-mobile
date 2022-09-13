package com.bits.bee.bpmc.presentation.ui.pilih_kasir

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPilihKasirBinding
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/03/22.
 */
@AndroidEntryPoint
class PilihKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPilihKasirBinding = FragmentPilihKasirBinding::inflate
) : BaseFragment<FragmentPilihKasirBinding>(){

    private val viewModel : PilihKasirViewModel by viewModels()

    private lateinit var adapter: PilihKasirAdapter

    private lateinit var dialog : LoadingDialogHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCashierList()
    }

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireContext())
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
                    R.string.page_pilih_kasir))
        setHasOptionsMenu(true)
        binding.apply {
            adapter = PilihKasirAdapter(onItemClick = {
                val device = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_nama_device), "") as String
                viewModel.onItemClick(cashier = it, device)
            })

            rvList.layoutManager = LinearLayoutManager(requireActivity())
            rvList.adapter = adapter
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        PilihKasirViewModel.UIEvent.NavigateToPin -> {
                            val action = PilihKasirFragmentDirections.actionPilihKasirFragmentToLoginOperatorFragment()
                            findNavController().navigate(action)
                        }
                        is PilihKasirViewModel.UIEvent.ShowDialog -> {
                            if(it.isShowDialog){
                                dialog.show()
                            } else {
                                dialog.hide()
                            }
                        }
                    }
                }
            }
        }
        viewModel.observeCashierResponse().observe(viewLifecycleOwner) {
            it?.let {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        setVisibilityComponent(true)
                    }
                    Resource.Status.SUCCESS -> {
                        setVisibilityComponent(false)
                        it.data?.let {
                            val data = it
                            adapter.submitList(data)
                        }
                    }
                    Resource.Status.ERROR -> {
                        setVisibilityComponent(false)
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_reload, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_refresh -> viewModel.getCashierList()
        }
        return super.onOptionsItemSelected(item)
    }


    /**
     * Check visibiliy of progress bar and recycler view when request data from api
     * @param isLoading
     */
    private fun setVisibilityComponent(isLoading : Boolean){
        binding.apply {
            if(isLoading){
                progressBar.visible()
                rvList.gone()
            } else {
                progressBar.gone()
                rvList.visible()
            }
        }
    }

    fun onItemClick(cashier :Cashier) {

    }

}