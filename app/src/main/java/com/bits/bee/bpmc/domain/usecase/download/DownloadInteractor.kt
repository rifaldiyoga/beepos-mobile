package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
data class DownloadInteractor @Inject constructor(
    val getLatestChannelUseCase: GetLatestChannelUseCase,
    val getLatestItemGroupUseCase: GetLatestItemGroupUseCase,
    val getLatestBpUseCase: GetLatestBpUseCase,
    val getLatestPriceLvlUseCase: GetLatestPriceLvlUseCase
)