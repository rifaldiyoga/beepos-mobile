package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/ItemSaleTaxEntity;", "getItemSaleTax", "", "getItemTaxByCodeItem", "itemCode", "", "app_debug"})
public abstract interface ItemSaleTaxDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item_tax")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity> getItemSaleTax();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT a.*, b.expr FROM item_tax a JOIN tax b ON a.tax_code = b.code WHERE item_code = :itemCode ")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity getItemTaxByCodeItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemCode);
}