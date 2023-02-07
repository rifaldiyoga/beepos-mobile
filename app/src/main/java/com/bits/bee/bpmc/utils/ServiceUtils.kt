package com.bits.bee.bpmc.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.bits.bee.bpmc.presentation.service.BStartReceiver
import kotlinx.coroutines.flow.first
import java.lang.String
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class ServiceUtils @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
){

    suspend fun startUploadService(context : Context) {
            val prefsRepeatTime = beePreferenceManager.sistemPreferences.first().periodeUpload.replace(" Menit", "")
            val repeatVal = BigDecimal(prefsRepeatTime).multiply(BigDecimal("60")).multiply(BigDecimal("1000"))
            val repeatTime = repeatVal.toLong()
            val i = Intent(context, BStartReceiver::class.java)
            val pendingIntent: PendingIntent? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_IMMUTABLE)
            } else {
                PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT)
            }
            val cal = Calendar.getInstance()
            cal.add(Calendar.SECOND, 30)
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.timeInMillis, repeatTime, pendingIntent)
            Log.i("SCHEDULERECV", "REPEATTIME:" + String.valueOf(repeatTime))
    }

}