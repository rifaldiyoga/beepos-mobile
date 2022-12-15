package com.bits.bee.bpmc.presentation.ui.initial

import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
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
import com.bits.bee.bpmc.databinding.ActivityInitialBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 10/03/22.
 */

@AndroidEntryPoint
class InitialActivity (
    override val bindingInflater: (LayoutInflater) -> ActivityInitialBinding = ActivityInitialBinding::inflate
) : BaseActivity<ActivityInitialBinding>() {

    private val viewModel : InitialViewModel by viewModels()

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
                toolbar.isVisible = navController.currentDestination?.id != R.id.initialFragment && navController.currentDestination?.id != R.id.walkThroughFragment
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

    override fun onBackPressed() {
        when(navController.currentDestination?.id){
            R.id.loginOperatorFragment -> {
                viewModel.onBackOperator()
            }
            R.id.pilihKasirFragment -> onBack(R.id.pilihKasirFragment, R.id.pilihCabangFragment)
            R.id.pilihCabangFragment -> onBack(R.id.pilihCabangFragment, R.id.modeTampilanFragment)
            R.id.pilihDbFragment -> {
                val dialog = DialogBuilderHelper.showDialogChoice(
                    this,
                    getString(R.string.yakin_akan_keluar), getString(R.string.konfirmasi_keluar),
                    positiveTxt = getString(R.string.batal),
                    positiveListener = {
                        it.dismiss()
                    },
                    negativeTxt = getString(R.string.keluar),
                    negativeListener = {
                        it.dismiss()
                        super.onBackPressed()
                    }
                )
                dialog.show(supportFragmentManager, TAG)
            }
            R.id.namaDeviceFragment -> {
                val dialog = DialogBuilderHelper.showDialogChoice(
                    this,
                    getString(R.string.yakin_akan_keluar), getString(R.string.konfirmasi_keluar),
                    positiveTxt = getString(R.string.batal),
                    positiveListener = {
                        it.dismiss()
                    },
                    negativeTxt = getString(R.string.keluar),
                    negativeListener = {
                        it.dismiss()
                        super.onBackPressed()
                    }
                )
                dialog.show(supportFragmentManager, TAG)
            }
            R.id.ulangiPinFragment -> onBack(R.id.ulangiPinFragment, R.id.aturPinFragment)
            R.id.tambahProdukFragment -> onBack(R.id.tambahProdukFragment, R.id.aturProdukFragment)
            else -> super.onBackPressed()
        }
    }

    fun onBack(currentDest : Int, dest : Int){
        navController.popBackStack(currentDest, true)
        navController.navigate(dest )

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        InitialViewModel.UIEvent.RequestConfirmKasir -> {
                            val dialog = DialogBuilderHelper.showDialogChoice(this@InitialActivity,
                                getString(R.string.konfirmasi), getString(R.string.yakin_ganti_kasir), positiveListener = {
                                    it.dismiss()
                                    if (ConnectionUtils.checkInternet(this@InitialActivity)){
                                        viewModel.deActiveStatusKasir(this@InitialActivity)
                                    }
                                }
                            )
                            dialog.show(supportFragmentManager, TAG)
                        }
                        is InitialViewModel.UIEvent.RequestDialogWarning -> {
                            val dialog = DialogBuilderHelper.showDialogInfo(
                                this@InitialActivity,
                                title = "Perhatian",
                                msg = it.msg,
                                positiveTxt = getString(R.string.ya),
                                positiveListener = {
                                    it.dismiss()
                                }
                            )
                            dialog.show(supportFragmentManager,"")
                        }
                    }
                }
            }
        }
        viewModel.observeCashierStatusResponse().removeObservers(this)
        viewModel.observeCashierStatusResponse().observe(this){
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        if (it.data.status_cashier){
                            viewModel.updateCashier()
                            onBack(R.id.loginOperatorFragment, R.id.pilihKasirFragment)
                        }else{
                            Toast.makeText(this@InitialActivity, "Gagal Proses Detach", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this@InitialActivity, "${it.message}", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.NOINTERNET -> TODO()
            }
        }
    }

}