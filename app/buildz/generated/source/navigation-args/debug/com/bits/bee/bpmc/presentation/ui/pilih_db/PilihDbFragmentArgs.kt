package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class PilihDbFragmentArgs(
  public val username: String,
  public val password: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("username", this.username)
    result.putString("password", this.password)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("username", this.username)
    result.set("password", this.password)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): PilihDbFragmentArgs {
      bundle.setClassLoader(PilihDbFragmentArgs::class.java.classLoader)
      val __username : String?
      if (bundle.containsKey("username")) {
        __username = bundle.getString("username")
        if (__username == null) {
          throw IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"username\" is missing and does not have an android:defaultValue")
      }
      val __password : String?
      if (bundle.containsKey("password")) {
        __password = bundle.getString("password")
        if (__password == null) {
          throw IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"password\" is missing and does not have an android:defaultValue")
      }
      return PilihDbFragmentArgs(__username, __password)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PilihDbFragmentArgs {
      val __username : String?
      if (savedStateHandle.contains("username")) {
        __username = savedStateHandle["username"]
        if (__username == null) {
          throw IllegalArgumentException("Argument \"username\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"username\" is missing and does not have an android:defaultValue")
      }
      val __password : String?
      if (savedStateHandle.contains("password")) {
        __password = savedStateHandle["password"]
        if (__password == null) {
          throw IllegalArgumentException("Argument \"password\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"password\" is missing and does not have an android:defaultValue")
      }
      return PilihDbFragmentArgs(__username, __password)
    }
  }
}
