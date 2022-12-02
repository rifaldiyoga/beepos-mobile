package com.bits.bee.bpmc.presentation.ui.tambah_member

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahMemberBinding
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.TaxInfoDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class TambahMemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahMemberBinding = FragmentTambahMemberBinding::inflate
) : BaseFragment<FragmentTambahMemberBinding>() {

    private val viewModel : TambahMemberViewModel by viewModels()
    private val mainViewModel : MainViewModel by activityViewModels()

    private var mDistrict: District? = null

    private lateinit var adapter : ArrayAdapter<String>
    private lateinit var regencyStr: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            if (!it.getString("district").equals("null") && it.getString("district")?.isNotEmpty() == true){
                mDistrict = Gson().fromJson(it.getString("district"), District::class.java)
                viewModel.updateState(
                    viewModel.state.copy(
                        district = mDistrict
                    )
                )
            }
            viewModel.state.district?.let {
                viewModel.getRegency()
            }
        }
    }

    override fun initComponents() {
        regencyStr = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_city),"") as String
//        var isCity = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_is_city), false) as Boolean
//        val ss = ""
//        if (!isCity){
//            var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()
//            sharedPreferences.remove(getString(R.string.pref_city))
//            sharedPreferences.commit()
//        }
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
            etKota.addTextChangedListener {
                viewModel.state.kota = etKota.text.toString().trim()
            }
            etKota.setOnClickListener {
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_member_name), viewModel.state.namaMember)
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_member_notelp), viewModel.state.noTelp)
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_member_email), viewModel.state.email)
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_member_alamat), viewModel.state.alamat)
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
            spPriceLvl.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.updateState(
                        viewModel.state.copy(
                            priceLvl = viewModel.state.priceLvlList[p2].id
                        )
                    )
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
            imgClose.setOnClickListener {
                viewModel.onClickIcon()
            }
            imgCloseTaxin.setOnClickListener {
                viewModel.onClickIcon()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        is TambahMemberViewModel.UIEvent.SuccessAddMember -> {
                            val dialog = DialogBuilderHelper.showDialogYesNo(
                                requireActivity(),
                                "Berhasil Tambah Member",
                                "Member berhasil ditambahkan, Gunakan member sekarang?",
                                positiveListener = {
                                    it.dismiss()
                                    findNavController().previousBackStackEntry?.savedStateHandle?.set("isUse", true)
                                    event.bp?.let {
                                        mainViewModel.updateActiveBp(it)
                                    }
                                    showToast(R.string.berhasil_membuat_member)
                                    findNavController().popBackStack()
                                },
                                negativeListener = {
                                    it.dismiss()
                                    findNavController().popBackStack()
                                }
                            )
                            dialog.show(parentFragmentManager, "")
                        }
                        TambahMemberViewModel.UIEvent.RequestKota -> {
                            val action = TambahMemberFragmentDirections.actionTambahMemberFragmentToCariKotaFragment()
                            findNavController().navigate(action)
                        }
                        TambahMemberViewModel.UIEvent.RequestTaxInfo ->{
                            val dialog = TaxInfoDialog()
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
                        binding.apply {
                            if(it.isInfoLainnya)
                                groupLainnya.visible()
                            else
                                groupLainnya.gone()

                            tilNamaMember.error = it.errorNamaMember
                            tilAlamat.error = it.errorAlamat
                            tilNoTelp.error = it.errorNoTelp
                            tilEmail.error = it.errorEmail
                            etNamaMember.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_member_name), "") as String)
                            etNoTelp.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_member_notelp), "") as String)
                            etEmail.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_member_email), "") as String)
                            etAlamat.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_add_member_alamat), "") as String)
                            var str = ""
                            if (regencyStr == ""){
                                it.regency?.let {
                                    str = it.name+(", ")+mDistrict!!.name
                                }
                            }else{
                                str = regencyStr
                            }
                            etKota.setText(str)
//                            etKota.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_city),"") as String)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.priceLvlList.collect {
                    viewModel.state.priceLvlList = it
                    viewModel.state.priceLvl = if(it.isNotEmpty()) it[0].id else 1
                    adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, it.map { it.name })
                    binding.spPriceLvl.adapter = adapter
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            val regTaxed = viewModel.regSaleTaxed.first()
            val regTaxInc = viewModel.regSaleTaxInc.first()
            val regDefPriceLvl = viewModel.regDefPriceLvl.first()

            binding.apply {
                cbTax.isChecked = regTaxed?.value == "1"
                cbTaxInc.isChecked = regTaxInc?.value == "1"
                spPriceLvl.setSelection(viewModel.state.priceLvlList.indexOfLast {
                    it.id == (regDefPriceLvl?.value?.toInt() ?: -1)
                })
            }
        }
    }

}