package com.bits.bee.bpmc.presentation.ui.initial

import android.view.LayoutInflater
import android.view.MenuItem
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
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 10/03/22.
 */

@AndroidEntryPoint
class InitialActivity (
    override val bindingInflater: (LayoutInflater) -> ActivityInitialBinding = ActivityInitialBinding::inflate
) : BaseActivity<ActivityInitialBinding>() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initComponents() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.initialHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            setSupportActionBar(toolbar)


            NavigationUI.setupActionBarWithNavController(this@InitialActivity, navController, appBarConfiguration)
            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
            navController.addOnDestinationChangedListener { _, _, _ ->
                toolbar.setNavigationIcon(R.drawable.ic_back_black)

            }
            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.initialHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            android.R.id.home -> {
//                onBackPressed()
//            }
//        }
//        return true
//    }

    override fun onBackPressed() {
        if(navController.currentDestination?.id == R.id.namaDeviceFragment || navController.currentDestination?.id == R.id.pilihDbFragment){
            val dialog = DialogBuilderUtils.showDialogChoice(
                this,
                getString(R.string.yakin_akan_keluar), getString(R.string.konfirmasi_keluar),
                positiveListener = {
                    it.dismiss()
                    super.onBackPressed()
                }
            )
            dialog.show(supportFragmentManager, TAG)
        } else {
            super.onBackPressed()
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

}