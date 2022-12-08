package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastItemgrpUseCase @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) {
    operator fun invoke(): Flow<ItemGroup?> = itemGroupRepository.getLastItemgrp()
}