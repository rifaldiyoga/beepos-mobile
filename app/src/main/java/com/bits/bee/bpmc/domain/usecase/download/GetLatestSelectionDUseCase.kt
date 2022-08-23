package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.SelectionD
import com.bits.bee.bpmc.domain.repository.SelectionDRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestSelectionDUseCase @Inject constructor(private val selectionDRepository: SelectionDRepository) {

    operator fun invoke(): Flow<Resource<List<SelectionD>>> {
        return selectionDRepository.getLatestSelectionDList()
    }

}