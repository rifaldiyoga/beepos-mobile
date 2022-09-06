package com.bits.bee.bpmc.presentation.ui.pos.pos_item;

import java.lang.System;

/**
 * Created by aldi on 12/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos_item/PosItemState;", "", "itemGroup", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "itemList", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Item;", "priceLvlId", "", "(Lcom/bits/bee/bpmc/domain/model/ItemGroup;Landroidx/paging/PagingData;I)V", "getItemGroup", "()Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "setItemGroup", "(Lcom/bits/bee/bpmc/domain/model/ItemGroup;)V", "getItemList", "()Landroidx/paging/PagingData;", "setItemList", "(Landroidx/paging/PagingData;)V", "getPriceLvlId", "()I", "setPriceLvlId", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class PosItemState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.ItemGroup itemGroup;
    @org.jetbrains.annotations.Nullable()
    private androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> itemList;
    private int priceLvlId;
    
    /**
     * Created by aldi on 12/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.pos_item.PosItemState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup itemGroup, @org.jetbrains.annotations.Nullable()
    androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> itemList, int priceLvlId) {
        return null;
    }
    
    /**
     * Created by aldi on 12/05/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 12/05/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 12/05/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PosItemState() {
        super();
    }
    
    public PosItemState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup itemGroup, @org.jetbrains.annotations.Nullable()
    androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> itemList, int priceLvlId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.ItemGroup component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.ItemGroup getItemGroup() {
        return null;
    }
    
    public final void setItemGroup(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> getItemList() {
        return null;
    }
    
    public final void setItemList(@org.jetbrains.annotations.Nullable()
    androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getPriceLvlId() {
        return 0;
    }
    
    public final void setPriceLvlId(int p0) {
    }
}