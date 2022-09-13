package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Selection
import com.bits.bee.bpmc.domain.repository.SelectionRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestSelectionUseCase @Inject constructor(private val channelRepository: SelectionRepository) {

    operator fun invoke(): Flow<Resource<List<Selection>>> {
        return channelRepository.getLatestSelectionList()
    }

}