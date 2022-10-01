package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.presentation.ui.setting_favorite.SettingFavMemberFragment
import com.bits.bee.bpmc.presentation.ui.setting_favorite.SettingFavProdukFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager

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
                BeePreferenceManager.saveToPreferences(mContext, mContext.getString(R.string.pref_tablayout), true)
                KasMasukFragment()
            }
            1 -> {
                BeePreferenceManager.saveToPreferences(mContext, mContext.getString(R.string.pref_tablayout), false)
                KasKeluarFragment()
            }
            else -> Fragment()
        }
    }
}