package com.bits.bee.bpmc.presentation.dialog.pilih_kategori

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogPilihKategoriMerekBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PilihKategoriDialog(
    val title: String,
    var valueSelected: ItemGroup?,
    val onSaveClick: (Dialog, ItemGroup) -> Unit,
    val onAddClick: (Dialog, String) -> Unit,
    val onEditClick: (Dialog, ItemGroup) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogPilihKategoriMerekBinding = DialogPilihKategoriMerekBinding::inflate
): BaseBottomSheetDialogFragment<DialogPilihKategoriMerekBinding>() {

    private val viewModel : PilihKategoriViewModel by viewModels()

    private lateinit var rbPilihKategoriAdapter: RbPilihKategoriAdapter

    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
            rbPilihKategoriAdapter = RbPilihKategoriAdapter(mListener = object : RbPilihKategoriAdapter.EditKategoriAdapterI{
                override fun onClick(itemGrp: ItemGroup) {
                    onEditClick(dialog!!, itemGrp)
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
                onAddClick(dialog!!,title)
                dismiss()
            }
            btnTambah.setOnClickListener {
                onAddClick(dialog!!, title)
                dismiss()
            }
            btnSimpan.setOnClickListener {
                onSaveClick(dialog!!, rbPilihKategoriAdapter.getSelectedPosition())
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.grpList.collect {
                    rbPilihKategoriAdapter.submitList(it)
                    binding.apply {
                        imgEmpty.isVisible = it.isEmpty()
                        textDetail.isVisible = it.isEmpty()
                        btnTambah.isVisible = it.isEmpty()
                        btnTambahKategori.isVisible = it.isNotEmpty()
                        btnSimpan.isVisible = it.isNotEmpty()
                        textDetail.text = getString(R.string.kategori_blm_ada)
                    }
                }
                rbPilihKategoriAdapter.setSelected(valueSelected)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                binding.apply {

                }
            }
        }
    }
}