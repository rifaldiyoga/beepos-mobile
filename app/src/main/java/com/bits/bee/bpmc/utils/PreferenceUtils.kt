package com.bits.bee.bpmc.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aldi on 22/03/22.
 */
@Singleton
class PreferenceUtils @Inject constructor(@ApplicationContext  val context : Context) {

    private var sharedPreferences : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    companion object{
        const val DEVICE_NAME : String = "DEVICE_NAME"
    }

    fun putDeviceName(value: String) {
        sharedPreferences.edit().putString(DEVICE_NAME, value).apply()
    }

    fun getDeviceName(key : String) : String {
        return sharedPreferences.getString(DEVICE_NAME, "") ?: ""
    }



}