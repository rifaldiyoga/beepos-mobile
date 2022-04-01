package com.bits.bee.bpmc.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

/**
 * Created by aldi on 01/04/22.
 */
class BeePreferenceManager {

    companion object {
        private lateinit var sharedPreferences : SharedPreferences
        private lateinit var sharedPreferencesEditor : SharedPreferences.Editor

        private fun initPreferences(context: Context){
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        }

        fun saveToPreferences(context : Context, key : String, value : Any) : Boolean {
            initPreferences(context)
            sharedPreferencesEditor = sharedPreferences.edit()
            when(value){
                is Boolean -> sharedPreferencesEditor.putBoolean(key, value)
                is String -> sharedPreferencesEditor.putString(key, value)
                is Int -> sharedPreferencesEditor.putInt(key, value)
                is Long -> sharedPreferencesEditor.putLong(key, value)
                is Float -> sharedPreferencesEditor.putFloat(key, value)
                else -> return false
            }
            sharedPreferencesEditor.commit()
            return true
        }

        fun getDataFromPreferences(context : Context, key : String, value : Any) : Any {
            initPreferences(context)
            when(value){
                is Boolean -> sharedPreferences.getBoolean(key, value)
                is String -> sharedPreferences.getString(key, value)
                is Int -> sharedPreferences.getInt(key, value)
                is Long -> sharedPreferences.getLong(key, value)
                is Float -> sharedPreferences.getFloat(key, value)
                else -> return false
            }
            return true
        }

        fun removeAllSharedPreferences(context: Context): Boolean {
            initPreferences(context)
            sharedPreferencesEditor = sharedPreferences.edit()
            sharedPreferencesEditor.clear()
            return sharedPreferencesEditor.commit()
        }
    }

}