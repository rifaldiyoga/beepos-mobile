package com.bits.bee.bpmc.presentation.ui.home

import android.view.LayoutInflater
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
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 07/04/22.
 */
@AndroidEntryPoint
class HomeActivity(
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding = ActivityHomeBinding::inflate
) : BaseActivity<ActivityHomeBinding>(){

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(this, getString(R.string.pref_last_page), getString(
            R.string.page_home))
        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            setSupportActionBar(toolbar)
            bottomAppBar.setBackgroundResource(R.color.white)
            navController.addOnDestinationChangedListener { _, _, _ ->
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back)
            }
            NavigationUI.setupActionBarWithNavController(this@HomeActivity, navController, appBarConfiguration)
            val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            NavigationUI.setupWithNavController(bottomNav, navController)
            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            fab.setOnClickListener {
                navController.navigate(R.id.mainActivity)
            }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                setVisibilityBottom(
                    destination.id == R.id.berandaFragment ||
                    destination.id == R.id.analasisiSesiFragment ||
                    destination.id == R.id.transaksiPenjualanFragment ||
                    destination.id == R.id.lainnyaFragment
                )
            }
        }
    }

    override fun subscribeObservers() {

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.initialHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setVisibilityBottom(isShow : Boolean){
        binding.apply {
            if(isShow) {
                bottomAppBar.visible()
                fab.visible()
            } else {
                bottomAppBar.gone()
                fab.gone()
            }
        }
    }
}

