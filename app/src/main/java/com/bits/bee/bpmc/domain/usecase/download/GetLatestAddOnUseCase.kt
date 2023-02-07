package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.AddOn
import com.bits.bee.bpmc.domain.repository.AddOnRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestAddOnUseCase @Inject constructor(private val addOnRepository: AddOnRepository) {

    operator fun invoke(): Flow<Resource<List<AddOn>>> {
        return addOnRepository.getLatestAddOnList()
    }

}