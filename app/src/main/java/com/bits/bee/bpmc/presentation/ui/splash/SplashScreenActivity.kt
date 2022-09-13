package com.bits.bee.bpmc.presentation.ui.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.databinding.ActivitySplashScreenBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity(
    override val bindingInflater: (LayoutInflater) -> ActivitySplashScreenBinding = ActivitySplashScreenBinding::inflate
) : BaseActivity<ActivitySplashScreenBinding>() {

    private val viewModel :SplashScreenViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper())
            .postDelayed(Runnable {
                val intent = Intent(this, InitialActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000)
    }

    override fun initComponents() {
        val apiKey = BeePreferenceManager.getDataFromPreferences(
            this,
            getString(R.string.api_key),
            ""
        ) as String

        RetrofitClient.API_KEY = apiKey
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

}