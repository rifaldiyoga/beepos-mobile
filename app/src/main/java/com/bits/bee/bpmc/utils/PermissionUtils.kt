package com.bits.bee.bpmc.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat

/**
 * Created by aldi on 13/10/22
 */
class PermissionUtils {

    companion object {
        fun checkPermissionIsGranted(context : Context, @NonNull string: String) : Boolean =
            (ActivityCompat.checkSelfPermission(context, string) == PackageManager.PERMISSION_GRANTED)
    }
}