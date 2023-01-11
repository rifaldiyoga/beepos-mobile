package com.bits.bee.bpmc.presentation.dialog.pilih_merk

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogPilihKategoriMerekBinding
import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PilihMerekDialog(
    val title: String,
    var valueSelected: Brand?,
    val onSaveClick: (Brand) -> Unit,
    val onAddClick: (String) -> Unit,
    val onEditClick: (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogPilihKategoriMerekBinding = DialogPilihKategoriMerekBinding::inflate
): BaseBottomSheetDialogFragment<DialogPilihKategoriMerekBinding>() {

    private val viewModel : PilihMerekViewModel by viewModels()

    private lateinit var rbPilihMerkAdapter: RbPilihMerkAdapter

    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
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
                rbPilihMerkAdapter.getSelectedPosition()?.let {
                    onSaveClick(it)
                    dismiss()
                } ?: run {
                    Toast.makeText(requireActivity(), "Pilih merek terlebih dahulu!", Toast.LENGTH_LONG).show()
                }

            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.grpList.collect {
                binding.apply {
                    rbPilihMerkAdapter = RbPilihMerkAdapter(it.indexOf(valueSelected), it, object : RbPilihMerkAdapter.EditMerkAdapterI{
                        override fun onClick(pos: Int) {
                            onEditClick(it[pos].brandName)
                            dismiss()
                        }
                    })

                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = rbPilihMerkAdapter
                    }
                    imgEmpty.isVisible = it.isEmpty()
                    textDetail.isVisible = it.isEmpty()
                    textDetail.text = getString(R.string.merek_blm_ada)
                    btnTambah.isVisible = it.isEmpty()
                    btnTambahKategori.isVisible = it.isNotEmpty()
                    btnSimpan.isVisible = it.isNotEmpty()
                }
            }
        }
    }

}