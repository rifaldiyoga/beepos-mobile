package com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_kategori

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogPilihKategoriMerekBinding
import com.bits.bee.bpmc.domain.model.KategoriProduk
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PilihKategoriDialog(
    val title: String,
    val katPrdList: List<KategoriProduk>?,
    var valueSelected: String,
    val onSaveClick: (Any) -> Unit,
    val onAddClick: (String) -> Unit,
    val onEditClick: (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogPilihKategoriMerekBinding = DialogPilihKategoriMerekBinding::inflate
): BaseBottomSheetDialogFragment<DialogPilihKategoriMerekBinding>() {

    private lateinit var rbPilihKategoriAdapter: RbPilihKategoriAdapter
    private var stringList = mutableListOf<String>()

    override fun initComponents() {
        parseItemgrp()
        binding.apply {
            tvTitle.text = title
            rbPilihKategoriAdapter = RbPilihKategoriAdapter(stringList.indexOf(valueSelected), requireContext(), object : RbPilihKategoriAdapter.EditKategoriAdapterI{
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
                onAddClick(title)
                dismiss()
            }
            btnTambah.setOnClickListener {
                onAddClick(title)
                dismiss()
            }
            btnSimpan.setOnClickListener {
                onSaveClick(stringList[rbPilihKategoriAdapter.getSelectedPosition()])
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                binding.apply {
                    katPrdList?.let {
                        if (it.size > 0){
                            rbPilihKategoriAdapter.initList(it)
                        }else{
                            imgEmpty.visibility = View.VISIBLE
                            textDetail.visibility = View.VISIBLE
                            btnTambah.visibility = View.VISIBLE
                            btnTambahKategori.visibility = View.GONE
                            btnSimpan.visibility = View.GONE
                        }
                    }
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