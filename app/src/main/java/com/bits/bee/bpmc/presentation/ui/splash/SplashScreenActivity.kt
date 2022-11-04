package com.bits.bee.bpmc.presentation.ui.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bits.bee.bpmc.BuildConfig
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.databinding.ActivitySplashScreenBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity(
    override val bindingInflater: (LayoutInflater) -> ActivitySplashScreenBinding = ActivitySplashScreenBinding::inflate
) : BaseActivity<ActivitySplashScreenBinding>() {

    private val viewModel :SplashScreenViewModel by viewModels()

    override fun initComponents() {
        val apiKey = BeePreferenceManager.getDataFromPreferences(
            this,
            getString(R.string.api_key),
            ""
        ) as String

        RetrofitClient.API_KEY = apiKey
        Handler(Looper.getMainLooper())
            .postDelayed({
                val intent = Intent(this, InitialActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
        binding.splashscreenTvVersion.text = BuildConfig.VERSION_NAME
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        lifecycleScope.launchWhenStarted {
            val ori = Utils.getScreenResolution(viewModel.beePreferenceManager, this@SplashScreenActivity)
            BeePreferenceManager.ORIENTATION = ori
        }
    }

}