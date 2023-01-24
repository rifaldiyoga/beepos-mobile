package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanDialog
import com.bits.bee.bpmc.presentation.ui.beranda.TAG
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.sql.Date

@AndroidEntryPoint
class DetailRiwayatSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailRiwayatSesiBinding = FragmentDetailRiwayatSesiBinding::inflate
): BaseFragment<FragmentDetailRiwayatSesiBinding>() {

    private val viewModel : DetailRiwayatSesiViewModel by viewModels()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_print, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_print -> {
                viewModel.onClickPrint()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            if (!it.getString("posses").equals("null") && it.getString("posses")?.isNotEmpty() == true){
                val mPosses = Gson().fromJson(it.getString("posses"), Posses::class.java)
                viewModel.updateState(
                    viewModel.state.copy(
                        posses = mPosses
                    )
                )
            }
        }
        viewModel.detailValue()
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            lLDetail.setOnClickListener {
                viewModel.onClickDetail()
            }
            cVAnalisaSesi.setOnClickListener {

                viewModel.detailAnalisaSesi()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when(event){
                        is DetailRiwayatSesiViewModel.UIEvent.RequestDetailPendapatan ->{
                            val dialog = DetailPendapatanDialog(event.model)
                            dialog.show(parentFragmentManager, TAG)
                        }
                        is DetailRiwayatSesiViewModel.UIEvent.RequestAnalisaSesi ->{
                            val action = DetailRiwayatSesiFragmentDirections.actionDetailRiwayatSesiFragmentToAnalasisiSesiFragment(viewModel.state.posses!!)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.activeBranch?.let { branch ->
                            binding.tvCabang.text = branch.name
                        }
                        it.cashier?.let { cashier ->
                            binding.tvKasir.text = cashier.cashierName
                        }
                        if (it.posses != null) {
                            binding.apply {
                                tvPendapatanSesi.text = "Pendapatan Sesi"
                                tvShift.text = it.posses!!.shift.toString()

                                val startTime = Date(it.posses!!.startTime.time)
                                val endTime = Date(it.posses!!.endTime?.time ?: 0)

                                tvMulaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, startTime)
                                tvSelesaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, endTime)
                                pemasukanTotal.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it.posses!!.total.add(it.posses!!.startBal)))
                            }
                        }
                        it.user?.let {
                            binding.tvUserKasir.text = it.name
                        }
                    }
                }
            }
        }
    }

}