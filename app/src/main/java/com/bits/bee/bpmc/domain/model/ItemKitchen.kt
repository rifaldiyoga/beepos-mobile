package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 01/07/22.
 */
@Parcelize
data class ItemKitchen(
    var id : Int,
    var itemId: Int,
    var kitchenId: Int,
    var createdBy : Int?,
    var createdAt : Date?,
    var updatedBy : Int?,
    var updatedAt : Date?,
) : Parcelable