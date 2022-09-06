package com.bits.bee.bpmc.presentation.ui.nama_device

import android.os.Bundle
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import kotlin.Int
import kotlin.String

public class NamaDeviceFragmentDirections private constructor() {
  private data class ActionNamaDeviceFragmentToPilihDbFragment(
    public val username: String,
    public val password: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_namaDeviceFragment_to_pilihDbFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("username", this.username)
        result.putString("password", this.password)
        return result
      }
  }

  public companion object {
    public fun actionNamaDeviceFragmentToPilihDbFragment(username: String, password: String):
        NavDirections = ActionNamaDeviceFragmentToPilihDbFragment(username, password)
  }
}
