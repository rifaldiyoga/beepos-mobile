package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 30/06/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00a1\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00108J\t\u0010N\u001a\u00020\u000eH\u00c6\u0003J\t\u0010O\u001a\u00020\u0005H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\fH\u00c6\u0003J\t\u0010R\u001a\u00020\u000eH\u00c6\u0003J\t\u0010S\u001a\u00020\u0016H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\u0016H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0005H\u00c6\u0003J\t\u0010X\u001a\u00020\u0007H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0007H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0007H\u00c6\u0003J\t\u0010[\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\\\u001a\u00020\fH\u00c6\u0003J\t\u0010]\u001a\u00020\u000eH\u00c6\u0003J\t\u0010^\u001a\u00020\u000eH\u00c6\u0003J\u00c4\u0001\u0010_\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010`J\t\u0010a\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010b\u001a\u00020\f2\b\u0010c\u001a\u0004\u0018\u00010dH\u00d6\u0003J\t\u0010e\u001a\u00020\u0003H\u00d6\u0001J\t\u0010f\u001a\u00020\u000eH\u00d6\u0001J\u0019\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010<\"\u0004\b=\u0010>R\u001a\u0010\u0014\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\"\"\u0004\bD\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\"\"\u0004\bF\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010&\"\u0004\bH\u0010(R\u001a\u0010\u0018\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010,\"\u0004\bJ\u0010.R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00100\"\u0004\bL\u00102\u00a8\u0006l"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Cstr;", "Landroid/os/Parcelable;", "id", "", "trxDate", "", "amount1", "Ljava/math/BigDecimal;", "amount2", "excrate1", "excrate2", "note", "", "refType", "", "refNo", "autoGen", "cashId1", "cashId2", "isUploaded", "kodeCstr", "createdAt", "Ljava/util/Date;", "createdBy", "updatedAt", "updatedBy", "(Ljava/lang/Integer;JLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/util/Date;ILjava/util/Date;I)V", "getAmount1", "()Ljava/math/BigDecimal;", "setAmount1", "(Ljava/math/BigDecimal;)V", "getAmount2", "setAmount2", "getAutoGen", "()Ljava/lang/String;", "setAutoGen", "(Ljava/lang/String;)V", "getCashId1", "()J", "setCashId1", "(J)V", "getCashId2", "setCashId2", "getCreatedAt", "()Ljava/util/Date;", "setCreatedAt", "(Ljava/util/Date;)V", "getCreatedBy", "()I", "setCreatedBy", "(I)V", "getExcrate1", "setExcrate1", "getExcrate2", "setExcrate2", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setUploaded", "(Z)V", "getKodeCstr", "setKodeCstr", "getNote", "setNote", "getRefNo", "setRefNo", "getRefType", "setRefType", "getTrxDate", "setTrxDate", "getUpdatedAt", "setUpdatedAt", "getUpdatedBy", "setUpdatedBy", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;JLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZLjava/lang/String;Ljava/util/Date;ILjava/util/Date;I)Lcom/bits/bee/bpmc/domain/model/Cstr;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Cstr implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer id;
    private long trxDate;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal amount1;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal amount2;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal excrate1;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal excrate2;
    private boolean note;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String refType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String refNo;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String autoGen;
    private long cashId1;
    private long cashId2;
    private boolean isUploaded;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String kodeCstr;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date createdAt;
    private int createdBy;
    @org.jetbrains.annotations.NotNull()
    private java.util.Date updatedAt;
    private int updatedBy;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Cstr> CREATOR = null;
    
    /**
     * Created by aldi on 30/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Cstr copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, long trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount1, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount2, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal excrate1, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal excrate2, boolean note, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, @org.jetbrains.annotations.NotNull()
    java.lang.String refNo, @org.jetbrains.annotations.NotNull()
    java.lang.String autoGen, long cashId1, long cashId2, boolean isUploaded, @org.jetbrains.annotations.NotNull()
    java.lang.String kodeCstr, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy) {
        return null;
    }
    
    /**
     * Created by aldi on 30/06/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 30/06/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 30/06/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Cstr(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, long trxDate, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount1, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount2, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal excrate1, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal excrate2, boolean note, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, @org.jetbrains.annotations.NotNull()
    java.lang.String refNo, @org.jetbrains.annotations.NotNull()
    java.lang.String autoGen, long cashId1, long cashId2, boolean isUploaded, @org.jetbrains.annotations.NotNull()
    java.lang.String kodeCstr, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, int createdBy, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, int updatedBy) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getTrxDate() {
        return 0L;
    }
    
    public final void setTrxDate(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getAmount1() {
        return null;
    }
    
    public final void setAmount1(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getAmount2() {
        return null;
    }
    
    public final void setAmount2(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getExcrate1() {
        return null;
    }
    
    public final void setExcrate1(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getExcrate2() {
        return null;
    }
    
    public final void setExcrate2(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getNote() {
        return false;
    }
    
    public final void setNote(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRefType() {
        return null;
    }
    
    public final void setRefType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRefNo() {
        return null;
    }
    
    public final void setRefNo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAutoGen() {
        return null;
    }
    
    public final void setAutoGen(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final long getCashId1() {
        return 0L;
    }
    
    public final void setCashId1(long p0) {
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long getCashId2() {
        return 0L;
    }
    
    public final void setCashId2(long p0) {
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean isUploaded() {
        return false;
    }
    
    public final void setUploaded(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKodeCstr() {
        return null;
    }
    
    public final void setKodeCstr(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int getCreatedBy() {
        return 0;
    }
    
    public final void setCreatedBy(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int getUpdatedBy() {
        return 0;
    }
    
    public final void setUpdatedBy(int p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Cstr> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Cstr createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Cstr[] newArray(int size) {
            return null;
        }
    }
}