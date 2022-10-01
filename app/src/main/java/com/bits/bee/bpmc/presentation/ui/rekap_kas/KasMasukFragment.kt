package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentKasMasukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tambah_kas.TambahKasDialog
import com.bits.bee.bpmc.presentation.dialog.tambah_kas.TambahKasSharedViewModel
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KasMasukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKasMasukBinding = FragmentKasMasukBinding::inflate
): BaseFragment<FragmentKasMasukBinding>() {

    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private val viewModel : TambahKasSharedViewModel by viewModels()
    private lateinit var parentKasAdapter: ParentKasAdapter

    override fun initComponents() {
        parentKasAdapter = ParentKasAdapter(requireContext())

        binding.apply {
            rvKasMasuk.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = parentKasAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTambah.setOnClickListener {
                sharedViewModel.onAddKasMasuk()
            }
            floatBtnTambah.setOnClickListener {
                sharedViewModel.onAddKasMasuk()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.event.collect { event ->
                    when (event) {
                        KasKeluarMasukSharedViewModel.UIEvent.RequestAddKasMasuk ->{
                            val dialog = TambahKasDialog.Builder(requireContext())
                                .setTitle(getString(R.string.tambah_kas_masuk))
//                                .setPositiveCallback {
//                                    sharedViewModel.onSaveKasMasuk(
//                                        viewModel.state.nominal!!,
//                                        viewModel.state.deskripsi!!,
//                                        viewModel.state.posses,
//                                        viewModel.state.cash)
//                                }
                                .build()
                            dialog.show(parentFragmentManager, TAG)
                        }
                        KasKeluarMasukSharedViewModel.UIEvent.SuccesAddkasMasuk ->{
                            Toast.makeText(requireContext(), "berhasil simpan", Toast.LENGTH_SHORT).show()
                            sharedViewModel.loadKasMasuk()
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.viewStates().collect {
                    it?.let {
                        it.cadjList?.let { data->
                            sharedViewModel.setListKas(data)
                        }
                    }
                }
            }
        }
    }
}