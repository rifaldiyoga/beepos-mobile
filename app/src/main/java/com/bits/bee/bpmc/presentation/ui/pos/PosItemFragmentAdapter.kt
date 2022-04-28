package com.bits.bee.bpmc.presentation.ui.pos

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bits.bee.bpmc.data.source.local.model.ItemGroup

/**
 * Created by aldi on 13/04/22.
 */
class PosItemFragmentAdapter(fragment : Fragment, private val itemGroupList : List<ItemGroup> = mutableListOf()) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = itemGroupList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = PositemFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(ITGRP, getItem(position))
        }
        return fragment

    }

    fun getItem(pos : Int) = itemGroupList[pos]

}