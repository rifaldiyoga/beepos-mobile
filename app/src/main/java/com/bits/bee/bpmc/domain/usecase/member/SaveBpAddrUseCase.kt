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
    private var mDistrict: District? = null
    private var mListDistrict: List<District>? = null
    private lateinit var province_code: String
    private lateinit var regency_code: String
    private lateinit var district_code: String

    suspend operator fun invoke(kota: String, bp: Bp, noTelp: String, email: String, alamat: String) {
        bpRepository.addUpdateBp(BpDataMapper.fromDomainToDb(bp))

        bpRepository.getlastId().collect {
            it.data?.let { data ->
                mBp = data
            }
        }

        if (!kota.equals("")){
            val kotaDistrict = kota.split(", ").toTypedArray()
            var getKota: String? = null
            var getDistrict: String? = null

            if (kotaDistrict.lastIndex == 1){
                getKota = kotaDistrict[0]
                getDistrict = kotaDistrict[1]
            }else if(kotaDistrict.lastIndex == 0){
                getKota = kotaDistrict[0]
            }

            regencyRepository.getCodeByRegency(getKota!!).collect {
                it.data?.let {
                    mRegency = it
                }
            }

            province_code = mRegency!!.provinceCode
            regency_code = mRegency!!.code

            if (getDistrict != null){
                districtRepository.getCodeByName(getDistrict).collect {
                    it.data?.let {
                        mDistrict = it
                    }
                }

                district_code = mDistrict!!.code
            }else{
                district_code = ""
            }
        }else{
            province_code = ""
            regency_code = ""
            district_code = ""
        }

        if (mBp != null){
            var bpAddr = BpAddr(
                bpId = mBp?.id!!,
                name = mBp?.name!!,
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
                cityId = 0,
                districtCode = district_code
            )

            bpAddrRepository.addUpdateBpAddr(BpAddrDataMapper.fromDomainToDb(bpAddr))
        }
    }
}