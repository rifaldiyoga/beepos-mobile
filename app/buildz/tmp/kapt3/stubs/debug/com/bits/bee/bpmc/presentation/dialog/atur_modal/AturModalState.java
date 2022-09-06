package com.bits.bee.bpmc.presentation.dialog.atur_modal;

import java.lang.System;

/**
 * Created by aldi on 15/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\nH\u00c6\u0003JA\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\nH\u00d6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalState;", "", "modal", "Ljava/math/BigDecimal;", "defaultModal", "activeBranch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "activeCashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "shift", "", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Cashier;I)V", "getActiveBranch", "()Lcom/bits/bee/bpmc/domain/model/Branch;", "setActiveBranch", "(Lcom/bits/bee/bpmc/domain/model/Branch;)V", "getActiveCashier", "()Lcom/bits/bee/bpmc/domain/model/Cashier;", "setActiveCashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;)V", "getDefaultModal", "()Ljava/math/BigDecimal;", "setDefaultModal", "(Ljava/math/BigDecimal;)V", "getModal", "setModal", "getShift", "()I", "setShift", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class AturModalState {
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal modal;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal defaultModal;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Branch activeBranch;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Cashier activeCashier;
    private int shift;
    
    /**
     * Created by aldi on 15/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalState copy(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal modal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal defaultModal, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, int shift) {
        return null;
    }
    
    /**
     * Created by aldi on 15/06/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 15/06/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 15/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public AturModalState() {
        super();
    }
    
    public AturModalState(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal modal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal defaultModal, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Branch activeBranch, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier activeCashier, int shift) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getModal() {
        return null;
    }
    
    public final void setModal(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getDefaultModal() {
        return null;
    }
    
    public final void setDefaultModal(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Cashier getActiveCashier() {
        return null;
    }
    
    public final void setActiveCashier(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Cashier p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getShift() {
        return 0;
    }
    
    public final void setShift(int p0) {
    }
}