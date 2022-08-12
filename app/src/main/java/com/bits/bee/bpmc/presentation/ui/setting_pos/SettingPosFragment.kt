package com.bits.bee.bpmc.presentation.ui.setting_pos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingPosBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.collectLifecycleFlow
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * Created by aldi on 04/04/22.
 */
private const val TAG = "SettingPosFragment"

@AndroidEntryPoint
class SettingPosFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingPosBinding = FragmentSettingPosBinding::inflate
) : BaseFragment<FragmentSettingPosBinding>() {

    private val viewModel : SettingPosViewModel by viewModels()

    private lateinit var ukuranFontList : List<String>
    private lateinit var presetBukaKasirList : List<String>
    private lateinit var posisiOrientasiList : List<String>
    private lateinit var customerList : List<String>
    private lateinit var jumlahMejaList : List<String>

    override fun initComponents() {
        ukuranFontList = requireActivity().resources.getStringArray(R.array.list_ukuran_font).toList()
        presetBukaKasirList = requireActivity().resources.getStringArray(R.array.list_preset_buka_kasir).toList()
        posisiOrientasiList = requireActivity().resources.getStringArray(R.array.list_orientation).toList()
        customerList = requireActivity().resources.getStringArray(R.array.list_customer).toList()
        jumlahMejaList = requireActivity().resources.getStringArray(R.array.list_jumlah_meja).toList()
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            clUkuranFont.setOnClickListener {
                viewModel.onClickUkuranFont()
            }
            clCustomer.setOnClickListener {
                viewModel.onClickCustomer()
            }
            clJumlahMeja.setOnClickListener {
                viewModel.onClickJumlahMeja()
            }
            clPresetBukaKasir.setOnClickListener {
                viewModel.onClickPresetBukaKasir()
            }
            clOrientasi.setOnClickListener {
                viewModel.onClickPosisiOrientasi()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.collectLifecycleFlow {
            viewModel.event.collect { event ->
                when(event){
                    SettingPosViewModel.UIEvent.RequestCustomer -> {
                        val dialog = RadioListDialogBuilder(getString(R.string.customer), customerList,0, { data ->
                            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG).show()
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(
                                R.string.pref_customer), data.toString())
                        })
                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestJumlahMeja -> {
                        val dialog = RadioListDialogBuilder(getString(R.string.jumlah_meja), jumlahMejaList,0, { data ->
                            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG).show()
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(
                                R.string.pref_jumlah_meja), data.toString().toInt())
                        })
                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestPosisiOrientasi -> {
                        val dialog = RadioListDialogBuilder(getString(R.string.posisi_orientasi), posisiOrientasiList,0, { data ->
                            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG).show()
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(
                                R.string.pref_screen_orientation), data.toString())
                        })
                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestPresetBukaKasir -> {
                        val dialog = RadioListDialogBuilder(getString(R.string.preset_buka_kasir), presetBukaKasirList,0, { data ->
                            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG).show()
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(
                                R.string.pref_preset_buka_kasir), data.toString())
                        })
                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestUkuranFont -> {
                        val dialog = RadioListDialogBuilder(getString(R.string.ukuran_font), ukuranFontList, 0,{ data ->
                            Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG).show()
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(
                                R.string.pref_ukuran_font), data.toString())
                        })
                        dialog.show(parentFragmentManager, TAG)
                    }
                }
            }
        }
        viewLifecycleOwner.collectLifecycleFlow {
            viewModel.state.collect {
                binding.apply {
                    swKonfirmasiCust.isChecked = it.isKonfirmasiCustomer
                    swMuatGambarProduk.isChecked = it.isMuatGambarProduk
                    swMultiLine.isChecked = it.isMultiFont
                }
            }
        }
    }
}