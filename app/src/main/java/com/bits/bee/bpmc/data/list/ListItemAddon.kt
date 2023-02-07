package com.bits.bee.bpmc.data.list

import com.bits.bee.bpmc.domain.model.Item
import java.math.BigDecimal
import java.util.*

class ListItemAddon : ArrayList<ListItemAddon.ItemAddon?>() {
    fun minItem(item: Item) {
        val itemAddons: List<ItemAddon?> = subList(0, size)
        Collections.reverse(itemAddons)
        for (itemAddon in itemAddons) {
            val item1: Item = itemAddon!!.getItem()
            if (item1.id == item.id) {
                val itemAddonList: List<Item> = itemAddon.getItemAddonList()
                if (itemAddonList.isNotEmpty()) {
                    for (item2 in itemAddonList) {
                        item2.qty = item2.qty - BigDecimal.ONE
                    }
                }
                item1.qty = item1.qty - BigDecimal.ONE
                if (item1 != item) {
                    item.qty = item.qty - BigDecimal.ONE
                }
                if (item1.qty == BigDecimal.ZERO) {
                    remove(itemAddon)
                }
                break
            }
        }
    }

    val selectedItemList: List<Any>
        get() {
            val itemList: MutableList<Item> = ArrayList<Item>()
            val itemAddonList: List<ItemAddon?> = subList(0, size)
            for (itemAddon in itemAddonList) {
                itemList.add(itemAddon!!.getItem())
            }
            return itemList
        }

    fun addItemBonusAddon(itemAddon: ItemAddon): Boolean {
        val item: Item = itemAddon.getItem()
        val itemAddonList: List<ItemAddon?> = subList(0, size)
        for (itemBonusAddOn in itemAddonList) {
            val item2: Item = itemBonusAddOn!!.getItem()
            if (item2.id == item.id) {
                val addonList: List<Item> = itemAddon.getItemAddonList()
                val addonBonusList: List<Item> = itemBonusAddOn.getItemAddonList()
                if (isSameAddon(addonBonusList, addonList)) {
                    item2.qty = item2.qty + item.qty
                    for (addonBonus in addonBonusList) {
                        for (addon in addonList) {
                            if (addonBonus.id == addon.id) {
                                addonBonus.qty = addonBonus.qty + addon.qty
                            }
                        }
                    }
                    return true
                }
            }
        }
        itemAddon.getItem().price = BigDecimal.ZERO
        return add(itemAddon)
    }

    private fun isSameAddon(itemList: List<Item>, itemList2: List<Item>): Boolean {
        if (itemList.isEmpty() && itemList2.isEmpty()) {
            return true
        }
        if (itemList.size == itemList2.size) {
            for (item in itemList) {
                var isExist = false
                for (item1 in itemList2) {
                    if (item.id == item1.id && item.qty == item1.qty) {
                        isExist = true
                    }
                }
                if (!isExist) {
                    return false
                }
            }
            return true
        }
        return false
    }

    class ItemAddon {
        private var item: Item
        private var itemAddonList: List<Item>
        var promoBonus: ListPromoBonus.PromoBonus? = null

        constructor(item: Item, itemAddonList: List<Item>) {
            this.item = item
            this.itemAddonList = itemAddonList
        }

        constructor(item: Item, itemAddonList: List<Item>, promoBonus: ListPromoBonus.PromoBonus?) {
            this.item = item
            this.itemAddonList = itemAddonList
            this.promoBonus = promoBonus
        }

        fun getItem(): Item {
            return item
        }

        fun setItem(item: Item) {
            this.item = item
        }

        fun getItemAddonList(): List<Item> {
            return itemAddonList
        }

        fun setItemAddonList(itemAddonList: List<Item>) {
            this.itemAddonList = itemAddonList
        }

    }
}