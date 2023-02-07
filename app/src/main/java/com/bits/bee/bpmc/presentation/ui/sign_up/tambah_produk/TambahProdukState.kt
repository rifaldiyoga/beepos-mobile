package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.graphics.Bitmap
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import java.math.BigDecimal

/**
 * Created by aldi on 31/08/22.
 */
data class TambahProdukState (
    var nama : String = "",
    var harga : String = "",
    var satuan : String = "",
    var tipeProduk : String = "",
    var itemGrp : ItemGroup? = null,
    var brand : Brand? = null,
    var itemDummy: ItemDummy? = null,
    var unitList : MutableList<UnitDummy> = mutableListOf(UnitDummy(idx = -1, unit= "", conv = BigDecimal.ONE,)),
    var bitmap: Bitmap? = null,
    var picPath: String? = null,
    var isEdit: Boolean = false,
    var itemId: Int = -1,
    var isActivePid: Boolean = false,
    var pid: String = "",
    var msgNama: String ="",
    var msgHarga: String="",
    var msgSatuan: String="",
    var msgTipe: String="",
    var posModeState: PosModeState? = null,
    var msgQty: String? = null
)