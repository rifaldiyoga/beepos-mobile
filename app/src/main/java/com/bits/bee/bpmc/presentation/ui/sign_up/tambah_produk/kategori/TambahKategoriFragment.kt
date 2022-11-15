package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentTambahKategoriBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.SpinnerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TambahKategoriFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahKategoriBinding = FragmentTambahKategoriBinding::inflate
): BaseFragment<FragmentTambahKategoriBinding>() {

    private val viewModel: TambahUbahKategoriViewModel by viewModels()

    override fun initComponents() {
        arguments?.let {
            val item = it.getString("itemKategori")
            item?.let {
                viewModel.state.isEdit = true
                viewModel.loadEditData(it)
            }

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNamaPrd.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        namaKategori = etNamaPrd.text.toString().trim()
                    )
                )
            }

//            cbSubKategori.setOnClickListener {
//                viewModel.state.useSubKategori = cbSubKategori.isChecked
//            }
            cbSubKategori.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    viewModel.updateState(
                        viewModel.state.copy(
                            useSubKategori = true
                        )
                    )
                    cbSubKategori.isChecked = true
                    lLKategori.visibility = View.VISIBLE
                    visibleSub()
                }else{
                    viewModel.updateState(
                        viewModel.state.copy(
                            useSubKategori = false
                        )
                    )
                    cbSubKategori.isChecked = false
                    lLKategori.visibility = View.GONE
                    visibleSub()
                }
            }

            spKategoriPrd.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.state.subKategori = viewModel.state.kategoriList?.get(p2) ?: "Kosong"
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }

            btnSimpan.setOnClickListener {
                viewModel.onSaveKategori(viewModel.state.namaKategori, viewModel.state.subKategori, viewModel.state.isEdit, viewModel.state.olId)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect{ event ->
                    when(event){
                        TambahUbahKategoriViewModel.UIEvent.FinishSave ->{
                            val action = TambahKategoriFragmentDirections.actionTambahKategoriFragmentToTambahProdukFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.itemgrp?.let { data ->
                                viewModel.state.olId = data.id!!
                                etNamaPrd.setText(data.name)
                                etNamaPrd.setSelection(etNamaPrd.text.length)
                                etNamaPrd.addTextChangedListener(object : TextWatcher{
                                    override fun beforeTextChanged(
                                        p0: CharSequence?,
                                        p1: Int,
                                        p2: Int,
                                        p3: Int
                                    ) {

                                    }

                                    override fun onTextChanged(
                                        p0: CharSequence?,
                                        p1: Int,
                                        p2: Int,
                                        p3: Int
                                    ) {
                                        etNamaPrd.removeTextChangedListener(this)
                                        data.name = p0.toString()
                                    }

                                    override fun afterTextChanged(p0: Editable?) {

                                    }

                                })
//                                if (it.upId == -1){
//
//                                }else{
//                                    viewModel.updateState(
//                                        viewModel.state.copy(
//                                            useSubKategori = true
//                                        )
//                                    )
//                                    cbSubKategori.isChecked = true
//                                    lLKategori.visibility = View.VISIBLE
//
//                                    visibleSub(it.upId)
//                                }
                            }

                        }
                    }
                }
            }
        }
    }

   private fun visibleSub(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.katPrdList?.let { data ->
                                if (viewModel.state.useSubKategori){
                                    viewModel.parseItemgrp(data)
                                }
                                it.kategoriList?.let {
                                    val subAdapter = SpinnerAdapter(requireContext(), it)
                                    spKategoriPrd.adapter = subAdapter
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}