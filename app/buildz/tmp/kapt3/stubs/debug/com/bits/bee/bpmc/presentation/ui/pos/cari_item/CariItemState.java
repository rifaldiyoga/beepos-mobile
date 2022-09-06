package com.bits.bee.bpmc.presentation.ui.pos.cari_item;

import java.lang.System;

/**
 * Created by aldi on 22/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/cari_item/CariItemState;", "", "query", "", "itemList", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Item;", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "usePid", "", "(Ljava/lang/String;Landroidx/paging/PagingData;Lcom/bits/bee/bpmc/domain/model/Bp;Z)V", "getBp", "()Lcom/bits/bee/bpmc/domain/model/Bp;", "setBp", "(Lcom/bits/bee/bpmc/domain/model/Bp;)V", "getItemList", "()Landroidx/paging/PagingData;", "setItemList", "(Landroidx/paging/PagingData;)V", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "getUsePid", "()Z", "setUsePid", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class CariItemState {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String query;
    @org.jetbrains.annotations.Nullable()
    private androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> itemList;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Bp bp;
    private boolean usePid;
    
    /**
     * Created by aldi on 22/07/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.pos.cari_item.CariItemState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> itemList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp bp, boolean usePid) {
        return null;
    }
    
    /**
     * Created by aldi on 22/07/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 22/07/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 22/07/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CariItemState() {
        super();
    }
    
    public CariItemState(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item> itemList, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp bp, boolean usePid) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuery() {
        return null;
    }
    
    public final void setQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Bp component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Bp getBp() {
        return null;
    }
    
    public final void setBp(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Bp p0) {
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getUsePid() {
        return false;
    }
    
    public final void setUsePid(boolean p0) {
    }
}