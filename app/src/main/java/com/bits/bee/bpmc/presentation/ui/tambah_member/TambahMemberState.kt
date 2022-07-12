package com.bits.bee.bpmc.presentation.ui.tambah_member

import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.domain.model.Regency

/**
 * Created by aldi on 27/04/22.
 */
data class TambahMemberState (
    var namaMember : String = "",
    var noTelp : String = "",
    var alamat : String = "",
    var isTaxed : Boolean = false,
    var isTaxInc : Boolean = false,
    var kota : String = "",
    var email : String = "",
    var priceLvl : Int = -1,
    var isInfoLainnya : Boolean = false,
    var errorNamaMember : String = "",
    var errorNoTelp : String = "",
    var errorAlamat : String = "",
    var errorEmail : String = "",
    var priceLvlList : List<PriceLvl> = mutableListOf(),
    var city: City? = null,
    var district: District? = null,
    var regency: Regency? = null
)