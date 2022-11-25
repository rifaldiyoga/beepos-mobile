package com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_merk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogPilihKategoriMerekBinding
import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment

class PilihMerekDialog(
    val title: String,
    val merkList: List<Brand> = mutableListOf(),
    var valueSelected: Brand?,
    val onSaveClick: (Brand) -> Unit,
    val onAddClick: (String) -> Unit,
    val onEditClick: (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogPilihKategoriMerekBinding = DialogPilihKategoriMerekBinding::inflate
): BaseBottomSheetDialogFragment<DialogPilihKategoriMerekBinding>() {

    private lateinit var rbPilihMerkAdapter: RbPilihMerkAdapter
    private var stringList = mutableListOf<String>()

    override fun initComponents() {
        parseBrand()
        binding.apply {
            tvTitle.text = title
            rbPilihMerkAdapter = RbPilihMerkAdapter(merkList.indexOf(valueSelected), stringList, object : RbPilihMerkAdapter.EditMerkAdapterI{
                override fun onClick(pos: Int) {
                    onEditClick(stringList[pos])
                    dismiss()
                }

            })

            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = rbPilihMerkAdapter
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
               onSaveClick(merkList[rbPilihMerkAdapter.getSelectedPosition()])
               dismiss()
           }
           imageView2.setOnClickListener {
               dismiss()
           }
       }
    }

    override fun subscribeObservers() {

    }

    private fun parseBrand(){
        for (brand in merkList!!){
            stringList.add(brand.brandName)
        }
    }

}