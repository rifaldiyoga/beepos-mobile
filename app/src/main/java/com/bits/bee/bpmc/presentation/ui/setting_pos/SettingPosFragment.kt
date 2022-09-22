package com.bits.bee.bpmc.presentation.ui.setting_pos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingPosBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.orientasi.OrientasiDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
            swMultiLine.setOnCheckedChangeListener { _, b ->
                viewModel.onClickMultiLine(b)
            }
            clMultiLine.setOnClickListener {
                swMultiLine.isChecked = !swMultiLine.isChecked
            }
            swKonfirmasiCust.setOnCheckedChangeListener { _, b ->
                viewModel.onClickKonfirmasiCust(b)
            }
            clKonfirmasiCustomer.setOnClickListener {
                swKonfirmasiCust.isChecked = !swKonfirmasiCust.isChecked
            }
            swMuatGambarProduk.setOnCheckedChangeListener { _, b ->
                viewModel.onClickMuatGambar(b)
            }
            clMuatGambarProduk.setOnClickListener {
                swMuatGambarProduk.isChecked = !swMuatGambarProduk.isChecked
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.posPreferences.collect {
                viewModel.updateState(
                    viewModel.state.copy(
                        ukuranFont = it.ukuranFont,
                        isMultiLine = it.isMultiLine,
                        isKonfirmasiCustomer = it.isKonfirmasiCust,
                        customer = it.customer,
                        jumlahMeja = it.jumlahMeja,
                        presetBukaKasir = it.presetBukaKasir,
                        isMuatGambar = it.isMuatGambar,
                        orientation = it.orientasi
                    )
                )
                binding.apply {
                    tvDetailUkuranFont.text = it.ukuranFont
                    tvDetailJumlahMeja.text = it.jumlahMeja
                    tvDetailCustomer.text = it.customer
                    tvDetailPresetBukaKasir.text = it.presetBukaKasir

                    swKonfirmasiCust.isChecked = it.isKonfirmasiCust
                    setVisibilityKonfirmasiCust(it.isKonfirmasiCust)

                    swMultiLine.isChecked = it.isMultiLine

                    swMuatGambarProduk.isChecked = it.isMuatGambar

                    swMultiLine.isChecked = it.isMultiLine

                    tvDetailOrientasi.text = it.orientasi
                }

            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect { event ->
                when(event){
                    SettingPosViewModel.UIEvent.RequestCustomer -> {
                        val dialog = RadioListDialogBuilder.Builder(requireActivity())
                            .setTitle(getString(R.string.customer))
                            .setList(customerList)
                            .setValue(viewModel.state.customer)
                            .setOnSaveListener {
                                viewModel.onSuccessCustomer(it.toString())
                                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                            }.build()

                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestJumlahMeja -> {
                        val dialog = RadioListDialogBuilder.Builder(requireActivity())
                            .setTitle(getString(R.string.jumlah_meja))
                            .setList(jumlahMejaList)
                            .setValue(viewModel.state.jumlahMeja)
                            .setOnSaveListener {
                                viewModel.onSuccessJumlahMeja(it.toString())
                                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()

                            }.build()

                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestPosisiOrientasi -> {
                        val orientasi = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.posisi_orientasi), BPMConstants.SCREEN_POTRAIT) as String
                        val dialog = OrientasiDialogBuilder(orientasi, onFinish = {
                            viewModel.onSuccessOrientasi(it)
                            requireActivity().finish()
                            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                        })

                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestPresetBukaKasir -> {
                        val dialog = RadioListDialogBuilder.Builder(requireActivity())
                            .setTitle(getString(R.string.preset_buka_kasir))
                            .setList(presetBukaKasirList)
                            .setValue(viewModel.state.presetBukaKasir)
                            .setOnSaveListener {
                                viewModel.onSuccessPresetBukaKasir(it.toString())
                                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                            }.build()

                        dialog.show(parentFragmentManager, TAG)
                    }
                    SettingPosViewModel.UIEvent.RequestUkuranFont -> {
                        val dialog = RadioListDialogBuilder.Builder(requireActivity())
                            .setTitle(getString(R.string.ukuran_font))
                            .setList(ukuranFontList)
                            .setValue(viewModel.state.ukuranFont)
                            .setOnSaveListener {
                                viewModel.onSuccessUkuranFont(it.toString())
                                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                            }.build()

                        dialog.show(parentFragmentManager, TAG)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collect {
                binding.apply {
                    it?.let {

                    }
                }
            }
        }
    }

    fun setVisibilityKonfirmasiCust(isKonfirmasi : Boolean){
        binding.apply {
            clCustomer.isVisible = isKonfirmasi
            vCustomer.isVisible = isKonfirmasi
            clJumlahMeja.isVisible = isKonfirmasi
            vJumlahMeja.isVisible = isKonfirmasi
        }
    }
}