package com.bits.bee.bpmc.presentation.dialog.tipe_printer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogTipePrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListAdapter
import com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbAdapter
import com.bits.bee.bpmc.presentation.ui.setting_printer.SettingPrinterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TipePrinterDialog(
    val onSaveClick : (Any) -> Unit,
    val ctx: Context,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogTipePrinterBinding = DialogTipePrinterBinding::inflate
): BaseBottomSheetDialogFragment<DialogTipePrinterBinding>() {

    private var list: MutableList<ListTipe> = mutableListOf()
    private lateinit var tipeAdapter: TipePrinterAdapter
    private val viewModel : SettingPrinterViewModel by viewModels()

    override fun initComponents() {
        getTipe()
    }

    override fun subscribeListeners() {
        binding.apply {
            imgClose.setOnClickListener {
                dismiss()
            }
            tipeAdapter = TipePrinterAdapter(list, ctx, mListener = object :  TipePrinterAdapter.PilihTipePrinterAddapterI{
                override fun OnItemClick(position: Int) {
                    if (position == 0){
//                        val action = TipePrinterDialogDirections.actionTipePrinterDialogToListPrinterFragment()
//                        findNavController().navigate(action)
                        onSaveClick(list.get(position).label)
                        dismiss()
                    }else{
                        onSaveClick(list.get(position).label)
                        dismiss()
                    }
                }

            })
            recyclerViewTipe.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewTipe.adapter = tipeAdapter
        }
    }

    override fun subscribeObservers() {

    }

    fun getTipe(){
        list.add(ListTipe(R.drawable.bx_bluetooth, resources.getString(R.string.bluetooth_printer)))
        list.add(ListTipe(R.drawable.bx_wifi, resources.getString(R.string.network_printer)))
    }


}