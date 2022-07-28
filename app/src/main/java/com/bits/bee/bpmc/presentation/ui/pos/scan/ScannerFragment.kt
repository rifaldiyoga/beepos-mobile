package com.bits.bee.bpmc.presentation.ui.pos.scan

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentScannerBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.budiyev.android.codescanner.CodeScanner
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 22/07/22.
 */
@AndroidEntryPoint
class ScannerFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScannerBinding = FragmentScannerBinding::inflate
) : BaseFragment<FragmentScannerBinding>() {

    private lateinit var codeScanner : CodeScanner

    override fun onStart() {
        super.onStart()
        codeScanner.startPreview()
    }

    override fun onStop() {
        super.onStop()
        codeScanner.stopPreview()
    }

    override fun initComponents() {
        binding.apply {
            codeScanner = CodeScanner(requireContext(), scannerView)
        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
    }

}