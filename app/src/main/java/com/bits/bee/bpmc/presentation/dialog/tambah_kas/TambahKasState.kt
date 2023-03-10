package com.bits.bee.bpmc.presentation.dialog.tambah_kas

import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.model.Posses
import java.math.BigDecimal

data class TambahKasState(
    var user: String? = null,
    var nominal : String = "",
    var deskripsi: String = "",
    var posses: Posses? = null,
    var cash: Cash? = null,
    var isValid: Boolean = false
)