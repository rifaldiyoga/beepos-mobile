package com.bits.bee.bpmc.presentation.ui.pos.promo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentPromoBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.extension.gone
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 19/08/22.
 */

@AndroidEntryPoint
class PromoFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPromoBinding = FragmentPromoBinding::inflate
) : BaseFragment<FragmentPromoBinding>(){

    private val viewModel : PromoViewModel by viewModels()

    private lateinit var promoAdapter: PromoAdapter

    override fun initComponents() {
        binding.apply {
            promoAdapter = PromoAdapter()
            progressBar.gone()
            rvList.apply {
                adapter = promoAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.promoList.collect {
                promoAdapter.submitList(it)
            }
        }
    }

}