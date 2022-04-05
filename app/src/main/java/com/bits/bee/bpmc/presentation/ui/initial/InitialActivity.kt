package com.bits.bee.bpmc.presentation.ui.initial

import android.os.Bundle
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
import com.bits.bee.bpmc.databinding.ActivityInitialBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 10/03/22.
 */

@AndroidEntryPoint
class InitialActivity (
    override val bindingInflater: (LayoutInflater) -> ActivityInitialBinding = ActivityInitialBinding::inflate
) : BaseActivity<ActivityInitialBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //View Model
//    private val viewModel : InitialViewModel by viewModels()

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initComponents() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.initialHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            setSupportActionBar(toolbar)
            navController.addOnDestinationChangedListener { _, _, _ ->
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back)
            }
            NavigationUI.setupActionBarWithNavController(this@InitialActivity, navController, appBarConfiguration)

            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.initialHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }


}