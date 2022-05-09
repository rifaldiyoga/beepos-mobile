package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bits.bee.bpmc.data.source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.databinding.FragmentPosItemBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 13/04/22.
 */

const val ITGRP = "itgrp"

@AndroidEntryPoint
class PositemFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPosItemBinding = FragmentPosItemBinding::inflate
) : BaseFragment<FragmentPosItemBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val itgrp : ItemGroup = it.getParcelable(ITGRP)!!

            Toast.makeText(requireContext(), itgrp.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}