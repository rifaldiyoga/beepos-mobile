package com.bits.bee.bpmc.presentation.base

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.OrientationUtils
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity(), BaseInterface {

    //View Binding
    private var _binding : ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> T

    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    @Inject
    lateinit var orientationUtils: OrientationUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)

        //set orientation
        lifecycleScope.launchWhenStarted {
            val ori = orientationUtils.getScreenResolution(this@BaseActivity)
            BeePreferenceManager.ORIENTATION = ori
            val orientation = if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE)
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            else
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            requestedOrientation = orientation
        }


        initComponents()
        subscribeListeners()
        subscribeObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResume() {
        val orientation = if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE)
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        else
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        requestedOrientation = orientation
        Log.i("OnResume", "Activity")
        super.onResume()
    }

    abstract override fun initComponents()

    abstract override fun subscribeListeners()

    abstract override fun subscribeObservers()

    override fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showSnackbarWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    ) {
        val snackBar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.setActionTextColor(ContextCompat.getColor(this, R.color.red))
        snackBar.show()
    }

    override fun showToast(message: Int) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setTheme(R.style.Theme_BeeposMobile)
    }

}