package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.repository.CrcRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 22/11/22
 */
class CurrencyConvUseCase @Inject constructor (
    private val crcRepository: CrcRepository,
    private val getDefaultCrcUseCase: GetDefaultCrcUseCase,
    private val dispatcher: CoroutineDispatcher
){

    suspend operator fun invoke(crcId : Int, value : BigDecimal) : Flow<BigDecimal?> = flow {
        val defCrc = getDefaultCrcUseCase().first()
        if(defCrc != null && defCrc.id != crcId) {
            val crc = crcRepository.getCrcById(crcId).first()
            crc?.let {
                val conv = crc.excRate * value
                emit(conv)
            }
        } else {
            emit(value)
        }
    }.flowOn(dispatcher)

}