package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003J9\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\'"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiState;", "", "posses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "activeBranch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "cashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "user", "Lcom/bits/bee/bpmc/domain/model/User;", "(Lcom/bits/bee/bpmc/domain/model/Posses;Lcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Cashier;Lcom/bits/bee/bpmc/domain/model/User;)V", "getActiveBranch", "()Lcom/bits/bee/bpmc/domain/model/Branch;", "setActiveBranch", "(Lcom/bits/bee/bpmc/domain/model/Branch;)V", "getCashier", "()Lcom/bits/bee/bpmc/domain/model/Cashier;", "setCashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;)V", "getPosses", "()Lcom/bits/bee/bpmc/domain/model/Posses;", "setPosses", "(Lcom/bits/bee/bpmc/domain/model/Posses;)V", "getUser", "()Lcom/bits/bee/bpmc/domain/model/User;", "setUser", "(Lcom/bits/bee/bpmc/domain/model/User;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class DetailRiwayatSesiState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Posses posses;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Branch activeBranch;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Cashier cashier;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.User user;
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses posses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier cashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public DetailRiwayatSesiState() {
        super();
    }
    
    public DetailRiwayatSesiState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses posses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier cashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Posses getPosses() {
        return null;
    }
    
    public final void setPosses(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Branch component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Branch getActiveBranch() {
        return null;
    }
    
    public final void setActiveBranch(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier getCashier() {
        return null;
    }
    
    public final void setCashier(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.User component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User p0) {
    }
}