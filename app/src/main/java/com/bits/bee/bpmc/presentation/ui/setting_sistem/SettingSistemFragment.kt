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
import com.bits.bee.bpmc.databinding.FragmentSettingPosBinding
import com.bits.bee.bpmc.databinding.FragmentSettingSistemBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CloudDapurDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder
import com.bits.bee.bpmc.presentation.ui.setting_pos.SettingPosViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.collectLifecycleFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
    private lateinit var cloudDataDapur : String

    private lateinit var sistemPenyimpanan: String
    private lateinit var batchUpload: String
    private lateinit var periodeUpload: String
    private var positionPenyimpanan: Int = 0
    private var positionBatchupload: Int = 0
    private var positionPeriodeUpload: Int = 0

    override fun initComponents() {
        sistemPenyimpananList = requireActivity().resources.getStringArray(R.array.list_sistem_penyimpanan).toList()
        sistemBatchUploadList = requireActivity().resources.getStringArray(R.array.list_sistem_batch_upload).toList()
        periodeUploadList = requireActivity().resources.getStringArray(R.array.list_periode_upload_otomatis).toList()
//        cloudDataDapur =
        binding.apply {
        }
    }

    fun iniliazePenyimpanan(): Int{
        sistemPenyimpanan = BeePreferenceManager.getDataFromPreferences(requireContext(),getString(
            R.string.pref_sistem_penyimpanan), "") as String
        if (sistemPenyimpanan.equals("7 Hari")){
            positionPenyimpanan = 0
        }else if (sistemPenyimpanan.equals("15 Hari")){
            positionPenyimpanan = 1
        }else if (sistemPenyimpanan.equals("30 Hari")){
            positionPenyimpanan = 2
        }
        return positionPenyimpanan
    }

    fun iniliazeBatch(): Int{
        batchUpload = BeePreferenceManager.getDataFromPreferences(requireContext(),getString(
            R.string.pref_batch_upload), "") as String
        if (batchUpload.equals("AUTO")){
            positionBatchupload = 0
        }else if(batchUpload.equals("5(Paling Ringan)")){
            positionBatchupload = 1
        }else if (batchUpload.equals("10")){
            positionBatchupload = 2
        }else if (batchUpload.equals("25")){
            positionBatchupload = 3
        }else if (batchUpload.equals("50(Paling Berat)")){
            positionBatchupload = 4
        }

        return positionBatchupload
    }

    fun iniliazePeriodeUpload(): Int{
        periodeUpload = BeePreferenceManager.getDataFromPreferences(requireContext(),getString(
            R.string.pref_periode_upload_otomatis), "") as String
        if (periodeUpload.equals("15 Menit")){
            positionPeriodeUpload = 0
        }else if (periodeUpload.equals("30 Menit")){
            positionPeriodeUpload = 1
        }else if (periodeUpload.equals("60 Menit")){
            positionPeriodeUpload = 2
        }
        return positionPeriodeUpload
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
            swcloudDapur.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_switch_dapur), true)
                }else{
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_switch_dapur), false)
                }
                viewModel.onClickAturPrinter()
            }
        }

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when (event) {
                        SettingSistemViewModel.UIEvent.RequestSistemPenyimpanan -> {
                            val dialog = RadioListDialogBuilder(
                                getString(R.string.sistem_penyimpanan),
                                sistemPenyimpananList,
                                iniliazePenyimpanan(),
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_sistem_penyimpanan
                                        ), data.toString()
                                    )
                                    viewModel.update(
                                        viewModel.state.copy(
                                            sistemPenyimpanan = data.toString()
                                        )
                                    )
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestSistemBatchUpload -> {
                            val dialog = RadioListDialogBuilder(
                                getString(R.string.sistem_batch),
                                sistemBatchUploadList,
                                iniliazeBatch(),
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_batch_upload
                                        ), data.toString()
                                    )
                                    viewModel.update(
                                        viewModel.state.copy(
                                            sistemBatchUpload = data.toString()
                                        )
                                    )
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestPeriodeUploadOtomatis -> {
                            val dialog = RadioListDialogBuilder(
                                getString(R.string.periode_upload),
                                periodeUploadList,
                                iniliazePeriodeUpload(),
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_periode_upload_otomatis
                                        ), data.toString()
                                    )
                                    viewModel.update(
                                        viewModel.state.copy(
                                            periodeUploadOtomatis = data.toString()
                                        )
                                    )
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestAboutCloudDapur -> {
                            val dialog = CloudDapurDialogBuilder(getString(R.string.tentang_cloud), { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_cloud_data_dapur
                                        ), data.toString()
                                    )
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingSistemViewModel.UIEvent.RequestSettingPritner -> {
//                            val dialog = CustomDialogBuilder.Builder(requireContext())
//                                .setTitle(getString(R.string.data_dapur_diperbarui))
//                                .setPositiveCallback {
//                                    val action = SettingSistemFragmentDirections.actionSettingSistemFragmentToSettingPrinterFragment()
//                                    findNavController().navigate(action)
//                                }
//                                .setNegativeCallback{
////                        dismis()
//                                }
//                                .setMessage(getString(R.string.apakah_anda_ingin_memberbarui_printer)).build()
//
//                            dialog.show(parentFragmentManager,
//                                com.bits.bee.bpmc.presentation.ui.nama_device.TAG
//                            )
                            val dialog2 = DialogBuilderUtils.showDialogChoice(requireContext(), getString(R.string.data_dapur_diperbarui),
                                getString(R.string.apakah_anda_ingin_memberbarui_printer),
                                "Atur sekarang", {
                                    val action = SettingSistemFragmentDirections.actionSettingSistemFragmentToSettingPrinterFragment()
                                    findNavController().navigate(action)
                                    return@showDialogChoice
                                }, "Nanti", {
                                    return@showDialogChoice
                                })
                            dialog2.show(parentFragmentManager,
                                com.bits.bee.bpmc.presentation.ui.nama_device.TAG
                            )
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        swcloudDapur.isChecked = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_switch_dapur), false) as Boolean
                        tvDetailPenyimpanan.text = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_sistem_penyimpanan), "") as String
                        tvDetailBatch.text = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_batch_upload), "" ) as String
                        tvDetailPeriode.text = BeePreferenceManager.getDataFromPreferences(requireContext(),getString(
                            R.string.pref_periode_upload_otomatis), "") as String
                    }
                }
            }
        }
//        viewLifecycleOwner.collectLifecycleFlow {
//            viewModel.state.collect {
//                binding.apply {
//                    swcloudDapur.isChecked = it.isCloudDapur
//
//                }
//            }
//        }
    }
}