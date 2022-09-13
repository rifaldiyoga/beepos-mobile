package com.bits.bee.bpmc.presentation.ui.upload_manual

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Sync

data class UploadManualState(
    var listSync: List<Sync>? = null,
    var listItem: List<Item>? = null,

)