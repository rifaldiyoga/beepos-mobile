package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.usecase.common.GetLatestCityUseCase
import com.bits.bee.bpmc.domain.usecase.common.PostMonitCashierUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase
import com.bits.bee.bpmc.domain.usecase.pilih_kasir.GetLatestCashierUseCase
import javax.inject.Inject

/**
 * Created by aldi on 22/04/22.
 */
data class DownloadInteractor @Inject constructor(
    val getLatestBranchUseCase: GetLatestBranchUseCase,
    val getLatestCashierUseCase : GetLatestCashierUseCase,
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
    val getLatestUnitUseCase: GetLatestUnitUseCase,
    val getLatestAddOnUseCase: GetLatestAddOnUseCase,
    val getLatestAddOnDUseCase: GetLatestAddOnDUseCase,
    val getLatestItemAddOnUseCase: GetLatestItemAddOnUseCase,
    val getLatestSelectionUseCase: GetLatestSelectionUseCase,
    val getLatestSelectionDUseCase: GetLatestSelectionDUseCase,
    val getLatestVariantUseCase: GetLatestVariantUseCase,
    val getLatestItemVariantUseCase: GetLatestItemVariantUseCase,
    val getLatestPromoUseCase: GetLatestPromoUseCase,
    val getLatestPromoMultiUseCase: GetLatestPromoMultiUseCase,
    val getLatestRegUseCase: GetLatestRegUseCase,
    val getLatestUsrGrpUseCase: GetLatestUsrGrpUseCase,
    val getLatestGrpPrvUseCase: GetLatestGrpPrvUseCase,
    val getLatestKitchenUseCase: GetLatestKitchenUseCase,
    val getLatestImageItemUseCase: GetLatestImageItemUseCase,
    val postMonitCashierUseCase: PostMonitCashierUseCase
)