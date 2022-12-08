package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KasMasukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKasMasukBinding = FragmentKasMasukBinding::inflate
): BaseFragment<FragmentKasMasukBinding>() {

    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private lateinit var parentKasAdapter: ParentKasAdapter
    private var isKasmasuk: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.loadKasMasuk(sharedViewModel.state.isDesc, sharedViewModel.state.search)
        sharedViewModel.checkPosses()
        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_tablayout), true)
    }

    override fun onResume() {
        super.onResume()
        isKasmasuk = true
    }

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
                            if (sharedViewModel.state.acrivePosses != null){
                                val dialog = TambahKasDialog.Builder(requireContext())
                                    .setTitle(getString(R.string.tambah_kas_masuk))
                                    .setNominal(getString(R.string.nominal_uang_masuk))
                                    .setStatus(isKasmasuk)
                                    .build()
                                dialog.show(parentFragmentManager, TAG)
                            }else{
                                Toast.makeText(requireContext(), "Pastikan buka kasir terlebih dahulu", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else -> {}
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                sharedViewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.cadjListIn?.let { data->
                                if (data.size > 0){
                                    sharedViewModel.setListKasIn(data)
                                    it.cashInList?.let {
                                        parentKasAdapter.initList(sharedViewModel.state.cashInList!!)
                                    }
                                    group3.visibility = View.GONE
                                    imageView17.visibility = View.GONE
                                    txtNotFound.visibility = View.GONE
                                    binding.floatBtnTambah.visibility = View.VISIBLE
                                }else{
                                    sharedViewModel.setListKasIn(data)
                                    it.cashInList?.let {
                                        parentKasAdapter.initList(sharedViewModel.state.cashInList!!)
//                                        if (it.size > 0){
//                                            parentKasAdapter.initList(sharedViewModel.state.cashInList!!)
//                                        }else{
//                                            imageView17.visibility = View.VISIBLE
//                                            textView91.visibility = View.VISIBLE
//                                        }
                                    }
                                    if (sharedViewModel.state.search.length >= 2){
                                        imageView17.visibility = View.VISIBLE
                                        txtNotFound.visibility = View.VISIBLE
                                        group3.visibility = View.GONE
                                    }
                                    floatBtnTambah.visibility = View.GONE
//                                    else{
//                                        group3.visibility = View.VISIBLE
//                                        binding.floatBtnTambah.visibility = View.GONE
//                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}