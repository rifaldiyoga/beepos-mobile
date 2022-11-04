package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.pilih_produk

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.ITGRP
import com.bits.bee.bpmc.presentation.ui.pos.pos_item.PositemFragment
import com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.FavProdukFragment

/**
 * Created by aldi on 13/04/22.
 */
class ItgrpFavTabFragmentAdapter(fragment : Fragment, private val itemGroupEntityList : List<ItemGroup> = mutableListOf()) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = itemGroupEntityList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = FavProdukFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(ITGRP, getItem(position))
        }
        return fragment
    }

    private fun getItem(pos : Int) = itemGroupEntityList[pos]

}