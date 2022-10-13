package com.bits.bee.bpmc.presentation.ui.rekap_kas

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRekapKasBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class RekapKasFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRekapKasBinding = FragmentRekapKasBinding::inflate
) : BaseFragment<FragmentRekapKasBinding>() {

    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private lateinit var vpAdapterRekapKas: VPAdapterRekapKas
    private var desc = false
    private var mMenu: Menu? = null

    override fun initComponents() {
        setHasOptionsMenu(true)
        vpAdapterRekapKas = VPAdapterRekapKas(childFragmentManager, lifecycle, requireContext())

        with(binding){
            vPRekapKas.adapter = vpAdapterRekapKas

            TabLayoutMediator(tLRekapKas, vPRekapKas){ tab, position ->
                when(position){
                    0 -> tab.text = requireActivity().getString(R.string.kas_masuk)
                    1 -> tab.text = requireActivity().getText(R.string.kas_kelaur)
                }
            }.attach()
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_rekap_kas, menu)

        val searchItem = menu.findItem(R.id.search_rekap_kas)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        if (newText?.length == 0){
                            sharedViewModel.loadKasMasuk(sharedViewModel.state.isDesc, "")
                            sharedViewModel.loadKasKeluar(sharedViewModel.state.isDesc, "")
                        }else if (newText!!.length >= 3){
                            sharedViewModel.updateState(
                                sharedViewModel.state.copy(
                                    cadjListIn = null
                                )
                            )
                            sharedViewModel.loadKasMasuk(sharedViewModel.state.isDesc, newText.toString().trim())

                            sharedViewModel.updateState(
                                sharedViewModel.state.copy(
                                    cadjListOut = null
                                )
                            )
                            sharedViewModel.loadKasKeluar(sharedViewModel.state.isDesc, newText.toString().trim())
                        }
                    }
                }
                return false
            }

        })

//        onClickSort(desc)
        if (!desc) {
            menu.getItem(1).icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
            desc = false
        }
        this.mMenu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sort_rekap_kas ->{
                if (desc){
                    mMenu!!.getItem(1).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_descending)
                    desc = false
                }else{
                    mMenu!!.getItem(1).icon =
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_sort_ascending)
                    desc = true
                }
                onClickSort(desc)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onClickSort(desc: Boolean) {
        sharedViewModel.updateState(
            sharedViewModel.state.copy(
                cadjListIn = null
            )
        )
        sharedViewModel.loadKasMasuk(desc, sharedViewModel.state.search)

        sharedViewModel.updateState(
            sharedViewModel.state.copy(
                cadjListOut = null
            )
        )
        sharedViewModel.loadKasKeluar(desc, sharedViewModel.state.search)
    }
}