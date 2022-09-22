package com.bits.bee.bpmc.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.preference.PreferenceManager
import com.bits.bee.bpmc.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aldi on 01/04/22.
 */

private const val TAG = "BeePreferenceManager"

@Singleton
class BeePreferenceManager @Inject constructor(@ApplicationContext private val context: Context){

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = BeePreferenceManager.DATASTORE_NAME)

    companion object {
        private val DATASTORE_NAME = "${BuildConfig.APPLICATION_ID}_${BeePreferenceManager::class.java.simpleName}_DATASTORE"

        var ORIENTATION = BPMConstants.SCREEN_POTRAIT

        private lateinit var sharedPreferences : SharedPreferences
        private lateinit var sharedPreferencesEditor : SharedPreferences.Editor

        private fun initPreferences(context: Context) {
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

        fun getDataFromPreferences(context : Context, key : String, value : Any) : Any? {
            initPreferences(context)
            return when(value){
                is Boolean -> sharedPreferences.getBoolean(key, value)
                is String -> sharedPreferences.getString(key, value.toString())
                is Int -> sharedPreferences.getInt(key, value.toInt())
                is Long -> sharedPreferences.getLong(key, value.toLong())
                is Float -> sharedPreferences.getFloat(key, value.toFloat())
                else -> false
            }
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

    val posPreferences = context.dataStore.data
        .catch {
            if (it is IOException) {
                Log.e(TAG, "Error reading preferences", it)
            } else {
                throw it
            }
        }.map {
            val ukuranFont = it[PreferenceKeys.UKURAN_FONT] ?: "Medium"
            val isMultiLine = it[PreferenceKeys.ISMULTILINE] ?: false
            val isKonfirmasiCust = it[PreferenceKeys.ISKONFIRMASICUST] ?: false
            val customer = it[PreferenceKeys.CUSTOMER] ?: "Nama"
            val jumlahMeja = it[PreferenceKeys.JUMLAH_MEJA] ?: "10"
            val presetBukaKasir = it[PreferenceKeys.PRESET_BUKA_KASIR] ?: "100000"
            val isMuatGambar = it[PreferenceKeys.IS_MUAT_GAMBAR] ?: false
            val orientasi = it[PreferenceKeys.ORIENTASI] ?: ""
            ORIENTATION = orientasi
            PosPreferences(ukuranFont, isMultiLine, isKonfirmasiCust, customer, jumlahMeja, presetBukaKasir, isMuatGambar, orientasi)
        }

    suspend fun updatePosPreferences(posPreferences: PosPreferences) {
        context.dataStore.edit {
            it[PreferenceKeys.UKURAN_FONT] = posPreferences.ukuranFont
            it[PreferenceKeys.ISMULTILINE] = posPreferences.isMultiLine
            it[PreferenceKeys.ISKONFIRMASICUST] = posPreferences.isKonfirmasiCust
            it[PreferenceKeys.CUSTOMER] = posPreferences.customer
            it[PreferenceKeys.JUMLAH_MEJA] = posPreferences.jumlahMeja
            it[PreferenceKeys.PRESET_BUKA_KASIR] = posPreferences.presetBukaKasir
            it[PreferenceKeys.IS_MUAT_GAMBAR] = posPreferences.isMuatGambar
            it[PreferenceKeys.ORIENTASI] = posPreferences.orientasi
            ORIENTATION = posPreferences.orientasi
        }
    }

    data class PosPreferences(
        val ukuranFont : String,
        val isMultiLine : Boolean,
        val isKonfirmasiCust : Boolean,
        val customer : String,
        val jumlahMeja : String,
        val presetBukaKasir : String,
        val isMuatGambar : Boolean,
        val orientasi : String,
    )

    private object PreferenceKeys {
        val UKURAN_FONT = stringPreferencesKey("${DATASTORE_NAME}_UKURAN_FONT")
        val ISMULTILINE = booleanPreferencesKey("${DATASTORE_NAME}_ISMULTILINE")
        val ISKONFIRMASICUST = booleanPreferencesKey("${DATASTORE_NAME}_ISKONFIRMASICUST")
        val CUSTOMER = stringPreferencesKey("${DATASTORE_NAME}_CUSTOMER")
        val JUMLAH_MEJA = stringPreferencesKey("${DATASTORE_NAME}_JUMLAH_MEJA")
        val PRESET_BUKA_KASIR = stringPreferencesKey("${DATASTORE_NAME}_PRESET_BUKA_KASIR")
        val IS_MUAT_GAMBAR = booleanPreferencesKey("${DATASTORE_NAME}_IS_MUAT_GAMBAR")
        val ORIENTASI = stringPreferencesKey("${DATASTORE_NAME}_ORIENTASI")
    }

}