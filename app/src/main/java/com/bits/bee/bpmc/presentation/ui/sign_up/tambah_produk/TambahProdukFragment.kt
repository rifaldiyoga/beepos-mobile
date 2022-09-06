package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahPrdBinding
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class TambahProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahPrdBinding = FragmentTambahPrdBinding::inflate
) : BaseFragment<FragmentTambahPrdBinding>() {

    private val viewModel : TambahProdukViewModel by viewModels()

    private lateinit var grpList : Array<String>
    private lateinit var tipeProdList : Array<String>
    private var tipeList = listOf("Barang Jadi (di stok)", "Jasa (tidak distok)")

    override fun initComponents() {
        grpList = resources.getStringArray(R.array.list_itgrp)
        tipeProdList = resources.getStringArray(R.array.list_tipe_produk)
        val mode = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_mode_tampilan), BPMConstants.MODE_FOOD_BEVERAGES)
        binding.apply {
            when(mode){
                BPMConstants.MODE_FOOD_BEVERAGES -> {
                    cvPid.gone()
                    groupSatuan.gone()

                    val adapterGrp = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, grpList)
                    spGrpPrd.adapter = adapterGrp
                    viewModel.state.kategoriProduk = grpList[0]
                }
                else -> {
                    cvPid.visible()
                    groupSatuan.visible()
                }
            }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, tipeList)
            spTipePrd.adapter = adapter
            viewModel.state.kategoriProduk = tipeProdList[0]

            arguments?.let {
                val item = it.getParcelable<ItemDummy>("itemDummy")
                val state = viewModel.state
                state.itemDummy = item
                item?.let {
                    state.nama = it.name
                    state.harga = it.price
                    state.satuan = it.unit
                    etNamaPrd.setText(it.name)
                    etHarga.setText(it.price)
                    etSatuan.setText(it.unit)
                    spTipePrd.setSelection(tipeProdList.indexOf(it.itemTypeCode))
                    spGrpPrd.setSelection(grpList.indexOf(it.itemGroup))
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNamaPrd.addTextChangedListener {
                viewModel.state.nama = etNamaPrd.text.toString().trim()
            }
            etHarga.addTextChangedListener {
                viewModel.state.harga = etHarga.text.toString().trim()
            }
            etSatuan.addTextChangedListener {
                viewModel.state.satuan = etSatuan.text.toString().trim()
            }
            spGrpPrd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.state.kategoriProduk = grpList[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
            spTipePrd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.state.tipeProduk = tipeProdList[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }
            btnLanjut.setOnClickListener {
                viewModel.onSubmit()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        TambahProdukViewModel.UIEvent.FinsihSubmit -> {
                            findNavController().popBackStack()
                        }
                    }
                }
            }
        }
    }
}