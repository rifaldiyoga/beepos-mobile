package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.pilih_produk

import com.bits.bee.bpmc.domain.repository.ItemGroupRepository
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by aldi on 06/10/22
 */
@HiltViewModel
class SettingFavPilihProdukViewModel @Inject constructor(
    private val itemGroupRepository: ItemGroupRepository
) : BaseViewModel<PilihProdukState, SettingFavPilihProdukViewModel.UIEvent>() {

    var itemGroupList = itemGroupRepository.getActiveItemGroupNotAddOnList()

    init {
        state = PilihProdukState()
    }

    sealed class UIEvent {

    }

}