package com.bits.bee.bpmc.presentation.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bits.bee.bpmc.utils.ImageUtils

class DownloadImageWorker constructor(
    private val context : Context,
    private val params : WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            val objKey = inputData.getString("objKey") ?: ""
            val bucketKey = inputData.getString("bucketKey") ?: ""
            ImageUtils.downloadImage(bucketKey, objKey)
            Result.success()
        } catch (e : Exception) {
            Result.failure()
        }
    }

}