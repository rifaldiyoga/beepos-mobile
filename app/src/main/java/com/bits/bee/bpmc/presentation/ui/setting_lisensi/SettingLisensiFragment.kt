package com.bits.bee.bpmc.presentation.ui.setting_lisensi

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentHelpLisensiBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.presentation.ui.pilih_kasir.PilihKasirFragmentDirections
import com.bits.bee.bpmc.presentation.ui.pilih_kasir.PilihKasirViewModel
import com.bits.bee.bpmc.utils.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingLisensiFragment(
    override var bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHelpLisensiBinding = FragmentHelpLisensiBinding::inflate
): BaseFragment<FragmentHelpLisensiBinding>() {

    private val viewModel : SettingLisensiViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        viewModel.getLicense()
        viewModel.getCashier()
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
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.perhatian))
                                .setMessage(getString(R.string.anda_tidak_dapat_detach_belum_tutup_kasir))
                                .setNegativeCallback {

                                }.build()
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
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
                                R.string.page_login))
                            val action = SettingLisensiFragmentDirections.actionSettingLisensiFragmentToInitialActivity()
                            findNavController().navigate(action)
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
                                tVNamaPerangkat.text = Build.MANUFACTURER + " " + Build.MODEL
                                tVNamaDevice.text = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(
                                    R.string.pref_nama_device), "") as String
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

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        if (it.data.status_cashier){
                            viewModel.confirmDetachLicense()
                        }else{
                            Toast.makeText(requireContext(), "Gagal Proses Detach", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.observeDetachResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeDetachResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        if (it.data.status){
                            Toast.makeText(requireContext(), "Berhasil Detach", Toast.LENGTH_SHORT).show()
                            viewModel.onSuccesDetach()
                        }else{
                            Toast.makeText(requireContext(), "Proses Detach Lisensi Gagal\n" +
                                    "Silahkan Kontak Admin", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}