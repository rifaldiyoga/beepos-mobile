package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Crc
import com.bits.bee.bpmc.domain.repository.CrcRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetLatestCrcUseCase @Inject constructor(
    private val crcRepository: CrcRepository
) {

    operator fun invoke() : Flow<Resource<List<Crc>>>{
        return crcRepository.getLatestCrc()
    }

}