package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.FilterDate
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.filter.RadioListFilterDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.FilterUtils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RiwayatSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRiwayatSesiBinding = FragmentRiwayatSesiBinding::inflate
): BaseFragment<FragmentRiwayatSesiBinding>() {

    private val viewModel : RiwayatSesiViewModel by viewModels()
//    private lateinit var riwayatSesiAdapter: RiwayatSesiAdapter
    private lateinit var parentSesiAdapter: ParentSesiAdapter
    private var desc = false
    private var mMenu: Menu? = null
    private lateinit var pilihTglList : List<String>
    private var pilihTgl: String = "1 Minggu Terakhir"
    private var posFilter: Int = 0

    override fun initComponents() {
        setHasOptionsMenu(true)

//        viewModel.getListHistory()
        pilihTglList = requireActivity().resources.getStringArray(R.array.list_pilih_tgl).toList()
//        viewModel.getFilterDays(inilizeTgl(), viewModel.state.selectFilter)
        viewModel.getFilterSorting(desc, viewModel.filterDate.value)
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
                            viewModel.getFilterSorting(desc, it)
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
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_riwayat_sesi, menu)
        OnClickSort(desc)
        if (!desc) {
            menu.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
            desc = false
        }
        this.mMenu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
//            R.id.filter__riwayat_sesi ->{
//                viewModel.showDialog()
//            }
            R.id.sort__riwayat_sesi ->{
                if (desc){
                    mMenu!!.getItem(0).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
                    desc = false
                }else{
                    mMenu!!.getItem(0).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_ascending)
                    desc = true
                }

                OnClickSort(desc)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun OnClickSort(desc: Boolean) {

        viewModel.updateState(
            viewModel.state.copy(
                listHistoryPosses = null
            )
        )
        viewModel.getFilterSorting(desc, viewModel.filterDate.value)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.listHistoryPosses?.let { data ->
                            viewModel.setListSesi(data, desc)
                            it.sesiList?.let {
                                if (it.size > 0){
                                    binding.lLRiwayatEmpty.visibility = View.GONE
                                    parentSesiAdapter.initList(viewModel.state.sesiList!!)
                                }else{
                                    binding.lLRiwayatEmpty.visibility = View.VISIBLE
                                    parentSesiAdapter.initList(mutableListOf())
                                }
                            }
                        }
                    }
                }
            }
        }


//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
////                viewModel.possesSort.collect {
////                    riwayatSesiAdapter.submitData(it)
////                }
//            }
//        }
    }

}