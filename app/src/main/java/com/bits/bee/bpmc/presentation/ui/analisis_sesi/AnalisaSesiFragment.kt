package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentAnalisaSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.sql.Date
import java.text.SimpleDateFormat

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class AnalisaSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAnalisaSesiBinding = FragmentAnalisaSesiBinding::inflate
) : BaseFragment<FragmentAnalisaSesiBinding>() {

    private val viewModel : AnalisaSesiViewModel by viewModels()
    private var mPosses: Posses? = null
    private var isRiwayat: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            isRiwayat = it.getBoolean("isRiwayat")
            if (isRiwayat){
                if (!it.getString("posses").equals("null") && it.getString("posses")?.isNotEmpty() == true){
                    mPosses = Gson().fromJson(it.getString("posses"), Posses::class.java)
                    viewModel.updateState(
                        viewModel.state.copy(
                            posses = mPosses
                        )
                    )
                }
            }
        }
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
    }

    override fun subscribeListeners() {
        binding.apply {
            btnBukaKasir.setOnClickListener {
                viewModel.onClickBukaKasir()
            }
            btnLihatRiwayat.setOnClickListener {
                viewModel.onClickMenu()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        AnalisaSesiViewModel.UIEvent.RequstDetailBukaKasir ->{
                            val action = AnalisaSesiFragmentDirections.actionAnalasisiSesiFragmentToDetailBukaKasirFragment()
                            findNavController().navigate(action)
                        }
                        AnalisaSesiViewModel.UIEvent.RequestRiwayatSesi ->{
                            val action = AnalisaSesiFragmentDirections.actionAnalasisiSesiFragmentToRiwayatSesiFragment()
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
                        binding.apply {
                            if (isRiwayat){
                                lLAnalisaEmpty.visibility = View.GONE
                                sVKasirAktif.visibility = View.VISIBLE
                            }else{
                                it.possesList?.let {
                                    if (it.size > 0){
                                        viewModel.getActivePosses()
                                        lLAnalisaEmpty.visibility = View.GONE
                                        sVKasirAktif.visibility = View.VISIBLE

                                    }else if(it.size == 0){
                                        lLAnalisaEmpty.visibility = View.VISIBLE
                                        sVKasirAktif.visibility = View.GONE
                                    }
                                }
                            }
                            it.posses?.let {
                                val startTime = Date(it!!.startTime.time)
                                tvMulaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, startTime)
                                if (it.endTime != null){
                                    val endTime = Date(it.endTime!!.time)
                                    tvSelesaiOperasional.text = DateFormatUtils.formatDateToString(
                                        BPMConstants.DEFAULT_DATE_FORMAT, endTime)
                                }else{
                                    tvSelesaiOperasional.text = ""
                                }
                                tvSesi.text = "#${it.shift}"
                                tvModal.text = it.startBal.toString()
                                tvTotalPendapatan.text = it.total.toString()
                                viewModel.getValueDetail()
                            }
                            it.user?.let {
                                tvUserKasir.text = it.name
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_analisa_sesi, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_list -> viewModel.onClickMenu()
        }
        return super.onOptionsItemSelected(item)
    }


}