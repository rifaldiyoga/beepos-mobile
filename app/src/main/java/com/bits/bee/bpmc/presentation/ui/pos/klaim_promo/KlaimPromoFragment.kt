package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentKlaimPromoBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 09/09/22
 */
@AndroidEntryPoint
class KlaimPromoFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKlaimPromoBinding = FragmentKlaimPromoBinding::inflate
) : BaseFragment<FragmentKlaimPromoBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

}