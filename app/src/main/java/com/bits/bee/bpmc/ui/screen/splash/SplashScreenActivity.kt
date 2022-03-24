package com.bits.bee.bpmc.ui.screen.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.bits.bee.bpmc.databinding.ActivitySplashScreenBinding
import com.bits.bee.bpmc.ui.base.BaseActivity
import com.bits.bee.bpmc.ui.screen.initial.InitialActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity(
    override val bindingInflater: (LayoutInflater) -> ActivitySplashScreenBinding = ActivitySplashScreenBinding::inflate
) : BaseActivity<ActivitySplashScreenBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper())
            .postDelayed(Runnable {
                val intent = Intent(this, InitialActivity::class.java)
                startActivity(intent)
                finish()
            }, 5000)
    }

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

}