package com.bits.bee.bpmc.presentation.ui.insight_preset_kasir

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentInsightPresetKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment

/**
 * Created by aldi on 27/09/22
 */
class InsightPresetKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInsightPresetKasirBinding = FragmentInsightPresetKasirBinding::inflate
) : BaseFragment<FragmentInsightPresetKasirBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            btnPrimary.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://app.beecloud.id/site/login")))
            }
            btnSecondary.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun subscribeObservers() {

    }


}