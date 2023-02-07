package com.bits.bee.bpmc.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import com.bits.bee.bpmc.R
import java.io.IOException

/**
 * Created by aldi on 14/03/22.
 */
class ConnectionUtils {

    companion object {
        fun checkInternet(requireContext: Context): Boolean{
            var isConnected = false
            if (!isNetworkAvailable(requireContext)){
                Toast.makeText(requireContext, requireContext.getText(R.string.cek_koneksi_internet), Toast.LENGTH_SHORT).show()
                isConnected = false
            }else if (isNetworkAvailable(requireContext)){
                isConnected = isInternetAvailable()
            }
            return isConnected
        }

        private fun isNetworkAvailable(requireContext: Context): Boolean{
            val connectivityManager = requireContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkCapabilities = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                connectivityManager.activeNetwork
            } else {
                return false
            }
            return connectivityManager.getNetworkCapabilities(networkCapabilities) != null
                    && connectivityManager.getNetworkCapabilities(networkCapabilities)!!.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        }

        fun isInternetAvailable(): Boolean{
            var isconnectInternet = false
            val command = "ping -c 1 google.com"
            val runtime = Runtime.getRuntime()
            try {
                val ipProcess = runtime.exec(command)
                val exitValue = ipProcess.waitFor()
                isconnectInternet = exitValue == 0
                return isconnectInternet
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return isconnectInternet
        }
    }

}