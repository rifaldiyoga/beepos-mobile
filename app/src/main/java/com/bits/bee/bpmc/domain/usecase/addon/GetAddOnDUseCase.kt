package com.bits.bee.bpmc.domain.usecase.addon

import com.bits.bee.bpmc.domain.model.AddOnD
import com.bits.bee.bpmc.domain.repository.AddOnDRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 13/12/22
 */
class GetAddOnDUseCase @Inject constructor(
    private val addOnDRepository: AddOnDRepository
) {

    operator fun invoke(itemId : Int) : Flow<List<AddOnD>> = addOnDRepository.getAddOnDByItemList(itemId)

}