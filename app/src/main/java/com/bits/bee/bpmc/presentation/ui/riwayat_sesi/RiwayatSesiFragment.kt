package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.filter.RadioListFilterDialog
import com.bits.bee.bpmc.utils.FilterUtils
import com.bits.bee.bpmc.utils.Resource
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class RiwayatSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRiwayatSesiBinding = FragmentRiwayatSesiBinding::inflate
): BaseFragment<FragmentRiwayatSesiBinding>() {

    private val viewModel : RiwayatSesiViewModel by viewModels()

    private lateinit var parentSesiAdapter: ParentSesiAdapter

    private var desc = false
    private var mMenu: Menu? = null
    private lateinit var pilihTglList : List<String>

    override fun initComponents() {
        setHasOptionsMenu(true)

        pilihTglList = requireActivity().resources.getStringArray(R.array.list_pilih_tgl).toList()
        parentSesiAdapter = ParentSesiAdapter(requireContext(), listener = object : NestedSesiAdapter.PilihRiwayatSesiI{
            override fun onclick(posses: Posses) {
                val action = RiwayatSesiFragmentDirections.actionRiwayatSesiFragmentToDetailRiwayatSesiFragment(
                    Gson().toJson(
                        posses
                    ))
                findNavController().navigate(action)
            }

        })
        binding.apply {
//            riwayatSesiAdapter = RiwayatSesiAdapter(mListener = object : RiwayatSesiAdapter.PilihRiwayatSesiI{
//                override fun onclick(posses: Posses) {
//                    val action = RiwayatSesiFragmentDirections.actionRiwayatSesiFragmentToDetailRiwayatSesiFragment(
//                        Gson().toJson(
//                        posses
//                    ))
//                    findNavController().navigate(action)
//                }
//
//            })
//            riwayatSesiAdapter.addLoadStateListener {
//                it.decideOnState(
//                    riwayatSesiAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
//                    showLoading = {
////                        setVisibilityComponent(it)
//                    },
//                    showEmptyState = { isVisible ->
//                        lLRiwayatEmpty.isVisible = isVisible
//                    },
//                    showError = { it ->
//                        showSnackbar(it)
//                    }
//                )
//            }

            rvRiwayatSesi.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = parentSesiAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            tilPeriode.root.setOnClickListener {
                val dialog = RadioListFilterDialog(
                    requireContext(),
                    getString(R.string.pilih_tanggal),
                    pilihTglList,
                    viewModel.filterDate.value,
                    onSaveClick = {
                        viewModel.onFilterPeriode(it)
                    }
                )
                dialog.show(parentFragmentManager, "")
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.filterDate.collectLatest {
                val filter = FilterUtils.getFilterDateLabel(it.selectedPos)
                binding.tilPeriode.tvTitle.text = filter
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.possesList.collectLatest {
                when(it.status){
                    Resource.Status.LOADING -> {
                        binding.progressBar.isVisible = true
                        binding.lLRiwayatEmpty.isVisible = false
                    }
                    Resource.Status.SUCCESS -> {
                        binding.progressBar.isVisible = false
                        it.data?.let { data ->
                            binding.lLRiwayatEmpty.isVisible = data.isEmpty()
                            parentSesiAdapter.initList(data.toMutableList())
                        }
                    }
                    Resource.Status.ERROR -> {
                        binding.progressBar.isVisible = false

                    }
                    Resource.Status.NOINTERNET -> {
                        binding.progressBar.isVisible = false

                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_riwayat_sesi, menu)
        if (!desc) {
            menu.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
            desc = false
        }
        this.mMenu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sort_riwayat_sesi ->{
                if (desc){
                    mMenu!!.getItem(0).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
                    desc = false
                }else{
                    mMenu!!.getItem(0).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_ascending)
                    desc = true
                }

                viewModel.onSortChange(desc)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}