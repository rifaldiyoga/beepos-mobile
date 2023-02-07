package com.bits.bee.bpmc.presentation.ui.initial

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bits.bee.bpmc.R

/**
 * Created by aldi on 08/12/22
 */
class SlidePagerAdapter(fragmentActivity: Fragment, val list : List<Int>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        return SliderFragment.newInstance(list[position])
    }

}