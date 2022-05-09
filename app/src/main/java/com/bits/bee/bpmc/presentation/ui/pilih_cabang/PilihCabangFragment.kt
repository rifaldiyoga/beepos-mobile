package com.bits.bee.bpmc.presentation.ui.pilih_cabang

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPilihCabangBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 17/03/22.
 */

@AndroidEntryPoint
class PilihCabangFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPilihCabangBinding = FragmentPilihCabangBinding::inflate
) : BaseFragment<FragmentPilihCabangBinding>() {

    private val viewModel : PilihCabangViewModel by viewModels()

    private lateinit var adapter: PilihCabangAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(R.string.page_pilih_cabang))
        setHasOptionsMenu(true)
        binding.apply {
            adapter = PilihCabangAdapter(onItemClick = {
                val action = PilihCabangFragmentDirections.actionPilihCabangFragmentToPilihKasirFragment()
                findNavController().navigate(action)
            })

            rvList.layoutManager = LinearLayoutManager(requireContext())
            rvList.adapter = adapter
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            swipeRefresh.setOnRefreshListener {
                viewModel.getLatestBranchUseCase()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getLatestBranchUseCase().collect {
                    it?.let {
                        when(it.status){
                            Resource.Status.LOADING -> {
                                setVisibilityComponent(true)
                            }
                            Resource.Status.SUCCESS -> {
                                setVisibilityComponent(false)
                                it.data?.let { data ->
                                    adapter.submitList(data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                            Resource.Status.ERROR -> {
                                setVisibilityComponent(false)
                            }
                            Resource.Status.TIMEOUT -> {
                                setVisibilityComponent(false)
                            }
                            Resource.Status.UNAUTHORIZED -> {
                                setVisibilityComponent(false)
                            }
                        }
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
            R.id.menu_refresh -> viewModel.getLatestBranchUseCase()
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
                rvList.gone()
                progressBar.visible()
            } else {
                if(swipeRefresh.isRefreshing)
                    swipeRefresh.isRefreshing = false
                rvList.visible()
                progressBar.gone()
            }
        }
    }

}