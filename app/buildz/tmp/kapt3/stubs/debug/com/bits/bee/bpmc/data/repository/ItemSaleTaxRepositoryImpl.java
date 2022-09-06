package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u000f0\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/ItemSaleTaxRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/ItemSaleTaxRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "itemSaleTaxDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;", "apiUtils", "Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemSaleTaxDao;Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;)V", "getItemTaxByCodeItem", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/ItemSaleTax;", "codeItem", "", "getLatestItemSaleTax", "Lcom/bits/bee/bpmc/utils/Resource;", "", "app_debug"})
public final class ItemSaleTaxRepositoryImpl implements com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository {
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao itemSaleTaxDao = null;
    private final com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils = null;
    
    @javax.inject.Inject()
    public ItemSaleTaxRepositoryImpl(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao itemSaleTaxDao, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.ItemSaleTax>>> getLatestItemSaleTax() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.ItemSaleTax> getItemTaxByCodeItem(@org.jetbrains.annotations.NotNull()
    java.lang.String codeItem) {
        return null;
    }
}