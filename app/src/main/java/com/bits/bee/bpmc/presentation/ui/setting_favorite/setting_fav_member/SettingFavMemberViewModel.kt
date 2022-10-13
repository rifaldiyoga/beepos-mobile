package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_member

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.usecase.member.GetActiveMemberUseCase
import com.bits.bee.bpmc.domain.usecase.setting.favorit.UpdateFavMemberUseCase
import com.bits.bee.bpmc.presentation.base.BaseViewModel
import com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_produk.SettingFavProdukViewModel
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
class SettingFavMemberViewModel @Inject constructor(
    private val getActiveMemberUseCase: GetActiveMemberUseCase,
    private val updateFavMemberUseCase: UpdateFavMemberUseCase
) : BaseViewModel<FavMemberState, SettingFavMemberViewModel.UIEvent>() {

    private var currentQuery: MutableStateFlow<String> = MutableStateFlow("")

    private var favorit: MutableStateFlow<Boolean> = MutableStateFlow(true)

    init {
        state = FavMemberState()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val memberList = combine(
        currentQuery,
        favorit
    ) { (query, fav) ->
        QueryWithSort(query as String, fav as Boolean)
    }.flatMapLatest {
        getActiveMemberUseCase(it.query, it.fav).cachedIn(viewModelScope)
    }

    fun onClickAdd() = viewModelScope.launch {
        eventChannel.send(UIEvent.NavigateToPilih)
    }

    fun updateFavorit(bp : Bp) = viewModelScope.launch {
        updateFavMemberUseCase(bp)
    }

    fun setFavorit(boolean: Boolean) = viewModelScope.launch {
        favorit.emit(boolean)
    }

    data class QueryWithSort(
        val query: String,
        val fav : Boolean = true
    )

    sealed class UIEvent {
        object NavigateToPilih : UIEvent()
    }

}