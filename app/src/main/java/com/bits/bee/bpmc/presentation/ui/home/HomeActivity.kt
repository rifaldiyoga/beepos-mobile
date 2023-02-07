package com.bits.bee.bpmc.presentation.ui.home

import android.content.Intent
import android.net.Uri
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup.MarginLayoutParams
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
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
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.databinding.ActivityHomeBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

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
    private lateinit var dialogLoading : LoadingDialogHelper

    override fun onResume() {
        super.onResume()
        val apiKey = BeePreferenceManager.getDataFromPreferences(this, getString(R.string.api_key), "") as String
        RetrofitClient.API_KEY = apiKey

        viewModel.checkLicense(BeePreferenceManager.getDataFromPreferences(this, getString(R.string.pref_nama_device), "") as String)
    }

    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(this, getString(R.string.pref_last_page), getString(
            R.string.page_home))
        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        dialogLoading = LoadingDialogHelper(this)
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
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            llLicense.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://my.beecloud.id/")))
            }
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
                if(navController.currentDestination?.id == R.id.berandaFragment || navController.currentDestination?.id == R.id.aturModalDialogBuilder) {
                    toolbar.navigationIcon = null
                } else {
                    toolbar.navigationIcon = ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_back_black)
                    viewModel.updateState(
                        viewModel.state.copy(
                            isShowLicense = false
                        )
                    )
                }

                toolbar.setNavigationOnClickListener {
                    super.onBackPressed()
                }

                when (navController.currentDestination?.id) {
                    R.id.cekStokFragment, R.id.rekapKasFragment, R.id.rekapProdukFragment, R.id.transaksiPenjualanFragment -> {
                        toolbar.collapseIcon = ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_back_black)
                    }
                    else -> {
                        toolbar.collapseIcon = null
                    }
                }
                setVisibilityBottom(
                    destination.id == R.id.berandaFragment ||
                            destination.id == R.id.analasisiSesiFragment ||
                            destination.id == R.id.transaksiPenjualanFragment ||
                            destination.id == R.id.lainnyaFragment ||
                            destination.id == R.id.aturModalDialogBuilder
                )
                if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE)
                    toolbar.isVisible = destination.id != R.id.transaksiPenjualanFragment
            }
            bottomNavigationView.setOnItemReselectedListener {
                navController.navigateUp()
                navController.navigate(it.itemId)
            }
        }
    }

    override fun subscribeObservers() {
        viewModel.observeLicense().removeObservers(this)
        viewModel.observeLicense().observe(this){
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        val license = it.firstOrNull()
                        if(license != null){
                            if(license.licExp == null || license.data == "expired"){
                                DialogBuilderHelper.showDialogChoice(this,
                                    "Lisensi Berakhir",
                                    "Maaf Lisensi BeePos Mobile Anda Telah Berakhir, Silahkan Kontak Sales Kami Untuk Informasi Lebih Lanjut atau silahkan tekan tombol retry apabila sudah perpanjang lisensi.",
                                    positiveTxt = "Retry",
                                    positiveListener = {
                                        it.dismiss()
                                        viewModel.reactiveLicense(
                                            BeePreferenceManager.getDataFromPreferences(this, getString(R.string.pref_nama_device), "") as String,
                                            Utils.getVersionName(this),
                                        )
                                    }
                                ).show(supportFragmentManager, "")
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.NOINTERNET -> {

                }
            }
        }
        viewModel.observeReactiveLicense().observe(this){
            when(it.status){
                Resource.Status.LOADING -> {
                    dialogLoading.show()
                }
                Resource.Status.SUCCESS -> {
                    dialogLoading.hide()
                    val license = it.data
                    if(license != null){
                        if(license.licExp == null || license.data == "expired"){
                            DialogBuilderHelper.showDialogChoice(this,
                                "Lisensi Berakhir",
                                "Maaf Lisensi BeePos Mobile Anda Telah Berakhir, Silahkan Kontak Sales Kami Untuk Informasi Lebih Lanjut atau silahkan tekan tombol retry apabila sudah perpanjang lisensi.",
                                positiveTxt = "Retry",
                                positiveListener = {
                                    it.dismiss()
                                    viewModel.reactiveLicense(
                                        BeePreferenceManager.getDataFromPreferences(this, getString(R.string.pref_nama_device), "") as String,
                                        Utils.getVersionName(this),
                                    )
                                }
                            ).show(supportFragmentManager, "")
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    dialogLoading.hide()
                }
                Resource.Status.NOINTERNET -> {
                    dialogLoading.hide()
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        HomeViewModel.UIEvent.NavigateToPos -> {
                            navController.navigate(R.id.mainActivity)
                            navController.navigateUp()
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let { state ->
                        binding.apply {
                            llLicense.isVisible = state.isShowLicense
                            tvLisensi.text = getString(R.string.masa_aktif_lisensi_device_anda_akan_berakhir_,
                                getDateDiff( Date(), state.activeLicense?.licExp ?: Date())
                            )
                        }
                    }
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
                val param = mainHostFragment.layoutParams as MarginLayoutParams
                param.bottomMargin = bottomAppBar.height
                mainHostFragment.layoutParams = param
                bottomAppBar.visible()
                fab.visible()

            } else {
                val param = mainHostFragment.layoutParams as MarginLayoutParams
                param.bottomMargin = 0
                mainHostFragment.layoutParams = param
                bottomAppBar.gone()
                fab.gone()
            }
        }
    }
}

