package com.bits.bee.bpmc.presentation.dialog.hapus_transaksi

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogHapusTransaksiBinding
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.TidakAdaAksesDialog
import com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan.DetailTransaksiPenjualanFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 03/11/22
 */
@AndroidEntryPoint
class HapusTransaksiDialog(
    private val sale : Sale,
    private val onFinish : (Sale, Dialog) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogHapusTransaksiBinding = DialogHapusTransaksiBinding::inflate
) : BaseBottomSheetDialogFragment<DialogHapusTransaksiBinding>() {

    private val viewModel : HapusTransaksiViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

            viewModel.loadData()
//            arguments?.let {
//                val sale = it.getParcelable<Sale>("sale")
            viewModel.state.sale = sale
            tvKet.text = getString(R.string.apakah_anda_yakin_ingin_menghapus_transaksi_no_jl12345, sale?.trxNo ?: "")
//            }
            findNavController().currentBackStackEntry?.savedStateHandle?.apply {
                getLiveData<Boolean>(BPMConstants.ACS_DEL).observe(viewLifecycleOwner) {
                    viewModel.state.isCanVoid = it
                    viewModel.doVoid()
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etAlasan.addTextChangedListener {
                viewModel.state.alasan = etAlasan.text.toString().trim()
            }
            btnBatal.setOnClickListener {
                dismiss()
            }
            btnHapus.setOnClickListener {
                viewModel.onClickHapus()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collectLatest {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
//                showSnackbar(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect {
                    when(it){
                        HapusTransaksiViewModel.UIEvent.NavigateToHakAkses -> {
                            val dialog = TidakAdaAksesDialog {
                                it.dismiss()
                                val action = DetailTransaksiPenjualanFragmentDirections.actionDetailTransaksiPenjualanFragmentToHakAksesFragment2(BPMConstants.ACS_DEL)
                                findNavController().navigate(action)
                            }
                            dialog.show(parentFragmentManager, "")
                        }
                        HapusTransaksiViewModel.UIEvent.SuccessVoid -> {
                            Toast.makeText(requireActivity(), "Transaksi berhasil dihapus", Toast.LENGTH_SHORT).show()
                            onFinish(viewModel.state.sale!!, dialog!!)
                        }
                    }
                }
            }
        }
    }

}