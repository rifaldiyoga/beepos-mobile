package com.bits.bee.bpmc.ui.screen.pilih_kasir

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.databinding.FragmentPilihKasirBinding
import com.bits.bee.bpmc.ui.base.BaseFragment
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 22/03/22.
 */
@AndroidEntryPoint
class PilihKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPilihKasirBinding = FragmentPilihKasirBinding::inflate
) : BaseFragment<FragmentPilihKasirBinding>(){

    private val viewModel : PilihKasirViewModel by viewModels()

    private lateinit var adapter: PilihKasirAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCashierList()
    }

    override fun initComponents() {
        binding.apply {
            adapter = PilihKasirAdapter(onItemClick = {
                val action = PilihKasirFragmentDirections.actionPilihKasirFragmentToLoginOperatorFragment()
                findNavController().navigate(action)
            })

            rvList.layoutManager = LinearLayoutManager(requireActivity())
            rvList.adapter = adapter
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewModel.observeCashierResponse().observe(viewLifecycleOwner, {
            it?.let {
                when(it.status){
                    Resource.Status.LOADING -> {
                        setVisibilityComponent(true)
                    }
                    Resource.Status.SUCCESS -> {
                        setVisibilityComponent(false)
                        it.data?.let {
                            val data = it.data!!.data
                            data.add(CashierResponse.Cashier(1, "", "Malang 1", 1, 2, 2, 3, true, true))
                            data.add(CashierResponse.Cashier(2, "", "Malang 2", 1, 2, 2, 3, false, true))
                            adapter.submitList(data)
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
                progressBar.visible()
                rvList.gone()
            } else {
                progressBar.gone()
                rvList.visible()
            }
        }
    }

}