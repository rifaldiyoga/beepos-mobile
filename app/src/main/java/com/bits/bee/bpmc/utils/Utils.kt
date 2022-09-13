package com.bits.bee.bpmc.utils

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.util.DisplayMetrics
import androidx.preference.PreferenceManager
import com.bits.bee.bpmc.R

/**
 * Created by aldi on 01/03/22.
 */
class Utils {

    companion object {

        fun getScreenResolution(activity: Activity): String {
            var screenDevice : String
            val metrics = DisplayMetrics()
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                val display = activity.display
                display?.getRealMetrics(metrics)
            } else {
                @Suppress("DEPRECATION")
                val display = activity.windowManager.defaultDisplay
                @Suppress("DEPRECATION")
                display.getMetrics(metrics)
            }
            val widthPixels = metrics.widthPixels
            val heightPixels = metrics.heightPixels
            val widthDpi = metrics.xdpi
            val heightDpi = metrics.ydpi
            val widthInches = widthPixels / widthDpi
            val heightInches = heightPixels / heightDpi
            val diagonalInches = Math.sqrt((widthInches * widthInches + heightInches * heightInches).toDouble())
//            val inc = diagonalInches.toString().substring(0, 3)

            //inci layar
            val orientation: String = PreferenceManager.getDefaultSharedPreferences(activity)
                .getString(
                    activity.getString(R.string.pref_screen_orientation),
                    BPMConstants.SCREEN_LANDSCAPE
                ) ?: BPMConstants.SCREEN_LANDSCAPE

            val isChange: Boolean = PreferenceManager.getDefaultSharedPreferences(activity)
                .getBoolean(activity.getString(R.string.pref_is_change_screen_orientation), false)

            if (diagonalInches < 6.5 && !isChange) {
                screenDevice = BPMConstants.SCREEN_POTRAIT
                PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(
                    activity.resources.getString(R.string.pref_screen_orientation),
                    BPMConstants.SCREEN_POTRAIT
                ).apply()
            } else if (diagonalInches >= 6.5 && !isChange) {
                screenDevice = BPMConstants.SCREEN_LANDSCAPE
                PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(
                    activity.resources.getString(R.string.pref_screen_orientation),
                    BPMConstants.SCREEN_LANDSCAPE
                ).apply()
            } else {
                if (orientation == BPMConstants.SCREEN_POTRAIT) {
                    screenDevice = BPMConstants.SCREEN_POTRAIT
                    PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(
                        activity.resources.getString(R.string.pref_screen_orientation),
                        BPMConstants.SCREEN_POTRAIT
                    ).apply()
                } else {
                    screenDevice = BPMConstants.SCREEN_LANDSCAPE
                    PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(
                        activity.resources.getString(R.string.pref_screen_orientation),
                        BPMConstants.SCREEN_LANDSCAPE
                    ).apply()
                }
            }
            return BPMConstants.SCREEN_POTRAIT.also { screenDevice = it }
        }

        fun isValidEmail(target : CharSequence) : Boolean {
            return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }

        fun getVersionName(context: Context): String {
            return context.packageManager.getPackageInfo(context.packageName, 0).versionName
        }

    }

}