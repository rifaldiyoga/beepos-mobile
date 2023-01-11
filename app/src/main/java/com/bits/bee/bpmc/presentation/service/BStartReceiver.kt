package com.bits.bee.bpmc.presentation.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class BStartReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, p1: Intent?) {
        context?.let {
            val request = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()
            WorkManager.getInstance(context).enqueue(request)
        }
    }

}