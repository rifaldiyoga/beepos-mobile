package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.databinding.FragmentPilihDbBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 04/03/22.
 */

@AndroidEntryPoint
class PilihDbFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPilihDbBinding = FragmentPilihDbBinding::inflate
) : BaseFragment<FragmentPilihDbBinding>() {

    //View Model
    private val viewModel : PilihDbViewModel by viewModels()

    private lateinit var adapter: PilihDbAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.inputEmail = it.getString("username", "hafis@beeaccounting.com")
            viewModel.inputPassword = it.getString("password", "Nanda123")

            viewModel.login()
        }
    }

    override fun initComponents() {
        binding.apply {
            setHasOptionsMenu(true)
            adapter = PilihDbAdapter(mListener = object :  PilihDbAdapter.PilihDbAdapterI{
                override fun onItemClick(db: LoginResponse.Db) {
                    val action = PilihDbFragmentDirections.actionPilihDbFragmentToModeTampilanFragment()
                    findNavController().navigate(action)
                }
            })
            rvList.layoutManager = LinearLayoutManager(requireContext())
            rvList.adapter = adapter
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewModel.observeLoginResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeLoginResponse().observe(viewLifecycleOwner, {
            it?.let {
                when(it.status){
                    Resource.Status.LOADING -> {
                        setVisibilityComponent(true)
                    }
                    Resource.Status.SUCCESS -> {
                        setVisibilityComponent(false)
                        it.data?.let {
                            adapter.submitList(it.db)
                            adapter.notifyDataSetChanged()
                        }
                    }
                    Resource.Status.ERROR -> {
                        setVisibilityComponent(false)
                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_reload, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_refresh -> viewModel.login()
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
                rvList.visible()
                progressBar.gone()
            }
        }
    }

}