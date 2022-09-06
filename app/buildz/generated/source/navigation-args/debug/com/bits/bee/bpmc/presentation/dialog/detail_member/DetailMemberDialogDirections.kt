package com.bits.bee.bpmc.presentation.dialog.detail_member

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class DetailMemberDialogDirections private constructor() {
  public companion object {
    public fun actionDetailMemberDialogToTaxInfoDialog(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailMemberDialog_to_taxInfoDialog)
  }
}
