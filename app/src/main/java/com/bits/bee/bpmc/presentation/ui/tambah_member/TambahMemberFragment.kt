package com.bits.bee.bpmc.presentation.ui.tambah_member

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahMemberBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class TambahMemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahMemberBinding = FragmentTambahMemberBinding::inflate
) : BaseFragment<FragmentTambahMemberBinding>() {

    private val viewModel : TambahMemberViewModel by viewModels()

    private lateinit var adapter : ArrayAdapter<String>

    override fun initComponents() {
        binding.apply {
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            clInfoLainnya.setOnClickListener {
                viewModel.onClickInfoLainnya()
            }
            etNamaMember.addTextChangedListener {
                viewModel.state.namaMember = etNamaMember.text.toString().trim()
            }
            etNoTelp.addTextChangedListener {
                viewModel.state.noTelp = etNoTelp.text.toString().trim()
            }
            etAlamat.addTextChangedListener{
                viewModel.state.alamat = etAlamat.text.toString().trim()
            }
            etEmail.addTextChangedListener {
                viewModel.state.email = etEmail.text.toString().trim()
            }
            etKota.setOnClickListener {
                viewModel.onClickKota()
            }
            btnSimpan.setOnClickListener {
                viewModel.onClickSimpan()
            }
            cbTax.setOnClickListener {
                viewModel.state.isTaxed = cbTax.isChecked
            }
            cbTaxInc.setOnClickListener {
                viewModel.state.isTaxInc = cbTaxInc.isChecked
            }
            etLevelHarga.setOnItemClickListener { _, _, i, _ ->
                viewModel.updateState(
                    viewModel.state.copy(
                        priceLvl = viewModel.state.priceLvlList[i].id
                    )
                )
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        TambahMemberViewModel.UIEvent.SuccessAddMember -> {
                            findNavController().popBackStack()
                            showToast(R.string.berhasil_membuat_member)
                        }
                        TambahMemberViewModel.UIEvent.RequestKota -> {
                            val action = TambahMemberFragmentDirections.actionTambahMemberFragmentToCariKotaFragment()
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
                            tilNamaMember.error = it.errorNamaMember
                            tilAlamat.error = it.errorAlamat
                            tilNoTelp.error = it.errorNoTelp
                            tilEmail.error = it.errorEmail

                            if(it.isInfoLainnya)
                                groupLainnya.visible()
                            else
                                groupLainnya.gone()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.priceLvlList.collect {
                    viewModel.state.priceLvlList = it
                    adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, it.map { it.name })
                    binding.etLevelHarga.setAdapter(adapter)
                }
            }
        }
    }


}