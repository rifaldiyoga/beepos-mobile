package com.bits.bee.bpmc.utils

import android.app.Activity
import android.util.DisplayMetrics
import android.util.Log
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.sqrt

@Singleton
class OrientationUtils @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager
) {

    suspend fun getScreenResolution( activity: Activity): String {
        val screenDevice : String
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
        val diagonalInches = sqrt((widthInches * widthInches + heightInches * heightInches).toDouble())
//            val inc = diagonalInches.toString().substring(0, 3)

        //inci layar
        val orientation = beePreferenceManager.posPreferences.first().orientasi

        val isChange = beePreferenceManager.posPreferences.first().isChangeOrientasi
        Log.i("Display Inchies", diagonalInches.toString())

        if (diagonalInches < 6.7 && !isChange) {
            screenDevice = BPMConstants.SCREEN_POTRAIT
            beePreferenceManager.updatePosPreferences(
                beePreferenceManager.posPreferences.first().copy(
                    orientasi = BPMConstants.SCREEN_POTRAIT
                )
            )
        } else if (diagonalInches >= 6.7 && !isChange) {
            screenDevice = BPMConstants.SCREEN_LANDSCAPE
            beePreferenceManager.updatePosPreferences(
                beePreferenceManager.posPreferences.first().copy(
                    orientasi = BPMConstants.SCREEN_LANDSCAPE
                )
            )
        } else {
            if (orientation == BPMConstants.SCREEN_POTRAIT) {
                screenDevice = BPMConstants.SCREEN_POTRAIT
                beePreferenceManager.updatePosPreferences(
                    beePreferenceManager.posPreferences.first().copy(
                        orientasi = BPMConstants.SCREEN_POTRAIT
                    )
                )
            } else {
                screenDevice = BPMConstants.SCREEN_LANDSCAPE
                beePreferenceManager.updatePosPreferences(
                    beePreferenceManager.posPreferences.first().copy(
                        orientasi = BPMConstants.SCREEN_LANDSCAPE
                    )
                )
            }
        }
        return screenDevice
    }


}