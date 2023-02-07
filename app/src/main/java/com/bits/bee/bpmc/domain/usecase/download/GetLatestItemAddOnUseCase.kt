package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.ItemAddOn
import com.bits.bee.bpmc.domain.repository.ItemAddOnRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestItemAddOnUseCase @Inject constructor(private val itemAddOnRepository: ItemAddOnRepository) {

    operator fun invoke(): Flow<Resource<List<ItemAddOn>>> {
        return itemAddOnRepository.getLatestItemAddOn()
    }

}