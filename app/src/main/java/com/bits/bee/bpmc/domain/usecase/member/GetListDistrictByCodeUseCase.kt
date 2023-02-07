package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.domain.repository.DistrictRepository
import com.bits.bee.bpmc.domain.repository.RegencyRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetListDistrictByCodeUseCase @Inject constructor(
    private val regencyRepository: RegencyRepository,
    private val districtRepository: DistrictRepository,
    private val defaultDispatcher: CoroutineDispatcher
) {
    private var mRegency: Regency? = null
    private var mListDistrict: List<District>? = null

    operator fun invoke(name : String) : Flow<Resource<List<District>>> {
        return flow {
            regencyRepository.getCodeByRegency(name).collect {
                it?.let { data ->
                    mRegency = data
                }
            }
            if (mRegency != null){
                districtRepository.getListDistrictByCode(mRegency!!.code).collect {
                    it.data?.let {
                        mListDistrict = it
                    }
                }
            }
            emit(Resource.success(mListDistrict!!))
        }.flowOn(defaultDispatcher)
    }
}