package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahKategoriBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.SpinnerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TambahKategoriFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahKategoriBinding = FragmentTambahKategoriBinding::inflate
): BaseFragment<FragmentTambahKategoriBinding>() {

    private val viewModel: TambahUbahKategoriViewModel by viewModels()

    override fun initComponents() {
        setHasOptionsMenu(true)
        arguments?.let {
            val item = it.getString("itemKategori")
            item?.let {
                (activity as InitialActivity).supportActionBar?.title = getString(R.string.title_ubah_kategori)
                viewModel.state.isEdit = true
                viewModel.loadEditData(it)
            }

        } ?: run {

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
                    viewModel.state.subKategori = viewModel.state.kategoriList?.get(p2) ?: ""
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

            }

            btnSimpan.setOnClickListener {
                if (viewModel.state.namaKategori.isNotEmpty()){
                    viewModel.onSaveKategori(viewModel.state.namaKategori, viewModel.state.subKategori, viewModel.state.isEdit, viewModel.state.olId)   
                }else{
                    Toast.makeText(requireContext(), "Nama kategor i tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect{ event ->
                    when(event){
                        TambahUbahKategoriViewModel.UIEvent.FinishSaveDelete ->{
                            val action = TambahKategoriFragmentDirections.actionTambahKategoriFragmentToTambahProdukFragment()
                            findNavController().navigate(action)
                        }
                        TambahUbahKategoriViewModel.UIEvent.RequestDialog ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.hapus_kategori))
                                .setMessage(getString(R.string.confirm_hapus_kategori))
                                .setPositiveText(getString(R.string.batal))
                                .setNegativeText(getString(R.string.hapus))
                                .setPositiveCallback {
                                    it.dismiss()
                                }
                                .setNegativeCallback {
                                    requireActivity().actionBar?.displayOptions
                                    viewModel.onDeleteKategori()
                                }.build()
                            dialog.show(parentFragmentManager, TAG)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_ubah_produk, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opsi_delete -> viewModel.onShowDelete()
        }
        return super.onOptionsItemSelected(item)
    }
}