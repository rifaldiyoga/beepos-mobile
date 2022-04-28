package com.bits.bee.bpmc.presentation.ui.tambah_member

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.FragmentTambahMemberBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment

/**
 * Created by aldi on 22/04/22.
 */
class TambahMemberFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahMemberBinding = FragmentTambahMemberBinding::inflate
) : BaseFragment<FragmentTambahMemberBinding>() {

    private val viewModel : TambahMemberViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            clInfoLainnya.setOnClickListener {

            }
        }
    }

    override fun subscribeObservers() {

    }


}