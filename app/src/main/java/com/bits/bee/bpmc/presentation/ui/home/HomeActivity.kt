package com.bits.bee.bpmc.presentation.ui.home

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.marginEnd
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
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
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/04/22.
 */
@AndroidEntryPoint
class HomeActivity(
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding = ActivityHomeBinding::inflate
) : BaseActivity<ActivityHomeBinding>(){

    private val viewModel : HomeViewModel by viewModels()

    private val sharedViewModel : BukaTutupKasirSharedViewModel by viewModels()

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(this, getString(R.string.pref_last_page), getString(
            R.string.page_home))
        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT) {
                val layoutParams = bottomNavigationView.layoutParams as MarginLayoutParams
                layoutParams.marginEnd = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    16f,
                    resources.displayMetrics
                ).toInt()
                bottomNavigationView.layoutParams = layoutParams
            }
            setSupportActionBar(toolbar)
            bottomAppBar.setBackgroundResource(R.color.white)
            NavigationUI.setupActionBarWithNavController(this@HomeActivity, navController, appBarConfiguration)
            val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            NavigationUI.setupWithNavController(bottomNav, navController)
            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
            navController.addOnDestinationChangedListener { _, _, _ ->
                if(navController.currentDestination?.id == R.id.berandaFragment || navController.currentDestination?.id == R.id.aturModalDialogBuilder)
                    toolbar.navigationIcon = null
                else
                    toolbar.navigationIcon = ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_back_black)

                toolbar.setNavigationOnClickListener {
                    super.onBackPressed()
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            fab.setOnClickListener {
                if (sharedViewModel.state.activePosses != null){
                    viewModel.onPosClick()
                } else {
                    val dialog = DialogBuilderHelper.showDialogChoice(this@HomeActivity,
                        getString(R.string.belum_buka_kasir), getString(R.string.msg_info_belum_buka_kasir_pos),
                        getString(R.string.buka_kasir), {
                            navController.navigate(R.id.detailBukaKasirFragment)
                            it.dismiss()
                        },
                        getString(R.string.tutup))
                    dialog.show(supportFragmentManager, "")
                }
            }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                setVisibilityBottom(
                    destination.id == R.id.berandaFragment ||
                            destination.id == R.id.analasisiSesiFragment ||
                            destination.id == R.id.transaksiPenjualanFragment ||
                            destination.id == R.id.lainnyaFragment ||
                            destination.id == R.id.aturModalDialogBuilder
                )
            }
        }
    }

    override fun subscribeObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        HomeViewModel.UIEvent.NavigateToPos -> {
                            navController.navigate(R.id.mainActivity)
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.posModeState.collect {

                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.initialHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun setVisibilityBottom(isShow : Boolean){
        binding.apply {
            if(isShow) {
                val param = mainHostFragment.layoutParams as ViewGroup.MarginLayoutParams
                param.bottomMargin = bottomAppBar.height
                mainHostFragment.layoutParams = param
                bottomAppBar.visible()
                fab.visible()

            } else {
                val param = mainHostFragment.layoutParams as ViewGroup.MarginLayoutParams
                param.bottomMargin = 0
                mainHostFragment.layoutParams = param
                bottomAppBar.gone()
                fab.gone()
            }
        }
    }

//    override fun onBackPressed() {
//        when(navController.currentDestination?.id){
//            else -> super.onBackPressed()
//        }
//    }
}

