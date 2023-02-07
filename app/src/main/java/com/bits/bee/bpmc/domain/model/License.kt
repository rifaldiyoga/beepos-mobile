package com.bits.bee.bpmc.domain.model

import java.util.*

/**
 * Created by aldi on 06/09/22
 */
data class License (
    var name: String,
    var licNumber : String,
    var item : String?,
    var licExp : Date?,
    var data : String
)
//=======
//import android.os.Parcelable
//import kotlinx.parcelize.Parcelize
//
//
//@Parcelize
//data class License(
//    var id : Int? = null,
//    var name: String,
//    var licNumber : String,
//    var item : String,
//    var licExp : Long,
//): Parcelable {
//}
//>>>>>>> 1ddb2a9... ^ login operator
