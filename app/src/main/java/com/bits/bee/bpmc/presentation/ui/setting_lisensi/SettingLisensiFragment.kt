package com.bits.bee.bpmc.presentation.ui.setting_lisensi

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.bits.bee.bpmc.BuildConfig
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.response.PostAllReturn
import com.bits.bee.bpmc.databinding.FragmentHelpLisensiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.error_dialog.ErrorDialogBuilder
import com.bits.bee.bpmc.presentation.service.UploadWorker
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.presentation.ui.upload_manual.UploadManualViewModel
import com.bits.bee.bpmc.utils.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class SettingLisensiFragment(
    override var bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHelpLisensiBinding = FragmentHelpLisensiBinding::inflate
): BaseFragment<FragmentHelpLisensiBinding>() {

    private val viewModel : SettingLisensiViewModel by viewModels()

    private val sharedViewModel: UploadManualViewModel by viewModels()

    private lateinit var loadingDialogHelper : LoadingDialogHelper

    override fun initComponents() {
        setToolbarTitle(getString(R.string.lisensi_saya))
        loadingDialogHelper = LoadingDialogHelper(requireActivity())
        viewModel.getLicense()
        viewModel.getCashier()
        binding.apply {
            tvVersiBpm.text = BuildConfig.VERSION_NAME

            tVNamaPerangkat.text = Build.MANUFACTURER + " " + Build.MODEL
            tVNamaDevice.text = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(
                R.string.pref_nama_device), "") as String
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnLepasLisensi.setOnClickListener {
                viewModel.doLepasLisensi()
            }
            btnPerpanjangLisensi.setOnClickListener {
                viewModel.doPerpanjangLisensi()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        SettingLisensiViewModel.UIEvent.RequestInfoTutupKasir -> {
                            val dialog = DialogBuilderHelper.showDialogInfo(requireContext(), getString(R.string.perhatian),
                                getString(R.string.anda_tidak_dapat_detach_belum_tutup_kasir), positiveListener = {
                                    it.dismiss()
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingLisensiViewModel.UIEvent.RequestSyncData ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.perhatian))
                                .setMessage(getString(R.string.anda_tidak_dapat_detach_belum_sync))
                                .setPositiveCallback {
                                    it.dismiss()
                                    sharedViewModel.onClickUpload()
                                }.build()
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingLisensiViewModel.UIEvent.ConfirmDetachLicense ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.informasi))
                                .setMessage(getString(R.string.proses_detach_akan_menghapus_seluruh_data))
                                .setPositiveCallback {
                                    it.dismiss()
                                    viewModel.detachLicense()
                                }.build()
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingLisensiViewModel.UIEvent.NavigateToLogin ->{
                            BeePreferenceManager.clearAllPreferences(requireActivity())
                            viewModel.clearDataStore()
                            Utils.deleteApplicationData(requireActivity())
                            requireActivity().finish()
                        }
                        SettingLisensiViewModel.UIEvent.RequestPerpanjang -> {
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://my.beecloud.id/")))
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.lisensi?.let {
                                tvNamaDb.text = it.name
                                tvJenisLisensi.text = it.item
                                tvNoLisensi.text = it.licNumber
                                tvTglBerakhir.text = DateFormatUtils.formatDateToString(BPMConstants.NEW_DATE_FORMAT, it.licExp ?: Date())
                                tVSerialLisensi.text = Settings.Secure.getString(
                                    requireActivity().contentResolver,
                                    Settings.Secure.ANDROID_ID
                                ) + "-" + Build.SERIAL
                            }
                        }
                    }
                }
            }
        }

        viewModel.observeCashierStatusResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeCashierStatusResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    loadingDialogHelper.show(message = "Proses detach kasir ..")
                }
                Resource.Status.SUCCESS -> {
                    loadingDialogHelper.hide()
                    it.data?.let {
                        if (it.data.status_cashier){
                            viewModel.detachLicense()
                        }else{
                            Toast.makeText(requireContext(), "Gagal Proses Detach", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    loadingDialogHelper.hide()
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.NOINTERNET -> TODO()
            }
        }

        viewModel.observeDetachResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeDetachResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    loadingDialogHelper.show(message = "Proses detach lisensi ..")
                }
                Resource.Status.SUCCESS -> {
                    loadingDialogHelper.hide()
                    it.data?.let {
                        if (it.data.status){
                            Toast.makeText(requireContext(), "Berhasil Detach", Toast.LENGTH_SHORT).show()
                            viewModel.onSuccesDetach()
                        }else{
                            viewModel.onSuccesDetach()
                            Toast.makeText(requireContext(), "Proses Detach Lisensi Gagal\n" +
                                    "Silahkan Kontak Admin", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    loadingDialogHelper.hide()
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.NOINTERNET -> TODO()
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.event.collect { event ->
                    when(event){
                        UploadManualViewModel.UIEvent.RequeatDialog ->{
                            val dialog = NoInternetDialogBuilder({
                                sharedViewModel.onClickUpload()
                            })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        UploadManualViewModel.UIEvent.RequestUpload ->{
                            val worker = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
                            WorkManager.getInstance(requireActivity()).enqueue(worker)
                            WorkManager.getInstance(requireActivity()).getWorkInfoByIdLiveData(worker.id).observe(viewLifecycleOwner){ workInfo ->
                                when(workInfo.state){
                                    WorkInfo.State.ENQUEUED, WorkInfo.State.RUNNING -> {
                                        loadingDialogHelper.show("", "Mohon tunggu sebentar..")
                                    }
                                    WorkInfo.State.SUCCEEDED -> {
                                        loadingDialogHelper.hide()
                                        DialogBuilderHelper.showDialogInfo(requireActivity(), "Info", "Upload data sukses!", "OK"){
                                            it.dismiss()
                                            viewModel.doLepasLisensi()
                                        }.show(parentFragmentManager, "")
                                    }
                                    WorkInfo.State.FAILED -> {
                                        loadingDialogHelper.hide()
                                        val error = workInfo.outputData.getString("error")
                                        if(error != "No Internet") {
                                            val dialog = ErrorDialogBuilder(error ?: "")
                                            dialog.show(parentFragmentManager, "")
                                        } else {
                                            sharedViewModel.showDialogNoInternet()
                                        }
                                    }
                                    else -> {
                                        loadingDialogHelper.hide()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}