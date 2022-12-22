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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPosBinding
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceListFragment
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.google.android.material.tabs.TabLayout
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

    private lateinit var tabAdapter: ItgrpTabFragmentAdapter

    private lateinit var listAdapter: ItgrpAdapter

    private val viewModel : PosViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_pos, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT) {
            when (item.itemId) {
                R.id.menu_draft -> {
                    mainViewModel.onClickDraft()
                }
                R.id.menu_diskon -> {
                    mainViewModel.onClickDiskonNota()
                }
                R.id.menu_search -> {
                    mainViewModel.onClickSearch()
                }
                R.id.menu_promo -> {
                    mainViewModel.onClickPromo()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT)
            setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initComponents() {
        binding.apply {
            if(mainViewModel.orientation.value == BPMConstants.SCREEN_LANDSCAPE) {
                listAdapter = ItgrpAdapter {
                    mainViewModel.updateActiveItemGroup(it)
                }
                rvList!!.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = listAdapter
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT) {
                fabTambahBaru!!.setOnClickListener {
                    viewModel.onClickAdd()
                }
                btnTambahBaru!!.setOnClickListener {
                    viewModel.onClickAdd()
                }
                llNext!!.setOnClickListener {
                    viewModel.onClickInvoice()
                }
                tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        tab?.let {
                            mainViewModel.updateActiveItemGroup(viewModel.state.itemGroupList[it.position])
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {

                    }

                })
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.viewStates().collect { state ->
                    state?.let {
                        if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT) {
                            TransitionManager.beginDelayedTransition(binding.clSubtotal!!)
                            binding.tvQty!!.text = getString(
                                R.string._1_produk,
                                CurrencyUtils.formatCurrency(getQtyDetail(state.saledList))
                            )
                            binding.tvSubtotal!!.text = getString(
                                R.string.mata_uang_nominal,
                                state.crc?.symbol ?: "",
                                CurrencyUtils.formatCurrency(state.sale.total)
                            )
                            when(mainViewModel.posModeState.value) {
                                PosModeState.RetailState -> {
                                    binding.apply {
                                        fabTambahBaru!!.isVisible = state.saledList.isNotEmpty()
                                        llNext!!.isVisible = state.saledList.isNotEmpty()
                                        (state.saledList.isEmpty()).also {
                                            image1!!.isVisible = it
                                            btnTambahBaru!!.isVisible = it
                                            textView44!!.isVisible = it
                                        }
                                    }
                                }
                                else -> {
                                    binding.llNext!!.isVisible = state.saledList.isNotEmpty()
                                }
                            }
                        }
                        if(it.sale.total < BigDecimal.ZERO){
                            val dialog = DialogBuilderHelper.showDialogInfo(requireActivity(), "Informasi", "Subtotal tidak boleh minus, transaksi akan langsung direset!", positiveListener = {
                                mainViewModel.resetState()
                                it.dismiss()
                            })
                            dialog.show(parentFragmentManager, "")
                        }
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
                    viewModel.state.itemGroupList = it
                    binding.apply {
                        if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT) {
                            tabAdapter = ItgrpTabFragmentAdapter(this@PosFragment, it)
                            viewPager!!.adapter = tabAdapter
                            TabLayoutMediator(tabLayout!!, viewPager) { tab, pos ->
                                tab.text = it[pos].name
                            }.attach()
                        } else {
                            listAdapter.submitList(it)

                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
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
            if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT) {
                groupFnB!!.isVisible = true
                groupRetail!!.isVisible = false
                fabTambahBaru!!.isVisible = false
            }
        }
    }

    private fun setupRetailMode() {
        binding.apply {
            if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT) {
                groupFnB!!.isVisible = false
                val state = mainViewModel.state
                fabTambahBaru!!.isVisible = state.saledList.isNotEmpty()
                llNext!!.isVisible = state.saledList.isNotEmpty()
                (state.saledList.isEmpty()).also {
                    image1!!.isVisible = it
                    btnTambahBaru!!.isVisible = it
                    textView44!!.isVisible = it
                }
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    val bundle: Bundle = Bundle().also { it.putString("page", "pos") }
                    add<InvoiceListFragment>(R.id.fragmentInvoice, args = bundle)
                }
            }
        }
    }

    private fun getQtyDetail(saledList : List<Saled>) : BigDecimal {
        var qty = BigDecimal.ZERO
        saledList.filter { !it.isBonus }.forEach {
            if(!it.isAddOn)
                qty = qty.add(it.qty)
        }
        return qty
    }

}