package com.bits.bee.bpmc.presentation.ui.pos.cari_item

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentCariItemBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 21/07/22.
 */
@AndroidEntryPoint
class CariItemFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCariItemBinding = FragmentCariItemBinding::inflate
) : BaseFragment<FragmentCariItemBinding>() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_scan, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.onActionViewExpanded()
        searchView.setIconifiedByDefault(false)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_scan -> {
                val action = CariItemFragmentDirections.actionCariItemFragmentToScannerFragment()
                findNavController().navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
    }
}