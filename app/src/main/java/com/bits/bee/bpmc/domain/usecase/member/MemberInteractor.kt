package com.bits.bee.bpmc.domain.usecase.member

import javax.inject.Inject

/**
 * Created by aldi on 27/04/22.
 */
data class MemberInteractor @Inject constructor (
    val getFavoritMemberUseCase: GetFavoritMemberUseCase,
    val addUpdateMemberUseCase: AddUpdateMemberUseCase
)