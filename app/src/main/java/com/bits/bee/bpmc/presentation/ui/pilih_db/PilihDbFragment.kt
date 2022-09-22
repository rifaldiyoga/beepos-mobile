package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.databinding.FragmentPilihDbBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

    private lateinit var dialog : LoadingDialogHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.state.inputEmail = it.getString("username", "")
            viewModel.state.inputPassword = it.getString("password", "")

            viewModel.login()
        }
    }

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireContext())
        binding.apply {
            setHasOptionsMenu(true)
            adapter = PilihDbAdapter(mListener = object :  PilihDbAdapter.PilihDbAdapterI{
                override fun onItemClick(db: LoginResponse.Db) {
//<<<<<<< HEAD
                    viewModel.postDb(db.dbName)
//=======
//                    viewModel.onClickDb(db)
//>>>>>>> 1ddb2a9... ^ login operator
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
        viewModel.observeLoginResponse().observe(viewLifecycleOwner) {
            it?.let {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        setVisibilityComponent(true)
                    }
                    Resource.Status.SUCCESS -> {
                        setVisibilityComponent(false)
                        it.data?.let {
                            adapter.submitList(it.db)
                        }
                    }
                    Resource.Status.ERROR -> {
                        setVisibilityComponent(false)
                    }
                }
            }
        }
//<<<<<<< HEAD
//=======
//        viewModel.observeInitialResponse().removeObservers(viewLifecycleOwner)
//        viewModel.observeInitialResponse().observe(viewLifecycleOwner) {
//            it?.let {
//                when(it.status){
//                    Resource.Status.LOADING -> {
//                        dialog.show(
//                            message = "Inisialisasi Data"
//                        )
//                    }
//                    Resource.Status.SUCCESS -> {
//                        dialog.hide()
//                        viewModel.onSuccessDb()
//                    }
//                    Resource.Status.ERROR -> {
//                        dialog.hide()
//                    }
//                }
//            }
//        }
//        viewModel.observeDbResponse().removeObservers(viewLifecycleOwner)
//        viewModel.observeDbResponse().observe(viewLifecycleOwner){
//            it?.let {
//                when (it.status) {
//                    Resource.Status.LOADING -> {
////                        setVisibilityComponent(true)
//                    }
//                    Resource.Status.SUCCESS -> {
//                        setVisibilityComponent(false)
//                        it.data?.let {
//                            val listData = it.dataDb
//                            if (it.status.equals("success")){
//                                val deviceName = Build.MANUFACTURER + Build.DEVICE + Build.ID + "-" + BeePreferenceManager.getDataFromPreferences(requireContext(),getString(R.string.pref_nama_device), "")
//                                viewModel.doLincensing(listData.get(0).auth_key, deviceName)
//                            }else{
//                                Toast.makeText(requireContext(), "Error Response Db: ${it.status}", Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                    }
//                    Resource.Status.ERROR -> {
////                        setVisibilityComponent(false)
//                    }
//                }
//            }
//        }

        viewModel.observeLicResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeLicResponse().observe(viewLifecycleOwner){
            it?.let {
                when(it.status){
                    Resource.Status.LOADING -> {
                        dialog.show(
                            message = "Validasi Lisensi"
                        )
                    }
                    Resource.Status.SUCCESS -> {
                        dialog.hide()
                        Toast.makeText(requireContext(), "Licensi Berhasil", Toast.LENGTH_SHORT).show()
                        viewModel.requestDb()
                    }
                    Resource.Status.ERROR -> {
                        dialog.hide()
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        PilihDbViewModel.UIEvent.NavigateToPilihMode -> {
                            val action = PilihDbFragmentDirections.actionPilihDbFragmentToModeTampilanFragment()
                            findNavController().navigate(action)
                        }
                        PilihDbViewModel.UIEvent.RequestDb -> {

                        }
                        is PilihDbViewModel.UIEvent.ShowLoading -> {
                            val isShow = it.isShow
                            if(isShow)
                                dialog.show(message = it.msg)
                            else
                                dialog.hide()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewStates().collect {
                it?.let {

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