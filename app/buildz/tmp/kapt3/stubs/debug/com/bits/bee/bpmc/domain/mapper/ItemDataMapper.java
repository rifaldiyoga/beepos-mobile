package com.bits.bee.bpmc.domain.mapper;

import java.lang.System;

/**
 * Created by aldi on 12/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/domain/mapper/ItemDataMapper;", "Lcom/bits/bee/bpmc/domain/mapper/BaseMapper;", "Lcom/bits/bee/bpmc/data/data_source/local/model/ItemEntity;", "Lcom/bits/bee/bpmc/domain/model/Item;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/ItemResponse$ItemModel;", "()V", "fromDbToDomain", "model", "fromDomainToDb", "fromNetworkToDb", "app_debug"})
public final class ItemDataMapper extends com.bits.bee.bpmc.domain.mapper.BaseMapper<com.bits.bee.bpmc.data.data_source.local.model.ItemEntity, com.bits.bee.bpmc.domain.model.Item, com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse.ItemModel> {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.domain.mapper.ItemDataMapper INSTANCE = null;
    
    private ItemDataMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.domain.model.Item fromDbToDomain(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.model.ItemEntity model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.data.data_source.local.model.ItemEntity fromDomainToDb(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.bits.bee.bpmc.data.data_source.local.model.ItemEntity fromNetworkToDb(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse.ItemModel model) {
        return null;
    }
}