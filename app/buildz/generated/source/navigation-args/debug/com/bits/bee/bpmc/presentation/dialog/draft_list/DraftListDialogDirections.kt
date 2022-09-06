package com.bits.bee.bpmc.presentation.dialog.draft_list

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.bits.bee.bpmc.R

public class DraftListDialogDirections private constructor() {
  public companion object {
    public fun actionDraftListDialogToDraftFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_draftListDialog_to_draftFragment)
  }
}
