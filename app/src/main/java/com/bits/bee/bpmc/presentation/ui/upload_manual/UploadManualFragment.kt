package com.bits.bee.bpmc.presentation.ui.upload_manual

import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentUploadManualBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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

    override fun initComponents() {
        setHasOptionsMenu(true)
        syncAdapter = SyncAdapter()
        binding.apply {
            rvSync.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = syncAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnUploadManual.setOnClickListener {
                CustomDialogBuilder.Builder(requireContext())
                    .setTitle(getString(R.string.konfirmasi))
                    .setMessage(getString(R.string.yakin_sync_manual))
                    .setPositiveCallback {
                        viewModel.manualUpload()
                    }
                    .setNegativeCallback {

                    }
            }
        }
    }

    override fun subscribeObservers() {
//        viewModel.observeBpReturn().removeObserver(viewLifecycleOwner)
        viewModel.observeBpReturn().observe(viewLifecycleOwner){
            it?.let {
                when (it.status) {
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        it.data?.let {
                            viewModel.checkBpCode(it)
                        }
                    }
                    Resource.Status.ERROR -> {

                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            viewModel.loadDataSync(BPMConstants.DEFAULT_DB_UPLOAD, lastPost)
                            it.listSync?.let {
                                if (it.isEmpty()){
                                    lLDoneSync.visibility = View.VISIBLE
                                    btnUploadManual.visibility = View.GONE
                                }else{
                                    lLDoneSync.visibility = View.GONE
                                    btnUploadManual.visibility = View.VISIBLE
                                }
                                syncAdapter.submitList(it)
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
        if (ConnectionUtils.checkInternet(requireContext())){
            mMenu!!.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_circle_green)
        }else{
            mMenu!!.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_circle_red)
            showDialog()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_cek_koneksi ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDialog(){
        val dialog = NoInternetDialogBuilder.Builder(requireContext())
            .setPositiveCallback {

            }.build()

        dialog.show(parentFragmentManager, TAG)
    }

}