package com.bits.bee.bpmc.presentation.ui.initial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInitalBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class InitialFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInitalBinding = FragmentInitalBinding::inflate
) : BaseFragment<FragmentInitalBinding>() {

    private var timer : Timer? = null
    private var run : Boolean = true

    override fun onDestroy() {
        super.onDestroy()
        run = false
        timer?.let {
            it.cancel()
            it.purge()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        timer = Timer()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        directPage()
        binding.apply {

            val list = listOf(R.layout.layout_slider_1, R.layout.layout_slider_2, R.layout.layout_slider_3)
            val adapter = SlidePagerAdapter(this@InitialFragment, list)
            viewPager2.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager2) { tab, pos ->

            }.attach()
            val timerTask = object : TimerTask() {
                override fun run() {
                    if(run) {
                        requireActivity().runOnUiThread {
                            if (viewPager2.currentItem + 1 == list.size)
                                viewPager2.currentItem = 0
                            else
                                viewPager2.currentItem = viewPager2.currentItem + 1
                        }
                    } else {
                        timer!!.cancel()
                        timer!!.purge()
                    }
                }
            }
            timer!!.schedule(timerTask, 5000, 5000)
        }
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
//                findNavController().navigate(R.id.modeTampilanFragment)
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