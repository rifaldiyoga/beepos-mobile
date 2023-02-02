package com.bits.bee.bpmc.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.bits.bee.bpmc.BuildConfig
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.databinding.ActivitySplashScreenBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.ServiceUtils
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class
SplashScreenActivity(
    override val bindingInflater: (LayoutInflater) -> ActivitySplashScreenBinding = ActivitySplashScreenBinding::inflate
) : BaseActivity<ActivitySplashScreenBinding>() {

    private val viewModel :SplashScreenViewModel by viewModels()

    @Inject
    lateinit var serviceUtils: ServiceUtils

    override fun initComponents() {
        val apiKey = BeePreferenceManager.getDataFromPreferences(this, getString(R.string.api_key), "") as String
        RetrofitClient.API_KEY = apiKey
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, InitialActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        binding.splashscreenTvVersion.text = BuildConfig.VERSION_NAME
        lifecycleScope.launchWhenStarted {
            serviceUtils.startUploadService(this@SplashScreenActivity)
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        lifecycleScope.launchWhenStarted {
//
            viewModel.bluetoothConnectService.onEventConnectAllPrinter(0)
        }
    }

}