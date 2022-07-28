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
    val getLatestProvinceUseCase: GetLatestProvinceUseCase,
    val getLatestRegencyUseCase: GetLatestRegencyUseCase,
    val getLatestDistrictUseCase: GetLatestDistrictUseCase,
    val getLatestPriceUseCase: GetLatestPriceUseCase,
    val getLatestItemBranchUseCase: GetLatestItemBranchUseCase,
    val getLatestItemSaleTaxUseCase: GetLatestItemSaleTaxUseCase,
    val getLatestTaxUseCase: GetLatestTaxUseCase,
    val getLatestEdcUseCase: GetLatestEdcUseCase,
    val getLatestEdcSurcUseCase: GetLatestEdcSurcUseCase,
    val getLatestCcTypeUseCase: GetLatestCcTypeUseCase,
    val getLatestPmtdUseCase: GetLatestPmtdUseCase,
)