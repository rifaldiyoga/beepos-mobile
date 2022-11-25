package com.bits.bee.bpmc.presentation.ui.setting_lisensi

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.BuildConfig
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentHelpLisensiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingLisensiFragment(
    override var bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHelpLisensiBinding = FragmentHelpLisensiBinding::inflate
): BaseFragment<FragmentHelpLisensiBinding>() {

    private val viewModel : SettingLisensiViewModel by viewModels()

    private lateinit var loadingDialogHelper : LoadingDialogHelper

    override fun initComponents() {
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
                viewModel.lepasLisensi()
            }
            btnPerpanjangLisensi.setOnClickListener {
                viewModel.perpanjangLisensi()
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
                                    viewModel.manualSync()
                                }.build()
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingLisensiViewModel.UIEvent.ConfirmDetachLicense ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.informasi))
                                .setMessage(getString(R.string.proses_detach_akan_menghapus_seluruh_data))
                                .setPositiveCallback {
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
                                tVSerialLisensi.text = it.licNumber
                                tvTglBerakhir.text = DateFormatUtils.formatDateToString(BPMConstants.NEW_DATE_FORMAT, it.licExp)
//                                Settings.Secure.getString(
//                                    getApplicationContext().getContentResolver(),
//                                    Settings.Secure.ANDROID_ID
//                                ) + "-" + Build.SERIAL
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
//                            viewModel.confirmDetachLicense()
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
    }
}