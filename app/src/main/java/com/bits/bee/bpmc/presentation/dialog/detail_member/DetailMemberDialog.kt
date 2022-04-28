package com.bits.bee.bpmc.presentation.dialog.detail_member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.DialogDetailMemberBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
class DetailMemberDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDetailMemberBinding = DialogDetailMemberBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDetailMemberBinding>() {

    private val viewModel : DetailMemberViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val bp = it.getParcelable<Bp>("member")
            bp?.let {
                viewModel.update(it)
            }
        }
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            clInfoLainnya.setOnClickListener {
                viewModel.setOnClickInfo()
            }
            imageInfoTax.setOnClickListener {
                viewModel.setOnClickInfoTax()
            }
            imageInfoTaxInc.setOnClickListener {
                viewModel.setOnClickInfoTax()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DetailMemberViewModel.UIEvent.RequestInfoTax -> {
                            val action = DetailMemberDialogDirections.actionDetailMemberDialogToTaxInfoDialog()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collect {
                    binding.apply {
                        if(it.isInfoLainnya)
                            groupLainnya.visible()
                        else
                            groupLainnya.gone()

                        it.bp?.let { bp ->
                            txtMember.text = bp.name
                            txtLevelHarga.text = bp.priceLvlId.toString()
                            cbTax.isSelected = bp.isTaxedOnSale
                            cbTax.isSelected = bp.isTaxIncOnSale
                        }
                    }
                }
            }
        }
    }
}