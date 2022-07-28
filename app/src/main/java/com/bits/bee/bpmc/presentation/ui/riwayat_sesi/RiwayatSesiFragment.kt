package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRiwayatSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListFilterDialog
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.decideOnState
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RiwayatSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRiwayatSesiBinding = FragmentRiwayatSesiBinding::inflate
): BaseFragment<FragmentRiwayatSesiBinding>() {

    private val viewModel : RiwayatSesiViewModel by viewModels()
    private lateinit var riwayatSesiAdapter: RiwayatSesiAdapter
    private var desc = false
    private var mMenu: Menu? = null
    private lateinit var pilihTglList : List<String>
    private lateinit var pilihTgl: String
    private var posFilter: Int = 0

    override fun initComponents() {
        setHasOptionsMenu(true)

        pilihTglList = requireActivity().resources.getStringArray(R.array.list_pilih_tgl).toList()

        binding.apply {
            riwayatSesiAdapter = RiwayatSesiAdapter(mListener = object : RiwayatSesiAdapter.PilihRiwayatSesiI{
                override fun onclick(posses: Posses) {
                    val action = RiwayatSesiFragmentDirections.actionRiwayatSesiFragmentToDetailRiwayatSesiFragment(
                        Gson().toJson(
                        posses
                    ))
                    findNavController().navigate(action)
                }

            })
            riwayatSesiAdapter.addLoadStateListener {
                it.decideOnState(
                    riwayatSesiAdapter as PagingDataAdapter<Any, RecyclerView.ViewHolder>,
                    showLoading = {
//                        setVisibilityComponent(it)
                    },
                    showEmptyState = { isVisible ->
                        lLRiwayatEmpty.isVisible = isVisible
                    },
                    showError = { it ->
                        showSnackbar(it)
                    }
                )
            }

            rvRiwayatSesi.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = riwayatSesiAdapter
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
                                getString(R.string.pilih_tanggal),
                                pilihTglList,
                                inilizeTgl(),
                                { data ->
//                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
//                                        .show()
//                                    BeePreferenceManager.saveToPreferences(
//                                        requireActivity(), getString(
//                                            R.string.pref_pilih_tgl
//                                        ), data.toString()
//                                    )
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            selectFilter = data.toString()
                                        )
                                    )
                                })
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        viewModel.getHistory()
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.possesList.collect {
                    riwayatSesiAdapter.submitData(it)
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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        viewModel.getSorting(desc)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.possesSort.collect {
                    riwayatSesiAdapter.submitData(it)
                }
            }
        }
    }

    private fun inilizeTgl(): Int{
        pilihTgl = viewModel.state.selectFilter
        if (pilihTgl.equals("1 Minggu Terakhir"))
            posFilter = 0
        else if(pilihTgl.equals("1 Bulan Terakhir"))
            posFilter = 1
        else if (pilihTgl.equals("90 Hari Terakhir"))
            posFilter = 2
        else if (pilihTgl.equals("Custom"))
            posFilter = 3

        return posFilter
    }

}