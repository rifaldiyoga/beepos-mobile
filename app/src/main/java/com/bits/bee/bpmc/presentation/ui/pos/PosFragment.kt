package com.bits.bee.bpmc.presentation.ui.pos

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.data.source.local.model.ItemGroup
import com.bits.bee.bpmc.databinding.FragmentPosBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 13/04/22.
 */

@AndroidEntryPoint
class PosFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPosBinding = FragmentPosBinding::inflate
) : BaseFragment<FragmentPosBinding>() {

    private lateinit var adapter: PosItemFragmentAdapter

    override fun initComponents() {
        binding.apply {
            val model = ItemGroup(1, "TES", "Itgrp 1", 1, 1, true)
            val list : List<ItemGroup> = buildList {
                for (i : Int in 1..10){
                    add(model.copy(id = i, name = "Itgrp $i"))
                }
            }

            adapter = PosItemFragmentAdapter(this@PosFragment, list)
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                tab.text = list[pos].name
            }.attach()

        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
    }


}