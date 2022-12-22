package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemUseCase
import com.bits.bee.bpmc.domain.usecase.setting.favorit.UpdateFavProdukUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 06/10/22
 */
@HiltViewModel
class SettingFavProdukViewModel @Inject constructor(
    private val getActiveItemUseCase: GetActiveItemUseCase,
    private val updateFavProdukUseCase: UpdateFavProdukUseCase,
    private val beePreferenceManager: BeePreferenceManager
) : BaseViewModel<FavProdukState, SettingFavProdukViewModel.UIEvent>() {

    private var currentQuery: MutableStateFlow<String> = MutableStateFlow("")

    private var activeItgrp: MutableStateFlow<Int> = MutableStateFlow(-1)

    val orientation = beePreferenceManager.posPreferences

    init {
        state = FavProdukState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val itemList = combine(
        currentQuery,
        activeItgrp
    ) { (query, itgrp) ->
        QueryWithSort(query as String, itgrp as Int)
    }.flatMapLatest {
        getActiveItemUseCase(itemGrpId = it.itgrpId, bp = null, query = it.query, channel = null).cachedIn(viewModelScope)
    }

    fun onClickAdd() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPilih)
    }

    fun updateFavorit(bp : Item) = viewModelScope.launch {
        updateFavProdukUseCase(bp)
    }

    fun updateActiveItemGroup(itemGroup: ItemGroup) = viewModelScope.launch{
        activeItgrp.emit(itemGroup.id ?:  -1)
    }

    data class QueryWithSort(
        val query: String,
        val itgrpId : Int = -1
    )

    sealed class UIEvent {
        object NavigateToPilih : UIEvent()
    }

}