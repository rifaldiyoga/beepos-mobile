package com.bits.bee.bpmc.presentation.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.goAsync
import kotlinx.coroutines.flow.first
import java.lang.String
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject
import kotlin.Long
import kotlin.let


class BSchedulerReceiver @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) : BroadcastReceiver() {

    private var REPEAT_TIME: Long = 15000

    override fun onReceive(context: Context?, intent: Intent?) = goAsync() {
        context?.let {
            val extras = intent?.extras
            if (extras != null && extras.getString("broadcaster").equals("signal_on", ignoreCase = true)) {
                val prefsRepeatTime = beePreferenceManager.sistemPreferences.first().periodeUpload.toLong()
                val repeatVal = BigDecimal(prefsRepeatTime).multiply(BigDecimal("1000"))
                REPEAT_TIME = repeatVal.toLong()
                val i = Intent(context, BStartReceiver::class.java)
                var pendingIntent: PendingIntent? = null
                pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_IMMUTABLE)
                } else {
                    PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT)
                }
                val cal = Calendar.getInstance()
                cal.add(Calendar.SECOND, 30)
//                context.getSystemService(Context.ALARM_SERVICE).ine(AlarmManager.RTC_WAKEUP, cal.timeInMillis, REPEAT_TIME, pendingIntent)
                Log.i("SCHEDULERECV", "REPEATTIME:" + String.valueOf(REPEAT_TIME))
            }
        }

    }

}