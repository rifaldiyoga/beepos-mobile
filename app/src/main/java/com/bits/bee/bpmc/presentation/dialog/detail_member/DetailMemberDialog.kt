package com.bits.bee.bpmc.presentation.dialog.detail_member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogDetailMemberBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.CloudDapurDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.TaxInfoDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class DetailMemberDialog(
    private val mBp: Bp,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDetailMemberBinding = DialogDetailMemberBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDetailMemberBinding>() {

    private val viewModel : DetailMemberViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val bp = it.getParcelable<Bp>("member")
            bp?.let {
                viewModel.updateState(
                    viewModel.state.copy(
                        bp = it
                    )
                )
            }
        }
//        if (!viewModel.state.bp!!.code.equals("CASH"))
//            viewModel.getBpaddr()
    }

    override fun initComponents() {
        viewModel.updateState(
            viewModel.state.copy(
                bp = mBp
            )
        )
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
            imgViewClose.setOnClickListener {
                dismiss()
            }
            buttonClosed.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DetailMemberViewModel.UIEvent.RequestInfoTax -> {
                            val dialog = TaxInfoDialog()
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            if(it.isInfoLainnya)
                                groupLainnya.visible()
                            else
                                groupLainnya.gone()

                            it.bp?.let { bp ->
                                tvMember.text = bp.name
                                tvLevelHarga.text = bp.priceLvlId.toString()
                                cbTax.isChecked = bp.isTaxedOnSale
                                cbTaxInc.isChecked = bp.isTaxIncOnSale
                                bp.bpAddr?.let {
                                    tvNoTelp.text = if(it.phone.isNullOrEmpty()) "-" else it.phone
                                    tvAlamat.text = if(it.address.isEmpty()) "-" else it.address
                                    tvKota.text = if(it.cityCode.isNullOrEmpty()) "-" else it.cityCode
                                }
                            }
//                            it.bpAdddr?.let {
//                                tvNoTelp.text = it.phone
//                                tvAlamat.text = it.address
//                                tvEmail.text = it.email
//                            }
//                            if (it.district != null){
//                                it.regency?.let { data ->
//                                    tvKota.text = data.name+", "+it.district.name
//                                }
//                            }else{
//                                it.regency?.let {
//                                    tvKota.text = it.name
//                                }
//                            }
                        }
                    }
                }
            }
        }
    }
}