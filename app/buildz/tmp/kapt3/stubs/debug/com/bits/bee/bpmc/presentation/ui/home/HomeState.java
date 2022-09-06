package com.bits.bee.bpmc.presentation.ui.home;

import java.lang.System;

/**
 * Created by aldi on 14/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J7\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\tH\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/home/HomeState;", "", "activePosses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "activeCashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "activeBranch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "shift", "", "(Lcom/bits/bee/bpmc/domain/model/Posses;Lcom/bits/bee/bpmc/domain/model/Cashier;Lcom/bits/bee/bpmc/domain/model/Branch;I)V", "getActiveBranch", "()Lcom/bits/bee/bpmc/domain/model/Branch;", "setActiveBranch", "(Lcom/bits/bee/bpmc/domain/model/Branch;)V", "getActiveCashier", "()Lcom/bits/bee/bpmc/domain/model/Cashier;", "setActiveCashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;)V", "getActivePosses", "()Lcom/bits/bee/bpmc/domain/model/Posses;", "setActivePosses", "(Lcom/bits/bee/bpmc/domain/model/Posses;)V", "getShift", "()I", "setShift", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class HomeState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Posses activePosses;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Cashier activeCashier;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Branch activeBranch;
    private int shift;
    
    /**
     * Created by aldi on 14/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.home.HomeState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses activePosses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, int shift) {
        return null;
    }
    
    /**
     * Created by aldi on 14/06/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 14/06/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 14/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public HomeState() {
        super();
    }
    
    public HomeState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses activePosses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, int shift) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses getActivePosses() {
        return null;
    }
    
    public final void setActivePosses(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier getActiveCashier() {
        return null;
    }
    
    public final void setActiveCashier(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Branch component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Branch getActiveBranch() {
        return null;
    }
    
    public final void setActiveBranch(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getShift() {
        return 0;
    }
    
    public final void setShift(int p0) {
    }
}