package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class DetailTutupKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTutupKasirBinding = FragmentDetailTutupKasirBinding::inflate
) : BaseFragment<FragmentDetailTutupKasirBinding>() {

    private val viewModel : DetailTutupKasirViewModel by viewModels()
    private val sharedViewModel : BukaTutupKasirSharedViewModel by activityViewModels()

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTutupKasir.setOnClickListener {
                val dialog = DialogBuilderUtils.showDialogYesNo(requireContext(),
                    getString(R.string.tutup_kasir), getString(R.string.msg_validasi_tutup_kasir), {
                        it.dismiss()
                        viewModel.onTutupKasir()
                        findNavController().popBackStack()
                    })
                dialog.show(parentFragmentManager, "DetailTutupKasirFragment")
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event  ->
                    when(event){
                        DetailTutupKasirViewModel.UIEvent.RequestSave -> {
                            sharedViewModel.doTutupKasir()
                        }
                        DetailTutupKasirViewModel.UIEvent.RequestRekapSesi ->{
                            val action = DetailTutupKasirFragmentDirections.actionDetailTutupKasirFragmentToRekapSesiFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.viewStates().collect {
                    it?.let {
                        it.activeBranch?.let { branch ->
                            binding.tvCabang.text = branch.name
                        }
                        it.activeCashier?.let { cashier ->
                            binding.tvKasir.text = cashier.cashierName
                        }
                        binding.tvShift.text = it.shift.toString()
                        it.activePosses?.let {
                            binding.apply {
                                tvModal.text = CurrencyUtils.formatCurrency(it.startBal)
                                tvPemasukan.text = CurrencyUtils.formatCurrency(it.totIn)
                                tvPengeluaran.text = CurrencyUtils.formatCurrency(it.totOut)
                                tvSaldoAkhir.text = CurrencyUtils.formatCurrency(it.total)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_tutup_kasir, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_list -> viewModel.onCLickMenu()
        }
        return super.onOptionsItemSelected(item)
    }

}