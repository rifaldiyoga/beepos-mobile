package com.bits.bee.bpmc.presentation.ui.walkthrough

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentWalkthroughBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 09/12/22
 */
@AndroidEntryPoint
class WalkThroughFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWalkthroughBinding = FragmentWalkthroughBinding::inflate
) : BaseFragment<FragmentWalkthroughBinding>() {

    private val viewModel : WalkThroughViewModel by viewModels()

    private val fnbList = listOf(
        WalkThrough(R.drawable.image_walk_fnb_2, R.string.tampilan_pos_untuk_transaksi, R.string.desain_khusus_untuk_bisnis_cafe),
        WalkThrough(R.drawable.image_walk_fnb_3, R.string.sesuaikan_selera_customer, R.string.customer_pesan_khusus_sesuai_seleranya),
        WalkThrough(R.drawable.image_walk_fnb_4, R.string.tampilan_landscape_atau_portrait, R.string.bebas_pilih_mau_tampilan_landscape),
    )

    private val retailList = listOf(
        WalkThrough(R.drawable.image_walk_retail_2, R.string.tampilan_pos_untuk_transaksi, R.string.didesain_khusus_untuk_anda_yang_memiliki_lebih),
        WalkThrough(R.drawable.image_walk_retail_3, R.string.scan_barcode_untuk_pencarian_cepat, R.string.pencarian_produk_lebih_mudah_cepat),
        WalkThrough(R.drawable.image_walk_retail_4, R.string.manfaatkan_fitur_product_id, R.string.product_id_atau_pid_adalah_fitur_yang),
    )

    override fun initComponents() {
        binding.apply {
            var list = fnbList
            arguments?.let {
                val item = it.getString("mode")
                if(item == "retail"){
                    tvTitle.text = "Retail atau Distributor"
                    tvDesc.text = getString(R.string.didesain_khusus_untuk_anda_yang_memiliki_lebih)
                    image.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.image_walk_retail_1))
                    list = retailList
                }
            }
            val adapter = WalkThroughAdapter(this@WalkThroughFragment, list)
            viewPager2.isUserInputEnabled = false
            viewPager2.adapter = adapter
            tabLayout2.isEnabled = false
            TabLayoutMediator(tabLayout2, viewPager2){ tab, pos ->
            }.attach()
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                if(viewModel.state.pos > -1){
                    viewModel.onClickBack()
                } else {
                    findNavController()
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnLanjut.setOnClickListener {
                viewModel.onClickLanjut()
            }
            toolbar2.setNavigationOnClickListener {
                viewModel.onClickBack()
            }
            tvLewati.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collect {
                it?.let {
                    binding.apply {
//                        TransitionManager.beginDelayedTransition(clLayout)
                        group5.isVisible = it.pos > -1
                        group6.isVisible = it.pos == -1
                        tabLayout2.isVisible = it.pos > -1
                        toolbar2.isVisible = it.pos > -1

                        if(it.pos > -1){
                            viewPager2.currentItem = it.pos
                            btnLanjut.text = if(it.pos > -1 && it.pos < fnbList.size -1) getString(R.string.lanjut) else getString(R.string.selesai)
                            if(it.pos == fnbList.size)
                                findNavController().popBackStack()
                        } else {
                            btnLanjut.text = getString(R.string.mulai)
                        }

                    }
                }
            }
        }
    }

}