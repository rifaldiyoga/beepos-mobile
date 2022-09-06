package com.bits.bee.bpmc.presentation.ui.buka_kasir;

import java.lang.System;

/**
 * Created by aldi on 20/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003JU\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u00020\tH\u00d6\u0001J\t\u00103\u001a\u000204H\u00d6\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00065"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirState;", "", "activePosses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "activeCashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "activeBranch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "shift", "", "listCasha", "", "Lcom/bits/bee/bpmc/domain/model/CashA;", "user", "Lcom/bits/bee/bpmc/domain/model/User;", "(Lcom/bits/bee/bpmc/domain/model/Posses;Lcom/bits/bee/bpmc/domain/model/Cashier;Lcom/bits/bee/bpmc/domain/model/Branch;ILjava/util/List;Lcom/bits/bee/bpmc/domain/model/User;)V", "getActiveBranch", "()Lcom/bits/bee/bpmc/domain/model/Branch;", "setActiveBranch", "(Lcom/bits/bee/bpmc/domain/model/Branch;)V", "getActiveCashier", "()Lcom/bits/bee/bpmc/domain/model/Cashier;", "setActiveCashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;)V", "getActivePosses", "()Lcom/bits/bee/bpmc/domain/model/Posses;", "setActivePosses", "(Lcom/bits/bee/bpmc/domain/model/Posses;)V", "getListCasha", "()Ljava/util/List;", "setListCasha", "(Ljava/util/List;)V", "getShift", "()I", "setShift", "(I)V", "getUser", "()Lcom/bits/bee/bpmc/domain/model/User;", "setUser", "(Lcom/bits/bee/bpmc/domain/model/User;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class BukaTutupKasirState {
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Posses activePosses;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Cashier activeCashier;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Branch activeBranch;
    private int shift;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.CashA> listCasha;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.User user;
    
    /**
     * Created by aldi on 20/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirState copy(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses activePosses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, int shift, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.CashA> listCasha, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user) {
        return null;
    }
    
    /**
     * Created by aldi on 20/06/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 20/06/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 20/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public BukaTutupKasirState() {
        super();
    }
    
    public BukaTutupKasirState(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Posses activePosses, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, int shift, @org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.CashA> listCasha, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.User user) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.CashA> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.CashA> getListCasha() {
        return null;
    }
    
    public final void setListCasha(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.CashA> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.User component6() {
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