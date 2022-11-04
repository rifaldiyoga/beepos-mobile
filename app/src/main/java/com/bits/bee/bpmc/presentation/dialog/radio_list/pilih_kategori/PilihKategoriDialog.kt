package com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_kategori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogPilihKategoriBinding
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PilihKategoriDialog(
    val title : String,
    val katPrdList: List<KategoriProduk>?,
    var posSelected: Int,
    val onSaveClick : (Any) -> Unit,
    val onAddClick : (String) -> Unit,
    val onEditClick : (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogPilihKategoriBinding = DialogPilihKategoriBinding::inflate
): BaseBottomSheetDialogFragment<DialogPilihKategoriBinding>() {

    private lateinit var rbPilihKategoriAdapter: RbPilihKategoriAdapter
    private var stringList = mutableListOf<String>()

    override fun initComponents() {
        parseItemgrp()
        binding.apply {
            tvTitle.text = title
            rbPilihKategoriAdapter = RbPilihKategoriAdapter(posSelected, requireContext(), object : RbPilihKategoriAdapter.EditKategoriAdapterI{
                override fun onClick(pos: Int) {
                    onEditClick(stringList[pos])
                    dismiss()
                }

            })
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rbPilihKategoriAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTambahKategori.setOnClickListener {
                val action = "TambahKategori"
                onAddClick(action)
                dismiss()
            }
            btnSimpan.setOnClickListener {
                onSaveClick(stringList[rbPilihKategoriAdapter.getSelectedPosition()])
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                katPrdList?.let {
                    rbPilihKategoriAdapter.initList(it)
                }
            }
        }
    }

    private fun parseItemgrp(){
        for (igrp in katPrdList!!){
            stringList.add(igrp.name)
        }
    }

}