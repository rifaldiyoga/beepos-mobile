package com.bits.bee.bpmc.presentation.ui.pos

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.ImageViewCompat
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
import com.bits.bee.bpmc.databinding.ActivityMainBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.ui.pos.channel.ChannelListDialogBuilder
import com.bits.bee.bpmc.presentation.ui.pos.pos.TAG
import com.bits.bee.bpmc.utils.extension.getColorFromAttr
import com.facebook.stetho.Stetho
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by aldi on 07/04/22.
 */

@AndroidEntryPoint
class MainActivity(
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
) : BaseActivity<ActivityMainBinding>() {

    private val viewModel : MainViewModel by viewModels()

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initComponents() {
        viewModel.saleTrans.newTrans()
        viewModel.loadData()
        viewModel.initPromo()

        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        initStetho()

        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            setSupportActionBar(toolbar)

            NavigationUI.setupActionBarWithNavController(this@MainActivity, navController, appBarConfiguration)
            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)
            toolbar.setNavigationOnClickListener {
                if(navController.currentDestination?.id == R.id.posFragment)
                    finish()
            }
            navController.addOnDestinationChangedListener { _, _, _ ->
                toolbar.setNavigationIcon(R.drawable.ic_back_white)
            }
        }
    }


    override fun subscribeListeners() {
        binding.apply {
            clChannel.setOnClickListener {
                viewModel.onClickChannel()
            }
            clMember.setOnClickListener {
                viewModel.onClickMember()
            }
            clSalesman.setOnClickListener {
                viewModel.onClickSalesman()
            }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                setVisibilityToolbar(destination.id)
                setBackgroundToolbar(destination.id)
            }
        }
    }

    override fun subscribeObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.activeSrep.collect {
                    binding.apply {
                        it?.let {
//                            viewModel.state.sale.bpId = it.id!!
//                            viewModel.state.sale.bpName = it.name
                            tvSalesman.text = it.name
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.activeBp.collect {
                    binding.apply {
                        it?.let {
                            viewModel.state.sale.bpId = it.id!!
                            viewModel.state.sale.bpName = it.name
                            tvMember.text = it.name
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.activeChannel.collect {
                    binding.apply {
                        it?.let { channel ->
                            viewModel.state.sale.channelId = channel.id
                            tvChannel.text = channel.name
                            channel.color?.let { color ->
                                if(color.isNotEmpty())
                                    ImageViewCompat.setImageTintList(imageChannel, ColorStateList.valueOf(
                                        Color.parseColor(color)))
                            }
                        }
                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect {
                    when(it){
                        MainViewModel.UIEvent.RequestMember -> {
                            navController.navigate(R.id.memberFragment)
                        }
                        MainViewModel.UIEvent.RequestChannel -> {
                            val dialog = ChannelListDialogBuilder(
                                viewModel.state.channelList,
                                onChannelClick = { channel ->
                                    viewModel.updateActiveChannel(channel)
                                }
                            )
                            dialog.show(supportFragmentManager, TAG)
                        }
                        MainViewModel.UIEvent.NavigateToDiskonNota -> {
                            navController.navigate(R.id.diskonNotaDialog)
                        }
                        MainViewModel.UIEvent.NavigateToDraft -> {
                            navController.navigate(R.id.draftListDialog)
                        }
                        MainViewModel.UIEvent.NavigateToSearch -> {
                            navController.navigate(R.id.cariItemFragment)
                        }
                        MainViewModel.UIEvent.NavigateToPromo -> {
                            navController.navigate(R.id.promoFragment)
                        }
                        MainViewModel.UIEvent.RequestSalesman -> {
                            navController.navigate(R.id.salesmanFragment)
                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.posModeState.collect {
                    when(it){
                        PosModeState.FnBState -> {
                            showSalesman(false)
                        }
                        PosModeState.RetailState -> {
                            showSalesman(true)
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

    private fun initStetho(){
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        )
    }

    private fun setVisibilityToolbar(destinationId: Int){
        binding.apply {
            val isVisible = destinationId == R.id.diskonNotaDialog || destinationId == R.id.invoiceFragment
                    || destinationId == R.id.posFragment || destinationId == R.id.draftListDialog
            linearLayout10.isVisible = isVisible
        }
    }

    private fun setBackgroundToolbar(destinationId : Int){
        if(destinationId == R.id.draftFragment || destinationId == R.id.transaksiBerhasilFragment
            || destinationId == R.id.klaimPromoFragment || destinationId == R.id.tambahMemberFragment
            || destinationId == R.id.memberFragment || destinationId == R.id.salesmanFragment || destinationId == R.id.detailSalesmanFragment) {
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.white
                    )
                )
            )
            binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.black))
            binding.toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.black))
            binding.toolbar.context.setTheme(R.style.MySearchViewStyleBlack)
        } else {
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    getColorFromAttr(R.attr.colorPrimary)
                )
            )
            binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
            binding.toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.white))
            binding.toolbar.context.setTheme(R.style.MySearchViewStyleWhite)
        }
    }

    private fun showSalesman(isVisible : Boolean) {
        binding.apply {
            viewSalesman.isVisible = isVisible
            clSalesman.isVisible = isVisible
        }
    }
}