package com.bits.bee.bpmc.presentation.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bits.bee.bpmc.utils.extension.showNotifications
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UploadWorker @Inject constructor(
    @ApplicationContext private val context : Context,
    private val params : WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            showNotifications(context, "Tes worker")
            Result.success()
        } catch (e : Exception){
            e.printStackTrace()
            Result.failure()
        }
    }

}