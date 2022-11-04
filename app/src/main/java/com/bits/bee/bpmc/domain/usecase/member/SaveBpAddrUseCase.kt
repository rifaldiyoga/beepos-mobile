package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.mapper.BpAddrDataMapper
import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.BpAddr
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.domain.repository.*
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SaveBpAddrUseCase @Inject constructor(
    private val cityRepository: CityRepository,
    private val bpAddrRepository: BpAddrRepository,
    private val bpRepository: BpRepository,
    private val regencyRepository: RegencyRepository,
    private val districtRepository: DistrictRepository
) {
    private var province_code: String = ""
    private var regency_code: String = ""
    private var district_code: String = ""

    suspend operator fun invoke(kota: String, bp: Bp, noTelp: String, email: String, alamat: String) {
        val lastId = bpRepository.addUpdateBp(bp)
        bp.id = lastId.toInt()

        if (kota != "") {
//            val kotaDistrict = kota.split(", ").toTypedArray()
//            var getKota: String? = null
//            var getDistrict: String? = null
//
//            if (kotaDistrict.lastIndex == 1) {
//                getKota = kotaDistrict[0]
//                getDistrict = kotaDistrict[1]
//            } else if (kotaDistrict.lastIndex == 0) {
//                getKota = kotaDistrict[0]
//            }
//
//            val regency = regencyRepository.getCodeByRegency(getKota!!).first()
//
//            province_code = regency?.provinceCode ?: ""
//            regency_code = regency?.code ?: ""
//
//            if (getDistrict != null) {
//                districtRepository.getCodeByName(getDistrict).collect {
//                    it.data?.let {
//                        mDistrict = it
//                    }
//                }
//
//                district_code = mDistrict!!.code
//            } else {
//                district_code = ""
//            }
        }

        val bpAddr = BpAddr(
            bpId = bp.id!!,
            name = bp.name,
            greeting = "",
            address = alamat,
            phone = noTelp,
            zipCode = "",
            email = email,
            note = "",
            isBillAddr = false,
            isShipAddr = false,
            isMainAddr = false,
            provinceCode = province_code,
            regencyCode = regency_code,
            cityCode = "",
            districtCode = district_code
        )

        bpAddrRepository.addUpdateBpAddr(BpAddrDataMapper.fromDomainToDb(bpAddr))

    }
}