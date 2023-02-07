package com.bits.bee.bpmc.presentation.ui.walkthrough

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bits.bee.bpmc.databinding.LayoutWalkthroughBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment

/**
 * Created by aldi on 09/12/22
 */
class HolderWalkThroughFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> LayoutWalkthroughBinding = LayoutWalkthroughBinding::inflate
) : BaseFragment<LayoutWalkthroughBinding>() {

    override fun initComponents() {
        binding.apply {
            arguments?.let {
                val data = it.getParcelable<WalkThrough>("data")

                data?.let {
                    tvTitle.text = getString(it.title)
                    tvDesc.text = getString(it.desc)
                    image.setImageDrawable(ContextCompat.getDrawable(requireActivity(), it.image))
                }
            }
        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
    }

}