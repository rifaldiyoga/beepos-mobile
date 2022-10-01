package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.view.LayoutInflater
import android.view.ViewGroup
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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KasKeluarFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKasKeluarBinding = FragmentKasKeluarBinding::inflate
): BaseFragment<FragmentKasKeluarBinding>() {

    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private lateinit var parentKasAdapter: ParentKasAdapter

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
                    }
                }
            }
        }
    }
}