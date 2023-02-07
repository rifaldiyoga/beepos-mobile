package com.bits.bee.bpmc.presentation.dialog.orientasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogRadioListBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first

/**
 * Created by aldi on 05/04/22.
 */
@AndroidEntryPoint
class OrientasiDialogBuilder(
    private val value : String,
    private val onFinish : (String) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListBinding = DialogRadioListBinding::inflate
) : BaseBottomSheetDialogFragment<DialogRadioListBinding>() {

    private val viewModel : OrientasiViewModel by viewModels()

    private lateinit var radioAdapter: OrientasiAdapter

    private var orientasiList = mutableListOf<String>()

    override fun initComponents() {
        binding.apply {
            tvTitle.text = getString(R.string.posisi_orientasi)
            orientasiList = resources.getStringArray(R.array.list_orientation).toMutableList()
            radioAdapter = OrientasiAdapter(orientasiList, orientasiList.indexOf(value))
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = radioAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                radioAdapter.getSelectedPosition()?.let { selectedPos ->
                    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                        val mode = viewModel.modePreferences.first()
                        if(mode == PosModeState.RetailState && selectedPos == 1){
                            val dialog = DialogBuilderHelper.showDialogInfo(requireActivity(), "Tampilan Landscape Belum Tersedia",
                                "Saat ini mode retail belum mendukung tampilan landscape. Tunggu update berikutnya, ya!",
                                "Mengerti"
                            ) {
                                it.dismiss()
                            }
                            dialog.show(parentFragmentManager, "")
                        } else {
                            onFinish(orientasiList[selectedPos])
                            dismiss()
                        }
                    }
                }
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {

    }

}