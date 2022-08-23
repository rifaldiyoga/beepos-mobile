package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.AddOnD
import com.bits.bee.bpmc.domain.repository.AddOnDRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestAddOnDUseCase @Inject constructor(private val addOnDRepository: AddOnDRepository) {

    operator fun invoke(): Flow<Resource<List<AddOnD>>> {
        return addOnDRepository.getLatestAddOnDList()
    }

}