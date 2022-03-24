package com.bits.bee.bpmc.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Utils

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    //View Binding
    private var _binding : ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> T

    @Suppress("UNCHECKED_CAST")
    protected val binding: T
        get() = _binding as T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)

        //set orientation
        val orientation = if(Utils.getScreenResolution(this).equals(BPMConstants.SCREEN_LANDSCAPE))
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        else ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        requestedOrientation = orientation

        initComponents()
        subscribeListeners()
        subscribeObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun initComponents()

    abstract fun subscribeListeners()

    abstract fun subscribeObservers()

}