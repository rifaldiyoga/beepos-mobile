package com.bits.bee.bpmc.presentation.ui.initial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInitalBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitialFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInitalBinding = FragmentInitalBinding::inflate
) : BaseFragment<FragmentInitalBinding>() {


    override fun initComponents() {
        directPage()
    }

    override fun subscribeListeners() {
        binding.apply {
            btnDaftar.setOnClickListener {
                val action = InitialFragmentDirections.actionInitialFragmentToInfoKontakFragment()
                findNavController().navigate(action)
            }
            btnMasuk.setOnClickListener {
                val action = InitialFragmentDirections.actionInitialFragmentToLoginFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun subscribeObservers() {

    }

    /**
     * check last page from prefences then direct to last page
     */
    private fun directPage(){
        when(BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_last_page), "")){
            getString(R.string.page_pilih_cabang) -> {
//                val action = LoginFragmentDirections.actionLoginFragmentToPilihCabangFragment()
                findNavController().navigate(R.id.pilihCabangFragment)
            }
            getString(R.string.page_pilih_kasir) -> {
//                val action = LoginFragmentDirections.actionLoginFragmentToPilihKasirFragment()
                findNavController().navigate(R.id.pilihKasirFragment)
            }
            getString(R.string.page_pilih_operator) -> {
//                val action = LoginFragmentDirections.actionLoginFragmentToLoginOperatorFragment()
                findNavController().navigate(R.id.loginOperatorFragment)
            }
            getString(R.string.page_mode_tampilan) -> {
//                val action = LoginFragmentDirections.actionLoginFragmentToModeTampilanFragment()
                findNavController().navigate(R.id.modeTampilanFragment)
            }
            getString(R.string.page_home) -> {
//                val action = LoginFragmentDirections.actionLoginFragmentToHomeActivity()
                findNavController().navigate(R.id.homeActivity)
                (activity as InitialActivity).finish()
            }
            getString(R.string.page_atur_pin) -> {
                findNavController().navigate(R.id.aturPinFragment)
            }
            getString(R.string.page_atur_produk) -> {
                findNavController().navigate(R.id.aturProdukFragment)
            }
            getString(R.string.page_otp) -> {
                findNavController().navigate(R.id.otpFragment)
            }
            getString(R.string.page_login) ->{
                findNavController().navigate(R.id.loginFragment)
            }
            getString(R.string.page_cek_db) ->{
                findNavController().navigate(R.id.cekDbFragment)
            }
            else -> {

            }
        }
    }

}