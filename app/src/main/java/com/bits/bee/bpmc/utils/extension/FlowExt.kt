package com.bits.bee.bpmc.utils.extension

import androidx.activity.ComponentActivity
import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip
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

fun <T, R> zips(
    vararg flows: Flow<T>,
    transform: suspend (List<T>) -> R
): Flow<R> = when(flows.size) {
    0 -> error("No flows")
    1 -> flows[0].map{ transform(listOf(it)) }
    2 -> flows[0].zip(flows[1]) { a, b -> transform(listOf(a, b)) }
    else -> {
        var accFlow: Flow<List<T>> = flows[0].zip(flows[1]) { a, b -> listOf(a, b) }
        for (i in 2 until flows.size) {
            accFlow = accFlow.zip(flows[i]) { list, it ->
                list + it
            }
        }
        accFlow.map(transform)
    }
}