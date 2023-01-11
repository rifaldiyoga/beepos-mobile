package com.bits.bee.bpmc.domain.usecase.riwayat_sesi

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sesi
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFilterSortingUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {

    operator fun invoke(desc: Boolean, current: Long, end: Long): Flow<Resource<List<Sesi>>> = flow {
        emit(Resource.loading())
        var possesList = possesRepository.getJmlPossesByDate(current, end).first()
        possesList = if(desc)
            possesList.sortedByDescending { it.possesId }
        else
            possesList.sortedBy { it.possesId }

        val possesMap = HashMap<Long, MutableList<Posses>>()
        for (posses in possesList){
            val key = DateFormatUtils.convertStartDate(posses.trxDate.time)
            if (!possesMap.containsKey(key)){
                val mutable: MutableList<Posses> = mutableListOf()
                mutable.add(posses)
                possesMap[key] = mutable
            }else{
                possesMap[key]!!.add(posses)
            }
        }
        val resultSorted = if (desc) {
            possesMap.toSortedMap(compareByDescending { it })
        } else {
            possesMap.toSortedMap(compareBy { it })
        }
        val sesiList = mutableListOf<Sesi>()
        for (newMap in resultSorted){
            val jmlTrans = possesRepository.getJmlPossesByDate(DateFormatUtils.convertStartDate(newMap.key), DateFormatUtils.convertEndDate(newMap.key)).first().size
            sesiList.add(Sesi(newMap.key, newMap.value, jmlTrans))
        }
        emit(Resource.success(sesiList))
    }

}