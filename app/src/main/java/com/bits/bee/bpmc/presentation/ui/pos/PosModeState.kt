package com.bits.bee.bpmc.presentation.ui.pos

/**
 * Created by aldi on 03/08/22.
 */
sealed class PosModeState {

    object FnBState : PosModeState()

    object RetailState : PosModeState()

}