package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Branch (
    val id : Int = -1,
    val code : String = "",
    val name: String = "",
    val version: Int = -1,
    val cmpName : String = "",
    val cmpPhone : String = "",
    val active : Boolean = false,
    val status : Boolean = false,
    val cmpAddress : String = "",
    val cmpFax : String = "",
    val custDeftId : Int? = null,
    val createdAt : Long = -1,
    val createdBy : Int = -1,
    val updatedAt : Long = -1,
    val updatedBy : Int = -1
) : Parcelable