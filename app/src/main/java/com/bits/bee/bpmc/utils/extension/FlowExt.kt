package com.bits.bee.bpmc.utils.extension

import androidx.activity.ComponentActivity
import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 28/03/22.
 */

fun LifecycleOwner.collectLifecycleFlow(collect : suspend () -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED){
            collect
        }
    }
}