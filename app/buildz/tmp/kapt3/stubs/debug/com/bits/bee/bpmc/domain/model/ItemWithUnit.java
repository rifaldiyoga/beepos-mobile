package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 10/08/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003JI\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u00c6\u0001J\t\u0010(\u001a\u00020)H\u00d6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020)H\u00d6\u0001J\t\u0010/\u001a\u00020\u0007H\u00d6\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020)H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u00065"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/ItemWithUnit;", "Landroid/os/Parcelable;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "unit", "Lcom/bits/bee/bpmc/domain/model/Unit;", "pid", "", "discExp", "discAmt", "Ljava/math/BigDecimal;", "note", "(Lcom/bits/bee/bpmc/domain/model/Item;Lcom/bits/bee/bpmc/domain/model/Unit;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;)V", "getDiscAmt", "()Ljava/math/BigDecimal;", "setDiscAmt", "(Ljava/math/BigDecimal;)V", "getDiscExp", "()Ljava/lang/String;", "setDiscExp", "(Ljava/lang/String;)V", "getItem", "()Lcom/bits/bee/bpmc/domain/model/Item;", "setItem", "(Lcom/bits/bee/bpmc/domain/model/Item;)V", "getNote", "setNote", "getPid", "setPid", "getUnit", "()Lcom/bits/bee/bpmc/domain/model/Unit;", "setUnit", "(Lcom/bits/bee/bpmc/domain/model/Unit;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class ItemWithUnit implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private com.bits.bee.bpmc.domain.model.Item item;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Unit unit;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String pid;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String discExp;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal discAmt;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String note;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.ItemWithUnit> CREATOR = null;
    
    /**
     * Created by aldi on 10/08/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.ItemWithUnit copy(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Unit unit, @org.jetbrains.annotations.Nullable()
    java.lang.String pid, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note) {
        return null;
    }
    
    /**
     * Created by aldi on 10/08/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 10/08/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 10/08/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ItemWithUnit(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Unit unit, @org.jetbrains.annotations.Nullable()
    java.lang.String pid, @org.jetbrains.annotations.NotNull()
    java.lang.String discExp, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal discAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Item component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Item getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Unit component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Unit getUnit() {
        return null;
    }
    
    public final void setUnit(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Unit p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPid() {
        return null;
    }
    
    public final void setPid(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiscExp() {
        return null;
    }
    
    public final void setDiscExp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getDiscAmt() {
        return null;
    }
    
    public final void setDiscAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.ItemWithUnit> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.ItemWithUnit createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.ItemWithUnit[] newArray(int size) {
            return null;
        }
    }
}