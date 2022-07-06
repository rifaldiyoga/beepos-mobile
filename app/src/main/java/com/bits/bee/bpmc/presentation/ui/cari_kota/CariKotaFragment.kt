package com.bits.bee.bpmc.presentation.ui.cari_kota

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCariKotaBinding
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/05/22.
 */
@AndroidEntryPoint
class CariKotaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCariKotaBinding = FragmentCariKotaBinding::inflate
) : BaseFragment<FragmentCariKotaBinding>() {

    private val viewModel : CariKotaViewModel by viewModels()
    private var mDistrict: District? = null

    private lateinit var cityAdapterRekomendasi : RekomendasiKotaAdapter
    private lateinit var cityAdapterSearch : CariKotaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (!it.getString("district").equals("null") && it.getString("district")?.isNotEmpty() == true){
                mDistrict = Gson().fromJson(it.getString("district"), District::class.java)
                viewModel.updateState(
                    viewModel.state.copy(
                        district = mDistrict
                    )
                )
            }
        }
    }

    override fun initComponents() {
        binding.apply {
            cityAdapterRekomendasi = RekomendasiKotaAdapter(mListener = object : RekomendasiKotaAdapter.PilihKotaPopulerI{
                override fun onItemClick(city: CityPopuler) {
                    val action = CariKotaFragmentDirections.actionCariKotaFragmentToCariKecamatanFragment(
                        Gson().toJson(city))
                    findNavController().navigate(action)
                }

            })
            cityAdapterSearch = CariKotaAdapter(mListener = object : CariKotaAdapter.PilihKotaI{
                override fun onItemClick(city: City) {
                    viewModel.updateState(
                        viewModel.state.copy(
                            etKota = city.name
                        )
                    )
                }

            })
            rvRekomendasi.apply {
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                adapter = cityAdapterRekomendasi
            }
//            rvCari.apply {
//                layoutManager = LinearLayoutManager(requireActivity())
//                adapter = cityAdapterSearch
//            }

//            val autotextView = requireView().findViewById<AutoCompleteTextView>(R.id.ac_txtView)

        }
    }

    override fun subscribeListeners() {
        binding.apply {
//            etCari.addTextChangedListener {
//                viewModel.onSearch(etCari.text.toString().trim())
//            }
            acSearch.addTextChangedListener {
//                viewModel.state.cari = acSearch.text.toString().trim()
                viewModel.onSearch(acSearch.text.toString().trim())
            }

            btnsimpanCity.setOnClickListener {
                val str = acSearch.text.toString()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_city), str)
                if (str.isEmpty()){
                    showToast(R.string.city_kosong)
                }else{
                    viewModel.saveValidate()
                }
//                doSave()
//                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        CariKotaViewModel.UIEvent.SuccesSaveCity ->{
                            findNavController().popBackStack()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
//                viewModel.cityList.collect {
//                    cityAdapterSearch.submitList(it)
//                }
                viewModel.cityPopuler.collect {
                    cityAdapterRekomendasi.submitList(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            if(it.cari.length >= 3){
                                groupRekomendasi.gone()
//                                rvCari.visible()
                                viewModel.searchCity()
//                                viewModel.onGetList(it.cityListCari)
                                it.nameList?.let {
                                    if (viewModel.state.nameList!!.size == 0){
                                        binding.lLCityEmpty.visibility = View.VISIBLE
                                    }else{
                                        binding.apply {
                                            val adapter
                                                    = ArrayAdapter(
                                                requireContext(),
                                                android.R.layout.simple_list_item_1,viewModel.state.nameList!!
                                            )
                                            acSearch.setAdapter(adapter)
                                        }
                                    }
                                }
                            } else {
                                groupRekomendasi.visible()
                                lLCityEmpty.gone()
//                                rvCari.gone()
                            }
//                            cityAdapterSearch.submitList(it.cityListCari)
//                            if(it.cityListCari.size == 0 ){
//                                lLCityEmpty.visibility = View.VISIBLE
//                            }else{
//                                lLCityEmpty.visibility = View.GONE
//                            }
//                            it.etKota?.let {
//                                etCari.setText(it.trim())
//                                etCari.editableText
//                                rvCari.gone()
//                            }
                            it.district?.let {
//                                rvCari.gone()
                                lLCityEmpty.gone()
                                acSearch.setText(it.name)
                            }
                        }
                    }
                }
            }
        }
    }


    private fun doSave(){


//        viewModel.saveValidate(str)
//        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_is_city), true)
    }



}