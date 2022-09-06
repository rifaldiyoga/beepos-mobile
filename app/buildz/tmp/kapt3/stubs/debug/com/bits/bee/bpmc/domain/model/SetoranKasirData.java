package com.bits.bee.bpmc.domain.model;

import java.lang.System;

@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\bH\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\t\u0010.\u001a\u00020\bH\u00c6\u0003J\t\u0010/\u001a\u00020\bH\u00c6\u0003J\t\u00100\u001a\u00020\bH\u00c6\u0003J\t\u00101\u001a\u00020\bH\u00c6\u0003J\t\u00102\u001a\u00020\bH\u00c6\u0003J\t\u00103\u001a\u00020\bH\u00c6\u0003J\t\u00104\u001a\u00020\bH\u00c6\u0003Ju\u00105\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u00c6\u0001J\t\u00106\u001a\u00020\u0006H\u00d6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u0006H\u00d6\u0001J\t\u0010<\u001a\u00020=H\u00d6\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0006H\u00d6\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018\u00a8\u0006C"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/SetoranKasirData;", "Landroid/os/Parcelable;", "saleList", "", "Lcom/bits/bee/bpmc/domain/model/Sale;", "totalNewMember", "", "totalCash", "Ljava/math/BigDecimal;", "totalCredit", "totalDebit", "totalGopay", "totalAvg", "totalQty", "totalVoid", "totalNota", "(Ljava/util/List;ILjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;)V", "getSaleList", "()Ljava/util/List;", "setSaleList", "(Ljava/util/List;)V", "getTotalAvg", "()Ljava/math/BigDecimal;", "setTotalAvg", "(Ljava/math/BigDecimal;)V", "getTotalCash", "setTotalCash", "getTotalCredit", "setTotalCredit", "getTotalDebit", "setTotalDebit", "getTotalGopay", "setTotalGopay", "getTotalNewMember", "()I", "setTotalNewMember", "(I)V", "getTotalNota", "setTotalNota", "getTotalQty", "setTotalQty", "getTotalVoid", "setTotalVoid", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class SetoranKasirData implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList;
    private int totalNewMember;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalCash;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalCredit;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalDebit;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalGopay;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalAvg;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalQty;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalVoid;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal totalNota;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.SetoranKasirData> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.SetoranKasirData copy(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList, int totalNewMember, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalCash, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalCredit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDebit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalGopay, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalAvg, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalQty, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalVoid, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalNota) {
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
    
    public SetoranKasirData() {
        super();
    }
    
    public SetoranKasirData(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList, int totalNewMember, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalCash, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalCredit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalDebit, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalGopay, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalAvg, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalQty, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalVoid, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal totalNota) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Sale> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Sale> getSaleList() {
        return null;
    }
    
    public final void setSaleList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getTotalNewMember() {
        return 0;
    }
    
    public final void setTotalNewMember(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalCash() {
        return null;
    }
    
    public final void setTotalCash(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalCredit() {
        return null;
    }
    
    public final void setTotalCredit(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalDebit() {
        return null;
    }
    
    public final void setTotalDebit(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalGopay() {
        return null;
    }
    
    public final void setTotalGopay(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalAvg() {
        return null;
    }
    
    public final void setTotalAvg(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalQty() {
        return null;
    }
    
    public final void setTotalQty(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalVoid() {
        return null;
    }
    
    public final void setTotalVoid(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalNota() {
        return null;
    }
    
    public final void setTotalNota(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
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
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.SetoranKasirData> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.SetoranKasirData createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.SetoranKasirData[] newArray(int size) {
            return null;
        }
    }
}