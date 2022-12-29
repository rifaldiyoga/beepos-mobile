package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.download.DownloadDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
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

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ data ->
        data.forEach {
            if(!it.value){
//                Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
//                try {
//                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                    val uri = Uri.fromParts("package", "com.bits.bee.bpmc", null)
//                    intent.data = uri
//                    startActivity(intent)
//                }catch (e : ActivityNotFoundException){
//                    e.printStackTrace()
//                }
            }
        }
    }

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
                    viewModel.postDb(db.dbName)
                }
            })
            rvList.layoutManager = LinearLayoutManager(requireContext())
            rvList.adapter = adapter
            findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>("isFinsihDownload")?.observe(viewLifecycleOwner){
                if(it)
                    viewModel.onSuccessDb()
            }
        }
        val permission = mutableListOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            permission.add(Manifest.permission.MANAGE_EXTERNAL_STORAGE, )
            permission.add(Manifest.permission.ACCESS_MEDIA_LOCATION)
        }
        requestPermissionCamera.launch(permission.toTypedArray())
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
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_email), viewModel.state.inputEmail)
                            adapter.submitList(it.db)
                            if(it.db.isNotEmpty() && it.db.size == 1){
                                viewModel.postDb(it.db[0].dbName)
                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        setVisibilityComponent(false)
                    }
                    Resource.Status.NOINTERNET -> {
                        val dialog = NoInternetDialogBuilder({
                            viewModel.login()
                        })
                        dialog.show(parentFragmentManager, "")
                    }
                }
            }
        }

        viewModel.observeLicense().removeObservers(viewLifecycleOwner)
        viewModel.observeLicense().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    viewModel.showDialog("Validasi Lisensi")
                }
                Resource.Status.SUCCESS -> {
                    viewModel.hideDialog()
                    it.data?.let {
                        if(it.licNumber.isNotEmpty()){
                            viewModel.onSuccessLicense()
                        } else {
                            val dialog = DialogBuilderHelper.showDialogChoice(requireActivity(), "Informasi",
                                "Lisensi telah digunakan semua!\nUlangi proses verifikasi lisensi?",
                                "Ulangi",
                                {
                                    it.dismiss()
                                    viewModel.postDb(viewModel.state.dbName)
                                },
                                "Tidak"
                            )
                            dialog.show(parentFragmentManager, "")
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    viewModel.hideDialog()
                    val dialog = DialogBuilderHelper.showDialogChoice(requireActivity(), "Informasi",
                        "Lisensi telah digunakan semua!\nUlangi proses verifikasi lisensi?",
                        "Ulangi",
                        {
                            it.dismiss()
                            viewModel.postDb(viewModel.state.dbName)
                        },
                        "Tidak"
                    )
                    dialog.show(parentFragmentManager, "")
                }
                Resource.Status.NOINTERNET -> {
                    val dialog = NoInternetDialogBuilder({
                        viewModel.postDb(viewModel.state.dbName)
                    })
                    dialog.show(parentFragmentManager, "")
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
                        PilihDbViewModel.UIEvent.NavigateToDownload -> {
                            val dialog = DownloadDialogBuilder(isCancel = false, onFinishDownload = {
                                viewModel.onSuccessDb()
                            })
                            dialog.show(parentFragmentManager, "")
                        }
                        PilihDbViewModel.UIEvent.ShowNoInternet -> {
                            val dialog = NoInternetDialogBuilder({
                                viewModel.postDb(viewModel.state.dbName)
                            })
                            dialog.show(parentFragmentManager, "")
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