package com.bits.bee.bpmc.presentation.ui.home

import android.app.SearchManager
import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ActivityHomeBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 04/04/22.
 */
@AndroidEntryPoint
class HomeActivity(
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding = ActivityHomeBinding::inflate
) : BaseActivity<ActivityHomeBinding>(){

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initComponents() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            setSupportActionBar(toolbar)
            navController.addOnDestinationChangedListener { _, _, _ ->
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back)
            }
            NavigationUI.setupActionBarWithNavController(this@HomeActivity, navController, appBarConfiguration)

            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.initialHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    override fun useMenu(menu: Menu) {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_search_fav, menu)
//
//        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        val searchItem = menu.findItem(R.id.search_fav)
//        val searchView = searchItem.actionView as SearchView
//
//        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                searchView.clearFocus()
//                searchView.setQuery("", false)
//                searchItem.collapseActionView()
//                Toast.makeText(this@HomeActivity, "Loking for$query",Toast.LENGTH_SHORT).show()
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return false
//            }
//
//        })
//    }
}

