package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.remote.model.UTM
import com.bits.bee.bpmc.data.data_source.remote.post.SignUpPost
import com.bits.bee.bpmc.domain.model.SignUp

/**
 * Created by aldi on 30/08/22.
 */
object SignUpDataMapper : BaseMapper<Any, SignUp, SignUpPost>() {

    override fun fromDbToDomain(model: Any): SignUp {
        TODO("Not yet implemented")
    }

    override fun fromDomainToDb(model: SignUp): Any {
        TODO("Not yet implemented")
    }

    override fun fromNetworkToDb(model: SignUpPost): Any {
        TODO("Not yet implemented")
    }

    fun fromDomainToNetwork(model : SignUp) : SignUpPost {
        return SignUpPost(
            username = model.nama,
            address = model.address,
            bussiness = model.bidangUsah,
            bussiness2 = "",
            city_id = model.cityId,
            company = model.namaPerusahaan,
            mobile = model.noWa,
            email = model.email,
            otptipe = "WA",
            step = model.step,
            regid = model.regId,
            data_utm = UTM(
                model.utm_source ,
                model.utm_medium ,
                model.utm_campaign ,
                model.utm_term ,
                model.utm_content ,
            ),
            cust_id = model.regId?.toInt() ?: 0
        )
    }
}