package com.bits.bee.bpmc.presentation.ui.splash

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.databinding.ActivitySplashScreenBinding
import com.bits.bee.bpmc.presentation.base.BaseActivity
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        lifecycleScope.launchWhenStarted {
            viewModel.posPreferences.collect {
                if(it.orientasi.isEmpty()){
                    viewModel.onUpdateOrientation(Utils.getScreenResolution(this@SplashScreenActivity))
                } else {
                    BeePreferenceManager.ORIENTATION = it.orientasi
                }
                val orientation = if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE)
                    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                else ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                requestedOrientation = orientation
            }
        }
    }

}