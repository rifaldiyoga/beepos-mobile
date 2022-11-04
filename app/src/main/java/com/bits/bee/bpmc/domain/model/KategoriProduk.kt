package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KategoriProduk(
    var name: String,
    var subKategori: List<ItemGroup>? = null
): Parcelable