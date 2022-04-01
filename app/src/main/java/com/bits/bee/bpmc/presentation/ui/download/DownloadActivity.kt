package com.bits.bee.bpmc.presentation.ui.download

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.bits.bee.bpmc.databinding.ActivityDownloadBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 29/03/22.
 */
@AndroidEntryPoint
class DownloadActivity(
    override val bindingInflater: (LayoutInflater) -> ActivityDownloadBinding = ActivityDownloadBinding::inflate
) : BaseActivity<ActivityDownloadBinding>() {

    private val viewModel : DownloadViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
    }


}