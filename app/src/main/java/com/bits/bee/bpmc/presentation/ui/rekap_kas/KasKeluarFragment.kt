package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentKasKeluarBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tambah_kas.TambahKasDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KasKeluarFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKasKeluarBinding = FragmentKasKeluarBinding::inflate
): BaseFragment<FragmentKasKeluarBinding>() {

    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private lateinit var parentKasAdapter: ParentKasAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.loadKasKeluar()
        BeePreferenceManager.saveToPreferences(requireContext(),getString(R.string.pref_tablayout), false)
    }

    override fun initComponents() {
        parentKasAdapter = ParentKasAdapter(requireContext())

        binding.apply {
            rvKasKeluar.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = parentKasAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTambah.setOnClickListener {
                sharedViewModel.onAddKasKeluar()
            }
            floatBtnTambah.setOnClickListener {
                sharedViewModel.onAddKasKeluar()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.event.collect { event ->
                    when (event) {
                        KasKeluarMasukSharedViewModel.UIEvent.RequestAddKasKeluar ->{
                            val dialog = TambahKasDialog.Builder(requireContext())
                                .setTitle(getString(R.string.tambah_kas_keluar)).build()
                            dialog.show(parentFragmentManager, TAG)
                        }
                        KasKeluarMasukSharedViewModel.UIEvent.RequestAddKasKeluar ->{
                            Toast.makeText(requireContext(), "Berhasil Simpan", Toast.LENGTH_SHORT).show()
                            sharedViewModel.loadKasKeluar()
                        }
                        KasKeluarMasukSharedViewModel.UIEvent.RequestAddKasMasuk -> TODO()
                        KasKeluarMasukSharedViewModel.UIEvent.RequestDialogNominal -> TODO()
                        KasKeluarMasukSharedViewModel.UIEvent.SuccesAddKasKeluar -> TODO()
                        KasKeluarMasukSharedViewModel.UIEvent.SuccesAddkasMasuk -> TODO()
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.viewStates().collect {
                    it?.let {
                        it.cadjListOut?.let { data ->
                            if (data.size > 0){
                                sharedViewModel.setListKasOut(data)
                                it.cashOutList?.let {
                                    parentKasAdapter.initList(sharedViewModel.state.cashOutList!!)
                                }
                                binding.lLEmptyKasKeluar.visibility = View.GONE
                                binding.floatBtnTambah.visibility = View.VISIBLE
                            }else{
                                binding.lLEmptyKasKeluar.visibility = View.VISIBLE
                                binding.floatBtnTambah.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }
}