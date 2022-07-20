package com.bits.bee.bpmc.presentation.ui.detail_sesi_kasir

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
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.TaxInfoDialog
import com.bits.bee.bpmc.presentation.dialog.detail_pendapatan.DetailPendapatanDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberFragmentDirections
import com.bits.bee.bpmc.presentation.ui.tambah_member.TambahMemberViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.sql.Date
import java.text.SimpleDateFormat

@AndroidEntryPoint
class DetailSesiKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailRekapSesiBinding = FragmentDetailRekapSesiBinding::inflate
): BaseFragment<FragmentDetailRekapSesiBinding>() {

    private val viewModel : DetailSesiKasirViewModel by viewModels()
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
        viewModel.getValueDetail()
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            lLDetail.setOnClickListener {
                viewModel.onClickDetail(mPosses!!)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                      is DetailSesiKasirViewModel.UIEvent.RequestDetailPendapatan ->{
                            val dialog = DetailPendapatanDialog(event.model)
                            dialog.show(parentFragmentManager, TAG)
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
                        it.activeCashier?.let { cashier ->
                            binding.tvKasir.text = cashier.cashierName
                        }
                        if (mPosses != null){
                            binding.apply {
                                tvShift.text = mPosses!!.shift.toString()

                                val startTime = Date(mPosses!!.startTime.time)
                                val endTime = Date(mPosses!!.endTime?.time ?: 0)
                                val format = SimpleDateFormat("yyyy/MM/dd HH:mm")

                                tvMulaiOperasional.text = format.format(startTime)
                                tvSelesaiOperasional.text = format.format(endTime)
                                pemasukanTotal.text = mPosses!!.total.toString()
                            }
                        }
                        it.user?.let {
                            binding.tvUserKasir.text = it.name
                        }
                        binding.tvSesi.text = "Auto"
                    }
                }
            }
        }
    }

}