package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.kategori

import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahKategoriBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.TambahProdukViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TambahKategoriFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahKategoriBinding = FragmentTambahKategoriBinding::inflate
): BaseFragment<FragmentTambahKategoriBinding>() {

    private val viewModel: TambahUbahKategoriViewModel by viewModels()
    private val shareViewmodel: TambahProdukViewModel by activityViewModels()

    override fun initComponents() {
        setHasOptionsMenu(true)
        arguments?.let {
            val item = it.getParcelable<ItemGroup>("itemGrp")
            item?.let {
                (activity as InitialActivity).supportActionBar?.title = getString(R.string.title_ubah_kategori)
                viewModel.state.isEdit = true
                 viewModel.loadEditData(it)
                binding.apply {
                    viewModel.state.olId = it.id!!
                    etNamaPrd.setText(it.name)
                    cbSubKategori.isChecked = it.upId != null
                }
            }

        }
        viewModel.loadItemgrp()
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
            cbSubKategori.setOnCheckedChangeListener { _, b ->
                viewModel.onChangeSubKategori(b)
            }

            actSubKategori.onItemClickListener = AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                viewModel.state.subKategori = viewModel.state.itemGroupList[p2].name
            }

            btnSimpan.setOnClickListener {
                viewModel.validateNama()
                if (viewModel.state.namaKategori.isNotEmpty()){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_default_kategori), false)
                    viewModel.onSaveKategori()
                }
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collect {
                showSnackbar(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        TambahUbahKategoriViewModel.UIEvent.FinishSaveDelete ->{
                            findNavController().popBackStack()
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
                                    shareViewmodel.updateState(
                                        shareViewmodel.state.copy(
                                            itemGrp = null
                                        )
                                    )
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
                viewModel.viewStates().collect { state ->
                    state?.let {
                        binding.apply {
                            lLKategori.isVisible = it.useSubKategori
                            val subAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, it.itemGroupList.map { it.name })
                            actSubKategori.setAdapter(subAdapter)
                            actSubKategori.setText(viewModel.state.subKategori, false)
                            tilNama.error = it.msgNama
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.modePreferences.collect {
                    binding.apply {
                        when(it){
                            PosModeState.FnBState -> {
                                etNamaPrd.hint = getString(R.string.cth_jus)
                            }
                            PosModeState.RetailState -> {
                                etNamaPrd.hint = getString(R.string.cth_sepatu)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        arguments?.let {
            val item = it.getParcelable<ItemGroup>("itemGrp")
            item?.let {
                inflater.inflate(R.menu.menu_void, menu)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_void -> viewModel.onShowDelete()
        }
        return super.onOptionsItemSelected(item)
    }
}