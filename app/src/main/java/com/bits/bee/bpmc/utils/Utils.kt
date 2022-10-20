package com.bits.bee.bpmc.utils

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.text.TextUtils
import android.util.DisplayMetrics
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse.Db
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.User
import kotlinx.coroutines.flow.first
import rx.Observable.Operator
import java.io.File
import java.util.concurrent.ConcurrentLinkedDeque


/**
 * Created by aldi on 01/03/22.
 */
class Utils {

    companion object {

        suspend fun getScreenResolution(beePreferenceManager: BeePreferenceManager, activity: Activity): String {
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

            val orientation = beePreferenceManager.posPreferences.first().orientasi

            val isChange = beePreferenceManager.posPreferences.first().isChangeOrientasi

            if (diagonalInches < 6.5 && !isChange) {
                screenDevice = BPMConstants.SCREEN_POTRAIT
                beePreferenceManager.updatePosPreferences(
                    beePreferenceManager.posPreferences.first().copy(
                        orientasi = BPMConstants.SCREEN_POTRAIT
                    )
                )
            } else if (diagonalInches >= 6.5 && !isChange) {
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

        fun isValidEmail(target : CharSequence) : Boolean {
            return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }

        fun getVersionName(context: Context): String {
            return context.packageManager.getPackageInfo(context.packageName, 0).versionName
        }

        fun deleteApplicationData(context: Context) {
            try {
                val packageName = context.applicationContext.packageName
                val runtime = Runtime.getRuntime()
                runtime.exec("pm clear $packageName")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun clearApplicationData(context: Context) {
            val cacheDirectory: File = context.cacheDir
            val applicationDirectory = cacheDirectory.parent?.let { File(it) }
            if (applicationDirectory != null && applicationDirectory.exists()) {
                val fileNames: Array<String> = applicationDirectory.list() as Array<String>
                for (fileName in fileNames) {
                    if (fileName != "lib") {
                        deleteFile(File(applicationDirectory, fileName))
                    }
                }
            }
        }

        private fun deleteFile(file: File?): Boolean {
            var deletedAll = true
            if (file != null) {
                if (file.isDirectory) {
                    val children: Array<String> = file.list()
                    for (i in children.indices) {
                        deletedAll = deleteFile(File(file, children[i])) && deletedAll
                    }
                } else {
                    deletedAll = file.delete()
                }
            }
            return deletedAll
        }

    }

}