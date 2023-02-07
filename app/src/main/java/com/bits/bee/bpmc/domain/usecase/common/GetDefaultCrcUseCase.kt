package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Crc
import com.bits.bee.bpmc.domain.repository.CrcRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 15/07/22.
 */
class GetDefaultCrcUseCase @Inject constructor(
    private val crcRepository: CrcRepository
){

    operator fun invoke() : Flow<Crc?> = crcRepository.getDefaultCrc()

}