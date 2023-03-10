package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapterRekapKas(
    fragmentManager: FragmentManager, lifecycle: Lifecycle, requireContext: Context
): FragmentStateAdapter(fragmentManager, lifecycle
) {

    private var mContext = requireContext

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                KasMasukFragment()
            }
            1 -> {
                KasKeluarFragment()
            }
            else -> Fragment()
        }
    }
}