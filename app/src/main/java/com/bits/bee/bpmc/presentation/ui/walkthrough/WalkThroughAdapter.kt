package com.bits.bee.bpmc.presentation.ui.walkthrough

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by aldi on 09/12/22
 */
class WalkThroughAdapter(fragmentActivity: Fragment, val list : List<WalkThrough>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        val fragment = HolderWalkThroughFragment()
        val bundle = Bundle()
        bundle.putParcelable("data", list[position])
        fragment.arguments = bundle
        return fragment
    }
}