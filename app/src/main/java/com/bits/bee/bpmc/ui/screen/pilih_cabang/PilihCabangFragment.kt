package com.bits.bee.bpmc.ui.screen.pilih_cabang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentPilihCabangBinding
import com.bits.bee.bpmc.ui.base.BaseFragment
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint

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

        viewModel.login()
    }

    override fun initComponents() {
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
    }

    override fun subscribeObservers() {
        viewModel.observeListBranch().removeObservers(viewLifecycleOwner)
        viewModel.observeListBranch().observe(viewLifecycleOwner, {
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
        })
    }

    private fun setVisibilityComponent(isLoading : Boolean){
        binding.apply {
            if(isLoading){
                rvList.gone()
                progressBar.visible()
            } else {
                rvList.visible()
                progressBar.gone()
            }
        }
    }
}