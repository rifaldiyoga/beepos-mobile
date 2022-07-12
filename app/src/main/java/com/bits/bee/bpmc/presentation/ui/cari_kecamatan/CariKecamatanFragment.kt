package com.bits.bee.bpmc.presentation.ui.cari_kecamatan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCariKecamatanBinding
import com.bits.bee.bpmc.databinding.FragmentCariKotaBinding
import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaAdapter
import com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer.AddPrinterViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CariKecamatanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCariKecamatanBinding = FragmentCariKecamatanBinding::inflate
): BaseFragment<FragmentCariKecamatanBinding>() {
    private val viewModel : CariKecamatanViewModel by viewModels()
    private var mCity: CityPopuler? = null
    private lateinit var kecamatanAdapter: KecamatanAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (!it.getString("regency").equals("null") && it.getString("regency")?.isNotEmpty() == true){
                mCity = Gson().fromJson(it.getString("regency"), CityPopuler::class.java)
            }
            viewModel.updateState(
                viewModel.state.copy(
                    cityPopuler = mCity
                )
            )
        }
        viewModel.getDistrictByCode()
    }

    override fun initComponents() {
        binding.apply {
            kecamatanAdapter = KecamatanAdapter(mListener = object : KecamatanAdapter.PilihKecamatanI{
                override fun onItemClick(district: District) {
                    val action = CariKecamatanFragmentDirections.actionCariKecamatanFragmentToTambahMemberFragment(Gson().toJson(district))
                    clearPref()
                    findNavController().navigate(action)
                }

            })
            rvKecamatan.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = kecamatanAdapter
            }
        }

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.listDistrict?.let {
                                kecamatanAdapter.submitList(it)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun clearPref(){
        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()
        sharedPreferences.remove(getString(R.string.pref_city))
        sharedPreferences.commit()
    }

}