package com.bits.bee.bpmc.presentation.dialog.edit_item

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogEditItemBinding
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 25/05/22.
 */
@AndroidEntryPoint
class EditItemDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogEditItemBinding = DialogEditItemBinding::inflate
) : BaseBottomSheetDialogFragment<DialogEditItemBinding>() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    private val viewModel : EditItemViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            val saled = bundle.getParcelable<Saled>("saled")
            saled?.let {
                viewModel.state.saled = saled
            }
        }
    }

    override fun initComponents() {
        binding.apply {
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect { state ->
                    state?.let {
                        binding.apply {
                            tvNamaItem.text = state.saled.name
                            etHarga.setText(CurrencyUtils.formatCurrency(state.saled.listPrice))
                            etDiskon.setText(state.saled.discExp)
                            etCatatan.setText(state.saled.dNotes)
                            etQty.setText(CurrencyUtils.formatCurrency(state.saled.qty))
                            tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(state.saled.qty))
                            tvSubtotal.text = getString(R.string.harga_produk ,CurrencyUtils.formatCurrency(state.saled.subtotal))
                        }
                    }
                }
            }
        }
    }

}