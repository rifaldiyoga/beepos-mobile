package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListFilterDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
        viewModel.getFilterSorting(desc, inilizeTgl(), viewModel.state.selectFilter)
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

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when(event){
                        RiwayatSesiViewModel.UIEvent.RequestDialogFilter ->{
                            val dialog = RadioListFilterDialog(
                                requireContext(),
                                getString(R.string.pilih_tanggal),
                                pilihTglList,
                                inilizeTgl(),
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            selectFilter = data.toString()
                                        )
                                    )
//                                    viewModel.getFilterDays(inilizeTgl(), viewModel.state.selectFilter)
                                    viewModel.getFilterSorting(desc, inilizeTgl(), viewModel.state.selectFilter)
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
//                viewModel.possesList.collect {
//                    riwayatSesiAdapter.submitData(it)
//                }
//                viewModel.getListHistory.collect {
//                    it.data?.let {
//                        viewModel.updateState(
//                            viewModel.state.copy(
//                                listHistoryPosses = it
//                            )
//                        )
//                    }
//                }
//                var mutableList: MutableList<Sesi> = mutableListOf()
//                parentSesiAdapter.submitList(mutableList)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
//                        it.listHistoryPosses?.let { data ->
//                            viewModel.setListSesi(data)
//                            it.sesiList?.let {
//                                parentSesiAdapter.initList(viewModel.state.sesiList!!)
//                            }
//                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_riwayat_sesi, menu)
        OnClickSort(desc)
        if (!desc) {
            menu.getItem(1).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
            desc = false
        }
        this.mMenu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.filter__riwayat_sesi ->{
                viewModel.showDialog()
            }
            R.id.sort__riwayat_sesi ->{
                if (desc){
                    mMenu!!.getItem(1).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
                    desc = false
                }else{
                    mMenu!!.getItem(1).icon =
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
        viewModel.getFilterSorting(desc, inilizeTgl(), viewModel.state.selectFilter)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.listHistoryPosses?.let { data ->
                            viewModel.setListSesi(data, desc)
                            it.sesiList?.let {
                                parentSesiAdapter.initList(viewModel.state.sesiList!!)
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

    private fun inilizeTgl(): Int{
        pilihTgl = viewModel.state.selectFilter
        if (pilihTgl.equals(getString(R.string.last_1_week)))
            posFilter = 0
        else if(pilihTgl.equals(getString(R.string.last_1_month)))
            posFilter = 1
        else if (pilihTgl.equals(getString(R.string.last_90_days)))
            posFilter = 2
        else
            posFilter = 3

        return posFilter
    }

}