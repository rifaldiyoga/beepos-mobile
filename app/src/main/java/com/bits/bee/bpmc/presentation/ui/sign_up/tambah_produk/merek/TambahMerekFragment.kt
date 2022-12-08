package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk.merek

import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahEditMerkBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TambahMerekFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahEditMerkBinding = FragmentTambahEditMerkBinding::inflate
): BaseFragment<FragmentTambahEditMerkBinding>() {

    private val viewModel: TambahUbahMerekViewModel by viewModels()

    override fun initComponents() {
        arguments?.let {
            val item = it.getString("itemBrand")
            item?.let {
                (activity as InitialActivity).supportActionBar?.title = getString(R.string.title_ubah_merek)
                viewModel.state.isEdit = true
                viewModel.loadEditData(it)
            }

        } ?: run {

        }
    }

    override fun subscribeListeners() {
        setHasOptionsMenu(true)
        binding.apply {
            etMerekPrd.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        namaMerek = etMerekPrd.text.toString().trim()
                    )
                )
            }

            btnSimpan.setOnClickListener {
                viewModel.onSaveMerk(viewModel.state.namaMerek, viewModel.state.isEdit, viewModel.state.olId)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        TambahUbahMerekViewModel.UIEvent.FinishSaveDelete ->{
                            findNavController().popBackStack()
                        }
                        TambahUbahMerekViewModel.UIEvent.RequestDialog ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.hapus_merk))
                                .setMessage(getString(R.string.confirm_hapus_merk))
                                .setPositiveText(getString(R.string.batal))
                                .setNegativeText(getString(R.string.hapus))
                                .setPositiveCallback {
                                    it.dismiss()
                                }
                                .setNegativeCallback {
                                    requireActivity().actionBar?.displayOptions
                                    viewModel.doDeleteMerk()
                                }.build()
                            dialog.show(parentFragmentManager, TAG)
                        }
                        else -> {}
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.brand?.let { data ->
                                viewModel.state.olId = data.id!!
                                etMerekPrd.setText(data.brandName)
                                etMerekPrd.setSelection(etMerekPrd.text.length)
                                etMerekPrd.addTextChangedListener(object : TextWatcher{
                                    override fun beforeTextChanged(
                                        p0: CharSequence?,
                                        p1: Int,
                                        p2: Int,
                                        p3: Int
                                    ) {

                                    }

                                    override fun onTextChanged(
                                        p0: CharSequence?,
                                        p1: Int,
                                        p2: Int,
                                        p3: Int
                                    ) {
                                        etMerekPrd.removeTextChangedListener(this)
                                        data.brandName = p0.toString()
                                    }

                                    override fun afterTextChanged(p0: Editable?) {

                                    }

                                })
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        arguments?.let {
            val item = it.getString("itemBrand")
            item?.let {
                inflater.inflate(R.menu.menu_void, menu)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_void -> viewModel.onShowDelete()
        }
        return super.onOptionsItemSelected(item)
    }
}