package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailRekapSesiBinding
import com.bits.bee.bpmc.databinding.FragmentDetailRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanDialog
import com.bits.bee.bpmc.presentation.ui.detail_sesi_kasir.DetailSesiKasirViewModel
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.sql.Date
import java.text.SimpleDateFormat

@AndroidEntryPoint
class DetailRiwayatSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailRiwayatSesiBinding = FragmentDetailRiwayatSesiBinding::inflate
): BaseFragment<FragmentDetailRiwayatSesiBinding>() {

    private val viewModel : DetailRiwayatSesiViewModel by viewModels()
    private var mPosses: Posses? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (!it.getString("posses").equals("null") && it.getString("posses")?.isNotEmpty() == true){
                mPosses = Gson().fromJson(it.getString("posses"), Posses::class.java)
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
                viewModel.onClickDetail(mPosses!!)
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
                            val action = DetailRiwayatSesiFragmentDirections.actionDetailRiwayatSesiFragmentToAnalasisiSesiFragment(
                                Gson().toJson(
                                    mPosses
                                ), true)
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
                        if (mPosses != null){
                            binding.apply {
                                tvPendapatanSesi.text = "Pendapatan Sesi#${mPosses!!.shift}"
                                tvShift.text = mPosses!!.shift.toString()

                                val startTime = Date(mPosses!!.startTime.time)
                                val endTime = Date(mPosses!!.endTime?.time ?: 0)

                                tvMulaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, startTime)
                                tvSelesaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, endTime)
                                pemasukanTotal.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(mPosses!!.total))
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