package com.bits.bee.bpmc.presentation.ui.upload_manual

import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.databinding.FragmentUploadManualBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.error_dialog.ErrorDialogBuilder
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.decideOnState
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class UploadManualFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUploadManualBinding = FragmentUploadManualBinding::inflate
) : BaseFragment<FragmentUploadManualBinding>() {

    private val viewModel: UploadManualViewModel by viewModels()
    private lateinit var syncAdapter: SyncAdapter
    private var lastPost: Long = 0
    private var mMenu: Menu? = null
    private lateinit var loadingDialog : LoadingDialogHelper

    override fun initComponents() {
        setHasOptionsMenu(true)
        loadingDialog = LoadingDialogHelper(requireContext())
        binding.apply {
            syncAdapter = SyncAdapter()
            syncAdapter.addLoadStateListener { loadState ->
                loadState.decideOnState(
                    syncAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
                    showLoading = {
                    },
                    showEmptyState = { isVisible ->
                        binding.lLDoneSync.isVisible = isVisible
                        binding.btnUploadManual.isVisible = !isVisible
                    },
                    showError = { it ->
                        showSnackbar(it)
                    }
                )
            }
            rvSync.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = syncAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnUploadManual.setOnClickListener {
                viewModel.onClickUpload()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.syncList.collectLatest {
                    syncAdapter.submitData(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when(event){
                        UploadManualViewModel.UIEvent.RequeatDialog ->{
                            val dialog = NoInternetDialogBuilder({
                                viewModel.onClickUpload()
                            })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        UploadManualViewModel.UIEvent.RequestUpload ->{
                        }
                    }
                }
            }
        }

        viewModel.observeBpReturn().removeObservers(viewLifecycleOwner)
        viewModel.observeBpReturn().observe(viewLifecycleOwner){
            it?.let {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        loadingDialog.show("", "Mohon tunggu sebentar..")
                    }
                    Resource.Status.SUCCESS -> {
                        loadingDialog.hide()
                        it.data?.let {
                            viewModel.checkBpCode(it)
                        }
                    }
                    Resource.Status.ERROR -> {
                        loadingDialog.hide()
                        DialogBuilderHelper.showDialogInfo(requireActivity(), "Error", it.message ?: "", "OK"){
                            it.dismiss()
                        }.show(parentFragmentManager, TAG)
                    }
                    Resource.Status.NOINTERNET -> {
                        loadingDialog.hide()
                        viewModel.showDialogNoInternet()
                    }
                }
            }
        }

        viewModel.observePostAllReturn().removeObservers(viewLifecycleOwner)
        viewModel.observePostAllReturn().observe(viewLifecycleOwner){
            it?.let {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        loadingDialog.show("", "Mohon tunggu sebentar..")
                    }
                    Resource.Status.SUCCESS -> {
                        loadingDialog.hide()
                        it.data?.let {
                            val string = it.string()
                            try {
                                val postAllReturn = Gson().fromJson(string, PostAllReturn::class.java)
                                if (postAllReturn.status){
                                    viewModel.prosesResponsePostAll()
                                    DialogBuilderHelper.showDialogInfo(requireActivity(), "Info", "Upload data sukses!", "OK"){
                                        it.dismiss()
                                    }.show(parentFragmentManager, "")
                                } else {
//                                    Toast.makeText(requireContext(), it.data, Toast.LENGTH_SHORT).show()
                                }
                            } catch (e : Exception){
                                val dialog = ErrorDialogBuilder(string, e)
                                dialog.show(parentFragmentManager, "")
                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        loadingDialog.hide()
                        val dialog = ErrorDialogBuilder(it.message ?: "", )
                        dialog.show(parentFragmentManager, "")
                    }
                    Resource.Status.NOINTERNET -> {
                        loadingDialog.hide()
                        viewModel.showDialogNoInternet()
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_cek_koneksi, menu)
        this.mMenu = menu
        if (ConnectionUtils.checkInternet(requireContext())){
            mMenu!!.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_circle_green)
        }else{
            mMenu!!.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_circle_red)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_cek_koneksi ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }

}