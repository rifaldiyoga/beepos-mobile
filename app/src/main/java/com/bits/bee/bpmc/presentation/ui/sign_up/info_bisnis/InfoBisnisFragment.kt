package com.bits.bee.bpmc.presentation.ui.sign_up.info_bisnis

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInfoBisnisBinding
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class InfoBisnisFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInfoBisnisBinding = FragmentInfoBisnisBinding::inflate
): BaseFragment<FragmentInfoBisnisBinding>() {

    private val viewModel: InfoBisnisViewModel by viewModels()

    private lateinit var dialog: LoadingDialogHelper

    private val list = mutableListOf<String>()

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireContext())
        arguments?.let {
            val signUp = it.getParcelable<SignUp>("signUp")
            viewModel.state.signUp = signUp
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnLanjut.setOnClickListener {
                onClickSignUp()
            }
            etAlamat.addTextChangedListener {
                val alamat = etAlamat.text.toString().trim()
                viewModel.state.alamat = alamat
                viewModel.validate()
                if(alamat.isNotEmpty()) {
                    tilAlamat.isErrorEnabled = false
                }
            }
            etNamaPerusahaan.addTextChangedListener {
                val namaPerusahaan = etNamaPerusahaan.text.toString().trim()
                viewModel.state.namaPerusahaan = namaPerusahaan
                viewModel.validate()
                if(namaPerusahaan.isNotEmpty()) {
                    tilNamaPerusahaan.isErrorEnabled = false
                }
            }
            acTxtView.addTextChangedListener {
                val kota = acTxtView.text.toString().trim()
                viewModel.state.kota = kota
                viewModel.validate()
                if(kota.isNotEmpty()) {
                    tilKota.isErrorEnabled = false
                }
            }
            actBidangUsaha.onItemClickListener = AdapterView.OnItemClickListener { p0, p1, p2, p3 ->
                    viewModel.state.tipeUsaha = list[p2]
                    viewModel.validate()
                }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collect {
                it?.let {
                    binding.btnLanjut.apply {
                        background = ContextCompat.getDrawable(requireContext(), when(it.isValid){
                            true -> R.drawable.btn_rect_primary
                            false -> R.drawable.btn_rect_disable
                        })
                        isEnabled = it.isValid
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.cityList.collectLatest {
                when(it.status){
                    Resource.Status.LOADING -> {
                        dialog.show()
                    }
                    Resource.Status.SUCCESS -> {
                        dialog.hide()
                        it.data?.let { data ->
                            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1,data.map { it.name })
                            binding.acTxtView.setAdapter(adapter)
                        }
                    }
                    Resource.Status.ERROR -> {
                        dialog.hide()
                    }
                    Resource.Status.NOINTERNET -> {
                        dialog.hide()
                        val dialog = NoInternetDialogBuilder({
                            onClickSignUp()
                        })
                        dialog.show(parentFragmentManager, "")
                    }
                }
            }

        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.bidangUsahaList.collectLatest {
                when(it.status){
                    Resource.Status.LOADING -> {
                        dialog.show()
                    }
                    Resource.Status.SUCCESS -> {
                        dialog.hide()
                        it.data?.let { data ->
                            if(it.data.status) {
                                val kategoriList = mutableListOf<String>()

                                list.add("Pilih Bidang Usaha")
                                kategoriList.add("Pilih Bidang Usaha")

                                for (data in data.data) {
                                    list.add(data.kategori)
                                    kategoriList.add(data.kategori)
                                    for (data2 in data.dataUsaha) {
                                        list.add(data2.name)
                                        viewModel.usahaList.add(data2)
                                    }
                                }
                                list.add("Lainnya")
                                val adapter = CustomArrayAdapter(requireContext(), list, kategoriList)
                                binding.actBidangUsaha.setAdapter(adapter)
                                viewModel.kategoriList = kategoriList
                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        dialog.hide()
                    }
                    Resource.Status.NOINTERNET -> {
                        dialog.hide()
                        val dialog = NoInternetDialogBuilder({
                            onClickSignUp()
                        })
                        dialog.show(parentFragmentManager, "")
                    }
                }
            }
        }
    }

    private fun onClickSignUp() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.postSignUp(requireContext()).collect{
                when(it.status){
                    Resource.Status.LOADING -> {
                        dialog.show()
                    }
                    Resource.Status.SUCCESS -> {
                        dialog.hide()
                        it.data?.let {
                            if(it.status){
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_is_sign_up), true)
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_nama_device), Build.MANUFACTURER + Build.ID + "-"+viewModel.state.signUp?.nama)
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_email), viewModel.state.signUp?.email ?: "")
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_password), viewModel.state.signUp?.password ?: "")
                                findNavController().navigate(InfoBisnisFragmentDirections.actionInfoBisnisFragmentToOtpFragment(viewModel.state.signUp!!))
                            } else if(it.errorData.isNotEmpty()){
                                for (data in it.errorData){
                                    data.company?.let {
                                        binding.tilNamaPerusahaan.apply {
                                            isErrorEnabled = true
                                            error = it.firstOrNull()
                                        }
                                    }
                                    data.address?.let {
                                        binding.tilAlamat.apply {
                                            isErrorEnabled = true
                                            error = it.firstOrNull()
                                        }
                                    }
                                    data.city_id?.let {
                                        binding.tilKota.apply {
                                            isErrorEnabled = true
                                            error = it.firstOrNull()
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        dialog.hide()
                    }
                    Resource.Status.NOINTERNET -> {
                        dialog.hide()
                        val dialog = NoInternetDialogBuilder({
                            onClickSignUp()
                        })
                        dialog.show(parentFragmentManager, "")
                    }
                }
            }
        }
    }

    class CustomArrayAdapter(context: Context, private val values: List<String>, private val kategoriList : MutableList<String>) : ArrayAdapter<String>(context,  android.R.layout.simple_spinner_dropdown_item, values) {

        override fun getItem(position: Int): String = values[position]

        override fun isEnabled(position: Int): Boolean {
            return !kategoriList.contains(getItem(position))
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            val v: View = super.getDropDownView(position, null, parent)

            if (kategoriList.contains(getItem(position))) {
                v.setBackgroundColor(ContextCompat.getColor(context, R.color.light_gray))
            } else {
                v.setBackgroundColor(Color.WHITE)
            }
            return v
        }

    }
}