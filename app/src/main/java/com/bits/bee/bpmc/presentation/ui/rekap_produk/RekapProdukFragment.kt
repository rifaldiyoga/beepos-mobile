package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentRekapProdukBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.riwayat_sesi.RiwayatSesiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class RekapProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRekapProdukBinding = FragmentRekapProdukBinding::inflate
) : BaseFragment<FragmentRekapProdukBinding>() {

    private val viewModel : RekapProdukViewModel by viewModels()

    override fun initComponents() {
        viewModel.loadRekapProduk()
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        it.itemList?.let { data ->

                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_rekap_produk, menu)

        val searchItem = menu.findItem(R.id.search_rekap_produk)
        val searchView = searchItem.actionView as SearchView
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.filter_rekap_produk ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }
}