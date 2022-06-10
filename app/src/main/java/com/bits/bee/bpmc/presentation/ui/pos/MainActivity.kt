package com.bits.bee.bpmc.presentation.ui.pos

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
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
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import com.facebook.stetho.Stetho
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        initStetho()

        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        binding.apply {
            setSupportActionBar(toolbar)
            navController.addOnDestinationChangedListener { _, _, _ ->
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back)
            }
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
            navController.addOnDestinationChangedListener { _, destination, _ ->
                setVisibilityToolbar(destination.id == R.id.invoiceFragment || destination.id == R.id.posFragment || destination.id == R.id.editItemDialog)
            }
        }
    }

    override fun subscribeObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.channel?.let {
                                tvChannel.text = it.name
                                ImageViewCompat.setImageTintList(imageChannel, ColorStateList.valueOf(
                                    Color.parseColor(it.color)))
                            }
                            it.bp?.let {
                                tvMember.text = it.name
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
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            channel = channel
                                        )
                                    )
                                }
                            )
                            dialog.show(supportFragmentManager, TAG)
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

    private fun setVisibilityToolbar(isShow : Boolean){
        binding.apply {
            if(isShow)
                linearLayout10.visible()
            else
                linearLayout10.gone()
        }
    }
}