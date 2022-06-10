package com.bits.bee.bpmc.presentation.ui.upload_manual

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentUploadManualBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class UploadManualFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUploadManualBinding = FragmentUploadManualBinding::inflate
) : BaseFragment<FragmentUploadManualBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }
}