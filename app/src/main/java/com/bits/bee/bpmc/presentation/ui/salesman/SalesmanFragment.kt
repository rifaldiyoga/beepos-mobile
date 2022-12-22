package com.bits.bee.bpmc.presentation.ui.salesman

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSalesmanBinding
import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.setSearchViewStyle
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class SalesmanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSalesmanBinding = FragmentSalesmanBinding::inflate
) : BaseFragment<FragmentSalesmanBinding>() {

    private val viewModel : SalesmanViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var salesmanAdapter: SalesmanAdapter

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            salesmanAdapter = SalesmanAdapter(
                onMemberClick = { model ->
                    viewModel.onClickDetailMember(model)
                },
                onEyeClick = { model ->
                    viewModel.onClickEye(model)
                },
                mainViewModel.activeSrep.value
            )

            rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = salesmanAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {

        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        is SalesmanViewModel.UIEvent.RequestPos -> {
                            mainViewModel.updateActiveSrep(it.model)
                            findNavController().popBackStack()
                        }
                        is SalesmanViewModel.UIEvent.RequestIconEye ->{
                            val action = SalesmanFragmentDirections.actionSalesmanFragmentToDetailSalesmanFragment(it.model)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.memberList.collect {
                    salesmanAdapter.submitList(it)
                    setVisibilityLoading(false, it)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)

//        val searchManager = requireContext().getSystemService(Context.SEARCH_SERVICE)

        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setSearchViewStyle(requireActivity(), R.color.black)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.length == 0){
                    viewModel.onSearch("")
                }else if (newText!!.length >= 3){
                    viewModel.onSearch(newText.toString().trim())
                }
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search_member ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setVisibilityLoading(isLoading : Boolean, data : List<Srep> = mutableListOf()){
        binding.apply {
            if(isLoading){
                progressBar.visible()
                groupList.gone()
                groupEmpty.gone()
            } else {
                progressBar.gone()
                if(data.isEmpty()) {
                    groupEmpty.visible()
                    groupList.gone()
                } else {
                    groupList.visible()
                    groupEmpty.gone()
                }
            }
        }
    }
}