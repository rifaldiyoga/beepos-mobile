package com.bits.bee.bpmc.presentation.ui.pos.pos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPosBinding
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.Resource
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 13/04/22.
 */
const val TAG = "PosFragment"

@AndroidEntryPoint
class PosFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPosBinding = FragmentPosBinding::inflate
) : BaseFragment<FragmentPosBinding>() {

    private lateinit var adapter: PosItemFragmentAdapter

    private val viewModel : PosViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
//            clChannel.setOnClickListener {
//                viewModel.onClickChannel()
//            }
//            clMember.setOnClickListener {
//                viewModel.onClickMember()
//            }
            llNext.setOnClickListener {
                viewModel.onClickInvoice()

            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.viewStates().collect {
                    it?.let {
                        binding.tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(getQtyDetail(it.saledList)))
                        binding.tvSubtotal.text = CurrencyUtils.formatCurrency(it.sale.total)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        PosViewModel.UIEvent.RequestInvoice -> {
                            val action = PosFragmentDirections.actionPosFragmentToInvoiceFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.itemGroupList.collect {
                    when(it.status){
                        Resource.Status.LOADING -> {

                        }
                        Resource.Status.SUCCESS -> {
                            it.data?.let { data ->
                                binding.apply {
                                    adapter = PosItemFragmentAdapter(this@PosFragment, data)
                                    viewPager.adapter = adapter
                                    TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                                        tab.text = data[pos].name
                                    }.attach()
                                }
                            }
                        }
                        Resource.Status.ERROR -> {
                            it.message?.let { msg ->
//                                showSnackbar(msg)
                            }
                        }
                    }
                }
            }
        }
    }


    fun getQtyDetail(saledList : List<Saled>) : BigDecimal {
        var qty = BigDecimal.ZERO
        saledList.forEach {
            qty = qty.add(it.qty)
        }
        return qty
    }


}