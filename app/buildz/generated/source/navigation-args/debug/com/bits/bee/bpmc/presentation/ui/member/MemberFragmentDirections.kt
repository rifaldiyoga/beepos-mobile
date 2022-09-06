package com.bits.bee.bpmc.presentation.ui.member

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.domain.model.Bp
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class MemberFragmentDirections private constructor() {
  private data class ActionMemberFragmentToTambahMemberFragment(
    public val district: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_memberFragment_to_tambahMemberFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("district", this.district)
        return result
      }
  }

  private data class ActionMemberFragmentToDetailMemberDialog(
    public val member: Bp
  ) : NavDirections {
    public override val actionId: Int = R.id.action_memberFragment_to_detailMemberDialog

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Bp::class.java)) {
          result.putParcelable("member", this.member as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Bp::class.java)) {
          result.putSerializable("member", this.member as Serializable)
        } else {
          throw UnsupportedOperationException(Bp::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionMemberFragmentToTambahMemberFragment(district: String): NavDirections =
        ActionMemberFragmentToTambahMemberFragment(district)

    public fun actionMemberFragmentToDetailMemberDialog(member: Bp): NavDirections =
        ActionMemberFragmentToDetailMemberDialog(member)

    public fun actionMemberFragmentToPosFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_memberFragment_to_posFragment)
  }
}
