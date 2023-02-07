package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.pilih_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.FragmentSettingFavPilihProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.SettingFavProdukViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SettingFavPilihProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingFavPilihProdukBinding = FragmentSettingFavPilihProdukBinding::inflate
): BaseFragment<FragmentSettingFavPilihProdukBinding>() {

    private val viewModel : SettingFavPilihProdukViewModel by viewModels()

    private val mainViewModel : SettingFavProdukViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.let {
                        mainViewModel.updateActiveItemGroup(viewModel.state.itemGroupList[it.position])
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })

        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.itemGroupList.collect {
                    viewModel.state.itemGroupList.addAll(it)
                    binding.apply {
                        val tabAdapter = ItgrpFavTabFragmentAdapter(this@SettingFavPilihProdukFragment, it)
                        viewPager.adapter = tabAdapter
                        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                            tab.text = it[pos].name
                        }.attach()
                    }
                }
            }
        }
    }
}