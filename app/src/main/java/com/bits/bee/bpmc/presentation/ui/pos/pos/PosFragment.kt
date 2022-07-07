package com.bits.bee.bpmc.presentation.ui.pos.pos

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
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

    private lateinit var searchView: SearchView
    private lateinit var draftMenu: MenuItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pos, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        searchView = searchItem.actionView as SearchView
        draftMenu = menu.findItem(R.id.menu_draft)

        searchView.setOnSearchClickListener {
            draftMenu.isVisible = false
        }
        searchView.setOnCloseListener(SearchView.OnCloseListener {
            draftMenu.isVisible = false
            return@OnCloseListener false
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
           R.id.menu_draft -> {
               viewModel.onClickDraft()
           }
            R.id.menu_diskon -> {
                viewModel.onClickDiskonNota()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {

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
                        PosViewModel.UIEvent.NavigateToDraft -> {
                            val action = PosFragmentDirections.actionPosFragmentToDraftListDialog()
                            findNavController().navigate(action)
                        }
                        PosViewModel.UIEvent.NavigateToDiskonNota -> {
                            val action = PosFragmentDirections.actionPosFragmentToDiskonNotaDialog()
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


    private fun getQtyDetail(saledList : List<Saled>) : BigDecimal {
        var qty = BigDecimal.ZERO
        saledList.forEach {
            qty = qty.add(it.qty)
        }
        return qty
    }


}