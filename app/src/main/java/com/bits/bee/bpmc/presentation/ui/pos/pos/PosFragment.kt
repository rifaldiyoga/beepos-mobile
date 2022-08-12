package com.bits.bee.bpmc.presentation.ui.pos.pos

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
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
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceListFragment
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.Resource
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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

    private lateinit var adapter: PosTabFragmentAdapter

    private val viewModel : PosViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pos, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_draft -> {
                mainViewModel.onClickDraft()
            }
            R.id.menu_diskon -> {
                mainViewModel.onClickDiskonNota()
            }
            R.id.menu_search -> {
                mainViewModel.onClickSearch()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            fabTambahBaru.setOnClickListener {
                viewModel.onClickAdd()
            }
            btnTambahBaru.setOnClickListener {
                viewModel.onClickAdd()
            }
            llNext.setOnClickListener {
                viewModel.onClickInvoice()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect { state ->
                    state?.let {
                        if (mainViewModel.posModeState.value == PosModeState.RetailState){
                            binding.apply {
                                fabTambahBaru.isVisible = state.saledList.size != 0
                                (state.saledList.size == 0).also {
                                    image1.isVisible = it
                                    btnTambahBaru.isVisible = it
                                    textView44.isVisible = it
                                }
                            }
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.viewStates().collect {
                    it?.let {
                        binding.tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(getQtyDetail(it.saledList)))
                        binding.tvSubtotal.text = getString(R.string.mata_uang_nominal, it.crc?.symbol ?: "", CurrencyUtils.formatCurrency(it.sale.total))

                        binding.llNext.visibility = if(it.saledList.isEmpty()) View.GONE else View.VISIBLE

//                        TransitionManager.beginDelayedTransition(binding.clContent)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event) {
                        PosViewModel.UIEvent.RequestInvoice -> {
                            val action = PosFragmentDirections.actionPosFragmentToInvoiceFragment()
                            findNavController().navigate(action)
                        }
                        PosViewModel.UIEvent.NavigateToSearch -> {
                            val action = PosFragmentDirections.actionPosFragmentToCariItemFragment()
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
                                    adapter = PosTabFragmentAdapter(this@PosFragment, data)
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
        viewLifecycleOwner.lifecycleScope.launch {
            mainViewModel.posModeState.collect {
                when(it){
                    PosModeState.FnBState -> {
                        setupFnbMode()
                    }
                    PosModeState.RetailState -> {
                        setupRetailMode()
                    }
                }
            }
        }
    }

    private fun setupFnbMode() {
        binding.apply {
            groupFnB.isVisible = true
            groupRetail.isVisible = false
        }
    }

    private fun setupRetailMode() {
        binding.apply {
            groupFnB.isVisible = false
            groupRetail.isVisible = true
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                var bundle : Bundle = Bundle().also { it.putString("page", "pos") }
                add<InvoiceListFragment>(R.id.fragmentInvoice, args = bundle)
            }
        }
    }

    private fun getQtyDetail(saledList : List<Saled>) : BigDecimal {
        var qty = BigDecimal.ZERO
        saledList.forEach {
            qty = qty.add(it.qty)
        }
        return qty
    }


}