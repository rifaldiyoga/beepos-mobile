package com.bits.bee.bpmc.presentation.ui.download

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.ActivityDownloadBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        if(it.status.isNotEmpty())
                            binding.tvDownload.text = it.status
                    }
                }
            }
        }
    }

}