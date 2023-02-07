package com.bits.bee.bpmc.data.list

import com.bits.bee.bpmc.domain.model.Item
import java.math.BigDecimal
import java.util.*

class ListItemBonusAddon : ArrayList<ListItemBonusAddon.ItemBonusAddOn?>() {
    fun minItem(item: Item) {
        val itemBonusAddOns: List<ItemBonusAddOn?> = subList(0, size)
        Collections.reverse(itemBonusAddOns)
        for (itemBonusAddOn in itemBonusAddOns) {
            val item1: Item = itemBonusAddOn!!.getItem()
            if (item1.id == item.id) {
                item1.qty = item1.qty - BigDecimal.ONE
                if (item1 != item) {
                    item.qty = item.qty - BigDecimal.ONE
                }
                if (item1.qty == BigDecimal.ZERO) {
                    remove(itemBonusAddOn)
                }
                break
            }
        }
    }

    val selectedItemList: List<Any>
        get() {
            val itemList: MutableList<Item> = ArrayList<Item>()
            val itemBonusAddOnList: List<ItemBonusAddOn?> = subList(0, size)
            for (itemBonusAddOn in itemBonusAddOnList) {
                itemList.add(itemBonusAddOn!!.getItem())
            }
            return itemList
        }

    fun addItemBonusAddon(itemBonusAddOn: ItemBonusAddOn): Boolean {
        val item: Item = itemBonusAddOn.getItem()
        val itemBonusAddOnList: List<ItemBonusAddOn?> = subList(0, size)
        for (bonusAddOn in itemBonusAddOnList) {
            val item2: Item = bonusAddOn!!.getItem()
            if (item2.id == itemBonusAddOn.getItem().id) {
                if (isSameAddon(bonusAddOn.getItemAddonList(), itemBonusAddOn.getItemAddonList())) {
                    item2.qty = item2.qty + item.qty
                    return true
                }
            }
        }
        itemBonusAddOn.getItem().price = BigDecimal.ZERO
        return add(itemBonusAddOn)
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

    class ItemBonusAddOn(item: Item, itemAddonList: List<Item>, promoBonus: ListPromoBonus.PromoBonus) {
        private var item: Item
        private var itemAddonList: List<Item>
        var promoBonus: ListPromoBonus.PromoBonus

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


        init {
            this.item = item
            this.itemAddonList = itemAddonList
            this.promoBonus = promoBonus
        }
    }
}