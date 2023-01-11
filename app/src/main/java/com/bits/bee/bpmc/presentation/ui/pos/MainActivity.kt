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
import com.bits.bee.bpmc.presentation.dialog.diskon_nota.DiskonNotaDialog
import com.bits.bee.bpmc.presentation.service.BluetoothConnectService
import com.bits.bee.bpmc.presentation.ui.pos.channel.ChannelListDialogBuilder
import com.bits.bee.bpmc.presentation.ui.pos.pos.TAG
import com.bits.bee.bpmc.utils.extension.getColorFromAttr
import com.facebook.stetho.Stetho
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

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
    private var isDialogShow : Boolean = false

    @Inject
    lateinit var bluetoothConnectService: BluetoothConnectService

    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenStarted {
            bluetoothConnectService.onEventConnectAllPrinter(0)
        }
    }

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
                if (navController.currentDestination?.id == R.id.posFragment || navController.currentDestination?.id == R.id.transaksiBerhasilFragment) {
                    toolbar.navigationIcon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_back_white)
                    toolbar.setNavigationOnClickListener {
                        if (navController.currentDestination?.id == R.id.posFragment)
                            finish()
                        if (navController.currentDestination?.id == R.id.transaksiBerhasilFragment) {

                        }
                    }
                } else {
                    toolbar.setNavigationOnClickListener {
                        onBackPressed()
                    }
                }
                setVisibilityToolbar(destination.id, navController.previousBackStackEntry?.destination?.id)
                setBackgroundToolbar(destination.id)
                if(navController.currentDestination?.id == R.id.transaksiBerhasilFragment) {
                    toolbar.navigationIcon = null
                }
                when (navController.currentDestination?.id) {
                    R.id.cariItemFragment, R.id.posFragment -> {
                        toolbar.collapseIcon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_back_white)
                    }
                    R.id.draftFragment, R.id.memberFragment, R.id.salesmanFragment -> {
                        toolbar.collapseIcon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_back_black)
                    }
                    else -> {
                        toolbar.collapseIcon = null
                    }
                }
            }
        }
    }

    override fun subscribeObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.msg.collect {
                if(it.isNotEmpty())
                    showSnackbar(it)
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.activeSrep.collect {
                    binding.apply {
                        it?.let {
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

        lifecycleScope.launchWhenStarted {
            viewModel.event.collect {
                when(it){
                    MainViewModel.UIEvent.RequestMember -> {
                        navController.navigateUp()
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
                    is MainViewModel.UIEvent.NavigateToDiskonNota -> {
                        if(!isDialogShow) {
                            val dialog = DiskonNotaDialog(it.tipe, onDismis = {
                                isDialogShow = false
                            })

                            dialog.show(supportFragmentManager, "")
                            isDialogShow = true
                        }
                    }
                    MainViewModel.UIEvent.NavigateToDraft -> {
                        navController.navigateUp()
                        navController.navigate(R.id.draftListDialog)
                    }
                    MainViewModel.UIEvent.NavigateToSearch -> {
                        navController.navigateUp()
                        navController.navigate(R.id.cariItemFragment)
                    }
                    MainViewModel.UIEvent.NavigateToPromo -> {
                        navController.navigateUp()
                        navController.navigate(R.id.promoFragment)
                    }
                    MainViewModel.UIEvent.RequestSalesman -> {
                        navController.navigateUp()
                        navController.navigate(R.id.salesmanFragment)
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

    private fun setVisibilityToolbar(destinationId: Int, prevDestinationId: Int? = null){
        binding.apply {
            val isVisible = destinationId == R.id.diskonNotaDialog
                    || destinationId == R.id.posFragment || destinationId == R.id.draftListDialog || destinationId == R.id.invoiceFragment
                    || (prevDestinationId == R.id.posFragment && destinationId == R.id.detailAddOnDialogBuilder)
            linearLayout10.isVisible = isVisible
        }
    }

    private fun setBackgroundToolbar(destinationId : Int){
        val dest = listOf(
            R.id.draftFragment,
            R.id.transaksiBerhasilFragment,
            R.id.memberFragment,
            R.id.klaimPromoFragment,
            R.id.tambahMemberFragment,
            R.id.salesmanFragment,
            R.id.detailSalesmanFragment,
            R.id.hakAksesFragment
        )

        if(dest.contains(destinationId)) {
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.white
                    )
                )
            )
            binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.black))
            binding.toolbar.navigationIcon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_back_black)
            binding.toolbar.context.setTheme(R.style.MySearchViewStyleBlack)
        } else {
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    getColorFromAttr(R.attr.colorPrimary)
                )
            )
            binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
            binding.toolbar.navigationIcon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_back_white)
            binding.toolbar.context.setTheme(R.style.MySearchViewStyleWhite)
        }
    }

    private fun showSalesman(isVisible : Boolean) {
        binding.apply {
            viewSalesman.isVisible = isVisible
            clSalesman.isVisible = isVisible
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun getToolbar() : Toolbar = binding.toolbar
}