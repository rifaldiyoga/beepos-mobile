package com.bits.bee.bpmc.presentation.ui.setting_sistem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingSistemBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CloudDapurDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.radio_list.list.RadioListDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

const val TAG = "SettingSistemFragment"

@AndroidEntryPoint
class SettingSistemFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingSistemBinding = FragmentSettingSistemBinding::inflate
) : BaseFragment<FragmentSettingSistemBinding>() {
    private val viewModel : SettingSistemViewModel by viewModels()

    private lateinit var sistemPenyimpananList : List<String>
    private lateinit var sistemBatchUploadList : List<String>
    private lateinit var periodeUploadList : List<String>

    override fun initComponents() {
        sistemPenyimpananList = requireActivity().resources.getStringArray(R.array.list_sistem_penyimpanan).toList()
        sistemBatchUploadList = requireActivity().resources.getStringArray(R.array.list_sistem_batch_upload).toList()
        periodeUploadList = requireActivity().resources.getStringArray(R.array.list_periode_upload_otomatis).toList()
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                val sistem = viewModel.sistemPreferences.first()
                swcloudDapur.isChecked = sistem.isCloudDapur
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            clSistemPenyimpanan.setOnClickListener {
                viewModel.onClickSistemPenyimpanan()
            }
            clSistemBatch.setOnClickListener {
                viewModel.onClickSistemBatchUpload()
            }
            clPeriodeUpload.setOnClickListener {
                viewModel.onClickPeriodeUploadOtomatis()
            }
            helpIcon.setOnClickListener {
                viewModel.onClickAboutCloudDapur()
            }
            swcloudDapur.setOnCheckedChangeListener { _, b ->
                viewModel.onClickCloudDapur(b)
                viewModel.onClickAturPrinter()
            }
            clCloudDataDapur.setOnClickListener {
                swcloudDapur.isChecked = !swcloudDapur.isChecked
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when (event) {
                        SettingSistemViewModel.UIEvent.RequestSistemPenyimpanan -> {
                            val dialog = RadioListDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.sistem_penyimpanan))
                                .setList(sistemPenyimpananList)
                                .setValue(viewModel.state.sistemPenyimpanan)
                                .setOnSaveListener {
                                    viewModel.onSuccessSistemPenyimpanan(it.toString())
                                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG)
                                        .show()
                                }.build()

                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestSistemBatchUpload -> {
                            val dialog = RadioListDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.sistem_batch))
                                .setValue(viewModel.state.sistemBatchUpload)
                                .setList(sistemBatchUploadList)
                                .setOnSaveListener {
                                    viewModel.onSuccessSistemBatchUpload(it.toString())
                                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG)
                                        .show()
                                }.build()

                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestPeriodeUploadOtomatis -> {
                            val dialog = RadioListDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.periode_upload))
                                .setValue(viewModel.state.periodeUploadOtomatis)
                                .setList(periodeUploadList)
                                .setOnSaveListener {
                                    viewModel.onSuccessSistemUploadOtomatis(it.toString())
                                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG)
                                        .show()
                                }.build()

                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestAboutCloudDapur -> {
                            val dialog = CloudDapurDialogBuilder(getString(R.string.tentang_cloud), { data ->
                                Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                    .show()
                            })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestSettingPritner -> {
                            val dialog2 = DialogBuilderHelper.showDialogChoice(requireContext(), getString(R.string.data_dapur_diperbarui),
                                getString(R.string.apakah_anda_ingin_memberbarui_printer),
                                "Atur sekarang", {
                                    val action = SettingSistemFragmentDirections.actionSettingSistemFragmentToSettingPrinterFragment()
                                    findNavController().navigate(action)
                                    it.dismiss()
                                }, "Nanti", {
                                    it.dismiss()
                                })
                            dialog2.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sistemPreferences.collect {
                    viewModel.updateState(
                        viewModel.state.copy(
                            sistemPenyimpanan = it.penyimpanan,
                            sistemBatchUpload = it.batchUpload,
                            periodeUploadOtomatis = it.periodeUpload,
                            isCloudDapur = it.isCloudDapur
                        )
                    )
                    binding.apply {
                        swcloudDapur.isChecked = it.isCloudDapur
                        tvDetailPenyimpanan.text = it.penyimpanan
                        tvDetailBatch.text = it.batchUpload
                        tvDetailPeriode.text = it.periodeUpload
                    }
                }
            }
        }
    }
}