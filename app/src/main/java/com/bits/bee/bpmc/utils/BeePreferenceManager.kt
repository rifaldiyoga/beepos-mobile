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
            sharedPreferencesEditor.apply()
            return true
        }

        fun getDataFromPreferences(context : Context, key : String, value : Any) : Any {
            initPreferences(context)
            return when(value){
                is Boolean -> sharedPreferences.getBoolean(key, value)
                is String -> sharedPreferences.getString(key, value.toString())
                is Int -> sharedPreferences.getInt(key, value.toInt())
                is Long -> sharedPreferences.getLong(key, value.toLong())
                is Float -> sharedPreferences.getFloat(key, value.toFloat())
                else -> false
            }!!
        }

        fun removeSomeKey(context: Context, key: String,  value : Any): Any{
            initPreferences(context)
            sharedPreferencesEditor = sharedPreferences.edit()
            return when(value){
                is Boolean -> sharedPreferencesEditor.remove(key)
                is String -> sharedPreferencesEditor.remove(key)
                is Int -> sharedPreferencesEditor.remove(key)
                is Long -> sharedPreferencesEditor.remove(key)
                is Float -> sharedPreferencesEditor.remove(key)
                else -> false
            }!!
        }

        fun removeAllSharedPreferences(context: Context): Boolean {
            initPreferences(context)
            sharedPreferencesEditor = sharedPreferences.edit()
            sharedPreferencesEditor.clear()
            return sharedPreferencesEditor.commit()
        }
    }

}