package com.bits.bee.bpmc.presentation.ui.upload_manual

import com.bits.bee.bpmc.domain.model.*
import kotlinx.coroutines.flow.first

data class UploadManualState(
    var listSync: List<Sync>? = null,
    var listItem: List<Item>? = null,
    var saleList : List<Sale> = mutableListOf(),
    var possesList : List<Posses> = mutableListOf(),
    var cadjList : List<Cadj> = mutableListOf(),
    var cstrList : List<Cstr> = mutableListOf()

)