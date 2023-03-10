package com.bits.bee.bpmc.presentation.ui.setting_favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_member.SettingFavMemberFragment
import com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.SettingFavProdukFragment

class ViewPagerAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SettingFavProdukFragment()
            else -> SettingFavMemberFragment()
        }
    }
}