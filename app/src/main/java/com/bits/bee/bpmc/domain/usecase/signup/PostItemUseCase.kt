package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 24/11/22
 */
class PostItemUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository
){

    suspend operator fun invoke() {
        val itemList = itemDummyRepository.getItemDummyList().first().data!!

    }

}