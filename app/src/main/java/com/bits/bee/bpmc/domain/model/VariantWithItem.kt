package com.bits.bee.bpmc.domain.model

/**
 * Created by aldi on 15/08/22.
 */
data class VariantWithItem (
    val variant: Variant,
    val itemList : List<Item> = mutableListOf()
)