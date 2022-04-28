package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Branch (
    val id : Int,
    val code : String,
    val name: String,
    val version: String,
    val cmpName : String,
    val cmpPhone : String,
    val active : Boolean,
    val cmpAddress : String,
    val cmpFax : String,
    val custDeftId : Int?,
    val createdAt : Long,
    val createdBy : Int,
    val updatedAt : Long,
    val updatedBy : Int,
) : Parcelable