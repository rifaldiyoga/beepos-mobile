package com.bits.bee.bpmc.domain.usecase.download

import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
data class DownloadInteractor @Inject constructor(
    val getLatestChannelUseCase: GetLatestChannelUseCase,
    val getLatestItemGroupUseCase: GetLatestItemGroupUseCase,
    val getLatestItemUseCase: GetLatestItemUseCase,
    val getLatestBpUseCase: GetLatestBpUseCase,
    val getLatestPriceLvlUseCase: GetLatestPriceLvlUseCase,
    val getLatestCityUseCase: GetLatestCityUseCase,
    val getLatestOperatorUseCase: GetLatestOperatorUseCase,
    val getLatestCmpUseCase: GetLatestCmpUseCase,
    val getLatestCrcUseCase: GetLatestCrcUseCase,
)