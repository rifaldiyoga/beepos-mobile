package com.bits.bee.bpmc.presentation.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.goAsync
import javax.inject.Inject


class BSchedulerReceiver @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : BroadcastReceiver() {

    private var REPEAT_TIME: Long = 15000

    override fun onReceive(context: Context?, intent: Intent?) = goAsync() {

    }

}