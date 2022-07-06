package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.mapper.BpAddrDataMapper
import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class SaveBpAddrUseCase @Inject constructor(
    private val cityRepository: CityRepository,
    private val bpAddrRepository: BpAddrRepository,
    private val bpRepository: BpRepository,
    private val regencyRepository: RegencyRepository,
    private val districtRepository: DistrictRepository
) {
    private var city: City? = null
    private var mBp: Bp? = null
    private var mRegency: Regency? = null
    private var mListDistrict: List<District>? = null

    suspend operator fun invoke(kota: String, bp: Bp, noTelp: String, email: String, alamat: String) {
        bpRepository.addUpdateBp(BpDataMapper.fromDomainToData(bp))

        bpRepository.getlastId().collect {
            it.data?.let { data ->
                mBp = data
            }
        }

        regencyRepository.getCodeByRegency(kota).collect {
            it.data?.let {
                mRegency = it
            }
        }

        districtRepository.getDistrictByCode(mRegency!!.code).collect {
            it.data?.let {
                mListDistrict = it
            }
        }
//        cityRepository.getCodeByName(kota).collect {
//            it.data?.let { data ->
//                city = data
//            }
//        }
        var district_code = mListDistrict!!.get(0).code

        if (mBp != null){
            var bpAddr = BpAddr(
                bpId = mBp?.id!!,
                name = mBp?.name!!,
                address = alamat,
                greeting = "",
                phone = noTelp,
                zipCode = "",
                email = email,
                note = "",
                isBillAddr = false,
                isShipAddr = false,
                isMainAddr = false,
                provinceCode = mRegency!!.provinceCode,
                regencyCode = mRegency!!.code,
                districtCode = district_code,
                cityId = 0
            )

            bpAddrRepository.addUpdateBpAddr(BpAddrDataMapper.fromDomainToData(bpAddr))
        }
    }
}