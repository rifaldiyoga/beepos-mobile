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
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentUploadManualBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.error_dialog.ErrorDialogBuilder
import com.bits.bee.bpmc.presentation.service.UploadWorker
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.extension.decideOnState
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
                            val worker = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
                            WorkManager.getInstance(requireActivity()).enqueue(worker)
                            WorkManager.getInstance(requireActivity()).getWorkInfoByIdLiveData(worker.id).observe(viewLifecycleOwner){ workInfo ->
                                when(workInfo.state){
                                    WorkInfo.State.ENQUEUED, WorkInfo.State.RUNNING -> {
                                        loadingDialog.show("", "Mohon tunggu sebentar..")
                                    }
                                    WorkInfo.State.SUCCEEDED -> {
                                        loadingDialog.hide()
                                        DialogBuilderHelper.showDialogInfo(requireActivity(), "Info", "Upload data sukses!", "OK"){
                                            it.dismiss()
                                        }.show(parentFragmentManager, "")
                                    }
                                    WorkInfo.State.FAILED -> {
                                        loadingDialog.hide()
                                        val error = workInfo.outputData.getString("error")
                                        if(error != "No Internet") {
                                            val dialog = ErrorDialogBuilder(error ?: "")
                                            dialog.show(parentFragmentManager, "")
                                        } else {
                                            viewModel.showDialogNoInternet()
                                        }
                                    }
                                    else -> {
                                        loadingDialog.hide()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_cek_koneksi, menu)
        this.mMenu = menu
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mMenu?.let {
                if (ConnectionUtils.checkInternet(requireContext())){
                    it.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_circle_green)
                }else{
                    it.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_circle_red)
                }
            }
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