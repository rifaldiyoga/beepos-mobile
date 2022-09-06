package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 23/08/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006*"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/SaleAddOnD;", "Landroid/os/Parcelable;", "id", "", "saleAddOnId", "Lcom/bits/bee/bpmc/domain/model/SaleAddOn;", "upSaledId", "Lcom/bits/bee/bpmc/domain/model/Saled;", "saledId", "(ILcom/bits/bee/bpmc/domain/model/SaleAddOn;Lcom/bits/bee/bpmc/domain/model/Saled;Lcom/bits/bee/bpmc/domain/model/Saled;)V", "getId", "()I", "setId", "(I)V", "getSaleAddOnId", "()Lcom/bits/bee/bpmc/domain/model/SaleAddOn;", "setSaleAddOnId", "(Lcom/bits/bee/bpmc/domain/model/SaleAddOn;)V", "getSaledId", "()Lcom/bits/bee/bpmc/domain/model/Saled;", "setSaledId", "(Lcom/bits/bee/bpmc/domain/model/Saled;)V", "getUpSaledId", "setUpSaledId", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class SaleAddOnD implements android.os.Parcelable {
    private int id;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.SaleAddOn saleAddOnId;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Saled upSaledId;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Saled saledId;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.SaleAddOnD> CREATOR = null;
    
    /**
     * Created by aldi on 23/08/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.SaleAddOnD copy(int id, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.SaleAddOn saleAddOnId, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled upSaledId, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled saledId) {
        return null;
    }
    
    /**
     * Created by aldi on 23/08/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 23/08/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 23/08/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SaleAddOnD() {
        super();
    }
    
    public SaleAddOnD(int id, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.SaleAddOn saleAddOnId, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled upSaledId, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled saledId) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.SaleAddOn component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.SaleAddOn getSaleAddOnId() {
        return null;
    }
    
    public final void setSaleAddOnId(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.SaleAddOn p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled getUpSaledId() {
        return null;
    }
    
    public final void setUpSaledId(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Saled getSaledId() {
        return null;
    }
    
    public final void setSaledId(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Saled p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.SaleAddOnD> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.SaleAddOnD createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.SaleAddOnD[] newArray(int size) {
            return null;
        }
    }
}