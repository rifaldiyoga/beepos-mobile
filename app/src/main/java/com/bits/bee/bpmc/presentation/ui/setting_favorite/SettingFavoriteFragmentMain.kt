package com.bits.bee.bpmc.presentation.ui.setting_favorite

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingFavMainBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFavoriteFragmentMain(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingFavMainBinding = FragmentSettingFavMainBinding::inflate
): BaseFragment<FragmentSettingFavMainBinding>(){
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        with(binding){
            vPSettingFav.adapter = viewPagerAdapter

            TabLayoutMediator(tabLayout, vPSettingFav){ tab, position ->
                when(position){
                    0 -> tab.text = requireActivity().getString(R.string.produk_fav)
                    1 -> tab.text = requireActivity().getText(R.string.member_fav)
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
        inflater.inflate(R.menu.menu_search_fav, menu)

//        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu.findItem(R.id.search_fav)
        val searchView = searchItem.actionView as SearchView

//        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searchItem.collapseActionView()
                Toast.makeText(requireContext(), "Loking for$query", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search_fav ->{

            }
        }
        return super.onOptionsItemSelected(item)
    }
}