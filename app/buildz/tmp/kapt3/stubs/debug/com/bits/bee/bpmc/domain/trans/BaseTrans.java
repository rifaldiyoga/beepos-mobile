package com.bits.bee.bpmc.domain.trans;

import java.lang.System;

/**
 * Created by aldi on 18/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0014\u001a\u00020\u0012J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006J\r\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001a\u001a\u00020\u0012H&J\b\u0010\u001b\u001a\u00020\u0012H&R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/bits/bee/bpmc/domain/trans/BaseTrans;", "M", "D", "", "()V", "mTblDetail", "", "getMTblDetail", "()Ljava/util/List;", "setMTblDetail", "(Ljava/util/List;)V", "mTblMaster", "getMTblMaster", "()Ljava/lang/Object;", "setMTblMaster", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "addDetail", "", "d", "clearDetailTransaction", "getListDetail", "getMaster", "loadTrans", "var1", "newTrans", "saveTrans", "voidTrans", "app_debug"})
public abstract class BaseTrans<M extends java.lang.Object, D extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private M mTblMaster;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<D> mTblDetail;
    
    public BaseTrans() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final M getMTblMaster() {
        return null;
    }
    
    protected final void setMTblMaster(@org.jetbrains.annotations.Nullable()
    M p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.List<D> getMTblDetail() {
        return null;
    }
    
    protected final void setMTblDetail(@org.jetbrains.annotations.NotNull()
    java.util.List<D> p0) {
    }
    
    public abstract void newTrans();
    
    public abstract void saveTrans();
    
    public abstract void voidTrans();
    
    public abstract void loadTrans(M var1);
    
    public M getMaster() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<D> getListDetail() {
        return null;
    }
    
    public void addDetail(D d) {
    }
    
    public final void clearDetailTransaction() {
    }
}