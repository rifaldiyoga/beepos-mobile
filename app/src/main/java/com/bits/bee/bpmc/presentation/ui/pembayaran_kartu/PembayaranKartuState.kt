package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu

import com.bits.bee.bpmc.domain.model.Edc
import com.bits.bee.bpmc.domain.model.EdcSurcAndCcType

/**
 * Created by aldi on 02/06/22.
 */
data class PembayaranKartuState (
    var edc : Edc? = null,
    var edcSurc : EdcSurcAndCcType? = null,
    var edcList: List<Edc> = mutableListOf(),
    var edcSurcList : List<EdcSurcAndCcType> = mutableListOf(),
    var type : String = "",
    var trackNo : String = "",
    var nomorkartu : String = "",
    var keterangan : String = ""
)